package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.PersonaDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.jtmc.apps.reforma.domain.Persona;
import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface PersonaMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Persona>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146264-07:00", comments="Source Table: persona")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, lastname, registration, status, primaryEmail, secondaryEmail);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.145948-07:00", comments="Source Table: persona")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PersonaResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="lastname", property="lastname", jdbcType=JdbcType.VARCHAR),
        @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="primaryEmail", property="primaryemail", jdbcType=JdbcType.VARCHAR),
        @Result(column="secondaryEmail", property="secondaryemail", jdbcType=JdbcType.VARCHAR)
    })
    List<Persona> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.14601-07:00", comments="Source Table: persona")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PersonaResult")
    Optional<Persona> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146037-07:00", comments="Source Table: persona")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, persona, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146063-07:00", comments="Source Table: persona")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, persona, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.14608-07:00", comments="Source Table: persona")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146103-07:00", comments="Source Table: persona")
    default int insert(Persona row) {
        return MyBatis3Utils.insert(this::insert, row, persona, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(lastname).toProperty("lastname")
            .map(registration).toProperty("registration")
            .map(status).toProperty("status")
            .map(primaryEmail).toProperty("primaryemail")
            .map(secondaryEmail).toProperty("secondaryemail")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146151-07:00", comments="Source Table: persona")
    default int insertMultiple(Collection<Persona> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, persona, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(lastname).toProperty("lastname")
            .map(registration).toProperty("registration")
            .map(status).toProperty("status")
            .map(primaryEmail).toProperty("primaryemail")
            .map(secondaryEmail).toProperty("secondaryemail")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146195-07:00", comments="Source Table: persona")
    default int insertSelective(Persona row) {
        return MyBatis3Utils.insert(this::insert, row, persona, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(lastname).toPropertyWhenPresent("lastname", row::getLastname)
            .map(registration).toPropertyWhenPresent("registration", row::getRegistration)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
            .map(primaryEmail).toPropertyWhenPresent("primaryemail", row::getPrimaryEmail)
            .map(secondaryEmail).toPropertyWhenPresent("secondaryemail", row::getSecondaryEmail)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146293-07:00", comments="Source Table: persona")
    default Optional<Persona> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, persona, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146315-07:00", comments="Source Table: persona")
    default List<Persona> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, persona, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146336-07:00", comments="Source Table: persona")
    default List<Persona> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, persona, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146357-07:00", comments="Source Table: persona")
    default Optional<Persona> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.14638-07:00", comments="Source Table: persona")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, persona, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146401-07:00", comments="Source Table: persona")
    static UpdateDSL<UpdateModel> updateAllColumns(Persona row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(name).equalTo(row::getName)
                .set(lastname).equalTo(row::getLastname)
                .set(registration).equalTo(row::getRegistration)
                .set(status).equalTo(row::getStatus)
                .set(primaryEmail).equalTo(row::getPrimaryEmail)
                .set(secondaryEmail).equalTo(row::getSecondaryEmail);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146448-07:00", comments="Source Table: persona")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Persona row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(name).equalToWhenPresent(row::getName)
                .set(lastname).equalToWhenPresent(row::getLastname)
                .set(registration).equalToWhenPresent(row::getRegistration)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(primaryEmail).equalToWhenPresent(row::getPrimaryEmail)
                .set(secondaryEmail).equalToWhenPresent(row::getSecondaryEmail);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146487-07:00", comments="Source Table: persona")
    default int updateByPrimaryKey(Persona row) {
        return update(c ->
            c.set(name).equalTo(row::getName)
            .set(lastname).equalTo(row::getLastname)
            .set(registration).equalTo(row::getRegistration)
            .set(status).equalTo(row::getStatus)
            .set(primaryEmail).equalTo(row::getPrimaryEmail)
            .set(secondaryEmail).equalTo(row::getSecondaryEmail)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.146522-07:00", comments="Source Table: persona")
    default int updateByPrimaryKeySelective(Persona row) {
        return update(c ->
            c.set(name).equalToWhenPresent(row::getName)
            .set(lastname).equalToWhenPresent(row::getLastname)
            .set(registration).equalToWhenPresent(row::getRegistration)
            .set(status).equalToWhenPresent(row::getStatus)
            .set(primaryEmail).equalToWhenPresent(row::getPrimaryEmail)
            .set(secondaryEmail).equalToWhenPresent(row::getSecondaryEmail)
            .where(id, isEqualTo(row::getId))
        );
    }
}