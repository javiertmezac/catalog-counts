package com.jtmc.apps.reforma.impl.branch;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Branch;
import com.jtmc.apps.reforma.repository.BranchRepository;
import com.jtmc.apps.reforma.repository.exception.BranchNotFoundException;

import java.util.Optional;

public class BranchImpl {

    @Inject
    private BranchRepository branchRepository;

    public Branch selectOneBranch(int branchId) {
        Optional<Branch> branch = branchRepository.selectOneBranch(branchId);
        if (!branch.isPresent()) {
            throw new BranchNotFoundException();
        }
        return branch.get();
    }
}
