package com.jtmc.apps.reforma.api.v1.report.audit;

import com.jtmc.apps.reforma.domain.Expenses;
import com.jtmc.apps.reforma.domain.Incomes;
import com.jtmc.apps.reforma.domain.Months;
import com.jtmc.apps.reforma.impl.report.audit.AuditReportImpl;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.management.monitor.MonitorSettingException;
import java.util.HashMap;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;
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
    private String expectedPeriodLabel;

    private AuditReportRequest expectedAuditReportRequest;
    private Incomes expectedIncomes;
    private Expenses expectedExpenses;
    private EasyRandom easyRandom = new EasyRandom();
    private double expectedPreviousBalance = easyRandom.nextDouble();

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        expectedTitle = "Informe de Auditoría";

        expectedAuditReportRequest = new AuditReportRequest();
        expectedAuditReportRequest.setFromMonth(expectedFromMonth);
        expectedAuditReportRequest.setToMonth(expectedToMonth);
        expectedAuditReportRequest.setYear(expectedYear);

        expectedPeriodLabel = String.format("%s - %s %s",
                Months.valueOfNumber(expectedFromMonth),
                Months.valueOfNumber(expectedToMonth),
                expectedYear);

        expectedIncomes = new Incomes();
        when(auditReportImpl.getSumIncomes(anyString(), anyString()))
                .thenReturn(expectedIncomes);

        expectedExpenses = new Expenses();
        when(auditReportImpl.getSumExpenses(anyString(), anyString()))
                .thenReturn(expectedExpenses);

        when(auditReportImpl.getPreviousBalance(anyInt(), anyInt()))
                .thenReturn(expectedPreviousBalance);
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
    void testCreateAuditReport_shouldReturn_correctReportPeriod() {
        AuditReportResponse actualResponse =
                auditReportApi.createAuditReport(expectedAuditReportRequest);
        Assertions.assertEquals(expectedPeriodLabel, actualResponse.getPeriod());
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

    @Test
    void testCreateAuditReport_returnsCorrectIncomesSum() {
        double expectedTotal = 1050.0;
        Incomes expectedIncomes = new Incomes();
        expectedIncomes.setDonations(1000);
        expectedIncomes.setOffering(10);
        expectedIncomes.setTithe(40);
        when(auditReportImpl.getSumIncomes(expectedFromDate, expectedToDate))
                .thenReturn(expectedIncomes);
        AuditReportResponse actualResponse =
                auditReportApi.createAuditReport(expectedAuditReportRequest);
        Assertions.assertEquals(expectedTotal,
                actualResponse.getSumIncomes().getSumIncomesTotal());
    }

    @Test
    void testCreateAuditReport_returnsCorrectExpenses() {
        Expenses expectedExpenses = easyRandom.nextObject(Expenses.class);
        double expectedTotal = expectedExpenses.getTotal();

        when(auditReportImpl.getSumExpenses(expectedFromDate, expectedToDate))
                .thenReturn(expectedExpenses);
        AuditReportResponse actualResponse =
                auditReportApi.createAuditReport(expectedAuditReportRequest);

        Assertions.assertNotNull(actualResponse.getSumExpenses());

        SumExpenses expectedSumExpenses = actualResponse.getSumExpenses();
        Assertions.assertEquals(expectedExpenses.getServices(),
                expectedSumExpenses.getServices());
        Assertions.assertEquals(expectedExpenses.getHelps(), expectedSumExpenses.getHelps());
        Assertions.assertEquals(expectedExpenses.getGeneral(),
                expectedSumExpenses.getGeneral());
        Assertions.assertEquals(expectedExpenses.getFood(),
                expectedSumExpenses.getFood());
        Assertions.assertEquals(expectedExpenses.getTraveling(),
                expectedSumExpenses.getTraveling());
        Assertions.assertEquals(expectedExpenses.getStationery(),
                expectedSumExpenses.getStationery());
        Assertions.assertEquals(expectedExpenses.getImmovables(),
                expectedSumExpenses.getImmovables());
        Assertions.assertEquals(expectedTotal,
                expectedSumExpenses.getSumExpensesTotal());
    }

    @Test
    void testCreateAuditReport_callsPreviousBalance() {
        auditReportApi.createAuditReport(expectedAuditReportRequest);
        verify(auditReportImpl).getPreviousBalance(expectedFromMonth, expectedYear);
    }

    @Test
    void testCreateAuditReport_returnsCorrect_previousBalance() {
        double expectedPreviousBalance = new Random().nextDouble();
        when(auditReportImpl.getPreviousBalance(expectedFromMonth, expectedYear))
                .thenReturn(expectedPreviousBalance);
        AuditReportResponse actualResponse =
                auditReportApi.createAuditReport(expectedAuditReportRequest);
        Assertions.assertEquals(expectedPreviousBalance, actualResponse.getPreviousBalance());
    }

    @Test
    void testCreateAuditReport_returnsCorrectTotal() {
        double expectedSumIncomes;
        double expectedSumExpenses;

        Incomes expectedIncomes = easyRandom.nextObject(Incomes.class);
        Expenses expectedExpenses = easyRandom.nextObject(Expenses.class);

        expectedSumIncomes = expectedIncomes.getTotal();
        expectedSumExpenses = expectedExpenses.getTotal();
        double expectedTotal =
                (expectedPreviousBalance + expectedSumIncomes) - expectedSumExpenses;

        when(auditReportImpl.getSumIncomes(expectedFromDate, expectedToDate))
                .thenReturn(expectedIncomes);
        when(auditReportImpl.getSumExpenses(expectedFromDate, expectedToDate))
                .thenReturn(expectedExpenses);
       AuditReportResponse actualResponse =
               auditReportApi.createAuditReport(expectedAuditReportRequest);

       Assertions.assertEquals(expectedTotal, actualResponse.getTotal());
    }

    @Test
    void testCreateAuditReport_shouldCall_AreMonthsValid() {
        auditReportApi.createAuditReport(expectedAuditReportRequest);
        verify(auditReportImpl).areMonthsValid(expectedFromMonth, expectedToMonth);
    }
}