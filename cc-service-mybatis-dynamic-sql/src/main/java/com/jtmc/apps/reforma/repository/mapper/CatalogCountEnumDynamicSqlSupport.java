package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import jakarta.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class CatalogCountEnumDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.076092-07:00", comments="Source Table: catalog_count_enum")
    public static final CatalogCountEnum catalogCountEnum = new CatalogCountEnum();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.076254-07:00", comments="Source field: catalog_count_enum.id")
    public static final SqlColumn<Integer> id = catalogCountEnum.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.076344-07:00", comments="Source field: catalog_count_enum.identifier")
    public static final SqlColumn<String> identifier = catalogCountEnum.identifier;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.076423-07:00", comments="Source field: catalog_count_enum.family")
    public static final SqlColumn<String> family = catalogCountEnum.family;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.076493-07:00", comments="Source field: catalog_count_enum.name")
    public static final SqlColumn<String> name = catalogCountEnum.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.076596-07:00", comments="Source field: catalog_count_enum.description")
    public static final SqlColumn<String> description = catalogCountEnum.description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.076745-07:00", comments="Source field: catalog_count_enum.type")
    public static final SqlColumn<Boolean> type = catalogCountEnum.type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.076844-07:00", comments="Source field: catalog_count_enum.isDeleted")
    public static final SqlColumn<Boolean> isdeleted = catalogCountEnum.isdeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.076172-07:00", comments="Source Table: catalog_count_enum")
    public static final class CatalogCountEnum extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> identifier = column("identifier", JDBCType.VARCHAR);

        public final SqlColumn<String> family = column("family", JDBCType.VARCHAR);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> description = column("description", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> type = column("type", JDBCType.BIT);

        public final SqlColumn<Boolean> isdeleted = column("isDeleted", JDBCType.BIT);

        public CatalogCountEnum() {
            super("catalog_count_enum");
        }
    }
}