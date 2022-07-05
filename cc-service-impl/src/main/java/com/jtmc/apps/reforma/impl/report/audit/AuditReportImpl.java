package com.jtmc.apps.reforma.impl.report.audit;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Expenses;
import com.jtmc.apps.reforma.domain.Incomes;
import com.jtmc.apps.reforma.domain.MonthlyTotal;
import com.jtmc.apps.reforma.domain.SumCatalogCountByFamily;
import com.jtmc.apps.reforma.impl.exception.MonthlyTotalNotFoundException;
import com.jtmc.apps.reforma.repository.ReportRepository;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport.AuditReportMapper;
import org.apache.commons.lang3.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

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
    public Incomes getSumIncomes(int branchId, Instant fromDate, Instant toDate) {
        validateDates(fromDate, toDate);
        Incomes incomes = new Incomes();

        List<SumCatalogCountByFamily> sumCatalogCountByFamily =
                auditReportMapper.selectSumCatalogCountIncomes(branchId, fromDate.toString(), toDate.toString());
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

    public Expenses getSumExpenses(int branchId, Instant fromDate, Instant toDate) {
        validateDates(fromDate, toDate);
        Expenses expenses = new Expenses();

        List<SumCatalogCountByFamily> sumCatalogCountByFamilies =
                auditReportMapper.selectSumCatalogCountExpenses(branchId, fromDate.toString(), toDate.toString());

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

    private void validateDates(Instant fromDate, Instant toDate) {
        checkNotNull(fromDate, "fromDate cannot be null");
        checkNotNull(toDate, "toDate cannot be null");
        checkArgument(fromDate.isBefore(toDate), "FromMonth cannot be greater than ToMonth");
    }
}