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
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244831-07:00", comments="Source Table: transferRegistry")
    BasicColumn[] selectList = BasicColumn.columnList(transferRegistryId, fromAccountId, toAccountId, amount, catalogCountEnumId, entryPersonId, entryDate, transferRegistryState, acceptedPersonId, acceptedDate, transferRegistryStatus, details);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244609-07:00", comments="Source Table: transferRegistry")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="TransferRegistryResult", value = {
        @Result(column="transferRegistryId", property="transferRegistryId", jdbcType=JdbcType.BINARY, id=true),
        @Result(column="fromAccountId", property="fromAccountId", jdbcType=JdbcType.INTEGER),
        @Result(column="toAccountId", property="toAccountId", jdbcType=JdbcType.INTEGER),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE),
        @Result(column="catalogCountEnumId", property="catalogCountEnumId", jdbcType=JdbcType.INTEGER),
        @Result(column="entryPersonId", property="entryPersonId", jdbcType=JdbcType.INTEGER),
        @Result(column="entryDate", property="entryDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="transferRegistryState", property="transferRegistryState", jdbcType=JdbcType.BIT),
        @Result(column="acceptedPersonId", property="acceptedPersonId", jdbcType=JdbcType.INTEGER),
        @Result(column="acceptedDate", property="acceptedDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="transferRegistryStatus", property="transferRegistryStatus", jdbcType=JdbcType.BIT),
        @Result(column="details", property="details", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<TransferRegistry> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244655-07:00", comments="Source Table: transferRegistry")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("TransferRegistryResult")
    Optional<TransferRegistry> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244672-07:00", comments="Source Table: transferRegistry")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, transferRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244686-07:00", comments="Source Table: transferRegistry")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, transferRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244698-07:00", comments="Source Table: transferRegistry")
    default int deleteByPrimaryKey(UUID transferRegistryId_) {
        return delete(c -> 
            c.where(transferRegistryId, isEqualTo(transferRegistryId_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244715-07:00", comments="Source Table: transferRegistry")
    default int insert(TransferRegistry row) {
        return MyBatis3Utils.insert(this::insert, row, transferRegistry, c ->
            c.map(transferRegistryId).toProperty("transferRegistryId")
            .map(fromAccountId).toProperty("fromAccountId")
            .map(toAccountId).toProperty("toAccountId")
            .map(amount).toProperty("amount")
            .map(catalogCountEnumId).toProperty("catalogCountEnumId")
            .map(entryPersonId).toProperty("entryPersonId")
            .map(entryDate).toProperty("entryDate")
            .map(transferRegistryState).toProperty("transferRegistryState")
            .map(acceptedPersonId).toProperty("acceptedPersonId")
            .map(acceptedDate).toProperty("acceptedDate")
            .map(transferRegistryStatus).toProperty("transferRegistryStatus")
            .map(details).toProperty("details")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244745-07:00", comments="Source Table: transferRegistry")
    default int insertMultiple(Collection<TransferRegistry> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, transferRegistry, c ->
            c.map(transferRegistryId).toProperty("transferRegistryId")
            .map(fromAccountId).toProperty("fromAccountId")
            .map(toAccountId).toProperty("toAccountId")
            .map(amount).toProperty("amount")
            .map(catalogCountEnumId).toProperty("catalogCountEnumId")
            .map(entryPersonId).toProperty("entryPersonId")
            .map(entryDate).toProperty("entryDate")
            .map(transferRegistryState).toProperty("transferRegistryState")
            .map(acceptedPersonId).toProperty("acceptedPersonId")
            .map(acceptedDate).toProperty("acceptedDate")
            .map(transferRegistryStatus).toProperty("transferRegistryStatus")
            .map(details).toProperty("details")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244773-07:00", comments="Source Table: transferRegistry")
    default int insertSelective(TransferRegistry row) {
        return MyBatis3Utils.insert(this::insert, row, transferRegistry, c ->
            c.map(transferRegistryId).toPropertyWhenPresent("transferRegistryId", row::getTransferRegistryId)
            .map(fromAccountId).toPropertyWhenPresent("fromAccountId", row::getFromAccountId)
            .map(toAccountId).toPropertyWhenPresent("toAccountId", row::getToAccountId)
            .map(amount).toPropertyWhenPresent("amount", row::getAmount)
            .map(catalogCountEnumId).toPropertyWhenPresent("catalogCountEnumId", row::getCatalogCountEnumId)
            .map(entryPersonId).toPropertyWhenPresent("entryPersonId", row::getEntryPersonId)
            .map(entryDate).toPropertyWhenPresent("entryDate", row::getEntryDate)
            .map(transferRegistryState).toPropertyWhenPresent("transferRegistryState", row::getTransferRegistryState)
            .map(acceptedPersonId).toPropertyWhenPresent("acceptedPersonId", row::getAcceptedPersonId)
            .map(acceptedDate).toPropertyWhenPresent("acceptedDate", row::getAcceptedDate)
            .map(transferRegistryStatus).toPropertyWhenPresent("transferRegistryStatus", row::getTransferRegistryStatus)
            .map(details).toPropertyWhenPresent("details", row::getDetails)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244848-07:00", comments="Source Table: transferRegistry")
    default Optional<TransferRegistry> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, transferRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244866-07:00", comments="Source Table: transferRegistry")
    default List<TransferRegistry> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, transferRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.24488-07:00", comments="Source Table: transferRegistry")
    default List<TransferRegistry> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, transferRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244893-07:00", comments="Source Table: transferRegistry")
    default Optional<TransferRegistry> selectByPrimaryKey(UUID transferregistryid_) {
        return selectOne(c ->
            c.where(transferRegistryId, isEqualTo(transferregistryid_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244908-07:00", comments="Source Table: transferRegistry")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, transferRegistry, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244923-07:00", comments="Source Table: transferRegistry")
    static UpdateDSL<UpdateModel> updateAllColumns(TransferRegistry row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(transferRegistryId).equalTo(row::getTransferRegistryId)
                .set(fromAccountId).equalTo(row::getFromAccountId)
                .set(toAccountId).equalTo(row::getToAccountId)
                .set(amount).equalTo(row::getAmount)
                .set(catalogCountEnumId).equalTo(row::getCatalogCountEnumId)
                .set(entryPersonId).equalTo(row::getEntryPersonId)
                .set(entryDate).equalTo(row::getEntryDate)
                .set(transferRegistryState).equalTo(row::getTransferRegistryState)
                .set(acceptedPersonId).equalTo(row::getAcceptedPersonId)
                .set(acceptedDate).equalTo(row::getAcceptedDate)
                .set(transferRegistryStatus).equalTo(row::getTransferRegistryStatus)
                .set(details).equalTo(row::getDetails);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244956-07:00", comments="Source Table: transferRegistry")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(TransferRegistry row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(transferRegistryId).equalToWhenPresent(row::getTransferRegistryId)
                .set(fromAccountId).equalToWhenPresent(row::getFromAccountId)
                .set(toAccountId).equalToWhenPresent(row::getToAccountId)
                .set(amount).equalToWhenPresent(row::getAmount)
                .set(catalogCountEnumId).equalToWhenPresent(row::getCatalogCountEnumId)
                .set(entryPersonId).equalToWhenPresent(row::getEntryPersonId)
                .set(entryDate).equalToWhenPresent(row::getEntryDate)
                .set(transferRegistryState).equalToWhenPresent(row::getTransferRegistryState)
                .set(acceptedPersonId).equalToWhenPresent(row::getAcceptedPersonId)
                .set(acceptedDate).equalToWhenPresent(row::getAcceptedDate)
                .set(transferRegistryStatus).equalToWhenPresent(row::getTransferRegistryStatus)
                .set(details).equalToWhenPresent(row::getDetails);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.244989-07:00", comments="Source Table: transferRegistry")
    default int updateByPrimaryKey(TransferRegistry row) {
        return update(c ->
            c.set(fromAccountId).equalTo(row::getFromAccountId)
            .set(toAccountId).equalTo(row::getToAccountId)
            .set(amount).equalTo(row::getAmount)
            .set(catalogCountEnumId).equalTo(row::getCatalogCountEnumId)
            .set(entryPersonId).equalTo(row::getEntryPersonId)
            .set(entryDate).equalTo(row::getEntryDate)
            .set(transferRegistryState).equalTo(row::getTransferRegistryState)
            .set(acceptedPersonId).equalTo(row::getAcceptedPersonId)
            .set(acceptedDate).equalTo(row::getAcceptedDate)
            .set(transferRegistryStatus).equalTo(row::getTransferRegistryStatus)
            .set(details).equalTo(row::getDetails)
            .where(transferRegistryId, isEqualTo(row::getTransferRegistryId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2025-03-30T20:40:32.245019-07:00", comments="Source Table: transferRegistry")
    default int updateByPrimaryKeySelective(TransferRegistry row) {
        return update(c ->
            c.set(fromAccountId).equalToWhenPresent(row::getFromAccountId)
            .set(toAccountId).equalToWhenPresent(row::getToAccountId)
            .set(amount).equalToWhenPresent(row::getAmount)
            .set(catalogCountEnumId).equalToWhenPresent(row::getCatalogCountEnumId)
            .set(entryPersonId).equalToWhenPresent(row::getEntryPersonId)
            .set(entryDate).equalToWhenPresent(row::getEntryDate)
            .set(transferRegistryState).equalToWhenPresent(row::getTransferRegistryState)
            .set(acceptedPersonId).equalToWhenPresent(row::getAcceptedPersonId)
            .set(acceptedDate).equalToWhenPresent(row::getAcceptedDate)
            .set(transferRegistryStatus).equalToWhenPresent(row::getTransferRegistryStatus)
            .set(details).equalToWhenPresent(row::getDetails)
            .where(transferRegistryId, isEqualTo(row::getTransferRegistryId))
        );
    }
}