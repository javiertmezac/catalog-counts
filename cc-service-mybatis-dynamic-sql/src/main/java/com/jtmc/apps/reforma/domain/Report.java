package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import jakarta.annotation.Generated;

public class Report {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.274659-07:00", comments="Source field: report.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.274808-07:00", comments="Source field: report.reportedBy")
    private Integer reportedby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.27493-07:00", comments="Source field: report.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.275051-07:00", comments="Source field: report.uuid")
    private String uuid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.276578-07:00", comments="Source field: report.branchId")
    private Integer branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.276761-07:00", comments="Source field: report.periodId")
    private Integer periodid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277015-07:00", comments="Source field: report.periodConfirmedBy")
    private Integer periodconfirmedby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277254-07:00", comments="Source field: report.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.274714-07:00", comments="Source field: report.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.27476-07:00", comments="Source field: report.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.27485-07:00", comments="Source field: report.reportedBy")
    public Integer getReportedby() {
        return reportedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.274891-07:00", comments="Source field: report.reportedBy")
    public void setReportedby(Integer reportedby) {
        this.reportedby = reportedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.274973-07:00", comments="Source field: report.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.275014-07:00", comments="Source field: report.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.275098-07:00", comments="Source field: report.uuid")
    public String getUuid() {
        return uuid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.275164-07:00", comments="Source field: report.uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.276642-07:00", comments="Source field: report.branchId")
    public Integer getBranchid() {
        return branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.276704-07:00", comments="Source field: report.branchId")
    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.276884-07:00", comments="Source field: report.periodId")
    public Integer getPeriodid() {
        return periodid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.27697-07:00", comments="Source field: report.periodId")
    public void setPeriodid(Integer periodid) {
        this.periodid = periodid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277161-07:00", comments="Source field: report.periodConfirmedBy")
    public Integer getPeriodconfirmedby() {
        return periodconfirmedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277213-07:00", comments="Source field: report.periodConfirmedBy")
    public void setPeriodconfirmedby(Integer periodconfirmedby) {
        this.periodconfirmedby = periodconfirmedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277294-07:00", comments="Source field: report.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277334-07:00", comments="Source field: report.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}