package com.jtmc.apps.reforma.domain;

public class Expenses {
    private double services;
    private double helps;
    private double general;
    private double food;
    private double traveling;
    private double stationery;
    private double immovables;
    private double fees;

    public double getServices() {
        return services;
    }

    public void setServices(double services) {
        this.services = services;
    }

    public double getHelps() {
        return helps;
    }

    public void setHelps(double helps) {
        this.helps = helps;
    }

    public double getGeneral() {
        return general;
    }

    public void setGeneral(double general) {
        this.general = general;
    }

    public double getFood() {
        return food;
    }

    public void setFood(double food) {
        this.food = food;
    }

    public double getTraveling() {
        return traveling;
    }

    public void setTraveling(double traveling) {
        this.traveling = traveling;
    }

    public double getStationery() {
        return stationery;
    }

    public void setStationery(double stationery) {
        this.stationery = stationery;
    }

    public double getImmovables() {
        return immovables;
    }

    public void setImmovables(double immovables) {
        this.immovables = immovables;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public double getTotal() {
        return this.services +
                this.helps +
                this.general +
                this.food +
                this.traveling +
                this.stationery +
                this.immovables +
                this.fees;
    }
}
