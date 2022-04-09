package com.jtmc.apps.reforma.repository.mapper;

import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.CustomCatalogCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
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
}
