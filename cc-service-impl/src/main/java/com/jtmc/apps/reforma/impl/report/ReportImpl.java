package com.jtmc.apps.reforma.impl.report;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Period;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import com.jtmc.apps.reforma.repository.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.*;
import java.util.*;
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
    private PersonaRepository personaRepository;

    @Inject
    private RoleRepository roleRepository;

    @Inject
    private CatalogCountImpl catalogCountImpl;

    public PeriodReport periodReport(int branchId, Period period) {

        int periodId = period.getId();
        Optional<Report> report = reportRepository.selectByPeriod(periodId);
        if (!report.isPresent()) {
            //this log was to notify that a report was not "stored" in the db. but nothing to worry about.
            // save reports is not yet implemented.
//          logger.warn("Report for PeriodId {}, not found", periodId);
        }

        List<PeriodDetails> periodConfirmationList = periodConfirmRepository.select(branchId, periodId);
        //optional todo: verify roles of "confirmation users"
        Stream<PersonaRolePeriodConfirmation> periodConfirmationStream = periodConfirmationList.stream().map(x -> {
            PersonaRolePeriodConfirmation confirmation = new PersonaRolePeriodConfirmation();
            confirmation.setPersonaId(x.getConfirmedby());
            confirmation.setConfirmationDate(x.getRegistration());

            Optional<PersonaDetails> personaDetails = personaDetailsRepository.selectOne(x.getConfirmedby(), x.getBranchid());
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

    public double calculatePreviousBalance(BranchDetails branchDetails, ReportDateLimitsParams params) {
        ZoneId zoneId = ZoneId.of(branchDetails.getTimezoneType().map(TimezoneType::getName).orElse("UTC"));
        ZonedDateTime firstDayCurrentDate = LocalDate
                .of(params.getFromYear(), params.getFromMonth(), 1)
                .atStartOfDay(zoneId);
        return catalogCountImpl.getTotalBalanceUpToGivenDate(
                branchDetails.getBranch().getId(), firstDayCurrentDate.toInstant()
        );
    }

    public Map<String, String> fetchBranchPersonaByRole(int branchId) {
        List<PersonaDetails> personaDetails = personaDetailsRepository.select(branchId);
        List<Role> roles = roleRepository.selectAll();
        List<Persona> personas = personaRepository.selectAll();
        Map<String, String> personaRoleMap = new HashMap<>();
        personaDetails.forEach(x -> {
            Optional<Role> role = roles.stream().filter(r -> r.getId().equals(x.getRoleid())).findFirst();
            Optional<Persona> persona = personas.stream()
                    .filter(p -> p.getId().equals(x.getPersonaid()))
                    .findFirst();
            if (role.isPresent() && persona.isPresent()) {
                personaRoleMap.put(role.get().getDescription(),
                        String.format("%s %s", persona.get().getName(), persona.get().getLastname()));
            }
        });
        return personaRoleMap;
    }
}

