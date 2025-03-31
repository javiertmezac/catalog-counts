package com.jtmc.apps.reforma.repository.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.Instant;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class TransferRegistryDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244361-07:00", comments="Source Table: transferRegistry")
    public static final TransferRegistry transferRegistry = new TransferRegistry();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244413-07:00", comments="Source field: transferRegistry.transferRegistryId")
    public static final SqlColumn<byte[]> transferRegistryId = transferRegistry.transferRegistryId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244431-07:00", comments="Source field: transferRegistry.fromAccountId")
    public static final SqlColumn<Integer> fromAccountId = transferRegistry.fromAccountId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244448-07:00", comments="Source field: transferRegistry.toAccountId")
    public static final SqlColumn<Integer> toAccountId = transferRegistry.toAccountId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244464-07:00", comments="Source field: transferRegistry.amount")
    public static final SqlColumn<Double> amount = transferRegistry.amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.24448-07:00", comments="Source field: transferRegistry.catalogCountEnumId")
    public static final SqlColumn<Integer> catalogCountEnumId = transferRegistry.catalogCountEnumId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244494-07:00", comments="Source field: transferRegistry.entryPersonId")
    public static final SqlColumn<Integer> entryPersonId = transferRegistry.entryPersonId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244512-07:00", comments="Source field: transferRegistry.entryDate")
    public static final SqlColumn<Instant> entryDate = transferRegistry.entryDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244533-07:00", comments="Source field: transferRegistry.transferRegistryState")
    public static final SqlColumn<Boolean> transferRegistryState = transferRegistry.transferRegistryState;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244548-07:00", comments="Source field: transferRegistry.acceptedPersonId")
    public static final SqlColumn<Integer> acceptedPersonId = transferRegistry.acceptedPersonId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244564-07:00", comments="Source field: transferRegistry.acceptedDate")
    public static final SqlColumn<Instant> acceptedDate = transferRegistry.acceptedDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244578-07:00", comments="Source field: transferRegistry.transferRegistryStatus")
    public static final SqlColumn<Boolean> transferRegistryStatus = transferRegistry.transferRegistryStatus;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244595-07:00", comments="Source field: transferRegistry.details")
    public static final SqlColumn<String> details = transferRegistry.details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244393-07:00", comments="Source Table: transferRegistry")
    public static final class TransferRegistry extends AliasableSqlTable<TransferRegistry> {
        public final SqlColumn<byte[]> transferRegistryId = column("transferRegistryId", JDBCType.BINARY);

        public final SqlColumn<Integer> fromAccountId = column("fromAccountId", JDBCType.INTEGER);

        public final SqlColumn<Integer> toAccountId = column("toAccountId", JDBCType.INTEGER);

        public final SqlColumn<Double> amount = column("amount", JDBCType.DOUBLE);

        public final SqlColumn<Integer> catalogCountEnumId = column("catalogCountEnumId", JDBCType.INTEGER);

        public final SqlColumn<Integer> entryPersonId = column("entryPersonId", JDBCType.INTEGER);

        public final SqlColumn<Instant> entryDate = column("entryDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> transferRegistryState = column("transferRegistryState", JDBCType.BIT);

        public final SqlColumn<Integer> acceptedPersonId = column("acceptedPersonId", JDBCType.INTEGER);

        public final SqlColumn<Instant> acceptedDate = column("acceptedDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> transferRegistryStatus = column("transferRegistryStatus", JDBCType.BIT);

        public final SqlColumn<String> details = column("details", JDBCType.LONGVARCHAR);

        public TransferRegistry() {
            super("transferRegistry", TransferRegistry::new);
        }
    }
}