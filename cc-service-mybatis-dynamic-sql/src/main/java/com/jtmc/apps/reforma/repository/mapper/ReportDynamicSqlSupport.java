package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ReportDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277425-07:00", comments="Source Table: report")
    public static final Report report = new Report();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277585-07:00", comments="Source field: report.id")
    public static final SqlColumn<Integer> id = report.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277664-07:00", comments="Source field: report.reportedBy")
    public static final SqlColumn<Integer> reportedby = report.reportedby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277743-07:00", comments="Source field: report.registration")
    public static final SqlColumn<Instant> registration = report.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277817-07:00", comments="Source field: report.uuid")
    public static final SqlColumn<String> uuid = report.uuid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277893-07:00", comments="Source field: report.branchId")
    public static final SqlColumn<Integer> branchid = report.branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277976-07:00", comments="Source field: report.periodId")
    public static final SqlColumn<Integer> periodid = report.periodid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.278055-07:00", comments="Source field: report.periodConfirmedBy")
    public static final SqlColumn<Integer> periodconfirmedby = report.periodconfirmedby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.278129-07:00", comments="Source field: report.status")
    public static final SqlColumn<Boolean> status = report.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.277502-07:00", comments="Source Table: report")
    public static final class Report extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> reportedby = column("reportedBy", JDBCType.INTEGER);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<String> uuid = column("uuid", JDBCType.VARCHAR);

        public final SqlColumn<Integer> branchid = column("branchId", JDBCType.INTEGER);

        public final SqlColumn<Integer> periodid = column("periodId", JDBCType.INTEGER);

        public final SqlColumn<Integer> periodconfirmedby = column("periodConfirmedBy", JDBCType.INTEGER);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public Report() {
            super("report");
        }
    }
}