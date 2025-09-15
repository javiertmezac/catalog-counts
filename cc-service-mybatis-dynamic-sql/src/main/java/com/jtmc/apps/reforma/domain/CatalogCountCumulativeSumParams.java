package com.jtmc.apps.reforma.domain;

public class CatalogCountCumulativeSumParams {
    private Integer branchId;
    private Integer deadLineDay;
    private Integer page;
    private Integer pageSize;
    private Integer filterYear;
    private String filterSearch;

    public String getFilterSearch() {
        return filterSearch;
    }

    public void setFilterSearch(String filterSearch) {
        this.filterSearch = filterSearch;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Integer getDeadLineDay() {
        return deadLineDay;
    }
    public void setDeadLineDay(Integer deadLineDay) {
        this.deadLineDay = deadLineDay;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getFilterYear() {
        return filterYear;
    }

    public void setFilterYear(Integer filterYear) {
        this.filterYear = filterYear;
    }
}
