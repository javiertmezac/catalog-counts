package com.jtmc.apps.reforma.repository.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.Instant;
import java.util.UUID;

import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TransferRegistryDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.912593-07:00", comments="Source Table: transferRegistry")
    public static final TransferRegistry transferRegistry = new TransferRegistry();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.912745-07:00", comments="Source field: transferRegistry.transferRegistryId")
    public static final SqlColumn<UUID> transferregistryid = transferRegistry.transferregistryid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.912885-07:00", comments="Source field: transferRegistry.fromAccountId")
    public static final SqlColumn<Integer> fromaccountid = transferRegistry.fromaccountid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.912928-07:00", comments="Source field: transferRegistry.toAccountId")
    public static final SqlColumn<Integer> toaccountid = transferRegistry.toaccountid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.912964-07:00", comments="Source field: transferRegistry.amount")
    public static final SqlColumn<Double> amount = transferRegistry.amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.913001-07:00", comments="Source field: transferRegistry.fromAccountCatalogCountId")
    public static final SqlColumn<Integer> fromaccountcatalogcountid = transferRegistry.fromaccountcatalogcountid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.913038-07:00", comments="Source field: transferRegistry.toAccountCatalogCountId")
    public static final SqlColumn<Integer> toaccountcatalogcountid = transferRegistry.toaccountcatalogcountid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.913069-07:00", comments="Source field: transferRegistry.entryPersonId")
    public static final SqlColumn<Integer> entrypersonid = transferRegistry.entrypersonid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.913102-07:00", comments="Source field: transferRegistry.entryDate")
    public static final SqlColumn<Instant> entrydate = transferRegistry.entrydate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.913134-07:00", comments="Source field: transferRegistry.inactiveDate")
    public static final SqlColumn<Instant> inactivedate = transferRegistry.inactivedate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.913164-07:00", comments="Source field: transferRegistry.acceptedPersonId")
    public static final SqlColumn<Integer> acceptedpersonid = transferRegistry.acceptedpersonid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.913197-07:00", comments="Source field: transferRegistry.acceptedDate")
    public static final SqlColumn<Instant> accepteddate = transferRegistry.accepteddate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.913226-07:00", comments="Source field: transferRegistry.details")
    public static final SqlColumn<String> details = transferRegistry.details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.912685-07:00", comments="Source Table: transferRegistry")
    public static final class TransferRegistry extends AliasableSqlTable<TransferRegistry> {
        public final SqlColumn<UUID> transferregistryid = column("transferRegistryId", JDBCType.BINARY);

        public final SqlColumn<Integer> fromaccountid = column("fromAccountId", JDBCType.INTEGER);

        public final SqlColumn<Integer> toaccountid = column("toAccountId", JDBCType.INTEGER);

        public final SqlColumn<Double> amount = column("amount", JDBCType.DOUBLE);

        public final SqlColumn<Integer> fromaccountcatalogcountid = column("fromAccountCatalogCountId", JDBCType.INTEGER);

        public final SqlColumn<Integer> toaccountcatalogcountid = column("toAccountCatalogCountId", JDBCType.INTEGER);

        public final SqlColumn<Integer> entrypersonid = column("entryPersonId", JDBCType.INTEGER);

        public final SqlColumn<Instant> entrydate = column("entryDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Instant> inactivedate = column("inactiveDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> acceptedpersonid = column("acceptedPersonId", JDBCType.INTEGER);

        public final SqlColumn<Instant> accepteddate = column("acceptedDate", JDBCType.TIMESTAMP);

        public final SqlColumn<String> details = column("details", JDBCType.LONGVARCHAR);

        public TransferRegistry() {
            super("transferRegistry", TransferRegistry::new);
        }
    }
}