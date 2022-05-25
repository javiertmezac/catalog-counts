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
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.551336-07:00", comments="Source Table: period")
    BasicColumn[] selectList = BasicColumn.columnList(id, description, from, to, year, status);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.542619-07:00", comments="Source Table: period")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.543692-07:00", comments="Source Table: period")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.544042-07:00", comments="Source Table: period")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Period> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.544775-07:00", comments="Source Table: period")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<Period> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.545242-07:00", comments="Source Table: period")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PeriodResult")
    Optional<Period> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.545684-07:00", comments="Source Table: period")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PeriodResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="from", property="from", jdbcType=JdbcType.INTEGER),
        @Result(column="to", property="to", jdbcType=JdbcType.INTEGER),
        @Result(column="year", property="year", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT)
    })
    List<Period> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.547298-07:00", comments="Source Table: period")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.547633-07:00", comments="Source Table: period")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, period, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.547981-07:00", comments="Source Table: period")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, period, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.548323-07:00", comments="Source Table: period")
    default int deleteByPrimaryKey(Integer id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.548696-07:00", comments="Source Table: period")
    default int insert(Period record) {
        return MyBatis3Utils.insert(this::insert, record, period, c ->
            c.map(id).toProperty("id")
            .map(description).toProperty("description")
            .map(from).toProperty("from")
            .map(to).toProperty("to")
            .map(year).toProperty("year")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.549717-07:00", comments="Source Table: period")
    default int insertMultiple(Collection<Period> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, period, c ->
            c.map(id).toProperty("id")
            .map(description).toProperty("description")
            .map(from).toProperty("from")
            .map(to).toProperty("to")
            .map(year).toProperty("year")
            .map(status).toProperty("status")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.550169-07:00", comments="Source Table: period")
    default int insertSelective(Period record) {
        return MyBatis3Utils.insert(this::insert, record, period, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(description).toPropertyWhenPresent("description", record::getDescription)
            .map(from).toPropertyWhenPresent("from", record::getFrom)
            .map(to).toPropertyWhenPresent("to", record::getTo)
            .map(year).toPropertyWhenPresent("year", record::getYear)
            .map(status).toPropertyWhenPresent("status", record::getStatus)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.552371-07:00", comments="Source Table: period")
    default Optional<Period> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, period, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.552765-07:00", comments="Source Table: period")
    default List<Period> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, period, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.553124-07:00", comments="Source Table: period")
    default List<Period> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, period, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.553519-07:00", comments="Source Table: period")
    default Optional<Period> selectByPrimaryKey(Integer id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.553845-07:00", comments="Source Table: period")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, period, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.554204-07:00", comments="Source Table: period")
    static UpdateDSL<UpdateModel> updateAllColumns(Period record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(description).equalTo(record::getDescription)
                .set(from).equalTo(record::getFrom)
                .set(to).equalTo(record::getTo)
                .set(year).equalTo(record::getYear)
                .set(status).equalTo(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.55464-07:00", comments="Source Table: period")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Period record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(from).equalToWhenPresent(record::getFrom)
                .set(to).equalToWhenPresent(record::getTo)
                .set(year).equalToWhenPresent(record::getYear)
                .set(status).equalToWhenPresent(record::getStatus);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.555356-07:00", comments="Source Table: period")
    default int updateByPrimaryKey(Period record) {
        return update(c ->
            c.set(description).equalTo(record::getDescription)
            .set(from).equalTo(record::getFrom)
            .set(to).equalTo(record::getTo)
            .set(year).equalTo(record::getYear)
            .set(status).equalTo(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-05-24T22:28:53.555807-07:00", comments="Source Table: period")
    default int updateByPrimaryKeySelective(Period record) {
        return update(c ->
            c.set(description).equalToWhenPresent(record::getDescription)
            .set(from).equalToWhenPresent(record::getFrom)
            .set(to).equalToWhenPresent(record::getTo)
            .set(year).equalToWhenPresent(record::getYear)
            .set(status).equalToWhenPresent(record::getStatus)
            .where(id, isEqualTo(record::getId))
        );
    }
}