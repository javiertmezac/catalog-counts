package com.jtmc.apps.reforma.api.v1.branch;

public class BranchRequest extends BranchBase {
    private Integer timezoneId;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Integer getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(Integer timezoneId) {
        this.timezoneId = timezoneId;
    }
}
