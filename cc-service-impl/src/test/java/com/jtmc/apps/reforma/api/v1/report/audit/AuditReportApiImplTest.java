package com.jtmc.apps.reforma.api.v1.report.audit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;

class AuditReportApiImplTest {

    @InjectMocks
    private AuditReportApiImpl auditReportApi;

    private String expectedTitle;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        expectedTitle = "Informe de Auditoría";
    }

    @Test
    void testCreateAuditReport_returnAuditReportResponseObject() {
        AuditReportResponse actualResponse = auditReportApi.createAuditReport(any(AuditReportRequest.class));
        Assertions.assertNotNull(actualResponse);
    }

    @Test
    void testCreateAuditReport_verifiesInformationDate_isSet() {
        AuditReportResponse actualResponse = auditReportApi.createAuditReport(any(AuditReportRequest.class));

        Assertions.assertEquals(expectedTitle, actualResponse.getTitle());
        Assertions.assertTrue(StringUtils.isNotBlank(actualResponse.getPeriod()));
        Assertions.assertTrue(StringUtils.isNotBlank(actualResponse.getMision()));

        Assertions.assertTrue(StringUtils.isNotBlank(actualResponse.getTreasurer()));
    }
}