package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.LoginDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.reforma.domain.Login;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface LoginMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.301493-07:00", comments="Source Table: login")
    BasicColumn[] selectList = BasicColumn.columnList(id, password, username, status, registration, personaid);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.293017-07:00", comments="Source Table: login")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.294089-07:00", comments="Source Table: login")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.294474-07:00", comments="Source Table: login")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Login> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.295017-07:00", comments="Source Table: login")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Login> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.295505-07:00", comments="Source Table: login")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("LoginResult")
    Optional<Login> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.295935-07:00", comments="Source Table: login")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="LoginResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="personaId", property="personaid", jdbcType=JdbcType.BIGINT)
    })
    List<Login> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.29754-07:00", comments="Source Table: login")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.297978-07:00", comments="Source Table: login")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, login, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.298294-07:00", comments="Source Table: login")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, login, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.298623-07:00", comments="Source Table: login")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.299011-07:00", comments="Source Table: login")
    default int insert(Login record) {
        return MyBatis3Utils.insert(this::insert, record, login, c ->
            c.map(id).toProperty("id")
            .map(password).toProperty("password")
            .map(username).toProperty("username")
            .map(status).toProperty("status")
            .map(registration).toProperty("registration")
            .map(personaid).toProperty("personaid")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.300053-07:00", comments="Source Table: login")
    default int insertMultiple(Collection<Login> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, login, c ->
            c.map(id).toProperty("id")
            .map(password).toProperty("password")
            .map(username).toProperty("username")
            .map(status).toProperty("status")
            .map(registration).toProperty("registration")
            .map(personaid).toProperty("personaid")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.300481-07:00", comments="Source Table: login")
    default int insertSelective(Login record) {
        return MyBatis3Utils.insert(this::insert, record, login, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(password).toPropertyWhenPresent("password", record::getPassword)
            .map(username).toPropertyWhenPresent("username", record::getUsername)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
            .map(registration).toPropertyWhenPresent("registration", record::getRegistration)
            .map(personaid).toPropertyWhenPresent("personaid", record::getPersonaid)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.302451-07:00", comments="Source Table: login")
    default Optional<Login> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, login, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.302828-07:00", comments="Source Table: login")
    default List<Login> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, login, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.303211-07:00", comments="Source Table: login")
    default List<Login> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, login, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.30379-07:00", comments="Source Table: login")
    default Optional<Login> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.304367-07:00", comments="Source Table: login")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, login, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.304788-07:00", comments="Source Table: login")
    static UpdateDSL<UpdateModel> updateAllColumns(Login record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(password).equalTo(record::getPassword)
                .set(username).equalTo(record::getUsername)
                .set(status).equalTo(record::getStatus)
                .set(registration).equalTo(record::getRegistration)
                .set(personaid).equalTo(record::getPersonaid);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.305303-07:00", comments="Source Table: login")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Login record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(password).equalToWhenPresent(record::getPassword)
                .set(username).equalToWhenPresent(record::getUsername)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(registration).equalToWhenPresent(record::getRegistration)
                .set(personaid).equalToWhenPresent(record::getPersonaid);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.306024-07:00", comments="Source Table: login")
    default int updateByPrimaryKey(Login record) {
        return update(c ->
            c.set(password).equalTo(record::getPassword)
            .set(username).equalTo(record::getUsername)
            .set(status).equalTo(record::getStatus)
            .set(registration).equalTo(record::getRegistration)
            .set(personaid).equalTo(record::getPersonaid)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-28T19:02:13.306498-07:00", comments="Source Table: login")
    default int updateByPrimaryKeySelective(Login record) {
        return update(c ->
            c.set(password).equalToWhenPresent(record::getPassword)
            .set(username).equalToWhenPresent(record::getUsername)
            .set(status).equalToWhenPresent(record::getStatus)
            .set(registration).equalToWhenPresent(record::getRegistration)
            .set(personaid).equalToWhenPresent(record::getPersonaid)
            .where(id, isEqualTo(record::getId))
        );
    }
}