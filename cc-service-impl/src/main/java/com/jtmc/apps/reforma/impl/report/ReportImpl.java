package com.jtmc.apps.reforma.impl.report;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.domain.Period;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import com.jtmc.apps.reforma.repository.PeriodConfirmRepository;
import com.jtmc.apps.reforma.repository.PersonaDetailsRepository;
import com.jtmc.apps.reforma.repository.ReportRepository;
import com.jtmc.apps.reforma.repository.RoleRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReportImpl {

    private final Logger logger = LoggerFactory.getLogger(ReportImpl.class);

   @Inject
   private ReportRepository reportRepository;

   @Inject
   private PeriodConfirmRepository periodConfirmRepository;

   @Inject
   private PersonaDetailsRepository personaDetailsRepository;

   @Inject
   private RoleRepository roleRepository;

   @Inject
   private CatalogCountImpl catalogCountImpl;

   public PeriodReport periodReport(int branchId, Period period) {

       int periodId = period.getId();
       Optional<Report> report = reportRepository.selectByPeriod(periodId);
       if (!report.isPresent()) {
          logger.warn("Report for PeriodId {}, not found", periodId);
       }

       List<PeriodDetails> periodConfirmationList = periodConfirmRepository.select(branchId, periodId);
       //optional todo: verify roles of "confirmation users"
       Stream<PersonaRolePeriodConfirmation> periodConfirmationStream = periodConfirmationList.stream().map(x -> {
           PersonaRolePeriodConfirmation confirmation = new PersonaRolePeriodConfirmation();
           confirmation.setPersonaId(x.getConfirmedby());
           confirmation.setConfirmationDate(x.getRegistration());

           Optional<PersonaDetails> personaDetails = personaDetailsRepository.selectOne(x.getConfirmedby());
           confirmation.setRole(personaDetails.map(pd ->
                   roleRepository.selectOne(pd.getRoleid())
                           .orElse(null))
                   .orElse(null));
           return confirmation;
       });

       PeriodReport periodReport = new PeriodReport();
       periodReport.setPeriodId(periodId);
       periodReport.setPeriodDescription(period.getDescription());
       periodReport.setReportUUID(report.map(r -> UUID.fromString(r.getUuid())).orElse(null));
       periodReport.setConfirmationList(periodConfirmationStream.collect(Collectors.toList()));

       return periodReport;
   }

    public String buildToDate(int toMonth, int year) {

        final int december = 12;
        final String day = "01";
        String month = String.valueOf(toMonth + 1);

        if(toMonth == december) {
            year = year + 1;
            month = "01";
        }
        return  String.format("%s-%s-%s",
                year, month, day);
    }

    public Instant buildFromDate(int fromMonth, int year) {

        int firstDay = 1;
        LocalDate date = LocalDate.of(year, fromMonth, firstDay);
        LocalDateTime dateTime = LocalDateTime.of(date, LocalTime.MIN);
        ZonedDateTime minZonedDateTime = dateTime.atZone(ZoneId.systemDefault());

        return minZonedDateTime.toInstant();
    }

    public double calculatePreviousBalance(int branchId, Instant fromDate) {
        double previousBalance;
        try {
             previousBalance = catalogCountImpl.getTotalBalanceUpToGivenDate(branchId, fromDate);
        } catch (Exception e) {
            logger.error("wrong date parsing", e);
            throw new RuntimeException(e);
        }
        return previousBalance;
    }

}


