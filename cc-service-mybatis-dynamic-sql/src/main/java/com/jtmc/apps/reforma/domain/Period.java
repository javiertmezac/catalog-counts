package com.jtmc.apps.reforma.domain;

import javax.annotation.Generated;

public class Period {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.793344-07:00", comments="Source field: period.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.7973-07:00", comments="Source field: period.description")
    private String description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.7975-07:00", comments="Source field: period.fromMonth")
    private Integer frommonth;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.797653-07:00", comments="Source field: period.toMonth")
    private Integer tomonth;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.797817-07:00", comments="Source field: period.year")
    private Integer year;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.79799-07:00", comments="Source field: period.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.796896-07:00", comments="Source field: period.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.797225-07:00", comments="Source field: period.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.797357-07:00", comments="Source field: period.description")
    public String getDescription() {
        return description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.797448-07:00", comments="Source field: period.description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.797552-07:00", comments="Source field: period.fromMonth")
    public Integer getFrommonth() {
        return frommonth;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.797606-07:00", comments="Source field: period.fromMonth")
    public void setFrommonth(Integer frommonth) {
        this.frommonth = frommonth;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.797709-07:00", comments="Source field: period.toMonth")
    public Integer getTomonth() {
        return tomonth;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.797762-07:00", comments="Source field: period.toMonth")
    public void setTomonth(Integer tomonth) {
        this.tomonth = tomonth;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.797877-07:00", comments="Source field: period.year")
    public Integer getYear() {
        return year;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.797934-07:00", comments="Source field: period.year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.798042-07:00", comments="Source field: period.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.798091-07:00", comments="Source field: period.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}