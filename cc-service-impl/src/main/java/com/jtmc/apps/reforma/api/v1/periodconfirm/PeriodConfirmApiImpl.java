package com.jtmc.apps.reforma.api.v1.periodconfirm;


import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.PeriodDetails;
import com.jtmc.apps.reforma.impl.periodconfirm.PeriodConfirmImpl;

import javax.ws.rs.core.Response;

import static com.google.common.base.Preconditions.checkArgument;

@JwtRequired
public class PeriodConfirmApiImpl implements PeriodConfirmApi {

    @Inject
    private PeriodConfirmImpl periodConfirmImpl;

    @Override
    public Response confirmPeriodForBranch(int branchId, int periodId) {
        checkArgument(branchId > 0, "Invalid BranchId");
        checkArgument(periodId > 0, "Invalid PeriodId");
        periodConfirmImpl.confirmPeriod(branchId, periodId);
        return  Response.noContent().build();
    }

    @Override
    public ConfirmResponse selectOne(int confirmId) {
        PeriodDetails periodDetails = periodConfirmImpl.selectOne(confirmId);

        ConfirmResponse response = new ConfirmResponse();
        response.setId(periodDetails.getId());
        response.setBranchId(periodDetails.getBranchid());
        response.setRegistration(periodDetails.getRegistration().toString());
        return response;
    }
}
