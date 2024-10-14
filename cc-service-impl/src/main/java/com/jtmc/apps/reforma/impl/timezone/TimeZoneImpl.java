package com.jtmc.apps.reforma.impl.timezone;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.TimezoneType;
import com.jtmc.apps.reforma.repository.TimeZoneRepository;

import java.util.List;

public class TimeZoneImpl {
    @Inject
    private TimeZoneRepository timeZoneRepository;

    public List<TimezoneType> selectAll() {
        return timeZoneRepository.selectAll();
    }
}
