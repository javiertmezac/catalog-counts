package com.jtmc.apps.reforma.api.v1.report;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.impl.branch.BranchImpl;
import com.jtmc.apps.reforma.impl.period.PeriodImpl;
import com.jtmc.apps.reforma.impl.report.ReportImpl;
import com.jtmc.apps.reforma.impl.report.audit.AuditReportImpl;

import java.util.List;
import java.util.Map;
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
    private BranchImpl branchImpl;

    @Override
    public PeriodReportResponseList periodReportStatus(int branchId) {
        List<Period> periodList = period.list();
        Stream<PeriodReportResponse> periodReportStream =
                periodList.stream().map(x -> convert(report.periodReport(branchId, x)));
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
        checkArgument(reportRequest.getFromYear() > 2020);
        checkArgument(reportRequest.getToYear() > 2020);
        checkArgument(reportRequest.getToYear() >= reportRequest.getFromYear(),
                "invalid year(s) configuration");
        checkArgument(reportRequest.getToMonth() >= reportRequest.getFromMonth(),
                "invalid mont(s) configuration");

        ReportResponse response = new ReportResponse();
        response.setTitle("Reporte");

        BranchDetails branchDetails = branchImpl.selectOneBranch(branchId);
        response.setMision(branchDetails.getBranch().getName());

        ReportDateLimitsParams reportDateLimitsParams = new ReportDateLimitsParams();
        reportDateLimitsParams.setFromMonth(reportRequest.getFromMonth());
        reportDateLimitsParams.setFromYear(reportRequest.getFromYear());
        reportDateLimitsParams.setToMonth(reportRequest.getToMonth());
        reportDateLimitsParams.setToYear(reportRequest.getToYear());

        response.setPeriod(reportDateLimitsParams.getPeriodTitle());

        double previousBalance = report.calculatePreviousBalance(branchDetails, reportDateLimitsParams);
        response.setPreviousBalance(previousBalance);

        Incomes incomes = auditReport.getSumIncomes(branchId, reportDateLimitsParams);
        SumIncomes sumIncomes = new SumIncomes();
        sumIncomes.setDonations(incomes.getDonations());
        sumIncomes.setTithe(incomes.getTithe());
        sumIncomes.setOffering(incomes.getOffering());
        sumIncomes.setSumIncomesTotal(incomes.getTotal());
        response.setSumIncomes(sumIncomes);

        Expenses expenses = auditReport.getSumExpenses(branchId, reportDateLimitsParams);
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

        Map<String, String> personaByRole = report.fetchBranchPersonaByRole(branchId);
        response.setAuditor("[placeholder]");
        response.setTreasurer(personaByRole.get(Roles.TREASURE.getDescription()));
        response.setSecretary(personaByRole.get(Roles.SECRETARY.getDescription()));

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
