package com.jtmc.apps.reforma.domain;

public enum Roles {
    TREASURE(1, "Tesorero Financiero"),
    SECRETARY (2, "Secretario Financiero");

    private int value;
    private String description;

    Roles(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
