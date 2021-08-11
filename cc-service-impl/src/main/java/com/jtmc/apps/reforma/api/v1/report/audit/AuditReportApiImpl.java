package com.jtmc.apps.reforma.api.v1.report.audit;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Expenses;
import com.jtmc.apps.reforma.domain.Incomes;
import com.jtmc.apps.reforma.domain.Months;
import com.jtmc.apps.reforma.impl.report.audit.AuditReportImpl;

public class AuditReportApiImpl implements AuditReportApi {

    @Inject
    private AuditReportImpl auditReport;

    @Override
    public AuditReportResponse createAuditReport(AuditReportRequest auditReportRequest) {
        AuditReportResponse response = new AuditReportResponse();
        response.setTitle("Informe de Auditoría");
        //todo: this should change once "Misions / services is added into system"
        response.setMision("Reforma");

        auditReport.areMonthsValid(
                auditReportRequest.getFromMonth(), auditReportRequest.getToMonth());

        String period = buildReportPeriod(
                auditReportRequest.getFromMonth(),
                auditReportRequest.getToMonth(),
                auditReportRequest.getYear()
        );
        response.setPeriod(period);

        double previousBalance = auditReport.getPreviousBalance(
                auditReportRequest.getFromMonth(),
                auditReportRequest.getYear()
        );
        response.setPreviousBalance(previousBalance);

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
        sumExpenses.setImmovables(expenses.getImmovables());
        sumExpenses.setSumExpensesTotal(expenses.getTotal());
        response.setSumExpenses(sumExpenses);

        //todo: get uncheckedExpenses from DB
        response.setUncheckedExpenses(0.0);
        //todo: get loans from DB
        response.setLoans(0.0);

        //todo: uncheckedExpenses and loans are not considered yet
        response.setTotal((previousBalance + incomes.getTotal()) - expenses.getTotal());


        //todo: change this part and get values from DB?
        response.setComments("This is an audit report");
        response.setAuditor("Ulises Cardenas");
        response.setTreasurer("Javier Trinidad Meza Cazarez");
        response.setSecretary("Mirna Mendoza");
        return response;
    }

    private String buildReportPeriod(int fromMonth, int toMonth, int year) {
        return String.format("%s - %s %s",
                Months.valueOfNumber(fromMonth),
                Months.valueOfNumber(toMonth),
                year);
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
