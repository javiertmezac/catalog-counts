package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Branch {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.975227-07:00", comments="Source field: branch.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.976739-07:00", comments="Source field: branch.address")
    private String address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.97684-07:00", comments="Source field: branch.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.977143-07:00", comments="Source field: branch.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.977223-07:00", comments="Source field: branch.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.97729-07:00", comments="Source field: branch.timezoneId")
    private Integer timezoneid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.97645-07:00", comments="Source field: branch.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.976687-07:00", comments="Source field: branch.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.976771-07:00", comments="Source field: branch.address")
    public String getAddress() {
        return address;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.976814-07:00", comments="Source field: branch.address")
    public void setAddress(String address) {
        this.address = address;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.976865-07:00", comments="Source field: branch.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.977118-07:00", comments="Source field: branch.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.977173-07:00", comments="Source field: branch.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.977202-07:00", comments="Source field: branch.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.977246-07:00", comments="Source field: branch.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.977268-07:00", comments="Source field: branch.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.977316-07:00", comments="Source field: branch.timezoneId")
    public Integer getTimezoneid() {
        return timezoneid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.977339-07:00", comments="Source field: branch.timezoneId")
    public void setTimezoneid(Integer timezoneid) {
        this.timezoneid = timezoneid;
    }
}