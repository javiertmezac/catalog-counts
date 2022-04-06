package com.jtmc.apps.reforma.impl.report.audit;

import com.jtmc.apps.reforma.domain.Expenses;
import com.jtmc.apps.reforma.domain.Incomes;
import com.jtmc.apps.reforma.domain.MonthlyTotal;
import com.jtmc.apps.reforma.domain.SumCatalogCountByFamily;
import com.jtmc.apps.reforma.impl.exception.MonthlyTotalNotFoundException;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport.AuditReportMapper;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

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
    private AuditReportMapper auditReportMapper;

    private String fromDate;
    private String toDate;
    int expectedMonth = 1;
    int expectedYear = 2021;

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
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                auditReport.getSumIncomes(null, toDate));
    }

    @Test
    void testGetSumIncomes_shouldThrowIllegalException_whenDateToNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () ->
                auditReport.getSumIncomes(fromDate, null));
    }

    @Test
    void testGetSumIncomes_shouldValidate_toDateIsGreater_thanFromDate() {
        IllegalArgumentException actualException =
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        auditReport.getSumIncomes(toDate, fromDate));

        String expectedMessage = String.format("FromMonth cannot be greater than ToMonth");
        Assertions.assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    void testValidateDateRange_returnsIllegalArgument_whenNoDateFormat() {
        IllegalArgumentException illegalArgumentException = Assertions.assertThrows(IllegalArgumentException.class, () ->
                auditReport.getSumExpenses("something", "blah"));
        Assertions.assertTrue(illegalArgumentException.getMessage().contains("Unparseable date:"));
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

        when(auditReportMapper.selectSumCatalogCountIncomes(fromDate, toDate))
                .thenReturn(Arrays.asList(sumTithe, donations, offering));

        Incomes actualIncomes = auditReport.getSumIncomes(fromDate, toDate);

        Assertions.assertNotNull(actualIncomes);
        Assertions.assertEquals(sumTithe.getSumAmount(), actualIncomes.getTithe());
        Assertions.assertEquals(donations.getSumAmount(), actualIncomes.getDonations());
        Assertions.assertEquals(offering.getSumAmount(), actualIncomes.getOffering());
    }

    @Test
    void testGetSumExpenses_callsAuditReportMapper() {
        auditReport.getSumExpenses(fromDate, toDate);
        verify(auditReportMapper).selectSumCatalogCountExpenses(anyString(), anyString());
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

       when(auditReportMapper.selectSumCatalogCountExpenses(fromDate, toDate))
               .thenReturn(Arrays.asList(expectedSumByFamily));

       Expenses actualExpenses = auditReport.getSumExpenses(fromDate, toDate);

       Assertions.assertNotNull(actualExpenses);
       Assertions.assertEquals(expectedAmount, getCorrectFamilyExpense(family, actualExpenses));
       assertNotAssignedAmountForOtherFamilies(family, families, actualExpenses);
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

    @Test
    void testGetPreviousBalance_returnsIllegalArgument_whenNoValid_fromMonth() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> auditReport.getPreviousBalance(0, 2021));
    }

    @Test
    void testGetPreviousBalance_returnsIllegalArgument_whenNoValid_fromMonth_greaterDec() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> auditReport.getPreviousBalance(13, 2021));
    }

    @Test
    void testGetPreviousBalance_shouldCall_auditMapper() {
        when(auditReportMapper.getPreviousBalanceFromMonthAndYear(anyInt(), anyInt()))
                .thenReturn(new MonthlyTotal());
        auditReport.getPreviousBalance(expectedMonth, expectedYear);
        verify(auditReportMapper).getPreviousBalanceFromMonthAndYear(expectedMonth, expectedYear);
    }

    @Test
    void testGetPreviousBalance_throwsException_fromAuditMapper() {
        doThrow(RuntimeException.class)
                .when(auditReportMapper)
                .getPreviousBalanceFromMonthAndYear(expectedMonth, expectedYear);
        Assertions.assertThrows(RuntimeException.class, () ->
                auditReport.getPreviousBalance(expectedMonth, expectedYear));
    }

    @Test
    void testGetPreviousBalance_throwsException_whenMonthlyTotal_Null() {
        when(auditReportMapper.getPreviousBalanceFromMonthAndYear(expectedMonth, expectedYear))
                .thenReturn(null);
        MonthlyTotalNotFoundException actualException =
                Assertions.assertThrows(MonthlyTotalNotFoundException.class, () ->
                        auditReport.getPreviousBalance(expectedMonth, expectedYear));
        String expectedErrorMessage =
                String.format("MonthlyTotal - PreviousBalance not found for month %s and Year %s",
                        expectedMonth, expectedYear);
        Assertions.assertEquals(expectedErrorMessage,
                actualException.getMessage());
        Assertions.assertEquals(404, actualException.getStatusCode());
    }

    @Test
    void testGetPreviousBalance_returnsCorrectValue() {
        EasyRandom easyRandom = new EasyRandom();
        MonthlyTotal expectedMonthlyTotal = easyRandom.nextObject(MonthlyTotal.class);
        when(auditReportMapper.getPreviousBalanceFromMonthAndYear(expectedMonth, expectedYear))
                .thenReturn(expectedMonthlyTotal);

        double actualResult = auditReport.getPreviousBalance(expectedMonth, expectedYear);
        Assertions.assertEquals(expectedMonthlyTotal.getTotal(), actualResult);
    }

    @Test
    void testAreMonthsValid_throwsIllegalException_whenFromMonth_notValid() {
        int notValidFromMonth = 13;

        //checkArgument is static, easiest way to test is through real class
        AuditReportImpl realImpl = new AuditReportImpl();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            realImpl.areMonthsValid(notValidFromMonth, expectedMonth);
        });
    }

    @Test
    void testAreMonthsValid_throwsIllegalException_whenToMonth_notValid() {
        int notValidToMonth = 13;

        //checkArgument is static, easiest way to test is through real class
        AuditReportImpl realImpl = new AuditReportImpl();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            realImpl.areMonthsValid(expectedMonth, notValidToMonth);
        });
    }
}