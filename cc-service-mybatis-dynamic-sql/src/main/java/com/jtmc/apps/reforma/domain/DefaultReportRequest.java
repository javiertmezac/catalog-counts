package com.jtmc.apps.reforma.domain;

public class DefaultReportRequest {
    private boolean isIncome;
    private Integer branchId;
    private Integer reportFromMonth;
    private Integer reportFromYear;
    private Integer reportToMonth;
    private Integer reportToYear;

    public boolean isIncome() {
        return isIncome;
    }

    public void setIncome(boolean income) {
        isIncome = income;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getReportFromMonth() {
        return reportFromMonth;
    }

    public void setReportFromMonth(Integer reportFromMonth) {
        this.reportFromMonth = reportFromMonth;
    }

    public Integer getReportFromYear() {
        return reportFromYear;
    }

    public void setReportFromYear(Integer reportFromYear) {
        this.reportFromYear = reportFromYear;
    }

    public Integer getReportToMonth() {
        return reportToMonth;
    }

    public void setReportToMonth(Integer reportToMonth) {
        this.reportToMonth = reportToMonth;
    }

    public Integer getReportToYear() {
        return reportToYear;
    }

    public void setReportToYear(Integer reportToYear) {
        this.reportToYear = reportToYear;
    }
}
