package com.jtmc.apps.reforma.impl.periodconfirm;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.PeriodDetails;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.impl.exception.PeriodConfirmException;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.PeriodConfirmRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;

public class PeriodConfirmImpl {
    private final Logger logger = LoggerFactory.getLogger(PeriodConfirmImpl.class);

    @Inject
    private PeriodConfirmRepository repository;

    @Inject
    private UserImpl userImpl;

    public void confirmPeriod(int branchId, int periodId) {
        UserDetails userDetails = userImpl.getLoggedInUserDetails();
        //todo: validate given periodId exists
        //todo: validate if given branch and userDetails default branch are equal?

        PeriodDetails details = new PeriodDetails();
        details.setBranchid(branchId);
        details.setPeriodid(periodId);
        details.setRegistration(Instant.now());
        details.setConfirmedby(userDetails.getPersonaId());
        details.setStatus(true);

        int validInsertion = 1;
        if (repository.insertPeriodDetails(details) != validInsertion) {
            logger.error("PeriodConfirm for branchId {} and periodId {} was not registered",
                    branchId, periodId);
            throw new PeriodConfirmException("Internal Error on PeriodConfirm", 500);
        }
    }
}
