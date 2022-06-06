package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.PeriodDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.reforma.domain.Period;
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
public interface PeriodMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.81166-07:00", comments="Source Table: period")
    BasicColumn[] selectList = BasicColumn.columnList(id, description, frommonth, tomonth, year, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.803151-07:00", comments="Source Table: period")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.804304-07:00", comments="Source Table: period")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.804664-07:00", comments="Source Table: period")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Period> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.805209-07:00", comments="Source Table: period")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Period> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.8057-07:00", comments="Source Table: period")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PeriodResult")
    Optional<Period> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.806118-07:00", comments="Source Table: period")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PeriodResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="fromMonth", property="frommonth", jdbcType=JdbcType.INTEGER),
        @Result(column="toMonth", property="tomonth", jdbcType=JdbcType.INTEGER),
        @Result(column="year", property="year", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<Period> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.807669-07:00", comments="Source Table: period")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.808002-07:00", comments="Source Table: period")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, period, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.808324-07:00", comments="Source Table: period")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, period, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.808685-07:00", comments="Source Table: period")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.809149-07:00", comments="Source Table: period")
    default int insert(Period record) {
        return MyBatis3Utils.insert(this::insert, record, period, c ->
            c.map(id).toProperty("id")
            .map(description).toProperty("description")
            .map(frommonth).toProperty("frommonth")
            .map(tomonth).toProperty("tomonth")
            .map(year).toProperty("year")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.810255-07:00", comments="Source Table: period")
    default int insertMultiple(Collection<Period> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, period, c ->
            c.map(id).toProperty("id")
            .map(description).toProperty("description")
            .map(frommonth).toProperty("frommonth")
            .map(tomonth).toProperty("tomonth")
            .map(year).toProperty("year")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.810699-07:00", comments="Source Table: period")
    default int insertSelective(Period record) {
        return MyBatis3Utils.insert(this::insert, record, period, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(description).toPropertyWhenPresent("description", record::getDescription)
            .map(frommonth).toPropertyWhenPresent("frommonth", record::getFrommonth)
            .map(tomonth).toPropertyWhenPresent("tomonth", record::getTomonth)
            .map(year).toPropertyWhenPresent("year", record::getYear)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.812578-07:00", comments="Source Table: period")
    default Optional<Period> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, period, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.812922-07:00", comments="Source Table: period")
    default List<Period> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, period, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.813258-07:00", comments="Source Table: period")
    default List<Period> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, period, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.813622-07:00", comments="Source Table: period")
    default Optional<Period> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.813935-07:00", comments="Source Table: period")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, period, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.814282-07:00", comments="Source Table: period")
    static UpdateDSL<UpdateModel> updateAllColumns(Period record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(description).equalTo(record::getDescription)
                .set(frommonth).equalTo(record::getFrommonth)
                .set(tomonth).equalTo(record::getTomonth)
                .set(year).equalTo(record::getYear)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.81471-07:00", comments="Source Table: period")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Period record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(frommonth).equalToWhenPresent(record::getFrommonth)
                .set(tomonth).equalToWhenPresent(record::getTomonth)
                .set(year).equalToWhenPresent(record::getYear)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.815391-07:00", comments="Source Table: period")
    default int updateByPrimaryKey(Period record) {
        return update(c ->
            c.set(description).equalTo(record::getDescription)
            .set(frommonth).equalTo(record::getFrommonth)
            .set(tomonth).equalTo(record::getTomonth)
            .set(year).equalTo(record::getYear)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-03T20:44:31.815841-07:00", comments="Source Table: period")
    default int updateByPrimaryKeySelective(Period record) {
        return update(c ->
            c.set(description).equalToWhenPresent(record::getDescription)
            .set(frommonth).equalToWhenPresent(record::getFrommonth)
            .set(tomonth).equalToWhenPresent(record::getTomonth)
            .set(year).equalToWhenPresent(record::getYear)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}