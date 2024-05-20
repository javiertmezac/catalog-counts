package com.jtmc.apps.reforma.impl.branch;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.branch.BranchInitialAmount;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.BranchRepository;
import com.jtmc.apps.reforma.repository.exception.BranchNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class BranchImpl {
    private Logger logger = LoggerFactory.getLogger(BranchImpl.class);

    @Inject
    private BranchRepository branchRepository;

    @Inject
    private CatalogCountImpl catalogCountImpl;

    @Inject
    private UserImpl userImpl;

    public BranchDetails selectOneBranch(int branchId) {
        Optional<Branch> branch = branchRepository.selectOneBranch(branchId);
        if (!branch.isPresent()) {
            logger.error("Branch #{} not found", branchId);
            throw new BranchNotFoundException("Branch not found", 404);
        }
        Optional<TimezoneType> branchTimeZone = branchRepository.getBranchTimeZone(branch.get().getId());
        BranchDetails details = new BranchDetails();
        details.setBranch(branch.get());
        details.setTimezoneType(branchTimeZone);
        return details;
    }

    public Optional<BranchInitialAmount> getInitialAmount(int branchId) {
        Optional<CustomCatalogCount> initialAmountCustomCatalog = catalogCountImpl
                .selectInitialAmountForBranch(branchId);
        if (!initialAmountCustomCatalog.isPresent()) {
            return Optional.empty();
        }

        BranchInitialAmount initialAmount = new BranchInitialAmount();
        initialAmount.setId(initialAmountCustomCatalog.get().getId());
        initialAmount.setAmount(initialAmountCustomCatalog.get().getAmount());
        initialAmount.setRegistration(initialAmountCustomCatalog.get().getRegistration().toString());
        return  Optional.of(initialAmount);
    }

    public List<Branch> selectBranches() {
       return branchRepository.selectAll();
    }

    public void insertBranch(Branch branch) {
        userImpl.getLoggedInUserDetails();
        if (branchRepository.insertBranch(branch) != 1) {
            logger.error("Branch was not inserted. {}", branch);
            throw new RuntimeException("Branch was not inserted.");
        }
    }

    public void insertInitialAmount(Branch branch, double amount) {
        UserDetails userDetails = userImpl.validateWritePermissionsForLoggedInUser();
        catalogCountImpl.insertInitialAmountCatalogCount(branch, amount);
    }
}
