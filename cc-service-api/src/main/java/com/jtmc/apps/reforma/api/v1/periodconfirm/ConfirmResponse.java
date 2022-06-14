package com.jtmc.apps.reforma.api.v1.periodconfirm;

public class ConfirmResponse {
    private int periodId;
    private String registration;
    private int branchId;
    private int confirmedBy;

    public int getConfirmedBy() {
        return confirmedBy;
    }

    public void setConfirmedBy(int confirmedBy) {
        this.confirmedBy = confirmedBy;
    }

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }
}
