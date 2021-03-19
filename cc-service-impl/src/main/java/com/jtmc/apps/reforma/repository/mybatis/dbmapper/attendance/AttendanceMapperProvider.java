package com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.jdbc.SQL;

public class AttendanceMapperProvider {
    private String tableName = "attendance";


    public String selectAttendanceByIdService() {
        return new SQL()
                .SELECT("*")
                .FROM(tableName)
                .WHERE("idService = 1")
                .toString();
    }
}
