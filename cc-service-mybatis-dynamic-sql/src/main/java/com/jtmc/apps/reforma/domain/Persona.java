package com.jtmc.apps.reforma.domain;

import jakarta.annotation.Generated;
import java.time.Instant;

public class Persona {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144765-07:00", comments="Source field: persona.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144839-07:00", comments="Source field: persona.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144885-07:00", comments="Source field: persona.lastname")
    private String lastname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144928-07:00", comments="Source field: persona.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144972-07:00", comments="Source field: persona.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145012-07:00", comments="Source field: persona.primaryEmail")
    private String primaryEmail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145608-07:00", comments="Source field: persona.secondaryEmail")
    private String secondaryEmail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.1448-07:00", comments="Source field: persona.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144821-07:00", comments="Source field: persona.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144855-07:00", comments="Source field: persona.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144871-07:00", comments="Source field: persona.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144899-07:00", comments="Source field: persona.lastname")
    public String getLastname() {
        return lastname;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144914-07:00", comments="Source field: persona.lastname")
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144943-07:00", comments="Source field: persona.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144958-07:00", comments="Source field: persona.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144986-07:00", comments="Source field: persona.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.144999-07:00", comments="Source field: persona.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145525-07:00", comments="Source field: persona.primaryEmail")
    public String getPrimaryEmail() {
        return primaryEmail;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145586-07:00", comments="Source field: persona.primaryEmail")
    public void setPrimaryEmail(String primaryEmail) {
        this.primaryEmail = primaryEmail;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145628-07:00", comments="Source field: persona.secondaryEmail")
    public String getSecondaryEmail() {
        return secondaryEmail;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145645-07:00", comments="Source field: persona.secondaryEmail")
    public void setSecondaryEmail(String secondaryEmail) {
        this.secondaryEmail = secondaryEmail;
    }
}