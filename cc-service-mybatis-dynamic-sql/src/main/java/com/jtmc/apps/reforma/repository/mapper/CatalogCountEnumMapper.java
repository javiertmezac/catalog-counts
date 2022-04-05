package com.jtmc.apps.reforma.repository.mapper;

import static com.jtmc.apps.reforma.repository.mapper.CatalogCountEnumDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.jtmc.apps.reforma.domain.CatalogCountEnum;
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
public interface CatalogCountEnumMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.622738-07:00", comments="Source Table: catalog_count_enum")
    BasicColumn[] selectList = BasicColumn.columnList(id, identifier, family, name, description, type, isdeleted);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.621871-07:00", comments="Source Table: catalog_count_enum")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.621923-07:00", comments="Source Table: catalog_count_enum")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.621969-07:00", comments="Source Table: catalog_count_enum")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<CatalogCountEnum> insertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.622017-07:00", comments="Source Table: catalog_count_enum")
    @InsertProvider(type=SqlProviderAdapter.class, method="insertMultiple")
    int insertMultiple(MultiRowInsertStatementProvider<CatalogCountEnum> multipleInsertStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.622071-07:00", comments="Source Table: catalog_count_enum")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("CatalogCountEnumResult")
    Optional<CatalogCountEnum> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.622127-07:00", comments="Source Table: catalog_count_enum")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="CatalogCountEnumResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="identifier", property="identifier", jdbcType=JdbcType.VARCHAR),
        @Result(column="family", property="family", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="isDeleted", property="isdeleted", jdbcType=JdbcType.BIT)
    })
    List<CatalogCountEnum> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.622219-07:00", comments="Source Table: catalog_count_enum")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.622275-07:00", comments="Source Table: catalog_count_enum")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, catalogCountEnum, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.622321-07:00", comments="Source Table: catalog_count_enum")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, catalogCountEnum, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.622362-07:00", comments="Source Table: catalog_count_enum")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.62241-07:00", comments="Source Table: catalog_count_enum")
    default int insert(CatalogCountEnum record) {
        return MyBatis3Utils.insert(this::insert, record, catalogCountEnum, c ->
            c.map(id).toProperty("id")
            .map(identifier).toProperty("identifier")
            .map(family).toProperty("family")
            .map(name).toProperty("name")
            .map(description).toProperty("description")
            .map(type).toProperty("type")
            .map(isdeleted).toProperty("isdeleted")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.622485-07:00", comments="Source Table: catalog_count_enum")
    default int insertMultiple(Collection<CatalogCountEnum> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, catalogCountEnum, c ->
            c.map(id).toProperty("id")
            .map(identifier).toProperty("identifier")
            .map(family).toProperty("family")
            .map(name).toProperty("name")
            .map(description).toProperty("description")
            .map(type).toProperty("type")
            .map(isdeleted).toProperty("isdeleted")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.62257-07:00", comments="Source Table: catalog_count_enum")
    default int insertSelective(CatalogCountEnum record) {
        return MyBatis3Utils.insert(this::insert, record, catalogCountEnum, c ->
            c.map(id).toPropertyWhenPresent("id", record::getId)
            .map(identifier).toPropertyWhenPresent("identifier", record::getIdentifier)
            .map(family).toPropertyWhenPresent("family", record::getFamily)
            .map(name).toPropertyWhenPresent("name", record::getName)
            .map(description).toPropertyWhenPresent("description", record::getDescription)
            .map(type).toPropertyWhenPresent("type", record::getType)
            .map(isdeleted).toPropertyWhenPresent("isdeleted", record::getIsdeleted)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.622788-07:00", comments="Source Table: catalog_count_enum")
    default Optional<CatalogCountEnum> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, catalogCountEnum, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.62284-07:00", comments="Source Table: catalog_count_enum")
    default List<CatalogCountEnum> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, catalogCountEnum, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.622897-07:00", comments="Source Table: catalog_count_enum")
    default List<CatalogCountEnum> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, catalogCountEnum, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.623009-07:00", comments="Source Table: catalog_count_enum")
    default Optional<CatalogCountEnum> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.623081-07:00", comments="Source Table: catalog_count_enum")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, catalogCountEnum, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.62313-07:00", comments="Source Table: catalog_count_enum")
    static UpdateDSL<UpdateModel> updateAllColumns(CatalogCountEnum record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(record::getId)
                .set(identifier).equalTo(record::getIdentifier)
                .set(family).equalTo(record::getFamily)
                .set(name).equalTo(record::getName)
                .set(description).equalTo(record::getDescription)
                .set(type).equalTo(record::getType)
                .set(isdeleted).equalTo(record::getIsdeleted);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.623257-07:00", comments="Source Table: catalog_count_enum")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(CatalogCountEnum record, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(record::getId)
                .set(identifier).equalToWhenPresent(record::getIdentifier)
                .set(family).equalToWhenPresent(record::getFamily)
                .set(name).equalToWhenPresent(record::getName)
                .set(description).equalToWhenPresent(record::getDescription)
                .set(type).equalToWhenPresent(record::getType)
                .set(isdeleted).equalToWhenPresent(record::getIsdeleted);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.623385-07:00", comments="Source Table: catalog_count_enum")
    default int updateByPrimaryKey(CatalogCountEnum record) {
        return update(c ->
            c.set(identifier).equalTo(record::getIdentifier)
            .set(family).equalTo(record::getFamily)
            .set(name).equalTo(record::getName)
            .set(description).equalTo(record::getDescription)
            .set(type).equalTo(record::getType)
            .set(isdeleted).equalTo(record::getIsdeleted)
            .where(id, isEqualTo(record::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2022-04-04T19:57:38.623507-07:00", comments="Source Table: catalog_count_enum")
    default int updateByPrimaryKeySelective(CatalogCountEnum record) {
        return update(c ->
            c.set(identifier).equalToWhenPresent(record::getIdentifier)
            .set(family).equalToWhenPresent(record::getFamily)
            .set(name).equalToWhenPresent(record::getName)
            .set(description).equalToWhenPresent(record::getDescription)
            .set(type).equalToWhenPresent(record::getType)
            .set(isdeleted).equalToWhenPresent(record::getIsdeleted)
            .where(id, isEqualTo(record::getId))
        );
    }
}