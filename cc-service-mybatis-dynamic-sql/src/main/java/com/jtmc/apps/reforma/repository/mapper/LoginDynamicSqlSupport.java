package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class LoginDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.624411-07:00", comments="Source Table: login")
    public static final Login login = new Login();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.624582-07:00", comments="Source field: login.id")
    public static final SqlColumn<Long> id = login.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.624659-07:00", comments="Source field: login.password")
    public static final SqlColumn<String> password = login.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.624727-07:00", comments="Source field: login.username")
    public static final SqlColumn<String> username = login.username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.624828-07:00", comments="Source field: login.status")
    public static final SqlColumn<Boolean> status = login.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.624909-07:00", comments="Source field: login.registration")
    public static final SqlColumn<Instant> registration = login.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.624995-07:00", comments="Source field: login.personaId")
    public static final SqlColumn<Long> personaid = login.personaid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.62448-07:00", comments="Source Table: login")
    public static final class Login extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> password = column("password", JDBCType.VARCHAR);

        public final SqlColumn<String> username = column("username", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> status = column("status", JDBCType.BIT);

        public final SqlColumn<Instant> registration = column("registration", JDBCType.TIMESTAMP);

        public final SqlColumn<Long> personaid = column("personaId", JDBCType.BIGINT);

        public Login() {
            super("login");
        }
    }
}