package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.PeriodDetailsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.reforma.domain.PeriodDetails;
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
public interface PeriodDetailsMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560591-07:00", comments="Source Table: period_details")
    BasicColumn[] selectList = BasicColumn.columnList(id, confirmedby, registration, periodid, branchid, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.559598-07:00", comments="Source Table: period_details")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.559662-07:00", comments="Source Table: period_details")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.559724-07:00", comments="Source Table: period_details")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<PeriodDetails> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.559777-07:00", comments="Source Table: period_details")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<PeriodDetails> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.559832-07:00", comments="Source Table: period_details")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PeriodDetailsResult")
    Optional<PeriodDetails> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.559906-07:00", comments="Source Table: period_details")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PeriodDetailsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="confirmedBy", property="confirmedby", jdbcType=JdbcType.INTEGER),
        @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="periodId", property="periodid", jdbcType=JdbcType.INTEGER),
        @Result(column="branchId", property="branchid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<PeriodDetails> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560029-07:00", comments="Source Table: period_details")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560079-07:00", comments="Source Table: period_details")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560129-07:00", comments="Source Table: period_details")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560175-07:00", comments="Source Table: period_details")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560225-07:00", comments="Source Table: period_details")
    default int insert(PeriodDetails record) {
        return MyBatis3Utils.insert(this::insert, record, periodDetails, c ->
            c.map(id).toProperty("id")
            .map(confirmedby).toProperty("confirmedby")
            .map(registration).toProperty("registration")
            .map(periodid).toProperty("periodid")
            .map(branchid).toProperty("branchid")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560349-07:00", comments="Source Table: period_details")
    default int insertMultiple(Collection<PeriodDetails> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, periodDetails, c ->
            c.map(id).toProperty("id")
            .map(confirmedby).toProperty("confirmedby")
            .map(registration).toProperty("registration")
            .map(periodid).toProperty("periodid")
            .map(branchid).toProperty("branchid")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560435-07:00", comments="Source Table: period_details")
    default int insertSelective(PeriodDetails record) {
        return MyBatis3Utils.insert(this::insert, record, periodDetails, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(confirmedby).toPropertyWhenPresent("confirmedby", record::getConfirmedby)
            .map(registration).toPropertyWhenPresent("registration", record::getRegistration)
            .map(periodid).toPropertyWhenPresent("periodid", record::getPeriodid)
            .map(branchid).toPropertyWhenPresent("branchid", record::getBranchid)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560666-07:00", comments="Source Table: period_details")
    default Optional<PeriodDetails> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560757-07:00", comments="Source Table: period_details")
    default List<PeriodDetails> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560833-07:00", comments="Source Table: period_details")
    default List<PeriodDetails> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560905-07:00", comments="Source Table: period_details")
    default Optional<PeriodDetails> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.560985-07:00", comments="Source Table: period_details")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.561057-07:00", comments="Source Table: period_details")
    static UpdateDSL<UpdateModel> updateAllColumns(PeriodDetails record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(confirmedby).equalTo(record::getConfirmedby)
                .set(registration).equalTo(record::getRegistration)
                .set(periodid).equalTo(record::getPeriodid)
                .set(branchid).equalTo(record::getBranchid)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.561202-07:00", comments="Source Table: period_details")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PeriodDetails record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(confirmedby).equalToWhenPresent(record::getConfirmedby)
                .set(registration).equalToWhenPresent(record::getRegistration)
                .set(periodid).equalToWhenPresent(record::getPeriodid)
                .set(branchid).equalToWhenPresent(record::getBranchid)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.561374-07:00", comments="Source Table: period_details")
    default int updateByPrimaryKey(PeriodDetails record) {
        return update(c ->
            c.set(confirmedby).equalTo(record::getConfirmedby)
            .set(registration).equalTo(record::getRegistration)
            .set(periodid).equalTo(record::getPeriodid)
            .set(branchid).equalTo(record::getBranchid)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.561533-07:00", comments="Source Table: period_details")
    default int updateByPrimaryKeySelective(PeriodDetails record) {
        return update(c ->
            c.set(confirmedby).equalToWhenPresent(record::getConfirmedby)
            .set(registration).equalToWhenPresent(record::getRegistration)
            .set(periodid).equalToWhenPresent(record::getPeriodid)
            .set(branchid).equalToWhenPresent(record::getBranchid)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}