package com.jtmc.apps.reforma.api.v1.periodconfirm;


import com.google.inject.Inject;
import com.jtmc.apps.reforma.impl.periodconfirm.PeriodConfirmImpl;

import static com.google.common.base.Preconditions.checkArgument;

public class PeriodConfirmApiImpl implements PeriodConfirmApi {

    @Inject
    private PeriodConfirmImpl periodConfirmImpl;

    @Override
    public void confirmPeriodForBranch(int branchId, int periodId) {
        checkArgument(branchId > 0, "Invalid BranchId");
        checkArgument(periodId > 0, "Invalid PeriodId");
        periodConfirmImpl.confirmPeriod(branchId, periodId);
    }
}
