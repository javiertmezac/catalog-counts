package com.jtmc.apps.reforma.domain;

import java.util.Optional;

public class BranchDetails {
    private Branch branch;
    private Optional<TimezoneType> timezoneType;

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public Optional<TimezoneType> getTimezoneType() {
        return timezoneType;
    }

    public void setTimezoneType(Optional<TimezoneType> timezoneType) {
        this.timezoneType = timezoneType;
    }
}
