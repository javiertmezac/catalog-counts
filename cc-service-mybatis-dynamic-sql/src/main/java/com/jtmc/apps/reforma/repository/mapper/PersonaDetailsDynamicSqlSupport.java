package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class PersonaDetailsDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085384-07:00", comments="Source Table: persona_details")
    public static final PersonaDetails personaDetails = new PersonaDetails();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085553-07:00", comments="Source field: persona_details.id")
    public static final SqlColumn<Integer> id = personaDetails.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085632-07:00", comments="Source field: persona_details.personaId")
    public static final SqlColumn<Integer> personaid = personaDetails.personaid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085701-07:00", comments="Source field: persona_details.branchId")
    public static final SqlColumn<Integer> branchid = personaDetails.branchid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085771-07:00", comments="Source field: persona_details.roleId")
    public static final SqlColumn<Integer> roleid = personaDetails.roleid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085842-07:00", comments="Source field: persona_details.registration")
    public static final SqlColumn<Instant> registration = personaDetails.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.08591-07:00", comments="Source field: persona_details.status")
    public static final SqlColumn<Boolean> status = personaDetails.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085448-07:00", comments="Source Table: persona_details")
    public static final class PersonaDetails extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

        public final SqlColumn<Integer> personaid = column("personaId", JDBCType.INTEGER);

        public final SqlColumn<Integer> branchid = column("branchId", JDBCType.INTEGER);

        public final SqlColumn<Integer> roleid = column("roleId", JDBCType.INTEGER);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public PersonaDetails() {
            super("persona_details");
        }
    }
}