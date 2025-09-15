package com.jtmc.apps.reforma.domain;

import jakarta.annotation.Generated;
import java.time.Instant;

public class Branch {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.136278-07:00", comments="Source field: branch.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137633-07:00", comments="Source field: branch.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137715-07:00", comments="Source field: branch.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137781-07:00", comments="Source field: branch.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.13784-07:00", comments="Source field: branch.timezoneId")
    private Integer timezoneId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137895-07:00", comments="Source field: branch.address")
    private String address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137481-07:00", comments="Source field: branch.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137605-07:00", comments="Source field: branch.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137659-07:00", comments="Source field: branch.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137693-07:00", comments="Source field: branch.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137741-07:00", comments="Source field: branch.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137763-07:00", comments="Source field: branch.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137801-07:00", comments="Source field: branch.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.13782-07:00", comments="Source field: branch.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137858-07:00", comments="Source field: branch.timezoneId")
    public Integer getTimezoneId() {
        return timezoneId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137879-07:00", comments="Source field: branch.timezoneId")
    public void setTimezoneId(Integer timezoneId) {
        this.timezoneId = timezoneId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137916-07:00", comments="Source field: branch.address")
    public String getAddress() {
        return address;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.137935-07:00", comments="Source field: branch.address")
    public void setAddress(String address) {
        this.address = address;
    }
}