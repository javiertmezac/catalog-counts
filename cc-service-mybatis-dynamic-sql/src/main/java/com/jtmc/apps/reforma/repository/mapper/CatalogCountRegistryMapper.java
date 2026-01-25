package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.CatalogCountRegistryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.jtmc.apps.reforma.domain.CatalogCountRegistry;
import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface CatalogCountRegistryMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<CatalogCountRegistry>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.677597-08:00", comments="Source Table: catalog_count_registry")
    BasicColumn[] selectList = BasicColumn.columnList(catalogcountregistryid, registrytype, entrypersonid, entrydate, acceptedpersonid, accepteddate, inactivedate, branchid, details);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.674725-08:00", comments="Source Table: catalog_count_registry")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CatalogCountRegistryResult", value = {
        @Result(column="catalogCountRegistryId", property="catalogcountregistryid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="registryType", property="registrytype", jdbcType=JdbcType.CHAR),
        @Result(column="entryPersonId", property="entrypersonid", jdbcType=JdbcType.INTEGER),
        @Result(column="entryDate", property="entrydate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="acceptedPersonId", property="acceptedpersonid", jdbcType=JdbcType.INTEGER),
        @Result(column="acceptedDate", property="accepteddate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="inactiveDate", property="inactivedate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="branchId", property="branchid", jdbcType=JdbcType.INTEGER),
        @Result(column="details", property="details", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<CatalogCountRegistry> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.675399-08:00", comments="Source Table: catalog_count_registry")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CatalogCountRegistryResult")
    Optional<CatalogCountRegistry> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.675551-08:00", comments="Source Table: catalog_count_registry")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, catalogCountRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.675702-08:00", comments="Source Table: catalog_count_registry")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, catalogCountRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.675919-08:00", comments="Source Table: catalog_count_registry")
    default int deleteByPrimaryKey(UUID catalogcountregistryid_) {
        return delete(c -> 
            c.where(catalogcountregistryid, isEqualTo(catalogcountregistryid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.676067-08:00", comments="Source Table: catalog_count_registry")
    default int insert(CatalogCountRegistry row) {
        return MyBatis3Utils.insert(this::insert, row, catalogCountRegistry, c ->
            c.map(catalogcountregistryid).toProperty("catalogcountregistryid")
            .map(registrytype).toProperty("registrytype")
            .map(entrypersonid).toProperty("entrypersonid")
            .map(entrydate).toProperty("entrydate")
            .map(acceptedpersonid).toProperty("acceptedpersonid")
            .map(accepteddate).toProperty("accepteddate")
            .map(inactivedate).toProperty("inactivedate")
            .map(branchid).toProperty("branchid")
            .map(details).toProperty("details")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.676823-08:00", comments="Source Table: catalog_count_registry")
    default int insertMultiple(Collection<CatalogCountRegistry> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, catalogCountRegistry, c ->
            c.map(catalogcountregistryid).toProperty("catalogcountregistryid")
            .map(registrytype).toProperty("registrytype")
            .map(entrypersonid).toProperty("entrypersonid")
            .map(entrydate).toProperty("entrydate")
            .map(acceptedpersonid).toProperty("acceptedpersonid")
            .map(accepteddate).toProperty("accepteddate")
            .map(inactivedate).toProperty("inactivedate")
            .map(branchid).toProperty("branchid")
            .map(details).toProperty("details")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.677145-08:00", comments="Source Table: catalog_count_registry")
    default int insertSelective(CatalogCountRegistry row) {
        return MyBatis3Utils.insert(this::insert, row, catalogCountRegistry, c ->
            c.map(catalogcountregistryid).toPropertyWhenPresent("catalogcountregistryid", row::getCatalogcountregistryid)
            .map(registrytype).toPropertyWhenPresent("registrytype", row::getRegistrytype)
            .map(entrypersonid).toPropertyWhenPresent("entrypersonid", row::getEntrypersonid)
            .map(entrydate).toPropertyWhenPresent("entrydate", row::getEntrydate)
            .map(acceptedpersonid).toPropertyWhenPresent("acceptedpersonid", row::getAcceptedpersonid)
            .map(accepteddate).toPropertyWhenPresent("accepteddate", row::getAccepteddate)
            .map(inactivedate).toPropertyWhenPresent("inactivedate", row::getInactivedate)
            .map(branchid).toPropertyWhenPresent("branchid", row::getBranchid)
            .map(details).toPropertyWhenPresent("details", row::getDetails)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.677869-08:00", comments="Source Table: catalog_count_registry")
    default Optional<CatalogCountRegistry> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, catalogCountRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.678002-08:00", comments="Source Table: catalog_count_registry")
    default List<CatalogCountRegistry> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, catalogCountRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.678141-08:00", comments="Source Table: catalog_count_registry")
    default List<CatalogCountRegistry> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, catalogCountRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.678283-08:00", comments="Source Table: catalog_count_registry")
    default Optional<CatalogCountRegistry> selectByPrimaryKey(UUID catalogcountregistryid_) {
        return selectOne(c ->
            c.where(catalogcountregistryid, isEqualTo(catalogcountregistryid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.678411-08:00", comments="Source Table: catalog_count_registry")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, catalogCountRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.678558-08:00", comments="Source Table: catalog_count_registry")
    static UpdateDSL<UpdateModel> updateAllColumns(CatalogCountRegistry row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(catalogcountregistryid).equalTo(row::getCatalogcountregistryid)
                .set(registrytype).equalTo(row::getRegistrytype)
                .set(entrypersonid).equalTo(row::getEntrypersonid)
                .set(entrydate).equalTo(row::getEntrydate)
                .set(acceptedpersonid).equalTo(row::getAcceptedpersonid)
                .set(accepteddate).equalTo(row::getAccepteddate)
                .set(inactivedate).equalTo(row::getInactivedate)
                .set(branchid).equalTo(row::getBranchid)
                .set(details).equalTo(row::getDetails);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.678736-08:00", comments="Source Table: catalog_count_registry")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CatalogCountRegistry row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(catalogcountregistryid).equalToWhenPresent(row::getCatalogcountregistryid)
                .set(registrytype).equalToWhenPresent(row::getRegistrytype)
                .set(entrypersonid).equalToWhenPresent(row::getEntrypersonid)
                .set(entrydate).equalToWhenPresent(row::getEntrydate)
                .set(acceptedpersonid).equalToWhenPresent(row::getAcceptedpersonid)
                .set(accepteddate).equalToWhenPresent(row::getAccepteddate)
                .set(inactivedate).equalToWhenPresent(row::getInactivedate)
                .set(branchid).equalToWhenPresent(row::getBranchid)
                .set(details).equalToWhenPresent(row::getDetails);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.678985-08:00", comments="Source Table: catalog_count_registry")
    default int updateByPrimaryKey(CatalogCountRegistry row) {
        return update(c ->
            c.set(registrytype).equalTo(row::getRegistrytype)
            .set(entrypersonid).equalTo(row::getEntrypersonid)
            .set(entrydate).equalTo(row::getEntrydate)
            .set(acceptedpersonid).equalTo(row::getAcceptedpersonid)
            .set(accepteddate).equalTo(row::getAccepteddate)
            .set(inactivedate).equalTo(row::getInactivedate)
            .set(branchid).equalTo(row::getBranchid)
            .set(details).equalTo(row::getDetails)
            .where(catalogcountregistryid, isEqualTo(row::getCatalogcountregistryid))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-24T23:01:50.679172-08:00", comments="Source Table: catalog_count_registry")
    default int updateByPrimaryKeySelective(CatalogCountRegistry row) {
        return update(c ->
            c.set(registrytype).equalToWhenPresent(row::getRegistrytype)
            .set(entrypersonid).equalToWhenPresent(row::getEntrypersonid)
            .set(entrydate).equalToWhenPresent(row::getEntrydate)
            .set(acceptedpersonid).equalToWhenPresent(row::getAcceptedpersonid)
            .set(accepteddate).equalToWhenPresent(row::getAccepteddate)
            .set(inactivedate).equalToWhenPresent(row::getInactivedate)
            .set(branchid).equalToWhenPresent(row::getBranchid)
            .set(details).equalToWhenPresent(row::getDetails)
            .where(catalogcountregistryid, isEqualTo(row::getCatalogcountregistryid))
        );
    }
}