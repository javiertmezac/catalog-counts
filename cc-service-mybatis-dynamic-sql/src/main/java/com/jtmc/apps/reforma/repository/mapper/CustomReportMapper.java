package com.jtmc.apps.reforma.repository.mapper;

import com.jtmc.apps.reforma.domain.DefaultReportRequest;
import com.jtmc.apps.reforma.domain.SumCatalogCountByCceIdentifier;
import com.jtmc.apps.reforma.domain.SumCatalogCountByFamily;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

@Mapper
public interface CustomReportMapper {

    @Select(value =  "{ call selectDefaultReportIncomesOrExpenses(" +
            "#{isIncome, mode=IN, jdbcType=TINYINT}, #{branchId, mode=IN, jdbcType=INTEGER}, " +
            "#{reportFromMonth, mode=IN, jdbcType=INTEGER}, #{reportFromYear, mode=IN, jdbcType=INTEGER}, " +
            "#{reportToMonth, mode=IN, jdbcType=INTEGER}, #{reportToYear, mode=IN, jdbcType=INTEGER} )}")
    @Options(statementType = StatementType.CALLABLE)
    @Results(value = {
            @Result(column = "family", property = "family", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sumAmount", property = "sumAmount", jdbcType = JdbcType.DECIMAL)
    })
    List<SumCatalogCountByFamily> selectSumCatalogCountByFamily(DefaultReportRequest params);

    @Select(value =  "{ call selectDefaultReportByCceIdentifier(" +
            "#{branchId, mode=IN, jdbcType=INTEGER}, " +
            "#{reportFromMonth, mode=IN, jdbcType=INTEGER}, #{reportFromYear, mode=IN, jdbcType=INTEGER}, " +
            "#{reportToMonth, mode=IN, jdbcType=INTEGER}, #{reportToYear, mode=IN, jdbcType=INTEGER} )}")
    @Options(statementType = StatementType.CALLABLE)
    @Results(value = {
            @Result(column = "identifier", property = "identifier", jdbcType = JdbcType.VARCHAR),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "family", property = "family", jdbcType = JdbcType.VARCHAR),
            @Result(column = "sumAmount", property = "sumAmount", jdbcType = JdbcType.DECIMAL)
    })
    List<SumCatalogCountByCceIdentifier> selectDefaultReportByCceIdentifier(DefaultReportRequest params);
}
