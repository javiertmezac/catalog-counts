package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Branch {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.594502-07:00", comments="Source field: branch.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.597421-07:00", comments="Source field: branch.address")
    private String address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.597616-07:00", comments="Source field: branch.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.597773-07:00", comments="Source field: branch.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.597962-07:00", comments="Source field: branch.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.597042-07:00", comments="Source field: branch.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.597346-07:00", comments="Source field: branch.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.597479-07:00", comments="Source field: branch.address")
    public String getAddress() {
        return address;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.597564-07:00", comments="Source field: branch.address")
    public void setAddress(String address) {
        this.address = address;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.597669-07:00", comments="Source field: branch.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.597724-07:00", comments="Source field: branch.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.597849-07:00", comments="Source field: branch.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.597905-07:00", comments="Source field: branch.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.598016-07:00", comments="Source field: branch.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.598076-07:00", comments="Source field: branch.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}