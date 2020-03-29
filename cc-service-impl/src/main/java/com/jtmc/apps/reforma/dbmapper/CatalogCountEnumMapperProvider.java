package com.jtmc.apps.reforma.dbmapper;

import org.apache.ibatis.jdbc.SQL;

public class CatalogCountEnumMapperProvider {
    private String tableName  = "catalog_count_enum";

    public String selectCatalogCountEnumWhereIdSql() {
        return new SQL()
                .SELECT("identifier")
                .FROM(tableName)
                .WHERE("id = #{id}")
                .toString();
    }

    public String insertCatalogCountEnumSql() {
        return new SQL()
                .INSERT_INTO(tableName)
                .INTO_COLUMNS("identifier, name, description, type, isDeleted")
                .INTO_VALUES("#{identifier}, #{name}, #{description}, #{type}, #{isDeleted}")
                .toString();
    }
}
