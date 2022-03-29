package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CatalogCountDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.802186-07:00", comments="Source Table: catalog_count")
    public static final CatalogCount catalogCount = new CatalogCount();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.802649-07:00", comments="Source field: catalog_count.id")
    public static final SqlColumn<Long> id = catalogCount.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.803035-07:00", comments="Source field: catalog_count.registrationDate")
    public static final SqlColumn<Instant> registrationdate = catalogCount.registrationdate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.803162-07:00", comments="Source field: catalog_count.catalogCountEnumId")
    public static final SqlColumn<Long> catalogcountenumid = catalogCount.catalogcountenumid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.803255-07:00", comments="Source field: catalog_count.amount")
    public static final SqlColumn<Double> amount = catalogCount.amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.803343-07:00", comments="Source field: catalog_count.details")
    public static final SqlColumn<String> details = catalogCount.details;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.803428-07:00", comments="Source field: catalog_count.isDeleted")
    public static final SqlColumn<Boolean> isdeleted = catalogCount.isdeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.802471-07:00", comments="Source Table: catalog_count")
    public static final class CatalogCount extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Instant> registrationdate = column("registrationDate", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> catalogcountenumid = column("catalogCountEnumId", JDBCType.BIGINT);

        public final SqlColumn<Double> amount = column("amount", JDBCType.DOUBLE);

        public final SqlColumn<String> details = column("details", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> isdeleted = column("isDeleted", JDBCType.BIT);

        public CatalogCount() {
            super("catalog_count");
        }
    }
}