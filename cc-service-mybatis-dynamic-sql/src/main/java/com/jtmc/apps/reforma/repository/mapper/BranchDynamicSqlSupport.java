package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BranchDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.978966-07:00", comments="Source Table: branch")
    public static final Branch branch = new Branch();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.979123-07:00", comments="Source field: branch.id")
    public static final SqlColumn<Integer> id = branch.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.979326-07:00", comments="Source field: branch.address")
    public static final SqlColumn<String> address = branch.address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.979372-07:00", comments="Source field: branch.name")
    public static final SqlColumn<String> name = branch.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.979416-07:00", comments="Source field: branch.registration")
    public static final SqlColumn<Instant> registration = branch.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.979451-07:00", comments="Source field: branch.status")
    public static final SqlColumn<Boolean> status = branch.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.979486-07:00", comments="Source field: branch.timezoneId")
    public static final SqlColumn<Integer> timezoneid = branch.timezoneid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:42:56.97905-07:00", comments="Source Table: branch")
    public static final class Branch extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public final SqlColumn<Integer> timezoneid = column("timezoneId", JDBCType.INTEGER);

        public Branch() {
            super("branch");
        }
    }
}