package com.jtmc.apps.reforma.domain;

public class CatalogCountEnum {
    private int id;
    private String identifier;
    private String name;
    private String description;
    private boolean type;
    private boolean isDeleted;

    @Override
    public String toString() {
        return "CatalogCountEnum{" +
                "id=" + id +
                ", identifier='" + identifier + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
