package com.jtmc.apps.reforma.domain;

public class Incomes {
    private double offering;
    private double tithe;
    private double donations;

    public double getOffering() {
        return offering;
    }

    public void setOffering(double offering) {
        this.offering = offering;
    }

    public double getTithe() {
        return tithe;
    }

    public void setTithe(double tithe) {
        this.tithe = tithe;
    }

    public double getDonations() {
        return donations;
    }

    public void setDonations(double donations) {
        this.donations = donations;
    }

    public double getTotal() {
        return this.offering + this.donations + this.tithe;
    }
}
