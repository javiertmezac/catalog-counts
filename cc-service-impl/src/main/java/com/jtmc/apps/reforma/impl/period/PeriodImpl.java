package com.jtmc.apps.reforma.impl.period;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Period;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.impl.exception.PeriodNotFoundException;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.PeriodRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.ws.rs.BadRequestException;
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

    //todo: ugly, change it
    public void upsert(Period period) {
        UserDetails userDetails = userImpl.getLoggedInUserDetails();
        //todo validate contralor rights.

        if (period.getFrommonth() > period.getTomonth()) {
            logger.error("Period FromMonth {} should not be greater than To Month {}. username: {}",
                    period.getFrommonth(), period.getTomonth(), userDetails.getUsername());
            throw new BadRequestException("From Month cannot be greater than To Month");
        }

        int success = 1;
        int newValue = 0;
        String finalLoggerMessage;
        if (period.getId() == newValue) {
            if(periodRepository.insert(period) != success) {
                logger.error("Could not insert new period");
                throw new RuntimeException("Could not insert period");
            }
            finalLoggerMessage = "New period from  {} to {} year {}: successfully inserted by {}";
        } else {
            if(periodRepository.update(period) != success) {
                logger.error("Could not update period {}", period.getId());
                throw new RuntimeException("Could not update period");
            }
            finalLoggerMessage = "Period from  {} to {} year {}: successfully updated by {}";
        }
        logger.info(finalLoggerMessage,
                period.getFrommonth(), period.getTomonth(), period.getYear(), userDetails.getUsername());
    }

    public List<Period> list() {
       return periodRepository.select();
    }
}
