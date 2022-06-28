package com.jtmc.apps.reforma.impl.report.audit;

import com.jtmc.apps.reforma.domain.Expenses;
import com.jtmc.apps.reforma.domain.Incomes;
import com.jtmc.apps.reforma.domain.MonthlyTotal;
import com.jtmc.apps.reforma.domain.SumCatalogCountByFamily;
import com.jtmc.apps.reforma.impl.exception.MonthlyTotalNotFoundException;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport.AuditReportMapper;
import org.apache.ibatis.jdbc.Null;
import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
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

    private Instant fromDate;
    private Instant toDate;
    int expectedMonth = 1;
    int expectedYear = 2021;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        fromDate = Instant.now();
        toDate = Instant.from(fromDate.plus(10, ChronoUnit.DAYS));
    }

    @Test
    void testGetSumIncomes_shouldCall_auditReportMapper() {
        auditReport.getSumIncomes(fromDate, toDate);
        verify(auditReportMapper).selectSumCatalogCountIncomes(anyString(), anyString());
    }

    @Test
    void testGetSumIncomes_shouldThrowNullPointerException_whenDateFromNull() {
        Assertions.assertThrows(NullPointerException.class, () ->
                auditReport.getSumIncomes(null, toDate));
    }

    @Test
    void testGetSumIncomes_shouldThrowNullPointerException_whenDateToNull() {
        Assertions.assertThrows(NullPointerException.class, () ->
                auditReport.getSumIncomes(fromDate, null));
    }

    @Test
    void testGetSumIncomes_shouldValidate_toDateIsGreater_thanFromDate() {
        IllegalArgumentException actualException =
                Assertions.assertThrows(IllegalArgumentException.class, () ->
                        auditReport.getSumIncomes(fromDate, Instant.MIN));

        String expectedMessage = String.format("FromMonth cannot be greater than ToMonth");
        Assertions.assertEquals(expectedMessage, actualException.getMessage());
    }

    @Test
    void testValidateDateRange_returnsIllegalArgument_whenNoFromDateFormat() {
        NullPointerException nullPointerException = Assertions.assertThrows(NullPointerException.class, () ->
                auditReport.getSumExpenses(null, Instant.MAX));
        Assertions.assertTrue(nullPointerException.getMessage().contains("fromDate cannot be null"));
    }

    @Test
    void testValidateDateRange_returnsIllegalArgument_whenNoToDateFormat() {
        NullPointerException nullPointerException = Assertions.assertThrows(NullPointerException.class, () ->
                auditReport.getSumExpenses(Instant.MIN, null));
        Assertions.assertTrue(nullPointerException.getMessage().contains("toDate cannot be null"));
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

        when(auditReportMapper.selectSumCatalogCountIncomes(fromDate.toString(), toDate.toString()))
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

       when(auditReportMapper.selectSumCatalogCountExpenses(fromDate.toString(), toDate.toString()))
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
}