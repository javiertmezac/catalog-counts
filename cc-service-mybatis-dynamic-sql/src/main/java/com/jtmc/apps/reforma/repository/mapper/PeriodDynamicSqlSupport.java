package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PeriodDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.80138-07:00", comments="Source Table: period")
    public static final Period period = new Period();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.801797-07:00", comments="Source field: period.id")
    public static final SqlColumn<Integer> id = period.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.802169-07:00", comments="Source field: period.description")
    public static final SqlColumn<String> description = period.description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.802277-07:00", comments="Source field: period.fromMonth")
    public static final SqlColumn<Integer> frommonth = period.frommonth;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.802404-07:00", comments="Source field: period.toMonth")
    public static final SqlColumn<Integer> tomonth = period.tomonth;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.802493-07:00", comments="Source field: period.year")
    public static final SqlColumn<Integer> year = period.year;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.802578-07:00", comments="Source field: period.status")
    public static final SqlColumn<Boolean> status = period.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.801636-07:00", comments="Source Table: period")
    public static final class Period extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<Integer> frommonth = column("fromMonth", JDBCType.INTEGER);

        public final SqlColumn<Integer> tomonth = column("toMonth", JDBCType.INTEGER);

        public final SqlColumn<Integer> year = column("year", JDBCType.INTEGER);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public Period() {
            super("period");
        }
    }
}