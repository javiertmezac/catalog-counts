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
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.619065-07:00", comments="Source Table: catalog_count")
    BasicColumn[] selectList = BasicColumn.columnList(id, registration, catalogcountenumid, amount, details, isdeleted, branchid);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.618083-07:00", comments="Source Table: catalog_count")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.61814-07:00", comments="Source Table: catalog_count")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.618202-07:00", comments="Source Table: catalog_count")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<CatalogCount> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.618263-07:00", comments="Source Table: catalog_count")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<CatalogCount> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.61832-07:00", comments="Source Table: catalog_count")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CatalogCountResult")
    Optional<CatalogCount> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.618383-07:00", comments="Source Table: catalog_count")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CatalogCountResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="catalogCountEnumId", property="catalogcountenumid", jdbcType=JdbcType.BIGINT),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE),
        @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR),
        @Result(column="isDeleted", property="isdeleted", jdbcType=JdbcType.BIT),
        @Result(column="branchId", property="branchid", jdbcType=JdbcType.BIGINT)
    })
    List<CatalogCount> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.618497-07:00", comments="Source Table: catalog_count")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.618549-07:00", comments="Source Table: catalog_count")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, catalogCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.618601-07:00", comments="Source Table: catalog_count")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, catalogCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.61865-07:00", comments="Source Table: catalog_count")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.618703-07:00", comments="Source Table: catalog_count")
    default int insert(CatalogCount record) {
        return MyBatis3Utils.insert(this::insert, record, catalogCount, c ->
            c.map(id).toProperty("id")
            .map(registration).toProperty("registration")
            .map(catalogcountenumid).toProperty("catalogcountenumid")
            .map(amount).toProperty("amount")
            .map(details).toProperty("details")
            .map(isdeleted).toProperty("isdeleted")
            .map(branchid).toProperty("branchid")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.618791-07:00", comments="Source Table: catalog_count")
    default int insertMultiple(Collection<CatalogCount> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, catalogCount, c ->
            c.map(id).toProperty("id")
            .map(registration).toProperty("registration")
            .map(catalogcountenumid).toProperty("catalogcountenumid")
            .map(amount).toProperty("amount")
            .map(details).toProperty("details")
            .map(isdeleted).toProperty("isdeleted")
            .map(branchid).toProperty("branchid")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.61889-07:00", comments="Source Table: catalog_count")
    default int insertSelective(CatalogCount record) {
        return MyBatis3Utils.insert(this::insert, record, catalogCount, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(registration).toPropertyWhenPresent("registration", record::getRegistration)
            .map(catalogcountenumid).toPropertyWhenPresent("catalogcountenumid", record::getCatalogcountenumid)
            .map(amount).toPropertyWhenPresent("amount", record::getAmount)
            .map(details).toPropertyWhenPresent("details", record::getDetails)
            .map(isdeleted).toPropertyWhenPresent("isdeleted", record::getIsdeleted)
            .map(branchid).toPropertyWhenPresent("branchid", record::getBranchid)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.61912-07:00", comments="Source Table: catalog_count")
    default Optional<CatalogCount> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, catalogCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.619237-07:00", comments="Source Table: catalog_count")
    default List<CatalogCount> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, catalogCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.619296-07:00", comments="Source Table: catalog_count")
    default List<CatalogCount> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, catalogCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.619362-07:00", comments="Source Table: catalog_count")
    default Optional<CatalogCount> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.619426-07:00", comments="Source Table: catalog_count")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, catalogCount, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.619484-07:00", comments="Source Table: catalog_count")
    static UpdateDSL<UpdateModel> updateAllColumns(CatalogCount record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(registration).equalTo(record::getRegistration)
                .set(catalogcountenumid).equalTo(record::getCatalogcountenumid)
                .set(amount).equalTo(record::getAmount)
                .set(details).equalTo(record::getDetails)
                .set(isdeleted).equalTo(record::getIsdeleted)
                .set(branchid).equalTo(record::getBranchid);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.619611-07:00", comments="Source Table: catalog_count")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CatalogCount record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(registration).equalToWhenPresent(record::getRegistration)
                .set(catalogcountenumid).equalToWhenPresent(record::getCatalogcountenumid)
                .set(amount).equalToWhenPresent(record::getAmount)
                .set(details).equalToWhenPresent(record::getDetails)
                .set(isdeleted).equalToWhenPresent(record::getIsdeleted)
                .set(branchid).equalToWhenPresent(record::getBranchid);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.619757-07:00", comments="Source Table: catalog_count")
    default int updateByPrimaryKey(CatalogCount record) {
        return update(c ->
            c.set(registration).equalTo(record::getRegistration)
            .set(catalogcountenumid).equalTo(record::getCatalogcountenumid)
            .set(amount).equalTo(record::getAmount)
            .set(details).equalTo(record::getDetails)
            .set(isdeleted).equalTo(record::getIsdeleted)
            .set(branchid).equalTo(record::getBranchid)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.619884-07:00", comments="Source Table: catalog_count")
    default int updateByPrimaryKeySelective(CatalogCount record) {
        return update(c ->
            c.set(registration).equalToWhenPresent(record::getRegistration)
            .set(catalogcountenumid).equalToWhenPresent(record::getCatalogcountenumid)
            .set(amount).equalToWhenPresent(record::getAmount)
            .set(details).equalToWhenPresent(record::getDetails)
            .set(isdeleted).equalToWhenPresent(record::getIsdeleted)
            .set(branchid).equalToWhenPresent(record::getBranchid)
            .where(id, isEqualTo(record::getId))
        );
    }
}