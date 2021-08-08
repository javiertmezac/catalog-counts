package com.jtmc.apps.reforma.api.v1.report.audit;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Expenses;
import com.jtmc.apps.reforma.domain.Incomes;
import com.jtmc.apps.reforma.impl.report.audit.AuditReportImpl;

public class AuditReportApiImpl implements AuditReportApi {

    @Inject
    private AuditReportImpl auditReport;

    @Override
    public AuditReportResponse createAuditReport(AuditReportRequest auditReportRequest) {
        AuditReportResponse response = new AuditReportResponse();
        response.setTitle("Informe de Auditoría");
        response.setMision("Reforma");
        response.setPeriod("Ene - May 2021");

        //todo: get previous Balance from DB
        response.setPreviousBalance(0.0);

        String fromDate = buildFromDate(auditReportRequest.getFromMonth(),
                auditReportRequest.getYear());
        String toDate = buildToDate(auditReportRequest.getToMonth(),
                auditReportRequest.getYear());

       Incomes incomes = auditReport.getSumIncomes(fromDate, toDate);

        SumIncomes sumIncomes = new SumIncomes();
        sumIncomes.setDonations(incomes.getDonations());
        sumIncomes.setTithe(incomes.getTithe());
        sumIncomes.setOffering(incomes.getOffering());
        sumIncomes.setSumIncomesTotal(incomes.getTotal());

        response.setSumIncomes(sumIncomes);

        Expenses expenses = auditReport.getSumExpenses(fromDate, toDate);
        SumExpenses sumExpenses = new SumExpenses();
        sumExpenses.setServices(expenses.getServices());
        sumExpenses.setHelps(expenses.getHelps());
        sumExpenses.setGeneral(expenses.getGeneral());
        sumExpenses.setFood(expenses.getFood());
        sumExpenses.setTraveling(expenses.getTraveling());
        sumExpenses.setStationery(expenses.getStationery());
        sumExpenses.setFees(expenses.getFees());
        sumExpenses.setSumExpensesTotal(expenses.getTotal());

        response.setSumExpenses(sumExpenses);

        response.setUncheckedExpenses(0.0);
        response.setLoans(0.0);

        response.setComments("This is an audit report");
        response.setAuditor("Ulises Cardenas");
        response.setTreasurer("Javier Trinidad Meza Cazarez");
        response.setSecretary("Mirna Mendoza");
        return response;
    }

    private String buildToDate(int toMonth, int year) {

        final int december = 12;
        final String day = "01";
        String month = String.valueOf(toMonth + 1);

        if(toMonth == december) {
            year = year + 1;
            month = "01";
        }
        return  String.format("%s-%s-%s",
                year, month, day);
    }

    private String buildFromDate(int fromMonth, int year) {
        return String.format("%s-%s-%s",
                year, fromMonth, "01");
    }
}
