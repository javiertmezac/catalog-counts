package com.jtmc.apps.reforma.repository.mapper;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.Instant;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class PersonaDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.14569-07:00", comments="Source Table: persona")
    public static final Persona persona = new Persona();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145773-07:00", comments="Source field: persona.id")
    public static final SqlColumn<Integer> id = persona.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145801-07:00", comments="Source field: persona.name")
    public static final SqlColumn<String> name = persona.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145833-07:00", comments="Source field: persona.lastname")
    public static final SqlColumn<String> lastname = persona.lastname;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145856-07:00", comments="Source field: persona.registration")
    public static final SqlColumn<Instant> registration = persona.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145879-07:00", comments="Source field: persona.status")
    public static final SqlColumn<Boolean> status = persona.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145901-07:00", comments="Source field: persona.primaryEmail")
    public static final SqlColumn<String> primaryEmail = persona.primaryEmail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145923-07:00", comments="Source field: persona.secondaryEmail")
    public static final SqlColumn<String> secondaryEmail = persona.secondaryEmail;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145742-07:00", comments="Source Table: persona")
    public static final class Persona extends AliasableSqlTable<Persona> {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> lastname = column("lastname", JDBCType.VARCHAR);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public final SqlColumn<String> primaryEmail = column("primaryEmail", JDBCType.VARCHAR);

        public final SqlColumn<String> secondaryEmail = column("secondaryEmail", JDBCType.VARCHAR);

        public Persona() {
            super("persona", Persona::new);
        }
    }
}