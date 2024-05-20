package com.jtmc.apps.reforma.domain;

public class ReportDateLimitsParams {

    private int fromMonth;
    private int fromYear;
    private int toMonth;
    private int toYear;

    //todo: validate Dates

    public int getFromMonth() {
        return fromMonth;
    }

    public void setFromMonth(int fromMonth) {
        this.fromMonth = fromMonth;
    }

    public int getFromYear() {
        return fromYear;
    }

    public void setFromYear(int fromYear) {
        this.fromYear = fromYear;
    }

    public int getToMonth() {
        return toMonth;
    }

    public void setToMonth(int toMonth) {
        this.toMonth = toMonth;
    }

    public int getToYear() {
        return toYear;
    }

    public void setToYear(int toYear) {
        this.toYear = toYear;
    }

    public String getPeriodTitle() {
       return String.format("%s %s - %s %s",
               Months.valueOfNumber(fromMonth), fromYear,
               Months.valueOfNumber(toMonth), toYear);
    }
}
