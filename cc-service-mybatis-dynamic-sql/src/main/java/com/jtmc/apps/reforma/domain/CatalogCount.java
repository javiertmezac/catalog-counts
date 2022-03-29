package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class CatalogCount {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.794709-07:00", comments="Source field: catalog_count.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.797698-07:00", comments="Source field: catalog_count.registrationDate")
    private Instant registrationdate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.797881-07:00", comments="Source field: catalog_count.catalogCountEnumId")
    private Long catalogcountenumid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.798147-07:00", comments="Source field: catalog_count.amount")
    private Double amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.798322-07:00", comments="Source field: catalog_count.details")
    private String details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.798529-07:00", comments="Source field: catalog_count.isDeleted")
    private Boolean isdeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.797301-07:00", comments="Source field: catalog_count.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.797619-07:00", comments="Source field: catalog_count.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.79777-07:00", comments="Source field: catalog_count.registrationDate")
    public Instant getRegistrationdate() {
        return registrationdate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.797829-07:00", comments="Source field: catalog_count.registrationDate")
    public void setRegistrationdate(Instant registrationdate) {
        this.registrationdate = registrationdate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.797998-07:00", comments="Source field: catalog_count.catalogCountEnumId")
    public Long getCatalogcountenumid() {
        return catalogcountenumid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.798093-07:00", comments="Source field: catalog_count.catalogCountEnumId")
    public void setCatalogcountenumid(Long catalogcountenumid) {
        this.catalogcountenumid = catalogcountenumid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.798211-07:00", comments="Source field: catalog_count.amount")
    public Double getAmount() {
        return amount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.798275-07:00", comments="Source field: catalog_count.amount")
    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.798372-07:00", comments="Source field: catalog_count.details")
    public String getDetails() {
        return details;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.79846-07:00", comments="Source field: catalog_count.details")
    public void setDetails(String details) {
        this.details = details;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.798584-07:00", comments="Source field: catalog_count.isDeleted")
    public Boolean getIsdeleted() {
        return isdeleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.798637-07:00", comments="Source field: catalog_count.isDeleted")
    public void setIsdeleted(Boolean isdeleted) {
        this.isdeleted = isdeleted;
    }
}