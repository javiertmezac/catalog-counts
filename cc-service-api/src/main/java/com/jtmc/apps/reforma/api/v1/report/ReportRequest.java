package com.jtmc.apps.reforma.api.v1.report;

public class ReportRequest {

    private int fromMonth;
    private int toMonth;
    private int year;
    private String reporterComments;

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getReporterComments() {
        return reporterComments;
    }

    public void setReporterComments(String reporterComments) {
        this.reporterComments = reporterComments;
    }
}
