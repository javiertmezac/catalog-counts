package com.jtmc.apps.reforma.api.v1.report;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Period;
import com.jtmc.apps.reforma.domain.PeriodReport;
import com.jtmc.apps.reforma.domain.PersonaRolePeriodConfirmation;
import com.jtmc.apps.reforma.impl.period.PeriodImpl;
import com.jtmc.apps.reforma.impl.report.ReportImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportApiImpl implements ReportApi {
    @Inject
    private ReportImpl report;

    @Inject
    private PeriodImpl period;

    @Override
    public PeriodReportResponseList periodReportStatus(int branchId) {
        List<Period> periodList = period.list();
        Stream<PeriodReportResponse> periodReportStream = periodList.stream().map(x -> convert(report.periodReport(branchId, x)));
        PeriodReportResponseList responseList = new PeriodReportResponseList();
        responseList.setPeriodReportList(periodReportStream.collect(Collectors.toList()));
        return responseList;
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
