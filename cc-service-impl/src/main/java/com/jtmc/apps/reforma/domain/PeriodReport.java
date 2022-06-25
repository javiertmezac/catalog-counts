package com.jtmc.apps.reforma.domain;

import java.util.List;
import java.util.UUID;

public class PeriodReport {
    private int periodId;
    private String periodDescription;
    private UUID reportUUID;
    private List<PersonaRolePeriodConfirmation> confirmationList;

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

    public List<PersonaRolePeriodConfirmation> getConfirmationList() {
        return confirmationList;
    }

        public void setConfirmationList(List<PersonaRolePeriodConfirmation> confirmationList) {
            this.confirmationList = confirmationList;
        }
}
