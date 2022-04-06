package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Login {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.078818-07:00", comments="Source field: login.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.078952-07:00", comments="Source field: login.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.079059-07:00", comments="Source field: login.username")
    private String username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.079187-07:00", comments="Source field: login.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.079296-07:00", comments="Source field: login.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.079426-07:00", comments="Source field: login.personaId")
    private Integer personaid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.078873-07:00", comments="Source field: login.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.078913-07:00", comments="Source field: login.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.07899-07:00", comments="Source field: login.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.079027-07:00", comments="Source field: login.password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.079101-07:00", comments="Source field: login.username")
    public String getUsername() {
        return username;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.079137-07:00", comments="Source field: login.username")
    public void setUsername(String username) {
        this.username = username;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.07923-07:00", comments="Source field: login.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.079266-07:00", comments="Source field: login.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.079347-07:00", comments="Source field: login.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.079385-07:00", comments="Source field: login.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.079459-07:00", comments="Source field: login.personaId")
    public Integer getPersonaid() {
        return personaid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.079509-07:00", comments="Source field: login.personaId")
    public void setPersonaid(Integer personaid) {
        this.personaid = personaid;
    }
}