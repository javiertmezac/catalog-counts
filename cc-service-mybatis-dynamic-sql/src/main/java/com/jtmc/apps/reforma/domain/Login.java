package com.jtmc.apps.reforma.domain;

import java.time.Instant;
import javax.annotation.Generated;

public class Login {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.282917-07:00", comments="Source field: login.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.286982-07:00", comments="Source field: login.password")
    private String password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287182-07:00", comments="Source field: login.username")
    private String username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287336-07:00", comments="Source field: login.status")
    private Boolean status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287484-07:00", comments="Source field: login.registration")
    private Instant registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287689-07:00", comments="Source field: login.personaId")
    private Long personaid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.286578-07:00", comments="Source field: login.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.2869-07:00", comments="Source field: login.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287038-07:00", comments="Source field: login.password")
    public String getPassword() {
        return password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287129-07:00", comments="Source field: login.password")
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287234-07:00", comments="Source field: login.username")
    public String getUsername() {
        return username;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287288-07:00", comments="Source field: login.username")
    public void setUsername(String username) {
        this.username = username;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287386-07:00", comments="Source field: login.status")
    public Boolean getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287438-07:00", comments="Source field: login.status")
    public void setStatus(Boolean status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287551-07:00", comments="Source field: login.registration")
    public Instant getRegistration() {
        return registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287607-07:00", comments="Source field: login.registration")
    public void setRegistration(Instant registration) {
        this.registration = registration;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287777-07:00", comments="Source field: login.personaId")
    public Long getPersonaid() {
        return personaid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.287835-07:00", comments="Source field: login.personaId")
    public void setPersonaid(Long personaid) {
        this.personaid = personaid;
    }
}