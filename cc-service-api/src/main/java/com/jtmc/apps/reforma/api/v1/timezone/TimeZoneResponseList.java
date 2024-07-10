package com.jtmc.apps.reforma.api.v1.timezone;

import java.util.List;

public class TimeZoneResponseList {

    private List<CCTimezone> timezoneList;

    public List<CCTimezone> getTimezone() {
        return timezoneList;
    }

    public void setTimezone(List<CCTimezone> timezone) {
        this.timezoneList = timezone;
    }
}
