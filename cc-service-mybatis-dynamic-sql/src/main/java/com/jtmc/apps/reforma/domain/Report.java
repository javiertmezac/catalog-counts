package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Report {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.974919-07:00", comments="Source field: report.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.975743-07:00", comments="Source field: report.reportedBy")
    private Integer reportedby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.976283-07:00", comments="Source field: report.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.977101-07:00", comments="Source field: report.uuid")
    private String uuid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.977869-07:00", comments="Source field: report.periodId")
    private Integer periodid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.978434-07:00", comments="Source field: report.branchId")
    private Integer branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.979113-07:00", comments="Source field: report.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.975279-07:00", comments="Source field: report.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.975489-07:00", comments="Source field: report.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.975931-07:00", comments="Source field: report.reportedBy")
    public Integer getReportedby() {
        return reportedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.976107-07:00", comments="Source field: report.reportedBy")
    public void setReportedby(Integer reportedby) {
        this.reportedby = reportedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.97647-07:00", comments="Source field: report.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.976631-07:00", comments="Source field: report.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.977303-07:00", comments="Source field: report.uuid")
    public String getUuid() {
        return uuid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.977699-07:00", comments="Source field: report.uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.97804-07:00", comments="Source field: report.periodId")
    public Integer getPeriodid() {
        return periodid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.978226-07:00", comments="Source field: report.periodId")
    public void setPeriodid(Integer periodid) {
        this.periodid = periodid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.978709-07:00", comments="Source field: report.branchId")
    public Integer getBranchid() {
        return branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.978944-07:00", comments="Source field: report.branchId")
    public void setBranchid(Integer branchid) {
        this.branchid = branchid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.979262-07:00", comments="Source field: report.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.979374-07:00", comments="Source field: report.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}