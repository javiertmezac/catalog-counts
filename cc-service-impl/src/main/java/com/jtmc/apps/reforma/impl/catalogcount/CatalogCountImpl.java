package com.jtmc.apps.reforma.impl.catalogcount;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponse;
import com.jtmc.apps.reforma.domain.Period;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.impl.branch.BranchImpl;
import com.jtmc.apps.reforma.impl.exception.CatalogCountLogicalDeleteException;
import com.jtmc.apps.reforma.impl.exception.CatalogCountNotEditableException;
import com.jtmc.apps.reforma.impl.exception.CatalogCountNotFoundException;
import com.jtmc.apps.reforma.impl.exception.PeriodNotFoundException;
import com.jtmc.apps.reforma.impl.period.PeriodImpl;
import com.jtmc.apps.reforma.impl.periodconfirm.PeriodConfirmImpl;
import com.jtmc.apps.reforma.impl.periodconfirm.PeriodDetailsConfirmationNotFoundException;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.CatalogCountEnumRepository;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import org.mybatis.guice.transactional.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.ForbiddenException;
import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
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

    @Inject
    private PeriodImpl periodImpl;

    @Inject
    private PeriodConfirmImpl periodConfirmImpl;

    @Inject
    @Named("deadLineDay")
    private Integer deadLineDay;

    public List<CatalogCountResponse> selectAllWithTotalColumn(Integer branchId) {
        CatalogCountCumulativeSumParams params = new CatalogCountCumulativeSumParams();
        params.setBranchId(branchId);
        params.setDeadLineDay(deadLineDay);
        return catalogCountRepository.selectAllCumulativeSumByBranch(params).stream().map(
                cc -> new CatalogCountResponse(
                        cc.getId(),
                        cc.getRegistration().toString(),
                        cc.getCatalogCountEnum(),
                        cc.getAmount(),
                        cc.getDetails(),
                        cc.getCumulativeSum(),
                        cc.isEditable()
                )
        ).collect(Collectors.toList());
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

    public double getTotalBalanceUpToGivenDate(int branchId, Instant instantWithZoneOffset) {
        CatalogCountCumulativeSumParams params = new CatalogCountCumulativeSumParams();
        params.setBranchId(branchId);
        params.setDeadLineDay(deadLineDay);
        Collection<CustomCatalogCount> customCatalogCountsCumulativeSum =
                catalogCountRepository.selectAllCumulativeSumByBranch(params);

        Stream<CustomCatalogCount> stream = customCatalogCountsCumulativeSum.stream()
                .filter(x -> x.getRegistration().isBefore(instantWithZoneOffset));
        Optional<CustomCatalogCount>  firstOrEmpty = stream.findFirst();
        return firstOrEmpty.map(CustomCatalogCount::getCumulativeSum).orElse(0.0);
    }

    @Transactional
    public void insertIntoCatalogCount(CatalogCount catalogCount) {
        UserDetails userDetails = userImpl.validateWritePermissionsForLoggedInUser();
        validateCatalogCountEnum(catalogCount);

        BranchDetails branchDetails = branchImpl.selectOneBranch(catalogCount.getBranchid());
        validateCurrentPeriodNotConfirmed(branchDetails, catalogCount, userDetails);
        isCatalogCountRegistrationDateValid(branchDetails, catalogCount.getRegistration());
        catalogCountRepository.insert(catalogCount);
        logger.debug("User {} inserted new CatalogCount into branch #{}", userDetails.getUsername(), branchDetails.getBranch().getId());
    }

    private void validateCurrentPeriodNotConfirmed(BranchDetails branchDetails, CatalogCount catalogCount, UserDetails userDetails) {
        Branch branch = branchDetails.getBranch();
        ZonedDateTime zonedDateTime = catalogCount.getRegistration().atZone(branchDetails.getZoneIdFromBranchTimeZone());
        try {
            Period period = periodImpl.getPeriodByQueryParams(zonedDateTime.getMonthValue(), zonedDateTime.getYear());
            periodConfirmImpl.selectOne(branch.getId(), period.getId(), userDetails.getPersonaId());
            throw new ForbiddenException("Current Period has been confirmed, not allowed to submit CatalogCount Movements");
        } catch (PeriodNotFoundException ex){
            this.logger.debug("Period still not registered in DB for date: {}", zonedDateTime);
        }catch (PeriodDetailsConfirmationNotFoundException ex) {
           logger.debug("Period confirmation still not registered in DB for date: {}", zonedDateTime);
        }
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
        BranchDetails branchDetails = branchImpl.selectOneBranch(catalogCount.getBranchid());
        validateCurrentPeriodNotConfirmed(branchDetails, catalogCount, userDetails);
        isCatalogCountRegistrationDateValid(branchDetails, catalogCount.getRegistration());

        CatalogCount ccToBeUpdated = this.selectOneRecord(catalogCount.getId());
        logger.info("CatalogCount #{} to be updated", ccToBeUpdated.getId());
        logCatalogCount(ccToBeUpdated);

        catalogCountRepository.update(catalogCount);
        logger.info("User '{}' updated CatalogCount #{} on branch #{}",
                userDetails.getUsername(), catalogCount.getId(), branchDetails.getBranch().getId()
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
        BranchDetails branchDetails = branchImpl.selectOneBranch(catalogCount.getBranchid());
        isCatalogCountRegistrationDateValid(branchDetails, ccFromDB.getRegistration());

        if (catalogCountRepository.logicalDelete(catalogCount) != 1) {
            logger.error("logicalDelete for record catalog-count {} was not successfully done", catalogCount.getId());
            throw new CatalogCountLogicalDeleteException("something wrong happened on deletion for catalog-count", 500);
        } else {
            logger.info("User {} deleted CatalogCount #{} on branch #{}", userDetails.getUsername(),
                    catalogCount.getId(), branchDetails.getBranch().getId());
        }
    }

    private void isCatalogCountRegistrationDateValid(BranchDetails branchDetails, Instant registration) {
        if(!validateCatalogCountEditableByRegistration(branchDetails, registration)) {
            logger.error("Cannot Insert CatalogCount as Registration date is out of range");
            throw new CatalogCountNotEditableException("CatalogCount with no valid registration dateRange", 400);
        }
    }

    private boolean validateCatalogCountEditableByRegistration(BranchDetails branchDetails, Instant catalogCountRegistration) {

        ZonedDateTime catalogCountRegistrationAtZoneDateTime = catalogCountRegistration.atZone(branchDetails.getZoneIdFromBranchTimeZone());
        ZonedDateTime nowAtZoneDateTime = Instant.now().atZone(branchDetails.getZoneIdFromBranchTimeZone());

        int firstDay = 1;
        LocalDateTime firstDayCurrentDate = LocalDate.of(nowAtZoneDateTime.getYear(), nowAtZoneDateTime.getMonth(), firstDay).atStartOfDay();
        ZonedDateTime minZonedDateTime = firstDayCurrentDate.atZone(branchDetails.getZoneIdFromBranchTimeZone()) ;

        int maxDay = deadLineDay;
        if (nowAtZoneDateTime.getDayOfMonth() <= maxDay) {
            return catalogCountRegistrationAtZoneDateTime.isAfter(minZonedDateTime
                    .minus(1, ChronoUnit.MONTHS));
        }
        return catalogCountRegistrationAtZoneDateTime.isAfter(minZonedDateTime.minus(1, ChronoUnit.DAYS));
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
