package com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface AuditReportMapper {

    @SelectProvider(
           type = AuditReportMapperProvider.class,
           method = "getSumCatalogCountSameFamily"
    )
    void selectSumCatalogCountAmountFromFamily(@Param("dateFrom") String dateFrom,
                                               @Param("dateTo") String dateTo,
                                               @Param("cceIds") String cceIds);

    @SelectProvider(
            type = AuditReportMapperProvider.class,
            method = "selectCatalogCountEnumFamily"
    )
    List<String> selectCatalogCountEnumFamily(@Param("cceFamily") String cceFamily);
}
