package com.jtmc.apps.reforma.api.v1.branch;

public class BranchResponse extends BranchBase {

    private Integer id;
    private String registration;
    private boolean status;

    private BranchInitialAmount initialAmount;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public BranchInitialAmount getInitialAmount() {
        return initialAmount;
    }

    public void setInitialAmount(BranchInitialAmount initialAmount) {
        this.initialAmount = initialAmount;
    }
}
