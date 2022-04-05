package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PersonaDetailsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630353-07:00", comments="Source Table: persona_details")
    public static final PersonaDetails personaDetails = new PersonaDetails();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630514-07:00", comments="Source field: persona_details.id")
    public static final SqlColumn<Long> id = personaDetails.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630583-07:00", comments="Source field: persona_details.personaId")
    public static final SqlColumn<Long> personaid = personaDetails.personaid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630647-07:00", comments="Source field: persona_details.branchId")
    public static final SqlColumn<Long> branchid = personaDetails.branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630734-07:00", comments="Source field: persona_details.roleId")
    public static final SqlColumn<Long> roleid = personaDetails.roleid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630816-07:00", comments="Source field: persona_details.registration")
    public static final SqlColumn<Instant> registration = personaDetails.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630884-07:00", comments="Source field: persona_details.status")
    public static final SqlColumn<Boolean> status = personaDetails.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.630422-07:00", comments="Source Table: persona_details")
    public static final class PersonaDetails extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> personaid = column("personaId", JDBCType.BIGINT);

        public final SqlColumn<Long> branchid = column("branchId", JDBCType.BIGINT);

        public final SqlColumn<Long> roleid = column("roleId", JDBCType.BIGINT);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public PersonaDetails() {
            super("persona_details");
        }
    }
}