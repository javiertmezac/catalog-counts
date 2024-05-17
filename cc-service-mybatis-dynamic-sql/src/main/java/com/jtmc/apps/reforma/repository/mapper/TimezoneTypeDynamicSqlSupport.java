package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class TimezoneTypeDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source Table: timezone_type")
    public static final TimezoneType timezoneType = new TimezoneType();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source field: timezone_type.id")
    public static final SqlColumn<Integer> id = timezoneType.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source field: timezone_type.name")
    public static final SqlColumn<String> name = timezoneType.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source field: timezone_type.status")
    public static final SqlColumn<Boolean> status = timezoneType.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source Table: timezone_type")
    public static final class TimezoneType extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public TimezoneType() {
            super("timezone_type");
        }
    }
}