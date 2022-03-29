package com.jtmc.apps.reforma.repository.mapper;

import java.sql.JDBCType;
import java.time.Instant;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class LoginDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.291235-07:00", comments="Source Table: login")
    public static final Login login = new Login();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.291685-07:00", comments="Source field: login.id")
    public static final SqlColumn<Integer> id = login.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.29206-07:00", comments="Source field: login.password")
    public static final SqlColumn<String> password = login.password;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.292182-07:00", comments="Source field: login.username")
    public static final SqlColumn<String> username = login.username;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.292274-07:00", comments="Source field: login.status")
    public static final SqlColumn<Boolean> status = login.status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.292365-07:00", comments="Source field: login.registration")
    public static final SqlColumn<Instant> registration = login.registration;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.29245-07:00", comments="Source field: login.personaId")
    public static final SqlColumn<Long> personaid = login.personaid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.29152-07:00", comments="Source Table: login")
    public static final class Login extends SqlTable {
        public final SqlColumn<Integer> id = column("id", JDBCType.INTEGER);

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