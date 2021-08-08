package com.jtmc.apps.reforma.api.v1.report.audit;

import com.jtmc.apps.reforma.domain.Expenses;
import com.jtmc.apps.reforma.domain.Incomes;
import com.jtmc.apps.reforma.impl.report.audit.AuditReportImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuditReportApiImplTest {

    @InjectMocks
    private AuditReportApiImpl auditReportApi;

    @Mock
    private AuditReportImpl auditReportImpl;

    private String expectedTitle;

    private int expectedFromMonth = 6;
    private int expectedToMonth = 10;
    private int expectedYear = 2021;
    private String expectedFromDate =  "2021-6-01";
    private String expectedToDate = "2021-11-01";

    private AuditReportRequest expectedAuditReportRequest;
    private Incomes expectedIncomes;
    private Expenses expectedExpenses;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        expectedTitle = "Informe de Auditoría";

        expectedAuditReportRequest = new AuditReportRequest();
        expectedAuditReportRequest.setFromMonth(expectedFromMonth);
        expectedAuditReportRequest.setToMonth(expectedToMonth);
        expectedAuditReportRequest.setYear(expectedYear);

        expectedIncomes = new Incomes();
        when(auditReportImpl.getSumIncomes(anyString(), anyString()))
                .thenReturn(expectedIncomes);

        expectedExpenses = new Expenses();
        when(auditReportImpl.getSumExpenses(anyString(), anyString()))
                .thenReturn(expectedExpenses);
    }

    @Test
    void testCreateAuditReport_returnAuditReportResponseObject() {
        AuditReportResponse actualResponse = auditReportApi
                .createAuditReport(new AuditReportRequest());

        Assertions.assertNotNull(actualResponse);
    }

    @Test
    void testCreateAuditReport_verifiesInformationDate_isSet() {
        AuditReportResponse actualResponse = auditReportApi
                .createAuditReport(new AuditReportRequest());

        Assertions.assertEquals(expectedTitle, actualResponse.getTitle());
        Assertions.assertTrue(StringUtils.isNotBlank(actualResponse.getPeriod()));
        Assertions.assertTrue(StringUtils.isNotBlank(actualResponse.getMision()));

        Assertions.assertTrue(StringUtils.isNotBlank(actualResponse.getTreasurer()));
    }

    @Test
    void testCreateAuditReport_callsAuditReportImpl_forIncomesAndExpenses() {
        auditReportApi.createAuditReport(new AuditReportRequest());
        verify(auditReportImpl).getSumIncomes(anyString(), anyString());
        verify(auditReportImpl).getSumExpenses(anyString(), anyString());
    }

    @Test
    void testCreateAuditReport_callsAuditReportImpl_withCorrectDates() {
        auditReportApi.createAuditReport(expectedAuditReportRequest);
        verify(auditReportImpl).getSumIncomes(expectedFromDate, expectedToDate);
    }

    @Test
    void testCreateAuditReport_callsAuditReportImpl_withCorrectDates_whenDec() {
        int december = 12;
        int year = expectedYear + 1;
        String toDate = String.format("%s-%s-%s", year, "01", "01");

        expectedAuditReportRequest.setToMonth(december);
        auditReportApi.createAuditReport(expectedAuditReportRequest);
        verify(auditReportImpl).getSumIncomes(expectedFromDate, toDate);
        verify(auditReportImpl).getSumExpenses(expectedFromDate, toDate);
    }
}