package com.jtmc.apps.reforma.api.v1.report;

import java.util.List;
import java.util.UUID;

public class PeriodReportResponse {
    private int periodId;
    private String periodDescription;
    private UUID reportUUID;
    private List<PeriodReportDetailsResponse> confirmationList;

    public int getPeriodId() {
        return periodId;
    }

    public void setPeriodId(int periodId) {
        this.periodId = periodId;
    }

    public String getPeriodDescription() {
        return periodDescription;
    }

    public void setPeriodDescription(String periodDescription) {
        this.periodDescription = periodDescription;
    }

    public UUID getReportUUID() {
        return reportUUID;
    }

    public void setReportUUID(UUID reportUUID) {
        this.reportUUID = reportUUID;
    }

    public List<PeriodReportDetailsResponse> getConfirmationList() {
        return confirmationList;
    }

    public void setConfirmationList(List<PeriodReportDetailsResponse> confirmationList) {
        this.confirmationList = confirmationList;
    }
}
