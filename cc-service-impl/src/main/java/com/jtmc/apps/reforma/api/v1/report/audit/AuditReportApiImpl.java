package com.jtmc.apps.reforma.api.v1.report.audit;

import com.google.inject.Inject;
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

        //todo: get SumIncomes from DB
       auditReport.selectSumIncomes();

        SumIncomes sumIncomes = new SumIncomes();
        sumIncomes.setSumIncomesTotal(10355.60);
        response.setSumIncomes(sumIncomes);

        //todo: get SumExpenses from DB
        SumExpenses sumExpenses = new SumExpenses();
        sumExpenses.setSumExpensesTotal(9345.98);
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
