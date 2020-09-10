package com.jtmc.apps.reforma.dbmapper.catalogcount;

import org.apache.ibatis.jdbc.SQL;

public class CatalogCountMapperProvider {

    private String tableName = "catalog_count";

    public String insertCatalogCountSql() {
        return new SQL()
                .INSERT_INTO(tableName)
                .INTO_COLUMNS("registrationDate, catalogCountEnumId, amount, details, isDeleted")
                .INTO_VALUES("#{model.registrationDate}, " +
                        "#{model.catalogCountEnumId}, #{model.amount}, " +
                        "#{model.details}, #{model.isDeleted}")
                .toString();
    }

    public String selectAllCatalogCountRecordsSql () {
        return new SQL()
                .SELECT("*")
                .FROM(tableName)
                .WHERE("isDeleted = false")
                .toString();
    }

    public String selectOneCatalogCountRecordSql() {
        return new SQL()
                .SELECT("*")
                .FROM(tableName)
                .WHERE("id = #{id}")
                .toString();
    }

    public String logicalDeleteOneCatalogCountRecordSql() {
        return new SQL()
                .UPDATE(tableName)
                .SET("isDeleted = true")
                .WHERE("id = #{id}")
                .toString();
    }
}