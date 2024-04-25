package com.jtmc.apps.reforma.impl.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponse;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.impl.branch.BranchImpl;
import com.jtmc.apps.reforma.impl.exception.CatalogCountLogicalDeleteException;
import com.jtmc.apps.reforma.impl.exception.CatalogCountNotEditableException;
import com.jtmc.apps.reforma.impl.exception.CatalogCountNotFoundException;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.CatalogCountEnumRepository;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import org.mybatis.guice.transactional.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.BadRequestException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CatalogCountImpl {
    final private Logger logger = LoggerFactory.getLogger(CatalogCountImpl.class);

    @Inject
    private CatalogCountRepository catalogCountRepository;

    @Inject
    private CatalogCountEnumRepository catalogCountEnumRepository;

    @Inject
    private BranchImpl branchImpl;

    @Inject
    private UserImpl userImpl;

    //todo: selectAllWithTotalColumn needs some refactor.
    // 1. many things happening under the hood. ie. calculateTotal is calculating but also transforming
    // the response into CatalogCountResponse.
    public List<CatalogCountResponse> selectAllWithTotalColumn(Integer branchId) {
        Collection<CustomCatalogCount> catalogCounts = selectAll(branchId);
        Stream<CatalogCountResponse> catalogCountResponseStream = calculateTotal(catalogCounts.stream());
        List<CatalogCountResponse> responseList = catalogCountResponseStream.collect(Collectors.toList());
        Collections.reverse(responseList);
        return responseList;
    }

    public Collection<CustomCatalogCount> selectAll(Integer branchId) {
        return catalogCountRepository.selectAllByBranch(branchId);
    }

    public Optional<CustomCatalogCount> selectInitialAmountForBranch(Integer branchId) {
        Collection<CustomCatalogCount> all = selectAll(branchId);
        CatalogCountEnum initialAmountEnum = catalogCountEnumRepository.getInitialAmountEnum();
        Stream<CustomCatalogCount> initialAmountList = all.stream()
                .filter(x -> x.getIdentifier().equals(initialAmountEnum.getIdentifier()));
        return all.stream()
                .filter(x -> x.getIdentifier().equals(initialAmountEnum.getIdentifier()))
                .findFirst();
    }

    //todo: improve this logic
    public double getTotalBalanceUpToGivenDate(int branchId, Instant fromDate) {
        Collection<CustomCatalogCount> catalogCounts = catalogCountRepository.selectAllByBranch(branchId);
        Stream<CustomCatalogCount> filteredCatalogCounts = catalogCounts.stream()
                .filter(x -> x.getRegistration().isBefore(fromDate));
        Stream<CatalogCountResponse> response = calculateTotal(filteredCatalogCounts);

        List<CatalogCountResponse> responseList = response.collect(Collectors.toList());
        Collections.reverse(responseList);

        Optional<CatalogCountResponse> optionalResponse = responseList.stream().findFirst();
        return optionalResponse.map(CatalogCountResponse::getTotal).orElse(0.0);
    }

    private Stream<CatalogCountResponse> calculateTotal(Stream<CustomCatalogCount> catalogCounts) {
        final double[] total = {0};
        return catalogCounts.map((cc) -> {
            total[0] = calculateTotalColumn(cc, total[0]);
            return new CatalogCountResponse(
                    cc.getId(),
                    cc.getRegistration().toString(),
                    String.format("%s - %s", cc.getIdentifier(), cc.getName()),
                    cc.getAmount(),
                    cc.getDetails(),
                    total[0],
                    validateCatalogCountEditableByRegistration(cc.getRegistration())
            );
        });
    }

    private double calculateTotalColumn(CatalogCount catalogCount, double saldo) {
        Stream<CatalogCountEnum> catalogCountEnumStream = catalogCountEnumRepository.getIncomeCatalogCountEnums();
        if (catalogCountEnumStream.anyMatch(x -> Objects.equals(x.getId(), catalogCount.getCatalogcountenumid()))) {
            saldo = saldo + catalogCount.getAmount();
        } else {
            saldo = saldo - catalogCount.getAmount();
        }
        return saldo;
    }

    @Transactional
    public void insertIntoCatalogCount(CatalogCount catalogCount) {
        UserDetails userDetails = userImpl.validateWritePermissionsForLoggedInUser();
        validateCatalogCountEnum(catalogCount);

        isCatalogCountRegistrationDateValid(catalogCount.getRegistration());

        Branch branch = branchImpl.selectOneBranch(catalogCount.getBranchid());
        catalogCountRepository.insert(catalogCount);
        logger.debug("User {} inserted new CatalogCount into branch #{}", userDetails.getUsername(), branch.getId());
    }

    @Transactional
    public void insertInitialAmountCatalogCount(Branch branch, double amount) {
        CatalogCountEnum initialAmountEnum = catalogCountEnumRepository.getInitialAmountEnum();

        CatalogCount catalogCount = new CatalogCount();
        catalogCount.setAmount(amount);
        catalogCount.setDetails(initialAmountEnum.getDescription());
        catalogCount.setCatalogcountenumid(initialAmountEnum.getId());
        catalogCount.setIsdeleted(false);

        ZonedDateTime zonedDateTime = branch.getRegistration().atZone(ZoneId.systemDefault());
        catalogCount.setRegistration(zonedDateTime.minusMonths(1).withDayOfMonth(10).toInstant());

        catalogCount.setBranchid(branch.getId());
        catalogCountRepository.insert(catalogCount);
    }

    @Transactional
    public void updateCatalogCount(CatalogCount catalogCount) {
        UserDetails userDetails = userImpl.validateWritePermissionsForLoggedInUser();
        validateCatalogCountEnum(catalogCount);

        isCatalogCountRegistrationDateValid(catalogCount.getRegistration());
        Branch branch = branchImpl.selectOneBranch(catalogCount.getBranchid());
        CatalogCount ccToBeUpdated = this.selectOneRecord(catalogCount.getId());
        logger.info("CatalogCount #{} to be updated", ccToBeUpdated.getId());
        logCatalogCount(ccToBeUpdated);

        catalogCountRepository.update(catalogCount);
        logger.info("User '{}' updated CatalogCount #{} on branch #{}",
                userDetails.getUsername(), catalogCount.getId(), branch.getId()
        );
        logCatalogCount(catalogCount);
    }

    public CatalogCount selectOneRecord(int id) {
        Optional<CatalogCount> catalogCount = catalogCountRepository.selectOneRecord(id);
        if(!catalogCount.isPresent()) {
            logger.error("CatalogCount #{} not found", id);
            throw new CatalogCountNotFoundException("CatalogCount not found", 404);
        }
        return catalogCount.get();
    }

    @Transactional
    public void logicalDeleteRecord(CatalogCount catalogCount) {
        UserDetails userDetails = userImpl.validateWritePermissionsForLoggedInUser();

        CatalogCount ccFromDB = this.selectOneRecord(catalogCount.getId());
        if (ccFromDB.getIsdeleted()) {
           logger.error("CatalogCount {} was already marked as deleted", ccFromDB.getId());
           throw new IllegalArgumentException("No valid Request");
        }
        isCatalogCountRegistrationDateValid(ccFromDB.getRegistration());

        Branch branch = branchImpl.selectOneBranch(catalogCount.getBranchid());
        if (catalogCountRepository.logicalDelete(catalogCount) != 1) {
            logger.error("logicalDelete for record catalog-count {} was not successfully done", catalogCount.getId());
            throw new CatalogCountLogicalDeleteException("something wrong happened on deletion for catalog-count", 500);
        } else {
            logger.info("User {} deleted CatalogCount #{} on branch #{}", userDetails.getUsername(), catalogCount.getId(), branch.getId());
        }
    }

    private void isCatalogCountRegistrationDateValid(Instant registration) {
        if(!validateCatalogCountEditableByRegistration(registration)) {
            logger.error("Cannot Insert CatalogCount as Registration date is out of range");
            throw new CatalogCountNotEditableException("CatalogCount with no valid registration dateRange", 400);
        }
    }

    //todo: should I consider the timezone of each "user"?
    // yes - lets consider time zones by branch, not by user
    private boolean validateCatalogCountEditableByRegistration(Instant catalogCountRegistration) {
        ZonedDateTime zonedDateTime = catalogCountRegistration.atZone(ZoneId.systemDefault());

        LocalDate currentDate = LocalDate.now();
        int firstDay = 1;
        LocalDate firstDayCurrentDate = LocalDate.of(currentDate.getYear(), currentDate.getMonth(), firstDay);
        LocalDateTime dateTime = LocalDateTime.of(firstDayCurrentDate, LocalTime.MAX);

        ZonedDateTime minZonedDateTime = dateTime.atZone(ZoneId.systemDefault());
        //todo: missing "and not confirmed"
        int maxDay = 16; //increase max day to 16 to support 15th day.
        if (currentDate.getDayOfMonth() <= maxDay) {
            return zonedDateTime.isAfter(minZonedDateTime
                    .minus(1, ChronoUnit.MONTHS)
                    .minus(1, ChronoUnit.DAYS));
        }
        return zonedDateTime.isAfter(minZonedDateTime.minus(1, ChronoUnit.DAYS));
    }

    private void validateCatalogCountEnum(CatalogCount catalogCount) {
        CatalogCountEnum initialAmountEnum = catalogCountEnumRepository.getInitialAmountEnum();
        if(catalogCount.getCatalogcountenumid().equals(initialAmountEnum.getId())) {
            throw new BadRequestException();
        }
    }

    private void logCatalogCount(CatalogCount cc) {
        logger.info("CatalogCount - id: {}, registration: {}, ccEnumId: {}, " +
                "amount: {}, details: {}, branchId: {}, isDeleted: {}", cc.getId(),
                cc.getRegistration().toString(), cc.getCatalogcountenumid(),
                cc.getAmount(), cc.getDetails(), cc.getBranchid(), cc.getIsdeleted());
    }
}
