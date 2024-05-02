package com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport;

import com.jtmc.apps.reforma.domain.DefaultReportRequest;
import com.jtmc.apps.reforma.domain.SumCatalogCountByFamily;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.StatementType;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface AuditReportMapper {

    @SelectProvider(
           type = AuditReportMapperProvider.class,
           method = "getSumCatalogCountIncomes"
    )
    List<SumCatalogCountByFamily> selectSumCatalogCountIncomes(@Param("branchId")int branchId,
                                                               @Param("dateFrom") String dateFrom,
                                                               @Param("dateTo") String dateTo);


    @Select(value = "{ call selectDefaultReportIncomesOrExpenses(" +
            "#{branchId, mode=IN, jdbcType=INTEGER}, #{isIncome, mode=IN, jdbcType=BOOLEAN}, " +
            "#{reportMonth, mode=IN, jdbcType=INTEGER}, #{reportYear, mode=IN, jdbcType=INTEGER} ) }")
    @Options(statementType = StatementType.CALLABLE)
    @Results(id="SumCatalogCountByFamily", value = {
            @Result(column="family", property="family", jdbcType= JdbcType.VARCHAR),
            @Result(column="sumAmount", property="sumAmount", jdbcType=JdbcType.DECIMAL),
    })
    List<SumCatalogCountByFamily> selectSumCatalogCountByFamily(DefaultReportRequest request);

    @SelectProvider(
            type = AuditReportMapperProvider.class,
            method = "getSumCatalogCountExpenses"
    )
    List<SumCatalogCountByFamily> selectSumCatalogCountExpenses(@Param("branchId")int branchId,
                                                                @Param("dateFrom") String dateFrom,
                                                                @Param("dateTo") String dateTo);

}
