package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class CatalogCount {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616381-07:00", comments="Source field: catalog_count.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616567-07:00", comments="Source field: catalog_count.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.61669-07:00", comments="Source field: catalog_count.catalogCountEnumId")
    private Long catalogcountenumid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616807-07:00", comments="Source field: catalog_count.amount")
    private Double amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616916-07:00", comments="Source field: catalog_count.details")
    private String details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617029-07:00", comments="Source field: catalog_count.isDeleted")
    private Boolean isdeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617147-07:00", comments="Source field: catalog_count.branchId")
    private Long branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616482-07:00", comments="Source field: catalog_count.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616527-07:00", comments="Source field: catalog_count.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616608-07:00", comments="Source field: catalog_count.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616654-07:00", comments="Source field: catalog_count.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616728-07:00", comments="Source field: catalog_count.catalogCountEnumId")
    public Long getCatalogcountenumid() {
        return catalogcountenumid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616772-07:00", comments="Source field: catalog_count.catalogCountEnumId")
    public void setCatalogcountenumid(Long catalogcountenumid) {
        this.catalogcountenumid = catalogcountenumid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616844-07:00", comments="Source field: catalog_count.amount")
    public Double getAmount() {
        return amount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616882-07:00", comments="Source field: catalog_count.amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616953-07:00", comments="Source field: catalog_count.details")
    public String getDetails() {
        return details;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.616995-07:00", comments="Source field: catalog_count.details")
    public void setDetails(String details) {
        this.details = details;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617069-07:00", comments="Source field: catalog_count.isDeleted")
    public Boolean getIsdeleted() {
        return isdeleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617108-07:00", comments="Source field: catalog_count.isDeleted")
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617202-07:00", comments="Source field: catalog_count.branchId")
    public Long getBranchid() {
        return branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617244-07:00", comments="Source field: catalog_count.branchId")
    public void setBranchid(Long branchid) {
        this.branchid = branchid;
    }
}