package com.jtmc.apps.reforma.api.v1.report.audit;

public class AuditReportResponse {

    private String title;
    private String mision;
    private String period;
    private double previousBalance;
    private SumIncomes sumIncomes;
    private SumExpenses sumExpenses;
    private double uncheckedExpenses;
    private double loans;
    private double total;
    private String comments;
    private String Auditor;
    private String treasure;
    private String secretary;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMision() {
        return mision;
    }

    public void setMision(String mision) {
        this.mision = mision;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public double getPreviousBalance() {
        return previousBalance;
    }

    public void setPreviousBalance(double previousBalance) {
        this.previousBalance = previousBalance;
    }

    public SumIncomes getSumIncomes() {
        return sumIncomes;
    }

    public void setSumIncomes(SumIncomes sumIncomes) {
        this.sumIncomes = sumIncomes;
    }

    public SumExpenses getSumExpenses() {
        return sumExpenses;
    }

    public void setSumExpenses(SumExpenses sumExpenses) {
        this.sumExpenses = sumExpenses;
    }

    public double getUncheckedExpenses() {
        return uncheckedExpenses;
    }

    public void setUncheckedExpenses(double uncheckedExpenses) {
        this.uncheckedExpenses = uncheckedExpenses;
    }

    public double getLoans() {
        return loans;
    }

    public void setLoans(double loans) {
        this.loans = loans;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAuditor() {
        return Auditor;
    }

    public void setAuditor(String auditor) {
        Auditor = auditor;
    }

    public String getTreasurer() {
        return treasure;
    }

    public void setTreasurer(String treasurer) {
        this.treasure = treasurer;
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }
}
