package com.jtmc.apps.reforma.domain;

import jakarta.annotation.Generated;
import java.time.Instant;
import java.util.UUID;

public class CatalogCountRegistry {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.366757-08:00", comments="Source field: catalog_count_registry.catalogCountRegistryId")
    private UUID catalogcountregistryid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.36822-08:00", comments="Source field: catalog_count_registry.registryType")
    private String registrytype;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.3683-08:00", comments="Source field: catalog_count_registry.entryPersonId")
    private Integer entrypersonid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368363-08:00", comments="Source field: catalog_count_registry.entryDate")
    private Instant entrydate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368434-08:00", comments="Source field: catalog_count_registry.acceptedPersonId")
    private Integer acceptedpersonid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368496-08:00", comments="Source field: catalog_count_registry.acceptedDate")
    private Instant accepteddate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368556-08:00", comments="Source field: catalog_count_registry.inactiveDate")
    private Instant inactivedate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368625-08:00", comments="Source field: catalog_count_registry.branchId")
    private Integer branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368682-08:00", comments="Source field: catalog_count_registry.catalogCountId")
    private Integer catalogcountid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368739-08:00", comments="Source field: catalog_count_registry.details")
    private String details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368053-08:00", comments="Source field: catalog_count_registry.catalogCountRegistryId")
    public UUID getCatalogcountregistryid() {
        return catalogcountregistryid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368191-08:00", comments="Source field: catalog_count_registry.catalogCountRegistryId")
    public void setCatalogcountregistryid(UUID catalogcountregistryid) {
        this.catalogcountregistryid = catalogcountregistryid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368243-08:00", comments="Source field: catalog_count_registry.registryType")
    public String getRegistrytype() {
        return registrytype;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368281-08:00", comments="Source field: catalog_count_registry.registryType")
    public void setRegistrytype(String registrytype) {
        this.registrytype = registrytype;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368322-08:00", comments="Source field: catalog_count_registry.entryPersonId")
    public Integer getEntrypersonid() {
        return entrypersonid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368344-08:00", comments="Source field: catalog_count_registry.entryPersonId")
    public void setEntrypersonid(Integer entrypersonid) {
        this.entrypersonid = entrypersonid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368394-08:00", comments="Source field: catalog_count_registry.entryDate")
    public Instant getEntrydate() {
        return entrydate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368417-08:00", comments="Source field: catalog_count_registry.entryDate")
    public void setEntrydate(Instant entrydate) {
        this.entrydate = entrydate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368456-08:00", comments="Source field: catalog_count_registry.acceptedPersonId")
    public Integer getAcceptedpersonid() {
        return acceptedpersonid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368477-08:00", comments="Source field: catalog_count_registry.acceptedPersonId")
    public void setAcceptedpersonid(Integer acceptedpersonid) {
        this.acceptedpersonid = acceptedpersonid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368518-08:00", comments="Source field: catalog_count_registry.acceptedDate")
    public Instant getAccepteddate() {
        return accepteddate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368539-08:00", comments="Source field: catalog_count_registry.acceptedDate")
    public void setAccepteddate(Instant accepteddate) {
        this.accepteddate = accepteddate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368583-08:00", comments="Source field: catalog_count_registry.inactiveDate")
    public Instant getInactivedate() {
        return inactivedate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368606-08:00", comments="Source field: catalog_count_registry.inactiveDate")
    public void setInactivedate(Instant inactivedate) {
        this.inactivedate = inactivedate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368645-08:00", comments="Source field: catalog_count_registry.branchId")
    public Integer getBranchid() {
        return branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368665-08:00", comments="Source field: catalog_count_registry.branchId")
    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368701-08:00", comments="Source field: catalog_count_registry.catalogCountId")
    public Integer getCatalogcountid() {
        return catalogcountid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368721-08:00", comments="Source field: catalog_count_registry.catalogCountId")
    public void setCatalogcountid(Integer catalogcountid) {
        this.catalogcountid = catalogcountid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368757-08:00", comments="Source field: catalog_count_registry.details")
    public String getDetails() {
        return details;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.368778-08:00", comments="Source field: catalog_count_registry.details")
    public void setDetails(String details) {
        this.details = details;
    }
}