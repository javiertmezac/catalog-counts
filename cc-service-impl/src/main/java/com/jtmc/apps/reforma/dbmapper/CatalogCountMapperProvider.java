package com.jtmc.apps.reforma.dbmapper;

import org.apache.ibatis.jdbc.SQL;

public class CatalogCountMapperProvider {
    private String tableName = "catalog_count";
    private String colRegistrationDate = "registrationDate";
    private String colCatalogCountEnum = "catalogCountEnumId";

    public String insertCatalogCountSql() {
        return new SQL()
                .INSERT_INTO(tableName)
                .INTO_COLUMNS("registrationDate, catalogCountEnumId, amount, details, isDeleted")
                .INTO_VALUES("#{registrationDate}, #{catalogCountEnumId}, #{amount}, #{details}, #{isDeleted}")
                .toString();
    }
}
