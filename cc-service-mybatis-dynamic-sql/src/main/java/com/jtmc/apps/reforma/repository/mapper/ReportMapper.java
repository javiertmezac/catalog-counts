package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.ReportDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.reforma.domain.Report;
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
public interface ReportMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564473-07:00", comments="Source Table: report")
    BasicColumn[] selectList = BasicColumn.columnList(id, reportedby, registration, uuid, perioddetailsid, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.563579-07:00", comments="Source Table: report")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.563628-07:00", comments="Source Table: report")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.563679-07:00", comments="Source Table: report")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Report> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.563732-07:00", comments="Source Table: report")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Report> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.563828-07:00", comments="Source Table: report")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ReportResult")
    Optional<Report> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.563887-07:00", comments="Source Table: report")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ReportResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="reportedBy", property="reportedby", jdbcType=JdbcType.INTEGER),
        @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uuid", property="uuid", jdbcType=JdbcType.VARCHAR),
        @Result(column="periodDetailsId", property="perioddetailsid", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<Report> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.56398-07:00", comments="Source Table: report")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564024-07:00", comments="Source Table: report")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, report, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564069-07:00", comments="Source Table: report")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, report, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564111-07:00", comments="Source Table: report")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564158-07:00", comments="Source Table: report")
    default int insert(Report record) {
        return MyBatis3Utils.insert(this::insert, record, report, c ->
            c.map(id).toProperty("id")
            .map(reportedby).toProperty("reportedby")
            .map(registration).toProperty("registration")
            .map(uuid).toProperty("uuid")
            .map(perioddetailsid).toProperty("perioddetailsid")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564243-07:00", comments="Source Table: report")
    default int insertMultiple(Collection<Report> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, report, c ->
            c.map(id).toProperty("id")
            .map(reportedby).toProperty("reportedby")
            .map(registration).toProperty("registration")
            .map(uuid).toProperty("uuid")
            .map(perioddetailsid).toProperty("perioddetailsid")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564328-07:00", comments="Source Table: report")
    default int insertSelective(Report record) {
        return MyBatis3Utils.insert(this::insert, record, report, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(reportedby).toPropertyWhenPresent("reportedby", record::getReportedby)
            .map(registration).toPropertyWhenPresent("registration", record::getRegistration)
            .map(uuid).toPropertyWhenPresent("uuid", record::getUuid)
            .map(perioddetailsid).toPropertyWhenPresent("perioddetailsid", record::getPerioddetailsid)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564521-07:00", comments="Source Table: report")
    default Optional<Report> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, report, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564569-07:00", comments="Source Table: report")
    default List<Report> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, report, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564615-07:00", comments="Source Table: report")
    default List<Report> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, report, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564662-07:00", comments="Source Table: report")
    default Optional<Report> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564712-07:00", comments="Source Table: report")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, report, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.56478-07:00", comments="Source Table: report")
    static UpdateDSL<UpdateModel> updateAllColumns(Report record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(reportedby).equalTo(record::getReportedby)
                .set(registration).equalTo(record::getRegistration)
                .set(uuid).equalTo(record::getUuid)
                .set(perioddetailsid).equalTo(record::getPerioddetailsid)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564877-07:00", comments="Source Table: report")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Report record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(reportedby).equalToWhenPresent(record::getReportedby)
                .set(registration).equalToWhenPresent(record::getRegistration)
                .set(uuid).equalToWhenPresent(record::getUuid)
                .set(perioddetailsid).equalToWhenPresent(record::getPerioddetailsid)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.564997-07:00", comments="Source Table: report")
    default int updateByPrimaryKey(Report record) {
        return update(c ->
            c.set(reportedby).equalTo(record::getReportedby)
            .set(registration).equalTo(record::getRegistration)
            .set(uuid).equalTo(record::getUuid)
            .set(perioddetailsid).equalTo(record::getPerioddetailsid)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.565105-07:00", comments="Source Table: report")
    default int updateByPrimaryKeySelective(Report record) {
        return update(c ->
            c.set(reportedby).equalToWhenPresent(record::getReportedby)
            .set(registration).equalToWhenPresent(record::getRegistration)
            .set(uuid).equalToWhenPresent(record::getUuid)
            .set(perioddetailsid).equalToWhenPresent(record::getPerioddetailsid)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}