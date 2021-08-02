package com.jtmc.apps.reforma.impl.report.audit;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport.AuditReportMapper;

import java.util.List;

public class AuditReportImpl {

    @Inject
    private AuditReportMapper auditReportMapper;

    public void selectSumIncomes() {

        String dateFrom = "2021-06-01";
        String dateTo = "2021-07-01";
        String cceFamily = "3.";
        List<String> cceIds = auditReportMapper.selectCatalogCountEnumFamily(cceFamily);
        auditReportMapper.selectSumCatalogCountAmountFromFamily(dateFrom, dateTo,
                String.join(",", cceIds));
    }
}