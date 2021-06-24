package com.jtmc.apps.reforma.domain;

public class CatalogCountEnum {
    private int id;
    private String identifier;
    private String name;
    private String description;
    private boolean type;
    private boolean isDeleted;

    public CatalogCountEnum() {}

    public CatalogCountEnum(String identifier, String name, String description, boolean type, boolean isDeleted) {
        this.identifier = identifier;
        this.name = name;
        this.description = description;
        this.type = type;
        this.isDeleted = isDeleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public String getCatalogCountEnumDisplay() {
        return String.format("%s - %s", this.identifier, this.name);
    }

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
