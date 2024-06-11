package com.jtmc.apps.reforma.api.v1.timezone;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.TimezoneType;
import com.jtmc.apps.reforma.impl.timezone.TimeZoneImpl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TimeZoneApiImpl implements TimeZoneApi {

    @Inject
    private TimeZoneImpl timezoneImpl;

    @Override
    public TimeZoneResponseList getTimezones() {
        List<TimezoneType> timezones = timezoneImpl.selectAll();
        TimeZoneResponseList responseList = new TimeZoneResponseList();

        Stream<CCTimezone> ccTimezoneStream = timezones.stream().map(x ->  {
            CCTimezone response = new CCTimezone();
            response.setId(x.getId());
            response.setLabel(x.getName());
            return response;
        });

        responseList.setTimezone(ccTimezoneStream.collect(Collectors.toList()));
        return  responseList;
    }
}
