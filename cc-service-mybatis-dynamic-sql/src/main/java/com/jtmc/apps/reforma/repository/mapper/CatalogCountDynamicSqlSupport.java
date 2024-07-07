package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CatalogCountDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.072246-07:00", comments="Source Table: catalog_count")
    public static final CatalogCount catalogCount = new CatalogCount();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.072411-07:00", comments="Source field: catalog_count.id")
    public static final SqlColumn<Integer> id = catalogCount.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.072513-07:00", comments="Source field: catalog_count.registration")
    public static final SqlColumn<Instant> registration = catalogCount.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.072591-07:00", comments="Source field: catalog_count.catalogCountEnumId")
    public static final SqlColumn<Integer> catalogcountenumid = catalogCount.catalogcountenumid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.07268-07:00", comments="Source field: catalog_count.amount")
    public static final SqlColumn<Double> amount = catalogCount.amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.072858-07:00", comments="Source field: catalog_count.details")
    public static final SqlColumn<String> details = catalogCount.details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.072968-07:00", comments="Source field: catalog_count.isDeleted")
    public static final SqlColumn<Boolean> isdeleted = catalogCount.isdeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.073048-07:00", comments="Source field: catalog_count.branchId")
    public static final SqlColumn<Integer> branchid = catalogCount.branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.072327-07:00", comments="Source Table: catalog_count")
    public static final class CatalogCount extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<Integer> catalogcountenumid = column("catalogCountEnumId", JDBCType.INTEGER);

        public final SqlColumn<Double> amount = column("amount", JDBCType.DOUBLE);

        public final SqlColumn<String> details = column("details", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> isdeleted = column("isDeleted", JDBCType.BIT);

        public final SqlColumn<Integer> branchid = column("branchId", JDBCType.INTEGER);

        public CatalogCount() {
            super("catalog_count");
        }
    }
}