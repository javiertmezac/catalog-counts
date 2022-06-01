package com.jtmc.apps.reforma.domain;

import javax.annotation.Generated;

public class Period {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.532868-07:00", comments="Source field: period.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.536574-07:00", comments="Source field: period.description")
    private String description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.536791-07:00", comments="Source field: period.from")
    private Integer from;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.536949-07:00", comments="Source field: period.to")
    private Integer to;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.537132-07:00", comments="Source field: period.year")
    private Integer year;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.537293-07:00", comments="Source field: period.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.536097-07:00", comments="Source field: period.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.536475-07:00", comments="Source field: period.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.536638-07:00", comments="Source field: period.description")
    public String getDescription() {
        return description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.536735-07:00", comments="Source field: period.description")
    public void setDescription(String description) {
        this.description = description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.536845-07:00", comments="Source field: period.from")
    public Integer getFrom() {
        return from;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.5369-07:00", comments="Source field: period.from")
    public void setFrom(Integer from) {
        this.from = from;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.537009-07:00", comments="Source field: period.to")
    public Integer getTo() {
        return to;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.537081-07:00", comments="Source field: period.to")
    public void setTo(Integer to) {
        this.to = to;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.537184-07:00", comments="Source field: period.year")
    public Integer getYear() {
        return year;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.537245-07:00", comments="Source field: period.year")
    public void setYear(Integer year) {
        this.year = year;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.537353-07:00", comments="Source field: period.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.537402-07:00", comments="Source field: period.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }
}