package com.jtmc.apps.reforma.api.v1.report;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.PeriodReport;
import com.jtmc.apps.reforma.domain.PersonaRolePeriodConfirmation;
import com.jtmc.apps.reforma.impl.report.ReportImpl;

import java.util.stream.Collectors;

public class ReportApiImpl implements ReportApi {
    @Inject
    private ReportImpl report;

    @Override
    public PeriodReportResponse periodReportStatus() {
        PeriodReport periodReport = report.periodReport(1, 5, 2022);
        return convert(periodReport);
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
