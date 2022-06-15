package com.jtmc.apps.reforma.impl.periodconfirm;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Branch;
import com.jtmc.apps.reforma.domain.Period;
import com.jtmc.apps.reforma.domain.PeriodDetails;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.impl.branch.BranchImpl;
import com.jtmc.apps.reforma.impl.exception.PeriodConfirmException;
import com.jtmc.apps.reforma.impl.period.PeriodImpl;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.PeriodConfirmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.Optional;

public class PeriodConfirmImpl {
    private final Logger logger = LoggerFactory.getLogger(PeriodConfirmImpl.class);

    @Inject
    private PeriodConfirmRepository repository;

    @Inject
    private UserImpl userImpl;

    @Inject
    private PeriodImpl periodImpl;

    @Inject
    private BranchImpl branchImpl;

    public void confirmPeriod(int branchId, int periodId) {
        UserDetails userDetails = userImpl.getLoggedInUserDetails();
        Branch branch = branchImpl.selectOneBranch(branchId);
        Period period = periodImpl.getPeriodById(periodId);

        if (userDetails.getDefaultBranch() != branchId) {
            logger.error("LoggedInUser's default branchId {} does not match with given branchId {}",
                    userDetails.getDefaultBranch(), branchId);
            throw new IllegalArgumentException("Wrong default branch selection");
        }

        PeriodDetails details = new PeriodDetails();
        details.setBranchid(branchId);
        details.setPeriodid(periodId);
        details.setRegistration(Instant.now());
        details.setConfirmedby(userDetails.getPersonaId());

        int validInsertion = 1;
        if (repository.insert(details) != validInsertion) {
            logger.error("PeriodConfirm for branchId {}, periodId {} and confirmedBy {} was not registered",
                    branch.getName(), period.getDescription(), userDetails.getUsername());
            throw new PeriodConfirmException("Internal Error on PeriodConfirm", 500);
        }
    }

    public PeriodDetails selectOne(int branchId, int periodId, int confirmedBy) {
        Optional<PeriodDetails> periodDetails = repository.selectOne(branchId, periodId, confirmedBy);
        if(!periodDetails.isPresent()) {
            logger.error("PeriodDetails (confirmation) not found: branchID {}, periodId {} and confirmedBy {}",
                    branchId, periodId, confirmedBy);
            throw new PeriodDetailsConfirmationNotFoundException("Confirmation not found", 404);
        }
        return periodDetails.get();
    }
}
