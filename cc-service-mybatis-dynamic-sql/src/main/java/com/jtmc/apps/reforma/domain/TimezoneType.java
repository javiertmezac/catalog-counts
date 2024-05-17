package com.jtmc.apps.reforma.domain;

import javax.annotation.Generated;

public class TimezoneType {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source field: timezone_type.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source field: timezone_type.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source field: timezone_type.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source field: timezone_type.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source field: timezone_type.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source field: timezone_type.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source field: timezone_type.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source field: timezone_type.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source field: timezone_type.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}