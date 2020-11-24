package com.jtmc.apps.reforma.repository.mybatis.dbmapper.monthlytotal;

import org.apache.ibatis.jdbc.SQL;

public class MonthlyTotalMapperProvider {

    private String tableName = "monthly_total";

    public String selectMonthlyTotalRecordSql() {
        return new SQL()
                .SELECT("*")
                .FROM(tableName)
                .WHERE("YEAR(registrationDate) = #{currentDateYear}")
                .AND()
                .WHERE("MONTH(registrationDate) = #{currentDateMonth}")
                .toString();
    }
}
