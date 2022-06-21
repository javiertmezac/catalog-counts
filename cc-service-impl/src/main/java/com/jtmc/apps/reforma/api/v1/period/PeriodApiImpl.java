package com.jtmc.apps.reforma.api.v1.period;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.Period;
import com.jtmc.apps.reforma.impl.period.PeriodImpl;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;

@JwtRequired
public class PeriodApiImpl implements PeriodApi {

    @Inject
    private PeriodImpl periodImpl;

    @Override
    public PeriodResponseList getPeriod(int toMonth, int year) {
        PeriodResponseList responseList = new PeriodResponseList();
        if (toMonth > 0 && year > 0 ) {
            validateQueryParams(toMonth, year);
            Period period = periodImpl.getPeriodByQueryParams(toMonth, year);
            PeriodResponse response = converter(period);
            responseList.setPeriodResponseList(Collections.singletonList(response));
            return responseList;
        }

        List<Period> list = periodImpl.list();
        Stream<PeriodResponse> periodResponseStream = list.stream().map(this::converter);
        responseList.setPeriodResponseList(periodResponseStream.collect(Collectors.toList()));
        return responseList;
    }

    @Override
    public PeriodResponse getPeriod(int periodId) {
        checkArgument(periodId > 0, "Invalid Period");
        Period p = periodImpl.getPeriodById(periodId);
        return converter(p);
    }

    private void validateQueryParams(int toMonth, int year) {
        checkArgument(toMonth > 0, "Invalid toMonth");
        checkArgument(toMonth < 13, "Invalid toMonth");

        int minYear = 2000;
        checkArgument(year > minYear, "Invalid year");
    }

    private PeriodResponse converter(Period p) {
        PeriodResponse response = new PeriodResponse();
        response.setId(p.getId());
        response.setDescription(p.getDescription());
        response.setToMonth(p.getTomonth());
        response.setFromMonth(p.getFrommonth());
        response.setYear(p.getYear());
        return response;
    }

    @Override
    public Response insert(PeriodRequest request) {
        checkArgument(request.getFromMonth() > 0, "Invalid From Month");
        checkArgument(request.getToMonth() > 0, "Invalid To Month");
        checkArgument(request.getYear() > 0, "Invalid Year");
        checkArgument(StringUtils.isNotBlank(request.getDescription()), "Invalid Description");

        Period p = new Period();
        p.setDescription(request.getDescription());
        p.setFrommonth(request.getFromMonth());
        p.setTomonth(request.getToMonth());
        p.setYear(request.getYear());
        periodImpl.insert(p);

        return Response.noContent().build();
    }
}
