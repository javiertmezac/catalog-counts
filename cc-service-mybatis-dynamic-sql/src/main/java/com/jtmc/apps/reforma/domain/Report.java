package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Report {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.561851-07:00", comments="Source field: report.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562019-07:00", comments="Source field: report.reportedBy")
    private Integer reportedby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562177-07:00", comments="Source field: report.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.56246-07:00", comments="Source field: report.uuid")
    private String uuid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562623-07:00", comments="Source field: report.periodDetailsId")
    private Integer perioddetailsid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562729-07:00", comments="Source field: report.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.56191-07:00", comments="Source field: report.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.561967-07:00", comments="Source field: report.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562072-07:00", comments="Source field: report.reportedBy")
    public Integer getReportedby() {
        return reportedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562128-07:00", comments="Source field: report.reportedBy")
    public void setReportedby(Integer reportedby) {
        this.reportedby = reportedby;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562231-07:00", comments="Source field: report.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562362-07:00", comments="Source field: report.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562538-07:00", comments="Source field: report.uuid")
    public String getUuid() {
        return uuid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562587-07:00", comments="Source field: report.uuid")
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.56266-07:00", comments="Source field: report.periodDetailsId")
    public Integer getPerioddetailsid() {
        return perioddetailsid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562696-07:00", comments="Source field: report.periodDetailsId")
    public void setPerioddetailsid(Integer perioddetailsid) {
        this.perioddetailsid = perioddetailsid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562764-07:00", comments="Source field: report.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.5628-07:00", comments="Source field: report.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}