package com.jtmc.apps.reforma.impl.report.audit;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.repository.mapper.CustomReportMapper;

import java.util.List;

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
    private CustomReportMapper auditReportMapper;

    public Incomes getSumIncomes(int branchId, ReportDateLimitsParams dateLimitsParams) {
        Incomes incomes = new Incomes();

        boolean isIncome = true;
        DefaultReportRequest request = buildDefaultReportParams(branchId, isIncome, dateLimitsParams);
        List<SumCatalogCountByFamily> sumCatalogCountByFamily =
                auditReportMapper.selectSumCatalogCountByFamily(request);

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

    private DefaultReportRequest buildDefaultReportParams(int branchId, boolean isIncome, ReportDateLimitsParams params) {
        DefaultReportRequest request = new DefaultReportRequest();
        request.setBranchId(branchId);
        request.setIncome(isIncome);
        request.setReportFromMonth(params.getFromMonth());
        request.setReportFromYear(params.getFromYear());
        request.setReportToMonth(params.getToMonth());
        request.setReportToYear(params.getToYear());
        return request;
    }

    public Expenses getSumExpenses(int branchId, ReportDateLimitsParams dateLimitsParams) {
        Expenses expenses = new Expenses();

        boolean isIncome = false;
        DefaultReportRequest request = buildDefaultReportParams(branchId, isIncome, dateLimitsParams);

        List<SumCatalogCountByFamily> sumCatalogCountByFamilies =
                auditReportMapper.selectSumCatalogCountByFamily(request);

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

    public List<SumCatalogCountByCceIdentifier> getSumExpensesByIdentifier(int branchId, ReportDateLimitsParams dateLimitsParams) {
        DefaultReportRequest request = buildDefaultReportParams(branchId, false, dateLimitsParams);
        return auditReportMapper.selectDefaultReportByCceIdentifier(request);
    }
}