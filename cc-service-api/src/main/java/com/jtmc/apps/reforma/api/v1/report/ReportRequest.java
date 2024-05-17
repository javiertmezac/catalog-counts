package com.jtmc.apps.reforma.api.v1.report;

public class ReportRequest {

    private int fromMonth;
    private int fromYear;
    private int toMonth;
    private int toYear;
    private String reporterComments;

    public int getFromYear() {
        return fromYear;
    }

    public void setFromYear(int fromYear) {
        this.fromYear = fromYear;
    }

    public int getToYear() {
        return toYear;
    }

    public void setToYear(int toYear) {
        this.toYear = toYear;
    }

    public int getFromMonth() {
        return fromMonth;
    }

    public void setFromMonth(int fromMonth) {
        this.fromMonth = fromMonth;
    }

    public int getToMonth() {
        return toMonth;
    }

    public void setToMonth(int toMonth) {
        this.toMonth = toMonth;
    }

    public String getReporterComments() {
        return reporterComments;
    }

    public void setReporterComments(String reporterComments) {
        this.reporterComments = reporterComments;
    }
}
