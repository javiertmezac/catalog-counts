package com.jtmc.apps.reforma.domain;

import jakarta.annotation.Generated;
import java.time.Instant;
import java.util.UUID;

public class TransferRegistry {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243859-07:00", comments="Source field: transferRegistry.transferRegistryId")
    private UUID transferRegistryId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243892-07:00", comments="Source field: transferRegistry.fromAccountId")
    private Integer fromAccountId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243916-07:00", comments="Source field: transferRegistry.toAccountId")
    private Integer toAccountId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.24394-07:00", comments="Source field: transferRegistry.amount")
    private Double amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243962-07:00", comments="Source field: transferRegistry.catalogCountEnumId")
    private Integer catalogCountEnumId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243985-07:00", comments="Source field: transferRegistry.entryPersonId")
    private Integer entryPersonId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244006-07:00", comments="Source field: transferRegistry.entryDate")
    private Instant entryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244037-07:00", comments="Source field: transferRegistry.transferRegistryState")
    private Boolean transferRegistryState;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244063-07:00", comments="Source field: transferRegistry.acceptedPersonId")
    private Integer acceptedPersonId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244086-07:00", comments="Source field: transferRegistry.acceptedDate")
    private Instant acceptedDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244173-07:00", comments="Source field: transferRegistry.transferRegistryStatus")
    private Boolean transferRegistryStatus;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244316-07:00", comments="Source field: transferRegistry.details")
    private String details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243872-07:00", comments="Source field: transferRegistry.transferRegistryId")
    public UUID getTransferRegistryId() {
        return transferRegistryId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243885-07:00", comments="Source field: transferRegistry.transferRegistryId")
    public void setTransferRegistryId(UUID transferRegistryId) {
        this.transferRegistryId = transferRegistryId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.2439-07:00", comments="Source field: transferRegistry.fromAccountId")
    public Integer getFromAccountId() {
        return fromAccountId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243909-07:00", comments="Source field: transferRegistry.fromAccountId")
    public void setFromAccountId(Integer fromAccountId) {
        this.fromAccountId = fromAccountId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243924-07:00", comments="Source field: transferRegistry.toAccountId")
    public Integer getToAccountId() {
        return toAccountId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243934-07:00", comments="Source field: transferRegistry.toAccountId")
    public void setToAccountId(Integer toAccountId) {
        this.toAccountId = toAccountId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243948-07:00", comments="Source field: transferRegistry.amount")
    public Double getAmount() {
        return amount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243956-07:00", comments="Source field: transferRegistry.amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243971-07:00", comments="Source field: transferRegistry.catalogCountEnumId")
    public Integer getCatalogCountEnumId() {
        return catalogCountEnumId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243978-07:00", comments="Source field: transferRegistry.catalogCountEnumId")
    public void setCatalogCountEnumId(Integer catalogCountEnumId) {
        this.catalogCountEnumId = catalogCountEnumId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.243992-07:00", comments="Source field: transferRegistry.entryPersonId")
    public Integer getEntryPersonId() {
        return entryPersonId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244-07:00", comments="Source field: transferRegistry.entryPersonId")
    public void setEntryPersonId(Integer entryPersonId) {
        this.entryPersonId = entryPersonId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244016-07:00", comments="Source field: transferRegistry.entryDate")
    public Instant getEntryDate() {
        return entryDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244028-07:00", comments="Source field: transferRegistry.entryDate")
    public void setEntryDate(Instant entryDate) {
        this.entryDate = entryDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244044-07:00", comments="Source field: transferRegistry.transferRegistryState")
    public Boolean getTransferRegistryState() {
        return transferRegistryState;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244056-07:00", comments="Source field: transferRegistry.transferRegistryState")
    public void setTransferRegistryState(Boolean transferRegistryState) {
        this.transferRegistryState = transferRegistryState;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244072-07:00", comments="Source field: transferRegistry.acceptedPersonId")
    public Integer getAcceptedPersonId() {
        return acceptedPersonId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244079-07:00", comments="Source field: transferRegistry.acceptedPersonId")
    public void setAcceptedPersonId(Integer acceptedPersonId) {
        this.acceptedPersonId = acceptedPersonId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244094-07:00", comments="Source field: transferRegistry.acceptedDate")
    public Instant getAcceptedDate() {
        return acceptedDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244161-07:00", comments="Source field: transferRegistry.acceptedDate")
    public void setAcceptedDate(Instant acceptedDate) {
        this.acceptedDate = acceptedDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244235-07:00", comments="Source field: transferRegistry.transferRegistryStatus")
    public Boolean getTransferRegistryStatus() {
        return transferRegistryStatus;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244305-07:00", comments="Source field: transferRegistry.transferRegistryStatus")
    public void setTransferRegistryStatus(Boolean transferRegistryStatus) {
        this.transferRegistryStatus = transferRegistryStatus;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244325-07:00", comments="Source field: transferRegistry.details")
    public String getDetails() {
        return details;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244336-07:00", comments="Source field: transferRegistry.details")
    public void setDetails(String details) {
        this.details = details;
    }
}