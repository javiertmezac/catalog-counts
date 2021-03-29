package com.jtmc.apps.reforma.repository.mybatis.dbmapper.service;

import org.apache.ibatis.jdbc.SQL;

public class ServiceMapperProvider {
    private String tableName = "service";

    public String getServiceByDate() {
        return new SQL()
                .SELECT("*")
                .FROM(tableName)
                .WHERE("date = #{date}").toString();
    }

    public String getServiceById() {
        return new SQL()
                .SELECT("*")
                .FROM(tableName)
                .WHERE("id = #{serviceId}")
                .toString();
    }
}
