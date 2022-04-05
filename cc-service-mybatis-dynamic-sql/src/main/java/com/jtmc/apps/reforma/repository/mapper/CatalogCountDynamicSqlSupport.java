package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CatalogCountDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.61734-07:00", comments="Source Table: catalog_count")
    public static final CatalogCount catalogCount = new CatalogCount();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617529-07:00", comments="Source field: catalog_count.id")
    public static final SqlColumn<Long> id = catalogCount.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617613-07:00", comments="Source field: catalog_count.registration")
    public static final SqlColumn<Instant> registration = catalogCount.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617693-07:00", comments="Source field: catalog_count.catalogCountEnumId")
    public static final SqlColumn<Long> catalogcountenumid = catalogCount.catalogcountenumid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617767-07:00", comments="Source field: catalog_count.amount")
    public static final SqlColumn<Double> amount = catalogCount.amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617842-07:00", comments="Source field: catalog_count.details")
    public static final SqlColumn<String> details = catalogCount.details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617918-07:00", comments="Source field: catalog_count.isDeleted")
    public static final SqlColumn<Boolean> isdeleted = catalogCount.isdeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.618006-07:00", comments="Source field: catalog_count.branchId")
    public static final SqlColumn<Long> branchid = catalogCount.branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.617447-07:00", comments="Source Table: catalog_count")
    public static final class CatalogCount extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> catalogcountenumid = column("catalogCountEnumId", JDBCType.BIGINT);

        public final SqlColumn<Double> amount = column("amount", JDBCType.DOUBLE);

        public final SqlColumn<String> details = column("details", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> isdeleted = column("isDeleted", JDBCType.BIT);

        public final SqlColumn<Long> branchid = column("branchId", JDBCType.BIGINT);

        public CatalogCount() {
            super("catalog_count");
        }
    }
}