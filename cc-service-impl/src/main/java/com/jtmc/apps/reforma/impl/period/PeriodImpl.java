package com.jtmc.apps.reforma.impl.period;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Period;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.impl.exception.PeriodNotFoundException;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.PeriodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PeriodImpl {
    private final Logger logger = LoggerFactory.getLogger(PeriodImpl.class);

    @Inject
    private PeriodRepository periodRepository;

    @Inject
    private UserImpl userImpl;

    public Period getPeriodByQueryParams(int toMonth, int year) {
       Optional<Period> period = periodRepository.selectOne(toMonth, year);
       if (!period.isPresent()) {
           logger.error("Period for toMonth {} and year {}, not found", toMonth, year);
           throw new PeriodNotFoundException("Period Not Found", 404);
       }
       return period.get();
    }

    public Period getPeriodById(int periodId) {
        Optional<Period> period = periodRepository.selectOne(periodId);
        if (!period.isPresent()) {
            logger.error("Period {} not found", periodId);
            throw new PeriodNotFoundException("Period Not Found", 404);
        }
        return period.get();
    }

    public void insert(Period period) {
        UserDetails userDetails = userImpl.getLoggedInUserDetails();
        //todo validate contralor rights.

        int successfulInserted = 1;
        if(periodRepository.insert(period) != successfulInserted) {
            logger.error("Could not insert new period");
            throw new RuntimeException("Could not insert period");
        }
        logger.info("New period from  {} to {} year {}: successfully inserted by {}",
                period.getFrommonth(), period.getTomonth(), period.getYear(), userDetails.getUsername());
    }

    public List<Period> list() {
       return periodRepository.select();
    }
}
