package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class BranchDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.600989-07:00", comments="Source Table: branch")
    public static final Branch branch = new Branch();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.601379-07:00", comments="Source field: branch.id")
    public static final SqlColumn<Long> id = branch.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.601756-07:00", comments="Source field: branch.address")
    public static final SqlColumn<String> address = branch.address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.601874-07:00", comments="Source field: branch.name")
    public static final SqlColumn<String> name = branch.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.601976-07:00", comments="Source field: branch.registration")
    public static final SqlColumn<Instant> registration = branch.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.60207-07:00", comments="Source field: branch.status")
    public static final SqlColumn<Boolean> status = branch.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.601221-07:00", comments="Source Table: branch")
    public static final class Branch extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> address = column("address", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public Branch() {
            super("branch");
        }
    }
}