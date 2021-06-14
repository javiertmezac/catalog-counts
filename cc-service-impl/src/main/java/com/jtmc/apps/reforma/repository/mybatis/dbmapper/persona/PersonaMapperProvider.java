package com.jtmc.apps.reforma.repository.mybatis.dbmapper.persona;

import org.apache.ibatis.jdbc.SQL;

public class PersonaMapperProvider {

    private String tableName = "persona";

    public String selectAllPersonas() {
        return new SQL()
                .SELECT("*")
                .FROM(tableName)
                .toString();
    }

    public String insertPersona() {
        return new SQL()
                .INSERT_INTO(tableName)
                .INTO_COLUMNS("name", "lastname")
                .INTO_VALUES("#{persona.name}", "#{persona.lastname}")
                .toString();
    }
}
