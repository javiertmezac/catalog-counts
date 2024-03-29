package com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport;

import com.jtmc.apps.reforma.domain.SumCatalogCountByFamily;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface AuditReportMapper {

    @SelectProvider(
           type = AuditReportMapperProvider.class,
           method = "getSumCatalogCountIncomes"
    )
    List<SumCatalogCountByFamily> selectSumCatalogCountIncomes(@Param("branchId")int branchId,
                                                               @Param("dateFrom") String dateFrom,
                                                               @Param("dateTo") String dateTo);

    @SelectProvider(
            type = AuditReportMapperProvider.class,
            method = "getSumCatalogCountExpenses"
    )
    List<SumCatalogCountByFamily> selectSumCatalogCountExpenses(@Param("branchId")int branchId,
                                                                @Param("dateFrom") String dateFrom,
                                                                @Param("dateTo") String dateTo);

}
