package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.BranchDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.jtmc.apps.reforma.domain.Branch;
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
public interface BranchMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Branch>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.142474-07:00", comments="Source Table: branch")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, registration, status, timezoneid, address);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.139679-07:00", comments="Source Table: branch")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BranchResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="timezoneId", property="timezoneid", jdbcType=JdbcType.INTEGER),
        @Result(column="address", property="address", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<Branch> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.140339-07:00", comments="Source Table: branch")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BranchResult")
    Optional<Branch> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.140492-07:00", comments="Source Table: branch")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, branch, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.140631-07:00", comments="Source Table: branch")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, branch, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.140974-07:00", comments="Source Table: branch")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.141126-07:00", comments="Source Table: branch")
    default int insert(Branch row) {
        return MyBatis3Utils.insert(this::insert, row, branch, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(registration).toProperty("registration")
            .map(status).toProperty("status")
            .map(timezoneid).toProperty("timezoneid")
            .map(address).toProperty("address")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.141815-07:00", comments="Source Table: branch")
    default int insertMultiple(Collection<Branch> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, branch, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(registration).toProperty("registration")
            .map(status).toProperty("status")
            .map(timezoneid).toProperty("timezoneid")
            .map(address).toProperty("address")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.142068-07:00", comments="Source Table: branch")
    default int insertSelective(Branch row) {
        return MyBatis3Utils.insert(this::insert, row, branch, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(registration).toPropertyWhenPresent("registration", row::getRegistration)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
            .map(timezoneid).toPropertyWhenPresent("timezoneid", row::getTimezoneId)
            .map(address).toPropertyWhenPresent("address", row::getAddress)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.142741-07:00", comments="Source Table: branch")
    default Optional<Branch> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, branch, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.142863-07:00", comments="Source Table: branch")
    default List<Branch> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, branch, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.142995-07:00", comments="Source Table: branch")
    default List<Branch> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, branch, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.143143-07:00", comments="Source Table: branch")
    default Optional<Branch> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.14328-07:00", comments="Source Table: branch")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, branch, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.143417-07:00", comments="Source Table: branch")
    static UpdateDSL<UpdateModel> updateAllColumns(Branch row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(name).equalTo(row::getName)
                .set(registration).equalTo(row::getRegistration)
                .set(status).equalTo(row::getStatus)
                .set(timezoneid).equalTo(row::getTimezoneId)
                .set(address).equalTo(row::getAddress);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.143624-07:00", comments="Source Table: branch")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Branch row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(name).equalToWhenPresent(row::getName)
                .set(registration).equalToWhenPresent(row::getRegistration)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(timezoneid).equalToWhenPresent(row::getTimezoneId)
                .set(address).equalToWhenPresent(row::getAddress);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.143935-07:00", comments="Source Table: branch")
    default int updateByPrimaryKey(Branch row) {
        return update(c ->
            c.set(name).equalTo(row::getName)
            .set(registration).equalTo(row::getRegistration)
            .set(status).equalTo(row::getStatus)
            .set(timezoneid).equalTo(row::getTimezoneId)
            .set(address).equalTo(row::getAddress)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:42:42.14413-07:00", comments="Source Table: branch")
    default int updateByPrimaryKeySelective(Branch row) {
        return update(c ->
            c.set(name).equalToWhenPresent(row::getName)
            .set(registration).equalToWhenPresent(row::getRegistration)
            .set(status).equalToWhenPresent(row::getStatus)
            .set(timezoneid).equalToWhenPresent(row::getTimezoneId)
            .set(address).equalToWhenPresent(row::getAddress)
            .where(id, isEqualTo(row::getId))
        );
    }
}