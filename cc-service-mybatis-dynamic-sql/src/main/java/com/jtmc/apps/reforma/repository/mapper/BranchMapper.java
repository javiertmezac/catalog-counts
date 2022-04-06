package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.BranchDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.reforma.domain.Branch;
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
public interface BranchMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.065063-07:00", comments="Source Table: branch")
    BasicColumn[] selectList = BasicColumn.columnList(id, address, name, registration, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.056095-07:00", comments="Source Table: branch")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.057185-07:00", comments="Source Table: branch")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.057716-07:00", comments="Source Table: branch")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Branch> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.058569-07:00", comments="Source Table: branch")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Branch> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.059092-07:00", comments="Source Table: branch")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BranchResult")
    Optional<Branch> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.059539-07:00", comments="Source Table: branch")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BranchResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<Branch> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.061037-07:00", comments="Source Table: branch")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.061364-07:00", comments="Source Table: branch")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, branch, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.061686-07:00", comments="Source Table: branch")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, branch, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.062025-07:00", comments="Source Table: branch")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.062492-07:00", comments="Source Table: branch")
    default int insert(Branch record) {
        return MyBatis3Utils.insert(this::insert, record, branch, c ->
            c.map(id).toProperty("id")
            .map(address).toProperty("address")
            .map(name).toProperty("name")
            .map(registration).toProperty("registration")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.063505-07:00", comments="Source Table: branch")
    default int insertMultiple(Collection<Branch> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, branch, c ->
            c.map(id).toProperty("id")
            .map(address).toProperty("address")
            .map(name).toProperty("name")
            .map(registration).toProperty("registration")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.06396-07:00", comments="Source Table: branch")
    default int insertSelective(Branch record) {
        return MyBatis3Utils.insert(this::insert, record, branch, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(address).toPropertyWhenPresent("address", record::getAddress)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(registration).toPropertyWhenPresent("registration", record::getRegistration)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.066193-07:00", comments="Source Table: branch")
    default Optional<Branch> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, branch, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.066572-07:00", comments="Source Table: branch")
    default List<Branch> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, branch, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.067006-07:00", comments="Source Table: branch")
    default List<Branch> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, branch, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.067389-07:00", comments="Source Table: branch")
    default Optional<Branch> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.067707-07:00", comments="Source Table: branch")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, branch, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.068059-07:00", comments="Source Table: branch")
    static UpdateDSL<UpdateModel> updateAllColumns(Branch record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(address).equalTo(record::getAddress)
                .set(name).equalTo(record::getName)
                .set(registration).equalTo(record::getRegistration)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.068498-07:00", comments="Source Table: branch")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Branch record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(address).equalToWhenPresent(record::getAddress)
                .set(name).equalToWhenPresent(record::getName)
                .set(registration).equalToWhenPresent(record::getRegistration)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.069183-07:00", comments="Source Table: branch")
    default int updateByPrimaryKey(Branch record) {
        return update(c ->
            c.set(address).equalTo(record::getAddress)
            .set(name).equalTo(record::getName)
            .set(registration).equalTo(record::getRegistration)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T20:26:07.069603-07:00", comments="Source Table: branch")
    default int updateByPrimaryKeySelective(Branch record) {
        return update(c ->
            c.set(address).equalToWhenPresent(record::getAddress)
            .set(name).equalToWhenPresent(record::getName)
            .set(registration).equalToWhenPresent(record::getRegistration)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}