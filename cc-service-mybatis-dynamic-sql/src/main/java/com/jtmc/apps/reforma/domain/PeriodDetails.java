package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class PeriodDetails {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.557605-07:00", comments="Source field: period_details.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.557843-07:00", comments="Source field: period_details.confirmedBy")
    private Integer confirmedby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558041-07:00", comments="Source field: period_details.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558225-07:00", comments="Source field: period_details.periodId")
    private Integer periodid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558403-07:00", comments="Source field: period_details.branchId")
    private Integer branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558602-07:00", comments="Source field: period_details.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.557694-07:00", comments="Source field: period_details.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.557776-07:00", comments="Source field: period_details.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.55791-07:00", comments="Source field: period_details.confirmedBy")
    public Integer getConfirmedby() {
        return confirmedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.557976-07:00", comments="Source field: period_details.confirmedBy")
    public void setConfirmedby(Integer confirmedby) {
        this.confirmedby = confirmedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558107-07:00", comments="Source field: period_details.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558169-07:00", comments="Source field: period_details.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558286-07:00", comments="Source field: period_details.periodId")
    public Integer getPeriodid() {
        return periodid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558346-07:00", comments="Source field: period_details.periodId")
    public void setPeriodid(Integer periodid) {
        this.periodid = periodid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558458-07:00", comments="Source field: period_details.branchId")
    public Integer getBranchid() {
        return branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.55852-07:00", comments="Source field: period_details.branchId")
    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558663-07:00", comments="Source field: period_details.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558706-07:00", comments="Source field: period_details.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}