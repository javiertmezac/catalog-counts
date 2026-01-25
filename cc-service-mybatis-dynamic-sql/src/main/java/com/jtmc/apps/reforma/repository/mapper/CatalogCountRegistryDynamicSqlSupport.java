package com.jtmc.apps.reforma.repository.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.Instant;
import java.util.UUID;

import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CatalogCountRegistryDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.673868-08:00", comments="Source Table: catalog_count_registry")
    public static final CatalogCountRegistry catalogCountRegistry = new CatalogCountRegistry();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.674019-08:00", comments="Source field: catalog_count_registry.catalogCountRegistryId")
    public static final SqlColumn<UUID> catalogcountregistryid = catalogCountRegistry.catalogcountregistryid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.674174-08:00", comments="Source field: catalog_count_registry.registryType")
    public static final SqlColumn<String> registrytype = catalogCountRegistry.registrytype;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.674217-08:00", comments="Source field: catalog_count_registry.entryPersonId")
    public static final SqlColumn<Integer> entrypersonid = catalogCountRegistry.entrypersonid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.674265-08:00", comments="Source field: catalog_count_registry.entryDate")
    public static final SqlColumn<Instant> entrydate = catalogCountRegistry.entrydate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.674302-08:00", comments="Source field: catalog_count_registry.acceptedPersonId")
    public static final SqlColumn<Integer> acceptedpersonid = catalogCountRegistry.acceptedpersonid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.674341-08:00", comments="Source field: catalog_count_registry.acceptedDate")
    public static final SqlColumn<Instant> accepteddate = catalogCountRegistry.accepteddate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.674379-08:00", comments="Source field: catalog_count_registry.inactiveDate")
    public static final SqlColumn<Instant> inactivedate = catalogCountRegistry.inactivedate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.674416-08:00", comments="Source field: catalog_count_registry.branchId")
    public static final SqlColumn<Integer> branchid = catalogCountRegistry.branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.674452-08:00", comments="Source field: catalog_count_registry.details")
    public static final SqlColumn<String> details = catalogCountRegistry.details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.673951-08:00", comments="Source Table: catalog_count_registry")
    public static final class CatalogCountRegistry extends AliasableSqlTable<CatalogCountRegistry> {
        public final SqlColumn<UUID> catalogcountregistryid = column("catalogCountRegistryId", JDBCType.BINARY);

        public final SqlColumn<String> registrytype = column("registryType", JDBCType.CHAR);

        public final SqlColumn<Integer> entrypersonid = column("entryPersonId", JDBCType.INTEGER);

        public final SqlColumn<Instant> entrydate = column("entryDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> acceptedpersonid = column("acceptedPersonId", JDBCType.INTEGER);

        public final SqlColumn<Instant> accepteddate = column("acceptedDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Instant> inactivedate = column("inactiveDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> branchid = column("branchId", JDBCType.INTEGER);

        public final SqlColumn<String> details = column("details", JDBCType.LONGVARCHAR);

        public CatalogCountRegistry() {
            super("catalog_count_registry", CatalogCountRegistry::new);
        }
    }
}