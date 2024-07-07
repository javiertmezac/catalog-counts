package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.PersonaDetailsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.reforma.domain.PersonaDetails;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import jakarta.annotation.Generated;
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
public interface PersonaDetailsMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086748-07:00", comments="Source Table: persona_details")
    BasicColumn[] selectList = BasicColumn.columnList(id, personaid, branchid, roleid, registration, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.085972-07:00", comments="Source Table: persona_details")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086029-07:00", comments="Source Table: persona_details")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086073-07:00", comments="Source Table: persona_details")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<PersonaDetails> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086117-07:00", comments="Source Table: persona_details")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<PersonaDetails> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086164-07:00", comments="Source Table: persona_details")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PersonaDetailsResult")
    Optional<PersonaDetails> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086215-07:00", comments="Source Table: persona_details")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PersonaDetailsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="personaId", property="personaid", jdbcType=JdbcType.INTEGER),
        @Result(column="branchId", property="branchid", jdbcType=JdbcType.INTEGER),
        @Result(column="roleId", property="roleid", jdbcType=JdbcType.INTEGER),
        @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<PersonaDetails> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.0863-07:00", comments="Source Table: persona_details")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086345-07:00", comments="Source Table: persona_details")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, personaDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086386-07:00", comments="Source Table: persona_details")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, personaDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086426-07:00", comments="Source Table: persona_details")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086468-07:00", comments="Source Table: persona_details")
    default int insert(PersonaDetails record) {
        return MyBatis3Utils.insert(this::insert, record, personaDetails, c ->
            c.map(id).toProperty("id")
            .map(personaid).toProperty("personaid")
            .map(branchid).toProperty("branchid")
            .map(roleid).toProperty("roleid")
            .map(registration).toProperty("registration")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086539-07:00", comments="Source Table: persona_details")
    default int insertMultiple(Collection<PersonaDetails> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, personaDetails, c ->
            c.map(id).toProperty("id")
            .map(personaid).toProperty("personaid")
            .map(branchid).toProperty("branchid")
            .map(roleid).toProperty("roleid")
            .map(registration).toProperty("registration")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086613-07:00", comments="Source Table: persona_details")
    default int insertSelective(PersonaDetails record) {
        return MyBatis3Utils.insert(this::insert, record, personaDetails, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(personaid).toPropertyWhenPresent("personaid", record::getPersonaid)
            .map(branchid).toPropertyWhenPresent("branchid", record::getBranchid)
            .map(roleid).toPropertyWhenPresent("roleid", record::getRoleid)
            .map(registration).toPropertyWhenPresent("registration", record::getRegistration)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086795-07:00", comments="Source Table: persona_details")
    default Optional<PersonaDetails> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, personaDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086843-07:00", comments="Source Table: persona_details")
    default List<PersonaDetails> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, personaDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086896-07:00", comments="Source Table: persona_details")
    default List<PersonaDetails> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, personaDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086938-07:00", comments="Source Table: persona_details")
    default Optional<PersonaDetails> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.086996-07:00", comments="Source Table: persona_details")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, personaDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.087045-07:00", comments="Source Table: persona_details")
    static UpdateDSL<UpdateModel> updateAllColumns(PersonaDetails record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(personaid).equalTo(record::getPersonaid)
                .set(branchid).equalTo(record::getBranchid)
                .set(roleid).equalTo(record::getRoleid)
                .set(registration).equalTo(record::getRegistration)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.087132-07:00", comments="Source Table: persona_details")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PersonaDetails record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(personaid).equalToWhenPresent(record::getPersonaid)
                .set(branchid).equalToWhenPresent(record::getBranchid)
                .set(roleid).equalToWhenPresent(record::getRoleid)
                .set(registration).equalToWhenPresent(record::getRegistration)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.087233-07:00", comments="Source Table: persona_details")
    default int updateByPrimaryKey(PersonaDetails record) {
        return update(c ->
            c.set(personaid).equalTo(record::getPersonaid)
            .set(branchid).equalTo(record::getBranchid)
            .set(roleid).equalTo(record::getRoleid)
            .set(registration).equalTo(record::getRegistration)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.087334-07:00", comments="Source Table: persona_details")
    default int updateByPrimaryKeySelective(PersonaDetails record) {
        return update(c ->
            c.set(personaid).equalToWhenPresent(record::getPersonaid)
            .set(branchid).equalToWhenPresent(record::getBranchid)
            .set(roleid).equalToWhenPresent(record::getRoleid)
            .set(registration).equalToWhenPresent(record::getRegistration)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}