package com.jtmc.apps.reforma.api.v1.report.audit;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.Expenses;
import com.jtmc.apps.reforma.domain.Incomes;
import com.jtmc.apps.reforma.domain.Months;
import com.jtmc.apps.reforma.impl.branch.BranchImpl;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import com.jtmc.apps.reforma.impl.report.audit.AuditReportImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@JwtRequired
public class AuditReportApiImpl implements AuditReportApi {
    final private Logger logger = LoggerFactory.getLogger(AuditReportApiImpl.class);

    @Inject
    private AuditReportImpl auditReport;

    @Inject
    private CatalogCountImpl catalogCountImpl;

    @Inject
    private BranchImpl branchImpl;

    @Override
    public AuditReportResponse createAuditReport(AuditReportRequest auditReportRequest) {
        checkNotNull(auditReportRequest, "invalid auditReport payload");
        checkArgument(auditReportRequest.getBranchId() > 0, "Invalid branchId");

        AuditReportResponse response = new AuditReportResponse();
        response.setTitle("Informe de Auditoría");
        response.setMision(branchImpl.selectOneBranch(auditReportRequest.getBranchId()).getName());

        auditReport.areMonthsValid(
                auditReportRequest.getFromMonth(), auditReportRequest.getToMonth());

        String period = buildReportPeriod(
                auditReportRequest.getFromMonth(),
                auditReportRequest.getToMonth(),
                auditReportRequest.getYear()
        );
        response.setPeriod(period);

        String fromDate = buildFromDate(auditReportRequest.getFromMonth(),
                auditReportRequest.getYear());
        String toDate = buildToDate(auditReportRequest.getToMonth(),
                auditReportRequest.getYear());

        double previousBalance;
        try {
             previousBalance = catalogCountImpl.getTotalBalanceUpToGivenDate(auditReportRequest.getBranchId(), fromDate);
        } catch (Exception e) {
            logger.error("wrong date parsing", e);
            throw new WebApplicationException(e);
        }
        response.setPreviousBalance(previousBalance);

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

        response.setComments(auditReportRequest.getReporterComments());

        //todo: change this part and get values from DB?
        response.setAuditor("[placeholder]");
        response.setTreasurer("Javier Trinidad Meza Cazarez");
        response.setSecretary("[placeholder]");

        //todo: save report..
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
