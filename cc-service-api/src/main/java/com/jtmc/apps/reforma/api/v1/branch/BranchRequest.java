package com.jtmc.apps.reforma.api.v1.branch;

public class BranchRequest extends BranchBase {
    private Integer timezoneId;

    public Integer getTimezoneId() {
        return timezoneId;
    }

    public void setTimezoneId(Integer timezoneId) {
        this.timezoneId = timezoneId;
    }
}
