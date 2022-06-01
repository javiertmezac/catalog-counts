package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PeriodDetailsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558798-07:00", comments="Source Table: period_details")
    public static final PeriodDetails periodDetails = new PeriodDetails();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558981-07:00", comments="Source field: period_details.id")
    public static final SqlColumn<Integer> id = periodDetails.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.559065-07:00", comments="Source field: period_details.confirmedBy")
    public static final SqlColumn<Integer> confirmedby = periodDetails.confirmedby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.559149-07:00", comments="Source field: period_details.registration")
    public static final SqlColumn<Instant> registration = periodDetails.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.559252-07:00", comments="Source field: period_details.periodId")
    public static final SqlColumn<Integer> periodid = periodDetails.periodid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.55937-07:00", comments="Source field: period_details.branchId")
    public static final SqlColumn<Integer> branchid = periodDetails.branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.559504-07:00", comments="Source field: period_details.status")
    public static final SqlColumn<Boolean> status = periodDetails.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.558886-07:00", comments="Source Table: period_details")
    public static final class PeriodDetails extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> confirmedby = column("confirmedBy", JDBCType.INTEGER);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> periodid = column("periodId", JDBCType.INTEGER);

        public final SqlColumn<Integer> branchid = column("branchId", JDBCType.INTEGER);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public PeriodDetails() {
            super("period_details");
        }
    }
}