package com.jtmc.apps.reforma.impl.report.audit;

import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.repository.mapper.CustomReportMapper;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AuditReportImplTest {

    private final String TITHES = "tithes";
    private final String DONATIONS = "donations";
    private final String OFFERINGS = "offerings";

    private final String SERVICES = "services";
    private final String HELPS = "helps";
    private final String GENERAL = "general";
    private final String FOOD = "food";
    private final String TRAVELING = "traveling";
    private final String STATIONARY = "stationary";
    private final String IMMOVABLES = "immovables";
    private final String FEES = "fees";

    @InjectMocks
    private AuditReportImpl auditReport;

    @Mock
    private CustomReportMapper auditReportMapper;

    private ReportDateLimitsParams expectedReportDateLimitsParams;
    private DefaultReportRequest expectedDefaultReportRequest;
    private EasyRandom easyRandom;
    int expectedBranchId = 0;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        easyRandom = new EasyRandom();
        expectedBranchId = easyRandom.nextInt();

        expectedReportDateLimitsParams = easyRandom.nextObject(ReportDateLimitsParams.class);

        expectedDefaultReportRequest = easyRandom.nextObject(DefaultReportRequest.class);
        expectedDefaultReportRequest.setBranchId(expectedBranchId);
    }

    @Test
    void testGetSumIncomes_shouldCall_auditReportMapper() {
        auditReport.getSumIncomes(expectedBranchId, expectedReportDateLimitsParams);
        verify(auditReportMapper).selectSumCatalogCountByFamily(any());
    }

    @Test
    void testGetSumIncomes_returns_correctValuesForEachFamily() {
        SumCatalogCountByFamily sumTithe = new SumCatalogCountByFamily();
        sumTithe.setFamily(TITHES);
        sumTithe.setSumAmount(1500);

        SumCatalogCountByFamily donations = new SumCatalogCountByFamily();
        donations.setFamily(DONATIONS);
        donations.setSumAmount(300);

        SumCatalogCountByFamily offering = new SumCatalogCountByFamily();
        offering.setFamily(OFFERINGS);
        offering.setSumAmount(300);

        when(auditReportMapper.selectSumCatalogCountByFamily(any(DefaultReportRequest.class)))
                .thenReturn(Arrays.asList(sumTithe, donations, offering));

        Incomes actualIncomes = auditReport.getSumIncomes(expectedBranchId, expectedReportDateLimitsParams);

        Assertions.assertNotNull(actualIncomes);
        Assertions.assertEquals(sumTithe.getSumAmount(), actualIncomes.getTithe());
        Assertions.assertEquals(donations.getSumAmount(), actualIncomes.getDonations());
        Assertions.assertEquals(offering.getSumAmount(), actualIncomes.getOffering());
    }

    @Test
    void testGetSumIncomes_callsSelectSumCatalogCountByFamily_correctParams() {
        auditReport.getSumIncomes(expectedBranchId, expectedReportDateLimitsParams);

        ArgumentCaptor<DefaultReportRequest> captor = ArgumentCaptor.forClass(DefaultReportRequest.class);
        verify(auditReportMapper).selectSumCatalogCountByFamily(captor.capture());
        Assertions.assertEquals(expectedBranchId, expectedDefaultReportRequest.getBranchId());
        Assertions.assertTrue(captor.getValue().isIncome());
        assertSelectSumCatalogCountByFamilyCapture(captor);
    }

    @Test
    void testGetSumExpenses_callsAuditReportMapper() {
        auditReport.getSumExpenses(expectedBranchId, expectedReportDateLimitsParams);
        verify(auditReportMapper).selectSumCatalogCountByFamily(any());
    }

    @Test
    void testGetSumExpenses_returnsCorrectFamilyValue() {
        List<String> families  = Arrays.asList(SERVICES, HELPS, GENERAL, FOOD, TRAVELING,
                STATIONARY, IMMOVABLES, FEES);

        int indexFamily = new Random().nextInt(families.size());
        String family = families.get(indexFamily);
        double expectedAmount = new Random().nextInt();

        SumCatalogCountByFamily expectedSumByFamily = new SumCatalogCountByFamily();
        expectedSumByFamily.setFamily(family);
        expectedSumByFamily.setSumAmount(expectedAmount);

        when(auditReportMapper.selectSumCatalogCountByFamily(any(DefaultReportRequest.class)))
                .thenReturn(Arrays.asList(expectedSumByFamily));

        Expenses actualExpenses = auditReport.getSumExpenses(expectedBranchId, expectedReportDateLimitsParams);

        Assertions.assertNotNull(actualExpenses);
        Assertions.assertEquals(expectedAmount, getCorrectFamilyExpense(family, actualExpenses));
        assertNotAssignedAmountForOtherFamilies(family, families, actualExpenses);
    }

    @Test
    void testGetSumExpenses_callSelectSumCatalogCountByFamily_correctParams() {
        auditReport.getSumExpenses(expectedBranchId, expectedReportDateLimitsParams);

        ArgumentCaptor<DefaultReportRequest> captor = ArgumentCaptor.forClass(DefaultReportRequest.class);
        verify(auditReportMapper).selectSumCatalogCountByFamily(captor.capture());
        Assertions.assertEquals(expectedBranchId, expectedDefaultReportRequest.getBranchId());
        Assertions.assertFalse(captor.getValue().isIncome());
        assertSelectSumCatalogCountByFamilyCapture(captor);
    }

    private void assertSelectSumCatalogCountByFamilyCapture(ArgumentCaptor<DefaultReportRequest> captor) {
        Assertions.assertEquals(expectedReportDateLimitsParams.getFromMonth(),
                captor.getValue().getReportFromMonth());
        Assertions.assertEquals(expectedReportDateLimitsParams.getFromYear(),
                captor.getValue().getReportFromYear());
        Assertions.assertEquals(expectedReportDateLimitsParams.getToMonth(),
                captor.getValue().getReportToMonth());
        Assertions.assertEquals(expectedReportDateLimitsParams.getToYear(),
                captor.getValue().getReportToYear());
    }

    private void assertNotAssignedAmountForOtherFamilies(String selectedFamily, List<String> families,
                                                         Expenses expenses) {
        families.stream().forEach(c -> {
            if(!c.equals(selectedFamily)) {
                Assertions.assertEquals(0.0, getCorrectFamilyExpense(c, expenses));
            }
        });
    }

    private double getCorrectFamilyExpense(String family, Expenses expenses) {
        double actualAmount = 0.0;
        switch (family) {
            case SERVICES:
                actualAmount = expenses.getServices();
                break;
            case HELPS:
                actualAmount = expenses.getHelps();
                break;
            case GENERAL:
                actualAmount = expenses.getGeneral();
                break;
            case FOOD:
                actualAmount = expenses.getFood();
                break;
            case TRAVELING:
                actualAmount = expenses.getTraveling();
                break;
            case STATIONARY:
                actualAmount = expenses.getStationery();
                break;
            case IMMOVABLES:
                actualAmount = expenses.getImmovables();
                break;
            case FEES:
                actualAmount = expenses.getFees();
                break;
        }
        return actualAmount;
    }
}