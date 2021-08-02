package com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport;

import org.apache.ibatis.jdbc.SQL;

public class AuditReportMapperProvider {

    private String ccTable = "catalog_count";
    private String cceTable = "catalog_count_enum";

    public String getSumCatalogCountSameFamily() {
        return new SQL()
                .SELECT("catalogCountEnumId, sum(amount)")
                .FROM(ccTable)
                .WHERE("registrationDate >= date(#{dateFrom} and registrationDate < date(#{dateTo}")
                .AND()
                .WHERE("catalogCountEnumId in (#{cceIds})")
                .GROUP_BY("catalogCountEnumId")
                .toString();
    }

    public String selectCatalogCountEnumFamily() {
        return new SQL()
                .SELECT("id")
                .FROM(cceTable)
                .WHERE("identifier like ('#{cceFamily}%'")
                .toString();
    }
}
