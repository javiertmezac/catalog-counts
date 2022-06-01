package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class ReportDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562883-07:00", comments="Source Table: report")
    public static final Report report = new Report();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.563139-07:00", comments="Source field: report.id")
    public static final SqlColumn<Integer> id = report.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.563218-07:00", comments="Source field: report.reportedBy")
    public static final SqlColumn<Integer> reportedby = report.reportedby;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.563293-07:00", comments="Source field: report.registration")
    public static final SqlColumn<Instant> registration = report.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.563364-07:00", comments="Source field: report.uuid")
    public static final SqlColumn<String> uuid = report.uuid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.563434-07:00", comments="Source field: report.periodDetailsId")
    public static final SqlColumn<Integer> perioddetailsid = report.perioddetailsid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.563504-07:00", comments="Source field: report.status")
    public static final SqlColumn<Boolean> status = report.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.562989-07:00", comments="Source Table: report")
    public static final class Report extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> reportedby = column("reportedBy", JDBCType.INTEGER);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<String> uuid = column("uuid", JDBCType.VARCHAR);

        public final SqlColumn<Integer> perioddetailsid = column("periodDetailsId", JDBCType.INTEGER);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public Report() {
            super("report");
        }
    }
}