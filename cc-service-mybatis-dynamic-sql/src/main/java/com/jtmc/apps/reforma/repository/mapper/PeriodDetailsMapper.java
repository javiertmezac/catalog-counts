package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.PeriodDetailsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.reforma.domain.PeriodDetails;
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
public interface PeriodDetailsMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.26885-07:00", comments="Source Table: period_details")
    BasicColumn[] selectList = BasicColumn.columnList(branchid, periodid, confirmedby, registration, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.260532-07:00", comments="Source Table: period_details")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.261895-07:00", comments="Source Table: period_details")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.262286-07:00", comments="Source Table: period_details")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<PeriodDetails> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.262831-07:00", comments="Source Table: period_details")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<PeriodDetails> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.263237-07:00", comments="Source Table: period_details")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PeriodDetailsResult")
    Optional<PeriodDetails> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.263632-07:00", comments="Source Table: period_details")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PeriodDetailsResult", value = {
        @Result(column="branchId", property="branchid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="periodId", property="periodid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="confirmedBy", property="confirmedby", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<PeriodDetails> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.265026-07:00", comments="Source Table: period_details")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.265353-07:00", comments="Source Table: period_details")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.26566-07:00", comments="Source Table: period_details")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.265997-07:00", comments="Source Table: period_details")
    default int deleteByPrimaryKey(Integer branchid_, Integer periodid_, Integer confirmedby_) {
        return delete(c -> 
            c.where(branchid, isEqualTo(branchid_))
            .and(periodid, isEqualTo(periodid_))
            .and(confirmedby, isEqualTo(confirmedby_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.266392-07:00", comments="Source Table: period_details")
    default int insert(PeriodDetails record) {
        return MyBatis3Utils.insert(this::insert, record, periodDetails, c ->
            c.map(branchid).toProperty("branchid")
            .map(periodid).toProperty("periodid")
            .map(confirmedby).toProperty("confirmedby")
            .map(registration).toProperty("registration")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.267382-07:00", comments="Source Table: period_details")
    default int insertMultiple(Collection<PeriodDetails> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, periodDetails, c ->
            c.map(branchid).toProperty("branchid")
            .map(periodid).toProperty("periodid")
            .map(confirmedby).toProperty("confirmedby")
            .map(registration).toProperty("registration")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.267828-07:00", comments="Source Table: period_details")
    default int insertSelective(PeriodDetails record) {
        return MyBatis3Utils.insert(this::insert, record, periodDetails, c ->
            c.map(branchid).toPropertyWhenPresent("branchid", record::getBranchid)
            .map(periodid).toPropertyWhenPresent("periodid", record::getPeriodid)
            .map(confirmedby).toPropertyWhenPresent("confirmedby", record::getConfirmedby)
            .map(registration).toPropertyWhenPresent("registration", record::getRegistration)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.269752-07:00", comments="Source Table: period_details")
    default Optional<PeriodDetails> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.270144-07:00", comments="Source Table: period_details")
    default List<PeriodDetails> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.270506-07:00", comments="Source Table: period_details")
    default List<PeriodDetails> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.27096-07:00", comments="Source Table: period_details")
    default Optional<PeriodDetails> selectByPrimaryKey(Integer branchid_, Integer periodid_, Integer confirmedby_) {
        return selectOne(c ->
            c.where(branchid, isEqualTo(branchid_))
            .and(periodid, isEqualTo(periodid_))
            .and(confirmedby, isEqualTo(confirmedby_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.271306-07:00", comments="Source Table: period_details")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.271668-07:00", comments="Source Table: period_details")
    static UpdateDSL<UpdateModel> updateAllColumns(PeriodDetails record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(branchid).equalTo(record::getBranchid)
                .set(periodid).equalTo(record::getPeriodid)
                .set(confirmedby).equalTo(record::getConfirmedby)
                .set(registration).equalTo(record::getRegistration)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.27214-07:00", comments="Source Table: period_details")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PeriodDetails record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(branchid).equalToWhenPresent(record::getBranchid)
                .set(periodid).equalToWhenPresent(record::getPeriodid)
                .set(confirmedby).equalToWhenPresent(record::getConfirmedby)
                .set(registration).equalToWhenPresent(record::getRegistration)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.272834-07:00", comments="Source Table: period_details")
    default int updateByPrimaryKey(PeriodDetails record) {
        return update(c ->
            c.set(registration).equalTo(record::getRegistration)
            .set(status).equalTo(record::getStatus)
            .where(branchid, isEqualTo(record::getBranchid))
            .and(periodid, isEqualTo(record::getPeriodid))
            .and(confirmedby, isEqualTo(record::getConfirmedby))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-13T22:32:32.273269-07:00", comments="Source Table: period_details")
    default int updateByPrimaryKeySelective(PeriodDetails record) {
        return update(c ->
            c.set(registration).equalToWhenPresent(record::getRegistration)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(branchid, isEqualTo(record::getBranchid))
            .and(periodid, isEqualTo(record::getPeriodid))
            .and(confirmedby, isEqualTo(record::getConfirmedby))
        );
    }
}