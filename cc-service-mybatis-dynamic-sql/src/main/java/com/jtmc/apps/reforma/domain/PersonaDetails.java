package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class PersonaDetails {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.629645-07:00", comments="Source field: persona_details.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.629748-07:00", comments="Source field: persona_details.personaId")
    private Long personaid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.629843-07:00", comments="Source field: persona_details.branchId")
    private Long branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.62996-07:00", comments="Source field: persona_details.roleId")
    private Long roleid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630118-07:00", comments="Source field: persona_details.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630213-07:00", comments="Source field: persona_details.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.629683-07:00", comments="Source field: persona_details.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.629719-07:00", comments="Source field: persona_details.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.62978-07:00", comments="Source field: persona_details.personaId")
    public Long getPersonaid() {
        return personaid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.629812-07:00", comments="Source field: persona_details.personaId")
    public void setPersonaid(Long personaid) {
        this.personaid = personaid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.629895-07:00", comments="Source field: persona_details.branchId")
    public Long getBranchid() {
        return branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.629929-07:00", comments="Source field: persona_details.branchId")
    public void setBranchid(Long branchid) {
        this.branchid = branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630008-07:00", comments="Source field: persona_details.roleId")
    public Long getRoleid() {
        return roleid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630082-07:00", comments="Source field: persona_details.roleId")
    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630152-07:00", comments="Source field: persona_details.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630185-07:00", comments="Source field: persona_details.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630245-07:00", comments="Source field: persona_details.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630278-07:00", comments="Source field: persona_details.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}