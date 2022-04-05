package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PersonaDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.627568-07:00", comments="Source Table: persona")
    public static final Persona persona = new Persona();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.627733-07:00", comments="Source field: persona.id")
    public static final SqlColumn<Long> id = persona.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.627803-07:00", comments="Source field: persona.name")
    public static final SqlColumn<String> name = persona.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.627885-07:00", comments="Source field: persona.lastname")
    public static final SqlColumn<String> lastname = persona.lastname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.627955-07:00", comments="Source field: persona.registration")
    public static final SqlColumn<Instant> registration = persona.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.628027-07:00", comments="Source field: persona.status")
    public static final SqlColumn<Boolean> status = persona.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.627653-07:00", comments="Source Table: persona")
    public static final class Persona extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> lastname = column("lastname", JDBCType.VARCHAR);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public Persona() {
            super("persona");
        }
    }
}