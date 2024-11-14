package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.TimezoneTypeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.reforma.domain.TimezoneType;
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
public interface TimezoneTypeMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source Table: timezone_type")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source Table: timezone_type")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source Table: timezone_type")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<TimezoneType> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source Table: timezone_type")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<TimezoneType> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source Table: timezone_type")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TimezoneTypeResult")
    Optional<TimezoneType> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source Table: timezone_type")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TimezoneTypeResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<TimezoneType> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source Table: timezone_type")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.239-07:00", comments="Source Table: timezone_type")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, timezoneType, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, timezoneType, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    default int insert(TimezoneType record) {
        return MyBatis3Utils.insert(this::insert, record, timezoneType, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    default int insertMultiple(Collection<TimezoneType> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, timezoneType, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    default int insertSelective(TimezoneType record) {
        return MyBatis3Utils.insert(this::insert, record, timezoneType, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    default Optional<TimezoneType> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, timezoneType, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    default List<TimezoneType> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, timezoneType, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    default List<TimezoneType> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, timezoneType, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    default Optional<TimezoneType> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, timezoneType, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    static UpdateDSL<UpdateModel> updateAllColumns(TimezoneType record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(name).equalTo(record::getName)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TimezoneType record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(name).equalToWhenPresent(record::getName)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    default int updateByPrimaryKey(TimezoneType record) {
        return update(c ->
            c.set(name).equalTo(record::getName)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-05-17T12:07:38.24-07:00", comments="Source Table: timezone_type")
    default int updateByPrimaryKeySelective(TimezoneType record) {
        return update(c ->
            c.set(name).equalToWhenPresent(record::getName)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}