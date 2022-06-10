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
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.949608-07:00", comments="Source Table: period_details")
    BasicColumn[] selectList = BasicColumn.columnList(periodid, branchid, confirmedby, registration, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.906104-07:00", comments="Source Table: period_details")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.912034-07:00", comments="Source Table: period_details")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.914403-07:00", comments="Source Table: period_details")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<PeriodDetails> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.91775-07:00", comments="Source Table: period_details")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<PeriodDetails> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.920123-07:00", comments="Source Table: period_details")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PeriodDetailsResult")
    Optional<PeriodDetails> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.921686-07:00", comments="Source Table: period_details")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PeriodDetailsResult", value = {
        @Result(column="periodId", property="periodid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="branchId", property="branchid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="confirmedBy", property="confirmedby", jdbcType=JdbcType.INTEGER),
        @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<PeriodDetails> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.92849-07:00", comments="Source Table: period_details")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.930519-07:00", comments="Source Table: period_details")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.932145-07:00", comments="Source Table: period_details")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.933786-07:00", comments="Source Table: period_details")
    default int deleteByPrimaryKey(Integer periodid_, Integer branchid_) {
        return delete(c -> 
            c.where(periodid, isEqualTo(periodid_))
            .and(branchid, isEqualTo(branchid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.935561-07:00", comments="Source Table: period_details")
    default int insert(PeriodDetails record) {
        return MyBatis3Utils.insert(this::insert, record, periodDetails, c ->
            c.map(periodid).toProperty("periodid")
            .map(branchid).toProperty("branchid")
            .map(confirmedby).toProperty("confirmedby")
            .map(registration).toProperty("registration")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.940632-07:00", comments="Source Table: period_details")
    default int insertMultiple(Collection<PeriodDetails> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, periodDetails, c ->
            c.map(periodid).toProperty("periodid")
            .map(branchid).toProperty("branchid")
            .map(confirmedby).toProperty("confirmedby")
            .map(registration).toProperty("registration")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.943534-07:00", comments="Source Table: period_details")
    default int insertSelective(PeriodDetails record) {
        return MyBatis3Utils.insert(this::insert, record, periodDetails, c ->
            c.map(periodid).toPropertyWhenPresent("periodid", record::getPeriodid)
            .map(branchid).toPropertyWhenPresent("branchid", record::getBranchid)
            .map(confirmedby).toPropertyWhenPresent("confirmedby", record::getConfirmedby)
            .map(registration).toPropertyWhenPresent("registration", record::getRegistration)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.953847-07:00", comments="Source Table: period_details")
    default Optional<PeriodDetails> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.955541-07:00", comments="Source Table: period_details")
    default List<PeriodDetails> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.957424-07:00", comments="Source Table: period_details")
    default List<PeriodDetails> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.958647-07:00", comments="Source Table: period_details")
    default Optional<PeriodDetails> selectByPrimaryKey(Integer periodid_, Integer branchid_) {
        return selectOne(c ->
            c.where(periodid, isEqualTo(periodid_))
            .and(branchid, isEqualTo(branchid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.959885-07:00", comments="Source Table: period_details")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, periodDetails, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.963687-07:00", comments="Source Table: period_details")
    static UpdateDSL<UpdateModel> updateAllColumns(PeriodDetails record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(periodid).equalTo(record::getPeriodid)
                .set(branchid).equalTo(record::getBranchid)
                .set(confirmedby).equalTo(record::getConfirmedby)
                .set(registration).equalTo(record::getRegistration)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.965783-07:00", comments="Source Table: period_details")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PeriodDetails record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(periodid).equalToWhenPresent(record::getPeriodid)
                .set(branchid).equalToWhenPresent(record::getBranchid)
                .set(confirmedby).equalToWhenPresent(record::getConfirmedby)
                .set(registration).equalToWhenPresent(record::getRegistration)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.968144-07:00", comments="Source Table: period_details")
    default int updateByPrimaryKey(PeriodDetails record) {
        return update(c ->
            c.set(confirmedby).equalTo(record::getConfirmedby)
            .set(registration).equalTo(record::getRegistration)
            .set(status).equalTo(record::getStatus)
            .where(periodid, isEqualTo(record::getPeriodid))
            .and(branchid, isEqualTo(record::getBranchid))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-06-10T12:33:29.96953-07:00", comments="Source Table: period_details")
    default int updateByPrimaryKeySelective(PeriodDetails record) {
        return update(c ->
            c.set(confirmedby).equalToWhenPresent(record::getConfirmedby)
            .set(registration).equalToWhenPresent(record::getRegistration)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(periodid, isEqualTo(record::getPeriodid))
            .and(branchid, isEqualTo(record::getBranchid))
        );
    }
}