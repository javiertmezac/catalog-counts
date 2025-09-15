package com.jtmc.apps.reforma.repository.mapper;

import com.jtmc.apps.reforma.domain.CatalogCountCumulativeSumParams;
import com.jtmc.apps.reforma.domain.CustomCatalogCount;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import java.util.List;

@Mapper
public interface CustomCatalogCountMapper {

    @SelectProvider(type= SqlProviderAdapter.class, method="select")
    @Results(id="CatalogCountResult", value = {
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="catalogCountEnumId", property="catalogcountenumid", jdbcType=JdbcType.INTEGER),
            @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE),
            @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR),
            @Result(column="isDeleted", property="isdeleted", jdbcType=JdbcType.BIT),
            @Result(column="branchId", property="branchid", jdbcType=JdbcType.INTEGER),
            @Result(column="identifier", property="identifier", jdbcType=JdbcType.VARCHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<CustomCatalogCount> selectMany(SelectStatementProvider selectStatement);

    @Select(value = "{ call selectCumulativeSumByBranch(#{branchId, mode=IN, jdbcType=INTEGER}, #{deadLineDay, mode=IN, jdbcType=INTEGER}) }")
    @Options(statementType = StatementType.CALLABLE)
    @Results(id="CatalogCountResultDirect", value = {
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="catalogCountEnum", property="catalogCountEnum", jdbcType=JdbcType.VARCHAR),
            @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE),
            @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR),
            @Result(column="total", property="cumulativeSum", jdbcType=JdbcType.DOUBLE),
            @Result(column="editable", property="editable", jdbcType=JdbcType.BOOLEAN),
    })
    List<CustomCatalogCount> selectManyDirect(CatalogCountCumulativeSumParams params);

    @Select(value = "{ call selectCumulativeSumByBranchAndPagination(" +
            "#{branchId, mode=IN, jdbcType=INTEGER}, " +
            "#{deadLineDay, mode=IN, jdbcType=INTEGER}, " +
            "#{filterYear, mode=IN, jdbcType=INTEGER}, " +
            "#{filterSearch, mode=IN, jdbcType=VARCHAR}, " +
            "#{page, mode=IN, jdbcType=INTEGER}, " +
            "#{pageSize, mode=IN, jdbcType=INTEGER}) " +
            "}")
    @Options(statementType = StatementType.CALLABLE)
    @Results(id="CatalogCountResultPagination", value = {
            @Result(column="id", property="id", jdbcType= JdbcType.INTEGER, id=true),
            @Result(column="registration", property="registration", jdbcType=JdbcType.TIMESTAMP),
            @Result(column="catalogCountEnum", property="catalogCountEnum", jdbcType=JdbcType.VARCHAR),
            @Result(column="amount", property="amount", jdbcType=JdbcType.DOUBLE),
            @Result(column="details", property="details", jdbcType=JdbcType.VARCHAR),
            @Result(column="total", property="cumulativeSum", jdbcType=JdbcType.DOUBLE),
            @Result(column="editable", property="editable", jdbcType=JdbcType.BOOLEAN)
    })
    List<CustomCatalogCount> selectManyPagination(CatalogCountCumulativeSumParams params);

    @Select(value = "{ call selectCumulativeSumByBranchAndPaginationCount(" +
            "#{branchId, mode=IN, jdbcType=INTEGER}, " +
            "#{filterYear, mode=IN, jdbcType=INTEGER}, " +
            "#{filterSearch, mode=IN, jdbcType=VARCHAR}) " +
            "}")
    @Options(statementType = StatementType.CALLABLE)
    @Results(id="CatalogCountResultPaginationCount", value = {
            @Result(column="totalRows", property="totalRows", jdbcType=JdbcType.DOUBLE),
    })
    long selectManyPaginationCount(CatalogCountCumulativeSumParams params);

}