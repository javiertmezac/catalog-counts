package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.TransferRegistryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import com.jtmc.apps.reforma.domain.TransferRegistry;
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
public interface TransferRegistryMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<TransferRegistry>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.916209-07:00", comments="Source Table: transferRegistry")
    BasicColumn[] selectList = BasicColumn.columnList(transferregistryid, fromaccountid, toaccountid, amount, fromaccountcatalogcountid, toaccountcatalogcountid, entrypersonid, entrydate, inactivedate, acceptedpersonid, accepteddate, details);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.91349-07:00", comments="Source Table: transferRegistry")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TransferRegistryResult", value = {
        @Result(column="transferRegistryId", property="transferregistryid", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="fromAccountId", property="fromaccountid", jdbcType=JdbcType.INTEGER),
        @Result(column="toAccountId", property="toaccountid", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE),
        @Result(column="fromAccountCatalogCountId", property="fromaccountcatalogcountid", jdbcType=JdbcType.INTEGER),
        @Result(column="toAccountCatalogCountId", property="toaccountcatalogcountid", jdbcType=JdbcType.INTEGER),
        @Result(column="entryPersonId", property="entrypersonid", jdbcType=JdbcType.INTEGER),
        @Result(column="entryDate", property="entrydate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="inactiveDate", property="inactivedate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="acceptedPersonId", property="acceptedpersonid", jdbcType=JdbcType.INTEGER),
        @Result(column="acceptedDate", property="accepteddate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="details", property="details", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TransferRegistry> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.914166-07:00", comments="Source Table: transferRegistry")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TransferRegistryResult")
    Optional<TransferRegistry> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.91434-07:00", comments="Source Table: transferRegistry")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, transferRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.914486-07:00", comments="Source Table: transferRegistry")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, transferRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.914743-07:00", comments="Source Table: transferRegistry")
    default int deleteByPrimaryKey(UUID transferregistryid_) {
        return delete(c -> 
            c.where(transferregistryid, isEqualTo(transferregistryid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.914884-07:00", comments="Source Table: transferRegistry")
    default int insert(TransferRegistry row) {
        return MyBatis3Utils.insert(this::insert, row, transferRegistry, c ->
            c.map(transferregistryid).toProperty("transferregistryid")
            .map(fromaccountid).toProperty("fromaccountid")
            .map(toaccountid).toProperty("toaccountid")
            .map(amount).toProperty("amount")
            .map(fromaccountcatalogcountid).toProperty("fromaccountcatalogcountid")
            .map(toaccountcatalogcountid).toProperty("toaccountcatalogcountid")
            .map(entrypersonid).toProperty("entrypersonid")
            .map(entrydate).toProperty("entrydate")
            .map(inactivedate).toProperty("inactivedate")
            .map(acceptedpersonid).toProperty("acceptedpersonid")
            .map(accepteddate).toProperty("accepteddate")
            .map(details).toProperty("details")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.915533-07:00", comments="Source Table: transferRegistry")
    default int insertMultiple(Collection<TransferRegistry> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, transferRegistry, c ->
            c.map(transferregistryid).toProperty("transferregistryid")
            .map(fromaccountid).toProperty("fromaccountid")
            .map(toaccountid).toProperty("toaccountid")
            .map(amount).toProperty("amount")
            .map(fromaccountcatalogcountid).toProperty("fromaccountcatalogcountid")
            .map(toaccountcatalogcountid).toProperty("toaccountcatalogcountid")
            .map(entrypersonid).toProperty("entrypersonid")
            .map(entrydate).toProperty("entrydate")
            .map(inactivedate).toProperty("inactivedate")
            .map(acceptedpersonid).toProperty("acceptedpersonid")
            .map(accepteddate).toProperty("accepteddate")
            .map(details).toProperty("details")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.915778-07:00", comments="Source Table: transferRegistry")
    default int insertSelective(TransferRegistry row) {
        return MyBatis3Utils.insert(this::insert, row, transferRegistry, c ->
            c.map(transferregistryid).toPropertyWhenPresent("transferregistryid", row::getTransferregistryid)
            .map(fromaccountid).toPropertyWhenPresent("fromaccountid", row::getFromaccountid)
            .map(toaccountid).toPropertyWhenPresent("toaccountid", row::getToaccountid)
            .map(amount).toPropertyWhenPresent("amount", row::getAmount)
            .map(fromaccountcatalogcountid).toPropertyWhenPresent("fromaccountcatalogcountid", row::getFromaccountcatalogcountid)
            .map(toaccountcatalogcountid).toPropertyWhenPresent("toaccountcatalogcountid", row::getToaccountcatalogcountid)
            .map(entrypersonid).toPropertyWhenPresent("entrypersonid", row::getEntrypersonid)
            .map(entrydate).toPropertyWhenPresent("entrydate", row::getEntrydate)
            .map(inactivedate).toPropertyWhenPresent("inactivedate", row::getInactivedate)
            .map(acceptedpersonid).toPropertyWhenPresent("acceptedpersonid", row::getAcceptedpersonid)
            .map(accepteddate).toPropertyWhenPresent("accepteddate", row::getAccepteddate)
            .map(details).toPropertyWhenPresent("details", row::getDetails)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.916504-07:00", comments="Source Table: transferRegistry")
    default Optional<TransferRegistry> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, transferRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.916633-07:00", comments="Source Table: transferRegistry")
    default List<TransferRegistry> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, transferRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.916791-07:00", comments="Source Table: transferRegistry")
    default List<TransferRegistry> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, transferRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.916981-07:00", comments="Source Table: transferRegistry")
    default Optional<TransferRegistry> selectByPrimaryKey(UUID transferregistryid_) {
        return selectOne(c ->
            c.where(transferregistryid, isEqualTo(transferregistryid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.917125-07:00", comments="Source Table: transferRegistry")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, transferRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.917276-07:00", comments="Source Table: transferRegistry")
    static UpdateDSL<UpdateModel> updateAllColumns(TransferRegistry row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(transferregistryid).equalTo(row::getTransferregistryid)
                .set(fromaccountid).equalTo(row::getFromaccountid)
                .set(toaccountid).equalTo(row::getToaccountid)
                .set(amount).equalTo(row::getAmount)
                .set(fromaccountcatalogcountid).equalTo(row::getFromaccountcatalogcountid)
                .set(toaccountcatalogcountid).equalTo(row::getToaccountcatalogcountid)
                .set(entrypersonid).equalTo(row::getEntrypersonid)
                .set(entrydate).equalTo(row::getEntrydate)
                .set(inactivedate).equalTo(row::getInactivedate)
                .set(acceptedpersonid).equalTo(row::getAcceptedpersonid)
                .set(accepteddate).equalTo(row::getAccepteddate)
                .set(details).equalTo(row::getDetails);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.917454-07:00", comments="Source Table: transferRegistry")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TransferRegistry row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(transferregistryid).equalToWhenPresent(row::getTransferregistryid)
                .set(fromaccountid).equalToWhenPresent(row::getFromaccountid)
                .set(toaccountid).equalToWhenPresent(row::getToaccountid)
                .set(amount).equalToWhenPresent(row::getAmount)
                .set(fromaccountcatalogcountid).equalToWhenPresent(row::getFromaccountcatalogcountid)
                .set(toaccountcatalogcountid).equalToWhenPresent(row::getToaccountcatalogcountid)
                .set(entrypersonid).equalToWhenPresent(row::getEntrypersonid)
                .set(entrydate).equalToWhenPresent(row::getEntrydate)
                .set(inactivedate).equalToWhenPresent(row::getInactivedate)
                .set(acceptedpersonid).equalToWhenPresent(row::getAcceptedpersonid)
                .set(accepteddate).equalToWhenPresent(row::getAccepteddate)
                .set(details).equalToWhenPresent(row::getDetails);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.917695-07:00", comments="Source Table: transferRegistry")
    default int updateByPrimaryKey(TransferRegistry row) {
        return update(c ->
            c.set(fromaccountid).equalTo(row::getFromaccountid)
            .set(toaccountid).equalTo(row::getToaccountid)
            .set(amount).equalTo(row::getAmount)
            .set(fromaccountcatalogcountid).equalTo(row::getFromaccountcatalogcountid)
            .set(toaccountcatalogcountid).equalTo(row::getToaccountcatalogcountid)
            .set(entrypersonid).equalTo(row::getEntrypersonid)
            .set(entrydate).equalTo(row::getEntrydate)
            .set(inactivedate).equalTo(row::getInactivedate)
            .set(acceptedpersonid).equalTo(row::getAcceptedpersonid)
            .set(accepteddate).equalTo(row::getAccepteddate)
            .set(details).equalTo(row::getDetails)
            .where(transferregistryid, isEqualTo(row::getTransferregistryid))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-06-09T22:14:43.917873-07:00", comments="Source Table: transferRegistry")
    default int updateByPrimaryKeySelective(TransferRegistry row) {
        return update(c ->
            c.set(fromaccountid).equalToWhenPresent(row::getFromaccountid)
            .set(toaccountid).equalToWhenPresent(row::getToaccountid)
            .set(amount).equalToWhenPresent(row::getAmount)
            .set(fromaccountcatalogcountid).equalToWhenPresent(row::getFromaccountcatalogcountid)
            .set(toaccountcatalogcountid).equalToWhenPresent(row::getToaccountcatalogcountid)
            .set(entrypersonid).equalToWhenPresent(row::getEntrypersonid)
            .set(entrydate).equalToWhenPresent(row::getEntrydate)
            .set(inactivedate).equalToWhenPresent(row::getInactivedate)
            .set(acceptedpersonid).equalToWhenPresent(row::getAcceptedpersonid)
            .set(accepteddate).equalToWhenPresent(row::getAccepteddate)
            .set(details).equalToWhenPresent(row::getDetails)
            .where(transferregistryid, isEqualTo(row::getTransferregistryid))
        );
    }
}