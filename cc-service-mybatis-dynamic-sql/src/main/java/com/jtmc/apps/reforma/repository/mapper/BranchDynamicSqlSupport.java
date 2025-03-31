package com.jtmc.apps.reforma.repository.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.Instant;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class BranchDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.139014-07:00", comments="Source Table: branch")
    public static final Branch branch = new Branch();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.139154-07:00", comments="Source field: branch.id")
    public static final SqlColumn<Integer> id = branch.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.139292-07:00", comments="Source field: branch.name")
    public static final SqlColumn<String> name = branch.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.13933-07:00", comments="Source field: branch.registration")
    public static final SqlColumn<Instant> registration = branch.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.13936-07:00", comments="Source field: branch.status")
    public static final SqlColumn<Boolean> status = branch.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.139396-07:00", comments="Source field: branch.timezoneId")
    public static final SqlColumn<Integer> timezoneId = branch.timezoneId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.139427-07:00", comments="Source field: branch.address")
    public static final SqlColumn<String> address = branch.address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.139095-07:00", comments="Source Table: branch")
    public static final class Branch extends AliasableSqlTable<Branch> {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public final SqlColumn<Integer> timezoneId = column("timezoneId", JDBCType.INTEGER);

        public final SqlColumn<String> address = column("address", JDBCType.LONGVARCHAR);

        public Branch() {
            super("branch", Branch::new);
        }
    }
}