package com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport;

import org.apache.ibatis.jdbc.SQL;

public class AuditReportMapperProvider {

    private final String ccTable = "catalog_count";
    private final Integer TITHE = 1;
    private final Integer DONATIONS = 2;
    private final Integer OFFERING = 3;

    private final String whereCatalogCountEnum =
            String.format("(%s, %s, %s)", TITHE, DONATIONS, OFFERING);

    //todo: for now incomes ids are hardcoded
    public String getSumCatalogCountIncomes() {
        return new SQL()
                .SELECT("cce.family, sum(cc.amount) as sumAmount")
                .FROM(ccTable + " as cc")
                .INNER_JOIN("catalog_count_enum as cce on cc.catalogCountEnumId = cce.id")
                .WHERE("registration >= #{dateFrom} and registration < #{dateTo}")
                .AND()
                .WHERE(String.format("catalogCountEnumId in %s", whereCatalogCountEnum))
                .AND()
                .WHERE("cc.branchId = #{branchId}")
                .AND()
                .WHERE("cc.isDeleted = false")
                .GROUP_BY("cce.family")
                .toString();
    }

    public String getSumCatalogCountExpenses() {
        return new SQL()
                .SELECT("cce.family, sum(cc.amount) as sumAmount")
                .FROM(ccTable + " as cc")
                .INNER_JOIN("catalog_count_enum as cce on cc.catalogCountEnumId = cce.id")
                .WHERE("registration >= #{dateFrom} and registration < #{dateTo}")
                .AND()
                .WHERE(String.format("catalogCountEnumId not in %s", whereCatalogCountEnum))
                .AND()
                .WHERE("cc.branchId = #{branchId}")
                .AND()
                .WHERE("cc.isDeleted = false")
                .GROUP_BY("cce.family")
                .toString();
    }
}
