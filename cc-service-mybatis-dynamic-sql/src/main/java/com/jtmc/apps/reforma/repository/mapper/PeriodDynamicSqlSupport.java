package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PeriodDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.540862-07:00", comments="Source Table: period")
    public static final Period period = new Period();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.541318-07:00", comments="Source field: period.id")
    public static final SqlColumn<Integer> id = period.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.54167-07:00", comments="Source field: period.description")
    public static final SqlColumn<String> description = period.description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.541806-07:00", comments="Source field: period.from")
    public static final SqlColumn<Integer> from = period.from;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.541897-07:00", comments="Source field: period.to")
    public static final SqlColumn<Integer> to = period.to;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.541993-07:00", comments="Source field: period.year")
    public static final SqlColumn<Integer> year = period.year;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.542076-07:00", comments="Source field: period.status")
    public static final SqlColumn<Boolean> status = period.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.541131-07:00", comments="Source Table: period")
    public static final class Period extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<Integer> from = column("from", JDBCType.INTEGER);

        public final SqlColumn<Integer> to = column("to", JDBCType.INTEGER);

        public final SqlColumn<Integer> year = column("year", JDBCType.INTEGER);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public Period() {
            super("period");
        }
    }
}