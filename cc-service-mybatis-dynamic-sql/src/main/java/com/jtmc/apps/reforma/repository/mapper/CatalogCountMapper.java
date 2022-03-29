package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.CatalogCountDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.reforma.domain.CatalogCount;
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
public interface CatalogCountMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.812582-07:00", comments="Source Table: catalog_count")
    BasicColumn[] selectList = BasicColumn.columnList(id, registrationdate, catalogcountenumid, amount, details, isdeleted);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.804092-07:00", comments="Source Table: catalog_count")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.80522-07:00", comments="Source Table: catalog_count")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.80556-07:00", comments="Source Table: catalog_count")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<CatalogCount> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.806138-07:00", comments="Source Table: catalog_count")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<CatalogCount> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.806584-07:00", comments="Source Table: catalog_count")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CatalogCountResult")
    Optional<CatalogCount> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.806977-07:00", comments="Source Table: catalog_count")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CatalogCountResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="registrationDate", property="registrationdate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="catalogCountEnumId", property="catalogcountenumid", jdbcType=JdbcType.BIGINT),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE),
        @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR),
        @Result(column="isDeleted", property="isdeleted", jdbcType=JdbcType.BIT)
    })
    List<CatalogCount> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.808459-07:00", comments="Source Table: catalog_count")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.808797-07:00", comments="Source Table: catalog_count")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, catalogCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.809092-07:00", comments="Source Table: catalog_count")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, catalogCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.809446-07:00", comments="Source Table: catalog_count")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.809808-07:00", comments="Source Table: catalog_count")
    default int insert(CatalogCount record) {
        return MyBatis3Utils.insert(this::insert, record, catalogCount, c ->
            c.map(id).toProperty("id")
            .map(registrationdate).toProperty("registrationdate")
            .map(catalogcountenumid).toProperty("catalogcountenumid")
            .map(amount).toProperty("amount")
            .map(details).toProperty("details")
            .map(isdeleted).toProperty("isdeleted")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.810926-07:00", comments="Source Table: catalog_count")
    default int insertMultiple(Collection<CatalogCount> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, catalogCount, c ->
            c.map(id).toProperty("id")
            .map(registrationdate).toProperty("registrationdate")
            .map(catalogcountenumid).toProperty("catalogcountenumid")
            .map(amount).toProperty("amount")
            .map(details).toProperty("details")
            .map(isdeleted).toProperty("isdeleted")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.811357-07:00", comments="Source Table: catalog_count")
    default int insertSelective(CatalogCount record) {
        return MyBatis3Utils.insert(this::insert, record, catalogCount, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(registrationdate).toPropertyWhenPresent("registrationdate", record::getRegistrationdate)
            .map(catalogcountenumid).toPropertyWhenPresent("catalogcountenumid", record::getCatalogcountenumid)
            .map(amount).toPropertyWhenPresent("amount", record::getAmount)
            .map(details).toPropertyWhenPresent("details", record::getDetails)
            .map(isdeleted).toPropertyWhenPresent("isdeleted", record::getIsdeleted)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.813622-07:00", comments="Source Table: catalog_count")
    default Optional<CatalogCount> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, catalogCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.814013-07:00", comments="Source Table: catalog_count")
    default List<CatalogCount> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, catalogCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.814373-07:00", comments="Source Table: catalog_count")
    default List<CatalogCount> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, catalogCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.814763-07:00", comments="Source Table: catalog_count")
    default Optional<CatalogCount> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.815088-07:00", comments="Source Table: catalog_count")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, catalogCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.815597-07:00", comments="Source Table: catalog_count")
    static UpdateDSL<UpdateModel> updateAllColumns(CatalogCount record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(registrationdate).equalTo(record::getRegistrationdate)
                .set(catalogcountenumid).equalTo(record::getCatalogcountenumid)
                .set(amount).equalTo(record::getAmount)
                .set(details).equalTo(record::getDetails)
                .set(isdeleted).equalTo(record::getIsdeleted);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.816185-07:00", comments="Source Table: catalog_count")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CatalogCount record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(registrationdate).equalToWhenPresent(record::getRegistrationdate)
                .set(catalogcountenumid).equalToWhenPresent(record::getCatalogcountenumid)
                .set(amount).equalToWhenPresent(record::getAmount)
                .set(details).equalToWhenPresent(record::getDetails)
                .set(isdeleted).equalToWhenPresent(record::getIsdeleted);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.817004-07:00", comments="Source Table: catalog_count")
    default int updateByPrimaryKey(CatalogCount record) {
        return update(c ->
            c.set(registrationdate).equalTo(record::getRegistrationdate)
            .set(catalogcountenumid).equalTo(record::getCatalogcountenumid)
            .set(amount).equalTo(record::getAmount)
            .set(details).equalTo(record::getDetails)
            .set(isdeleted).equalTo(record::getIsdeleted)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-03-14T00:36:44.817604-07:00", comments="Source Table: catalog_count")
    default int updateByPrimaryKeySelective(CatalogCount record) {
        return update(c ->
            c.set(registrationdate).equalToWhenPresent(record::getRegistrationdate)
            .set(catalogcountenumid).equalToWhenPresent(record::getCatalogcountenumid)
            .set(amount).equalToWhenPresent(record::getAmount)
            .set(details).equalToWhenPresent(record::getDetails)
            .set(isdeleted).equalToWhenPresent(record::getIsdeleted)
            .where(id, isEqualTo(record::getId))
        );
    }
}