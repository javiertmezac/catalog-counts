package com.jtmc.apps.reforma.repository.mapper;

import com.jtmc.apps.reforma.domain.DefaultReportRequest;
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

}
