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

        //todo: set correct dates from Month
       Incomes incomes = auditReport.getSumIncomes("2021-06-01", "2021-07-01");

        SumIncomes sumIncomes = new SumIncomes();
        sumIncomes.setDonations(incomes.getDonations());
        sumIncomes.setTithe(incomes.getTithe());
        sumIncomes.setOffering(incomes.getOffering());
        sumIncomes.setSumIncomesTotal(incomes.getTotal());

        response.setSumIncomes(sumIncomes);

        Expenses expenses = auditReport.getSumExpenses("2021-06-01", "2021-07-01");
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
}
