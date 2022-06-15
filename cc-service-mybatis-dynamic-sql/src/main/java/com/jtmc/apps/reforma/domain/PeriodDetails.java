package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class PeriodDetails {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.250486-07:00", comments="Source field: period_details.branchId")
    private Integer branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.254461-07:00", comments="Source field: period_details.periodId")
    private Integer periodid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.254633-07:00", comments="Source field: period_details.confirmedBy")
    private Integer confirmedby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.254792-07:00", comments="Source field: period_details.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.255083-07:00", comments="Source field: period_details.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.254052-07:00", comments="Source field: period_details.branchId")
    public Integer getBranchid() {
        return branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.25438-07:00", comments="Source field: period_details.branchId")
    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.254523-07:00", comments="Source field: period_details.periodId")
    public Integer getPeriodid() {
        return periodid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.254581-07:00", comments="Source field: period_details.periodId")
    public void setPeriodid(Integer periodid) {
        this.periodid = periodid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.254687-07:00", comments="Source field: period_details.confirmedBy")
    public Integer getConfirmedby() {
        return confirmedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.254742-07:00", comments="Source field: period_details.confirmedBy")
    public void setConfirmedby(Integer confirmedby) {
        this.confirmedby = confirmedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.254866-07:00", comments="Source field: period_details.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.254999-07:00", comments="Source field: period_details.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.255173-07:00", comments="Source field: period_details.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.255255-07:00", comments="Source field: period_details.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}