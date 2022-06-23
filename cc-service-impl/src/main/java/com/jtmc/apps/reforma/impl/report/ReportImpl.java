package com.jtmc.apps.reforma.impl.report;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Period;
import com.jtmc.apps.reforma.domain.PeriodDetails;
import com.jtmc.apps.reforma.domain.Report;
import com.jtmc.apps.reforma.impl.exception.PeriodNotFoundException;
import com.jtmc.apps.reforma.repository.PeriodConfirmRepository;
import com.jtmc.apps.reforma.repository.PeriodRepository;
import com.jtmc.apps.reforma.repository.ReportRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ReportImpl {

    private final Logger logger = LoggerFactory.getLogger(ReportImpl.class);

   @Inject
   private ReportRepository reportRepository;

   @Inject
   private PeriodRepository periodRepository;

   @Inject
   private PeriodConfirmRepository periodConfirmRepository;

   public void whatever(int branchId, int month, int year) {

       Optional<Period> period = periodRepository.selectOne(month, year);
       if(!period.isPresent()) {
           logger.error("Period for month {} and year {}, not found", month, year);
           throw new PeriodNotFoundException("Not Found", 404);
       }

       int periodId = period.get().getId();
       Optional<Report> report = reportRepository.selectByPeriod(periodId);
       if (!report.isPresent()) {
          logger.warn("Report for PeriodId {}, not found", periodId);
       }

       List<PeriodDetails> periodConfirmationList = periodConfirmRepository.select(branchId, periodId);
       //optional todo: verify roles of "confirmation users"

       PeriodReport periodReport = new PeriodReport();
       periodReport.setReportUUID(report.map(r -> UUID.fromString(r.getUuid())).orElse(null));

   }
    class PeriodReport {
       private int periodId;
       private String periodDescription;
       private UUID reportUUID;
       private boolean treasureConfirmation;
       private boolean secretaryConfirmation;

        public int getPeriodId() {
            return periodId;
        }

        public void setPeriodId(int periodId) {
            this.periodId = periodId;
        }

        public String getPeriodDescription() {
            return periodDescription;
        }

        public void setPeriodDescription(String periodDescription) {
            this.periodDescription = periodDescription;
        }

        public UUID getReportUUID() {
            return reportUUID;
        }

        public void setReportUUID(UUID reportUUID) {
            this.reportUUID = reportUUID;
        }

        public boolean isTreasureConfirmation() {
            return treasureConfirmation;
        }

        public void setTreasureConfirmation(boolean treasureConfirmation) {
            this.treasureConfirmation = treasureConfirmation;
        }

        public boolean isSecretaryConfirmation() {
            return secretaryConfirmation;
        }

        public void setSecretaryConfirmation(boolean secretaryConfirmation) {
            this.secretaryConfirmation = secretaryConfirmation;
        }
    }
}


