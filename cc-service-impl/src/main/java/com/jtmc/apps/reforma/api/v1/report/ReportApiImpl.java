package com.jtmc.apps.reforma.api.v1.report;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.impl.branch.BranchImpl;
import com.jtmc.apps.reforma.impl.period.PeriodImpl;
import com.jtmc.apps.reforma.impl.report.ReportImpl;
import com.jtmc.apps.reforma.impl.report.audit.AuditReportImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@JwtRequired
public class ReportApiImpl implements ReportApi {

    @Inject
    private ReportImpl report;

    @Inject
    private AuditReportImpl auditReport;

    @Inject
    private PeriodImpl period;

    @Inject
    private BranchImpl branch;

    @Override
    public PeriodReportResponseList periodReportStatus(int branchId) {
        List<Period> periodList = period.list();
        Stream<PeriodReportResponse> periodReportStream = periodList.stream().map(x -> convert(report.periodReport(branchId, x)));
        PeriodReportResponseList responseList = new PeriodReportResponseList();
        responseList.setPeriodReportList(periodReportStream.collect(Collectors.toList()));
        return responseList;
    }

    @Override
    public ReportResponse createReport(int branchId, ReportRequest reportRequest) {
        checkNotNull(reportRequest, "invalid request payload");
        checkArgument(branchId > 0, "Invalid branchId");
        checkArgument(reportRequest.getFromMonth() >= 1 && reportRequest.getFromMonth() <= 12 ,
                "fromMonth not valid");
        checkArgument(reportRequest.getToMonth() >= 1 && reportRequest.getToMonth() <= 12 ,
                "toMonth not valid");

        ReportResponse response = new ReportResponse();
        response.setTitle("Reporte");
        response.setMision(branch.selectOneBranch(branchId).getName());

        int fromMonth = reportRequest.getFromMonth();
        int toMonth = reportRequest.getToMonth();
        int year = reportRequest.getYear();
        response.setPeriod(String.format("%s - %s %s",
                Months.valueOfNumber(fromMonth),
                Months.valueOfNumber(toMonth),
                year));

        String fromDate = report.buildFromDate(fromMonth, year);
        String toDate = report.buildToDate(toMonth, year);

        double previousBalance = report.calculatePreviousBalance(branchId, fromDate);
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

        response.setComments(reportRequest.getReporterComments());

        //todo: change this part and get values from DB?
        response.setAuditor("[placeholder]");
        response.setTreasurer("Javier Trinidad Meza Cazarez");
        response.setSecretary("[placeholder]");

        //todo: save report..
        return response;
    }

    private PeriodReportResponse convert(PeriodReport periodReport) {
        PeriodReportResponse response  = new PeriodReportResponse();
        response.setPeriodId(periodReport.getPeriodId());
        response.setReportUUID(periodReport.getReportUUID());
        response.setPeriodDescription(periodReport.getPeriodDescription());

        response.setConfirmationList(periodReport.getConfirmationList()
                .stream().map(this::convertPeriodReportDetails).collect(Collectors.toList())
        );
        return response;
    }

    private PeriodReportDetailsResponse convertPeriodReportDetails(PersonaRolePeriodConfirmation confirmationDetails) {
        PeriodReportDetailsResponse response = new PeriodReportDetailsResponse();
        response.setConfirmationDate(confirmationDetails.getConfirmationDate().toString());
        response.setPersonaId(confirmationDetails.getPersonaId());
        response.setRoleDescription(confirmationDetails.getRole().getDescription());
        response.setRoleId(confirmationDetails.getRole().getId());
        return response;
    }
}
