package com.jtmc.apps.reforma.impl.report.audit;

import com.jtmc.apps.reforma.domain.Incomes;
import com.jtmc.apps.reforma.domain.SumCatalogCountByFamily;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport.AuditReportMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.catalogcountenum.CatalogCountEnumMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuditReportImplTest {

    private final String TITHES = "tithes";
    private final String DONATIONS = "donations";
    private final String OFFERINGS = "offerings";

    @InjectMocks
    private AuditReportImpl auditReport;

    @Mock
    private AuditReportMapper auditReportMapper;

    @Mock
    private CatalogCountEnumMapper catalogCountEnumMapper;

    private String fromDate;
    private String toDate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        fromDate = "2021-06-01";
        toDate = "2021-07-01";
    }

    @Test
    void testGetSumIncomes_shouldCall_auditReportMapper() {
        auditReport.getSumIncomes(fromDate, toDate);
        verify(auditReportMapper).selectSumCatalogCountIncomes(anyString(), anyString());
    }

    @Test
    void testGetSumIncomes_shouldThrowIllegalException_whenDateFromNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> auditReport.getSumIncomes(null, toDate));
    }

    @Test
    void testGetSumIncomes_shouldThrowIllegalException_whenDateToNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> auditReport.getSumIncomes(fromDate, null));
    }

    @Test
    void testGetSumIncomes_shouldValidate_toDateIsGreater_thanFromDate() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> auditReport.getSumIncomes(toDate, fromDate));
    }

    @Test
    void testGetSumIncomes() {
        SumCatalogCountByFamily sumTithe = new SumCatalogCountByFamily();
        sumTithe.setFamily(TITHES);
        sumTithe.setSumAmount(1500);

        SumCatalogCountByFamily donations = new SumCatalogCountByFamily();
        donations.setFamily(DONATIONS);
        donations.setSumAmount(300);

        SumCatalogCountByFamily offering = new SumCatalogCountByFamily();
        offering.setFamily(OFFERINGS);
        offering.setSumAmount(300);

        when(auditReportMapper.selectSumCatalogCountIncomes(fromDate, toDate))
                .thenReturn(Arrays.asList(sumTithe, donations, offering));

        Incomes actualIncomes = auditReport.getSumIncomes(fromDate, toDate);

        Assertions.assertNotNull(actualIncomes);
        Assertions.assertEquals(sumTithe.getSumAmount(), actualIncomes.getTithe());
        Assertions.assertEquals(donations.getSumAmount(), actualIncomes.getDonations());
        Assertions.assertEquals(offering.getSumAmount(), actualIncomes.getOffering());
    }
}