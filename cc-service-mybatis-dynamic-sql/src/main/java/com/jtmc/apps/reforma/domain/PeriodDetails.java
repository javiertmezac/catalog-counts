package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class PeriodDetails {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.866199-07:00", comments="Source field: period_details.periodId")
    private Integer periodid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.884203-07:00", comments="Source field: period_details.branchId")
    private Integer branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.88486-07:00", comments="Source field: period_details.confirmedBy")
    private Integer confirmedby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.885288-07:00", comments="Source field: period_details.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.885799-07:00", comments="Source field: period_details.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.88277-07:00", comments="Source field: period_details.periodId")
    public Integer getPeriodid() {
        return periodid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.883954-07:00", comments="Source field: period_details.periodId")
    public void setPeriodid(Integer periodid) {
        this.periodid = periodid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.884543-07:00", comments="Source field: period_details.branchId")
    public Integer getBranchid() {
        return branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.88472-07:00", comments="Source field: period_details.branchId")
    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.88501-07:00", comments="Source field: period_details.confirmedBy")
    public Integer getConfirmedby() {
        return confirmedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.885152-07:00", comments="Source field: period_details.confirmedBy")
    public void setConfirmedby(Integer confirmedby) {
        this.confirmedby = confirmedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.88551-07:00", comments="Source field: period_details.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.885672-07:00", comments="Source field: period_details.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.885934-07:00", comments="Source field: period_details.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.886069-07:00", comments="Source field: period_details.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}