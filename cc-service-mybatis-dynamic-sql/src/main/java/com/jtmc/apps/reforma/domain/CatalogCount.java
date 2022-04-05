package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class CatalogCount {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071179-07:00", comments="Source field: catalog_count.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071372-07:00", comments="Source field: catalog_count.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071507-07:00", comments="Source field: catalog_count.catalogCountEnumId")
    private Integer catalogcountenumid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071637-07:00", comments="Source field: catalog_count.amount")
    private Double amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071785-07:00", comments="Source field: catalog_count.details")
    private String details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071908-07:00", comments="Source field: catalog_count.isDeleted")
    private Boolean isdeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.072038-07:00", comments="Source field: catalog_count.branchId")
    private Integer branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071248-07:00", comments="Source field: catalog_count.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071316-07:00", comments="Source field: catalog_count.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071421-07:00", comments="Source field: catalog_count.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071465-07:00", comments="Source field: catalog_count.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071551-07:00", comments="Source field: catalog_count.catalogCountEnumId")
    public Integer getCatalogcountenumid() {
        return catalogcountenumid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071597-07:00", comments="Source field: catalog_count.catalogCountEnumId")
    public void setCatalogcountenumid(Integer catalogcountenumid) {
        this.catalogcountenumid = catalogcountenumid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071691-07:00", comments="Source field: catalog_count.amount")
    public Double getAmount() {
        return amount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071746-07:00", comments="Source field: catalog_count.amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071826-07:00", comments="Source field: catalog_count.details")
    public String getDetails() {
        return details;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.07187-07:00", comments="Source field: catalog_count.details")
    public void setDetails(String details) {
        this.details = details;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071951-07:00", comments="Source field: catalog_count.isDeleted")
    public Boolean getIsdeleted() {
        return isdeleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.071995-07:00", comments="Source field: catalog_count.isDeleted")
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.07211-07:00", comments="Source field: catalog_count.branchId")
    public Integer getBranchid() {
        return branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.072157-07:00", comments="Source field: catalog_count.branchId")
    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }
}