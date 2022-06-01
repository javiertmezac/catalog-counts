package com.jtmc.apps.reforma.api.v1.period;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Period;
import com.jtmc.apps.reforma.impl.period.PeriodImpl;

import static com.google.common.base.Preconditions.checkArgument;

public class PeriodApiImpl implements PeriodApi {

    @Inject
    private PeriodImpl periodImpl;

    @Override
    public PeriodResponse getPeriod(int toMonth, int year) {
        checkArgument(toMonth > 0, "Invalid toMonth");
        checkArgument(toMonth < 13, "Invalid toMonth");
        int minYear = 2000;
        checkArgument(year > minYear, "Invalid year");

        Period period = periodImpl.getPeriodByQueryParams(toMonth, year);
        PeriodResponse response = new PeriodResponse();
        response.setDescription(period.getDescription());
        response.setId(period.getId());
        return response;
    }
}
