package com.jtmc.apps.reforma.impl.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponse;
import com.jtmc.apps.reforma.domain.Branch;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.CustomCatalogCount;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.impl.branch.BranchImpl;
import com.jtmc.apps.reforma.impl.exception.CatalogCountNotEditableException;
import com.jtmc.apps.reforma.impl.exception.CatalogCountNotFoundException;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import org.mybatis.guice.transactional.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
    private BranchImpl branchImpl;

    @Inject
    private UserImpl userImpl;

    public List<CatalogCountResponse> selectAllWithTotalColumn(Integer branchId) {
        Collection<CustomCatalogCount> catalogCounts = catalogCountRepository.selectAllByBranch(branchId);
        final double[] total = {0};
        Stream<CatalogCountResponse> catalogCountResponseStream = catalogCounts.stream().map((cc) -> {
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

        List<CatalogCountResponse> responseList = catalogCountResponseStream.collect(Collectors.toList());
        Collections.reverse(responseList);
        return responseList;
    }

    private double calculateTotalColumn(CatalogCount catalogCount, double saldo) {
        //todo: this will only work if first 3 rows from CatalogCountEnum are "incoming values"
        int incomingEnums = 3;
        if (catalogCount.getCatalogcountenumid() <= incomingEnums)  {
            saldo = saldo + catalogCount.getAmount();
        } else {
            saldo = saldo - catalogCount.getAmount();
        }
        return saldo;
    }

    @Transactional
    public void insertIntoCatalogCount(CatalogCount catalogCount) {
        isCatalogCountRegistrationDateValid(catalogCount.getRegistration());

        UserDetails userDetails = userImpl.validateWritePermissionsForLoggedInUser();

        Branch branch = branchImpl.selectOneBranch(catalogCount.getBranchid());
        catalogCountRepository.insert(catalogCount);
        logger.info("User {} inserted new CatalogCount into branch #{}", userDetails.getUsername(), branch.getId());
    }

    @Transactional
    public void updateCatalogCount(CatalogCount catalogCount) {
        isCatalogCountRegistrationDateValid(catalogCount.getRegistration());

        UserDetails userDetails = userImpl.validateWritePermissionsForLoggedInUser();
        Branch branch = branchImpl.selectOneBranch(catalogCount.getBranchid());
        CatalogCount ccToBeUpdated = this.selectOneRecord(catalogCount.getId());
        logger.info("CatalogCount #{} to be updated", ccToBeUpdated.getId());
        logCatalogCount(ccToBeUpdated);

        catalogCountRepository.update(catalogCount);
        logger.info("User '{}' updated CatalogCount #{} on branch #{}", userDetails.getUsername(), catalogCount.getId(), branch.getId());
        logCatalogCount(catalogCount);
    }

    public CatalogCount selectOneRecord(int id) {
        Optional<CatalogCount> catalogCount = catalogCountRepository.selectOneRecord(id);
        if(!catalogCount.isPresent()) {
            logger.error("CatalogCount #{} not found", id);
            throw new CatalogCountNotFoundException("CatalogCount not found");
        }
        return catalogCount.get();
    }

    @Transactional
    public void logicalDeleteRecord(CatalogCount catalogCount) {
        isCatalogCountRegistrationDateValid(catalogCount.getRegistration());
        UserDetails userDetails = userImpl.validateWritePermissionsForLoggedInUser();
        Branch branch = branchImpl.selectOneBranch(catalogCount.getBranchid());
        if (catalogCountRepository.logicalDelete(catalogCount) != 1) {
            logger.error("logicalDelete for record catalog-count {} was not successfully done", catalogCount.getId());
            throw new RuntimeException("something wrong happened on deletion for catalog-count");
        } else {
            logger.info("User {} deleted CatalogCount #{} on branch #{}", userDetails.getUsername(), catalogCount.getId(), branch.getId());
        }
    }

    private void isCatalogCountRegistrationDateValid(Instant registration) {
        if(!validateCatalogCountEditableByRegistration(registration)) {
            logger.error("Cannot Insert CatalogCount as Registration date is out of range");
            throw new CatalogCountNotEditableException("CatalogCount with no valid registration dateRange");
        }
    }

    private boolean validateCatalogCountEditableByRegistration(Instant catalogCountRegistration) {
        LocalDate currentDate = LocalDate.now();
        Month currentMonth = currentDate.getMonth();
        LocalDate date = LocalDate.of(currentDate.getYear(), currentMonth, 1);
        LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.MIDNIGHT);

        int secondsInADay = 86340;
        return catalogCountRegistration.isAfter(dateTime.toInstant(ZoneOffset.UTC).minus(1, ChronoUnit.DAYS).plusSeconds(secondsInADay));
    }

    private void logCatalogCount(CatalogCount cc) {
        logger.info("CatalogCount - id: {}, registration: {}, ccEnumId: {}, " +
                "amount: {}, details: {}, branchId: {}, isDeleted: {}", cc.getId(),
                cc.getRegistration().toString(), cc.getCatalogcountenumid(),
                cc.getAmount(), cc.getDetails(), cc.getBranchid(), cc.getIsdeleted());
    }
}
