package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import jakarta.annotation.Generated;

public class PersonaDetails {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.084632-07:00", comments="Source field: persona_details.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.084765-07:00", comments="Source field: persona_details.personaId")
    private Integer personaid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.084868-07:00", comments="Source field: persona_details.branchId")
    private Integer branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.084972-07:00", comments="Source field: persona_details.roleId")
    private Integer roleid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085142-07:00", comments="Source field: persona_details.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085247-07:00", comments="Source field: persona_details.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.084688-07:00", comments="Source field: persona_details.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.084725-07:00", comments="Source field: persona_details.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.084797-07:00", comments="Source field: persona_details.personaId")
    public Integer getPersonaid() {
        return personaid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.084835-07:00", comments="Source field: persona_details.personaId")
    public void setPersonaid(Integer personaid) {
        this.personaid = personaid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.0849-07:00", comments="Source field: persona_details.branchId")
    public Integer getBranchid() {
        return branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.084942-07:00", comments="Source field: persona_details.branchId")
    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085014-07:00", comments="Source field: persona_details.roleId")
    public Integer getRoleid() {
        return roleid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085089-07:00", comments="Source field: persona_details.roleId")
    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085186-07:00", comments="Source field: persona_details.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085218-07:00", comments="Source field: persona_details.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085279-07:00", comments="Source field: persona_details.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085312-07:00", comments="Source field: persona_details.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}