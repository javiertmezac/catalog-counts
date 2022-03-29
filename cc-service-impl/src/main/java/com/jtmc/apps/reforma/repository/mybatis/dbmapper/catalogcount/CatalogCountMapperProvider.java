package com.jtmc.apps.reforma.repository.mybatis.dbmapper.catalogcount;

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
                .SELECT("cc.id as ccId , cc.registrationDate as ccRegistrationDate, cc.amount as ccAmount, " +
                        "cc.details as ccDetails, cc.isDeleted as ccIsDeleted, cce.id as cceId, " +
                        "cce.identifier as cceIdentifier, cce.name as cceName")
                .FROM(tableName + " as cc ")
                .INNER_JOIN("catalog_count_enum as cce on cc.catalogCountEnumId = cce.id")
                .WHERE("cc.isDeleted = false")
                .ORDER_BY("registrationDate asc")
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
