package com.jtmc.apps.reforma.impl.report.audit;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Expenses;
import com.jtmc.apps.reforma.domain.Incomes;
import com.jtmc.apps.reforma.domain.MonthlyTotal;
import com.jtmc.apps.reforma.domain.SumCatalogCountByFamily;
import com.jtmc.apps.reforma.impl.exception.MonthlyTotalNotFoundException;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport.AuditReportMapper;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;

public class AuditReportImpl {

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

    @Inject
    private AuditReportMapper auditReportMapper;

    //todo: consider UTC time for from and to Dates!
    public Incomes getSumIncomes(String fromDate, String toDate) {
        dateValidations(fromDate, toDate);

        Incomes incomes = new Incomes();

        List<SumCatalogCountByFamily> sumCatalogCountByFamily =
                auditReportMapper.selectSumCatalogCountIncomes(fromDate, toDate);
        sumCatalogCountByFamily.stream().forEach( c -> {
            switch (c.getFamily()) {
                case TITHES:
                    incomes.setTithe(c.getSumAmount());
                    break;
                case DONATIONS:
                    incomes.setDonations(c.getSumAmount());
                    break;
                case OFFERINGS:
                    incomes.setOffering(c.getSumAmount());
                    break;
            }
        });

        return incomes;
    }

    public Expenses getSumExpenses(String fromDate, String toDate) {
        dateValidations(fromDate, toDate);
        Expenses expenses = new Expenses();

        List<SumCatalogCountByFamily> sumCatalogCountByFamilies =
                auditReportMapper.selectSumCatalogCountExpenses(fromDate, toDate);

        sumCatalogCountByFamilies.stream().forEach(c -> {
            switch (c.getFamily()) {
                case SERVICES:
                    expenses.setServices(c.getSumAmount());
                    break;
                case HELPS:
                     expenses.setHelps(c.getSumAmount());
                    break;
                case GENERAL:
                    expenses.setGeneral(c.getSumAmount());
                    break;
                case FOOD:
                    expenses.setFood(c.getSumAmount());
                    break;
                case TRAVELING:
                    expenses.setTraveling(c.getSumAmount());
                    break;
                case STATIONARY:
                    expenses.setStationery(c.getSumAmount());
                    break;
                case IMMOVABLES:
                    expenses.setImmovables(c.getSumAmount());
                    break;
                case FEES:
                    expenses.setFees(c.getSumAmount());
                    break;
            }
        });
        return expenses;
    }

    private boolean validateDateRange(String fromDate, String toDate) {
         try {
            Date from = new SimpleDateFormat("yyyy-MM-dd").parse(fromDate);
            Date to = new SimpleDateFormat("yyyy-MM-dd").parse(toDate);

            return from.before(to);

        } catch (ParseException ex) {
           throw new IllegalArgumentException(ex.getMessage());
        }
    }

    private void dateValidations(String fromDate, String toDate) {
        checkArgument(StringUtils.isNotBlank(fromDate));
        checkArgument(StringUtils.isNotBlank(toDate));

        String errorMessage = "FromMonth cannot be greater than ToMonth";
        checkArgument(validateDateRange(fromDate, toDate), errorMessage);
    }

    public void areMonthsValid(int fromMonth, int toMonth) {
        checkArgument(fromMonth >= 1 && fromMonth <= 12 ,
                "fromMonth not valid");

        checkArgument(toMonth >= 1 && toMonth <= 12 ,
                "toMonth not valid");
    }

    public double getPreviousBalance(int fromMonth, int year) {
        checkArgument(fromMonth >= 1 && fromMonth <= 12 ,
                "fromMonth not valid");
        MonthlyTotal monthlyTotal =
                auditReportMapper.getPreviousBalanceFromMonthAndYear(fromMonth, year);
        if(monthlyTotal == null) {
            String errorMessage =
                    String.format(
                            "MonthlyTotal - PreviousBalance not found for month %s and Year %s",
                            fromMonth, year
                    );
            throw new MonthlyTotalNotFoundException(errorMessage, 404);
        }
        return monthlyTotal.getTotal();
    }
}