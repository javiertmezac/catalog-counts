package com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;

class AuditReportMapperProviderTest {
    private AuditReportMapperProvider provider;

    @BeforeEach
    void setUp() {
        provider = new AuditReportMapperProvider();
    }

    @Test
    void getSumCatalogCountIncomes() {
        String expectedSumIncomesQuery = "SELECT cce.family, sum(cc.amount) as sumAmount\n" +
                "FROM catalog_count as cc\n" +
                "INNER JOIN catalog_count_enum as cce on cc.catalogCountEnumId = cce.id\n" +
                "WHERE (registration >= #{dateFrom} and registration < #{dateTo}) \n" +
                "AND (catalogCountEnumId in (1, 2, 3)) \n" +
                "AND (cc.isDeleted = false)\n" +
                "GROUP BY cce.family";
        Assertions.assertEquals(expectedSumIncomesQuery, provider.getSumCatalogCountIncomes());
    }

    @Test
    void getSumCatalogCountExpenses() {
        String expectedSumIncomesQuery = "SELECT cce.family, sum(cc.amount) as sumAmount\n" +
                "FROM catalog_count as cc\n" +
                "INNER JOIN catalog_count_enum as cce on cc.catalogCountEnumId = cce.id\n" +
                "WHERE (registration >= #{dateFrom} and registration < #{dateTo}) \n" +
                "AND (catalogCountEnumId not in (1, 2, 3)) \n" +
                "AND (cc.isDeleted = false)\n" +
                "GROUP BY cce.family";
        Assertions.assertEquals(expectedSumIncomesQuery, provider.getSumCatalogCountExpenses());
    }

    @Test
    void testGetPreviousBalance_sqlStatement() {
        String expectedPreviousBalanceQuery = "SELECT *\n" +
                "FROM monthly_total\n" +
                "WHERE (MONTH(registrationDate) = #{month}) \n" +
                "AND (YEAR(registrationDate) = #{year})\n" +
                "ORDER BY registrationDate ASC LIMIT 1";

        Assertions.assertEquals(expectedPreviousBalanceQuery, provider.getPreviousBalance());
    }
}