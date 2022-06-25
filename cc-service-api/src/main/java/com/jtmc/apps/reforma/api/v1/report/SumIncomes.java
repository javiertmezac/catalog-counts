package com.jtmc.apps.reforma.api.v1.report;

public class SumIncomes {

    private double offering;
    private double tithe;
    private double donations;
    private double sumIncomesTotal;

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

    public double getSumIncomesTotal() {
        return sumIncomesTotal;
    }

    public void setSumIncomesTotal(double sumIncomesTotal) {
        this.sumIncomesTotal = sumIncomesTotal;
    }
}
