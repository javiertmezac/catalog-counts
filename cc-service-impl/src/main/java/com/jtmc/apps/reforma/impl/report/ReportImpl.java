package com.jtmc.apps.reforma.impl.report;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.impl.exception.PeriodNotFoundException;
import com.jtmc.apps.reforma.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
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
   private PeriodRepository periodRepository;

   @Inject
   private PeriodConfirmRepository periodConfirmRepository;

   @Inject
   private PersonaDetailsRepository personaDetailsRepository;

   @Inject
   private RoleRepository roleRepository;

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
}


