package com.jtmc.apps.reforma.api.v1.catalogcount;

import java.time.Instant;
import java.util.UUID;

public class CatalogCountCumulativeSumResponse extends CatalogCountRequest  {

    private String catalogCountEnumDisplay;
    private double total;
    private boolean editable;
    private UUID registryId;
    private Instant registryEntryDate;
    private String registryType;
    private String entryDate;

    public CatalogCountCumulativeSumResponse() {}

    public CatalogCountCumulativeSumResponse(
            int catalogCountId,
            Instant entryDate,
            String catalogCountEnumDisplay,
            double amount,
            String details,
            double total,
            boolean editable
    ) {
        this.setId(catalogCountId);
        this.setRegistrationDate(entryDate);
        this.catalogCountEnumDisplay = catalogCountEnumDisplay;
        this.setAmount(amount);
        this.setDetails(details);
        this.total = total;
        this.editable = editable;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCatalogCountEnumDisplay() {
        return catalogCountEnumDisplay;
    }

    public void setCatalogCountEnumDisplay(String catalogCountEnumDisplay) {
        this.catalogCountEnumDisplay = catalogCountEnumDisplay;
    }

    public UUID getRegistryId() {
        return registryId;
    }

    public void setRegistryId(UUID registryId) {
        this.registryId = registryId;
    }

    public Instant getRegistryEntryDate() {
        return registryEntryDate;
    }

    public void setRegistryEntryDate(Instant registryEntryDate) {
        this.registryEntryDate = registryEntryDate;
    }

    public String getRegistryType() {
        return registryType;
    }

    public void setRegistryType(String registryType) {
        this.registryType = registryType;
    }

    public String getEntryDate() {
        return this.getRegistrationDate().toString();
    }
}
