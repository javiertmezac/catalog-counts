package com.jtmc.apps.reforma.repository.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.Instant;
import java.util.UUID;

import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class CatalogCountRegistryDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.369923-08:00", comments="Source Table: catalog_count_registry")
    public static final CatalogCountRegistry catalogCountRegistry = new CatalogCountRegistry();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.370082-08:00", comments="Source field: catalog_count_registry.catalogCountRegistryId")
    public static final SqlColumn<UUID> catalogcountregistryid = catalogCountRegistry.catalogcountregistryid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.370246-08:00", comments="Source field: catalog_count_registry.registryType")
    public static final SqlColumn<String> registrytype = catalogCountRegistry.registrytype;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.37029-08:00", comments="Source field: catalog_count_registry.entryPersonId")
    public static final SqlColumn<Integer> entrypersonid = catalogCountRegistry.entrypersonid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.370324-08:00", comments="Source field: catalog_count_registry.entryDate")
    public static final SqlColumn<Instant> entrydate = catalogCountRegistry.entrydate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.370369-08:00", comments="Source field: catalog_count_registry.acceptedPersonId")
    public static final SqlColumn<Integer> acceptedpersonid = catalogCountRegistry.acceptedpersonid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.37043-08:00", comments="Source field: catalog_count_registry.acceptedDate")
    public static final SqlColumn<Instant> accepteddate = catalogCountRegistry.accepteddate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.370471-08:00", comments="Source field: catalog_count_registry.inactiveDate")
    public static final SqlColumn<Instant> inactivedate = catalogCountRegistry.inactivedate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.370502-08:00", comments="Source field: catalog_count_registry.branchId")
    public static final SqlColumn<Integer> branchid = catalogCountRegistry.branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.370533-08:00", comments="Source field: catalog_count_registry.catalogCountId")
    public static final SqlColumn<Integer> catalogcountid = catalogCountRegistry.catalogcountid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.370574-08:00", comments="Source field: catalog_count_registry.details")
    public static final SqlColumn<String> details = catalogCountRegistry.details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-25T20:47:33.370011-08:00", comments="Source Table: catalog_count_registry")
    public static final class CatalogCountRegistry extends AliasableSqlTable<CatalogCountRegistry> {
        public final SqlColumn<UUID> catalogcountregistryid = column("catalogCountRegistryId", JDBCType.BINARY);

        public final SqlColumn<String> registrytype = column("registryType", JDBCType.CHAR);

        public final SqlColumn<Integer> entrypersonid = column("entryPersonId", JDBCType.INTEGER);

        public final SqlColumn<Instant> entrydate = column("entryDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> acceptedpersonid = column("acceptedPersonId", JDBCType.INTEGER);

        public final SqlColumn<Instant> accepteddate = column("acceptedDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Instant> inactivedate = column("inactiveDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> branchid = column("branchId", JDBCType.INTEGER);

        public final SqlColumn<Integer> catalogcountid = column("catalogCountId", JDBCType.INTEGER);

        public final SqlColumn<String> details = column("details", JDBCType.LONGVARCHAR);

        public CatalogCountRegistry() {
            super("catalog_count_registry", CatalogCountRegistry::new);
        }
    }
}