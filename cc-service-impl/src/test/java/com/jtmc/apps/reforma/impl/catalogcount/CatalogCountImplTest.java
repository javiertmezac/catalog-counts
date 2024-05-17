package com.jtmc.apps.reforma.impl.catalogcount;

import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponse;
import com.jtmc.apps.reforma.domain.CustomCatalogCount;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.exception.RepositoryException;
import org.junit.Ignore;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CatalogCountImplTest {

    //todo: add UNIT TESTS

    @InjectMocks
    private CatalogCountImpl catalogCountImpl;

    @Mock
    private CatalogCountRepository catalogCountRepository;

    private double expectedTotal;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        expectedTotal = 0.0;
    }

    @Test
    void testSelectAllRecords_callsRepository() {
       catalogCountImpl.selectAllWithTotalColumn(0);
       verify(catalogCountRepository).selectAllCumulativeSumByBranch(any());
    }

    @Test
    void testSelectAllRecords_shouldPropagateException() {

        when(catalogCountRepository.selectAllByBranch(anyInt())).thenThrow(RepositoryException.class);

        RepositoryException actualException = Assertions.assertThrows(RepositoryException.class,
                () -> catalogCountRepository.selectAllByBranch(0));

        Assertions.assertNotNull(actualException);
    }

    //todo: fix this test
    @Ignore
    void testSelectAllRecords_returnsCorrectList_withCorrectTotalColumn() {
        double initialTotal = 1000.50;
        //todo: easyRandom
        Integer enum1 = 1;

        CustomCatalogCount catalogCount1 = new CustomCatalogCount();
        catalogCount1.setId(1);
        catalogCount1.setAmount(500.00);
        catalogCount1.setCatalogcountenumid(enum1);
        catalogCount1.setRegistration(Instant.now());
        double expectedTotalForCatalogCount1 = 1250.00;
        LocalDate expectedLocalDate1 = convertToGMTMinus07Zone(catalogCount1.getRegistration().getEpochSecond());

        Integer  enum2 = 5;

        CustomCatalogCount catalogCount2 = new CustomCatalogCount();
        catalogCount2.setId(2);
        catalogCount2.setAmount(300.50);
        catalogCount2.setCatalogcountenumid(enum2);
        catalogCount2.setRegistration(Instant.now().minus(Period.ofDays(3)));
        double expectedTotalForCatalogCount2 = 700.00;
        LocalDate expectedLocalDate2 = convertToGMTMinus07Zone(catalogCount2.getRegistration().getEpochSecond());

        Integer enum3 = 3;
        CustomCatalogCount catalogCount3 = new CustomCatalogCount();
        catalogCount3.setId(3);
        catalogCount3.setAmount(50.00);
        catalogCount3.setCatalogcountenumid(enum3);
        catalogCount3.setRegistration(Instant.now().minus(Period.ofDays(1)));
        double expectedTotalForCatalogCount3 = 750.00;
        LocalDate expectedLocalDate3 = convertToGMTMinus07Zone(catalogCount3.getRegistration().getEpochSecond());

        List<CustomCatalogCount> catalogCounts = new ArrayList<>();
        catalogCounts.add(catalogCount1);
        catalogCounts.add(catalogCount3);
        catalogCounts.add(catalogCount2);
        int expectedRecordsSize = catalogCounts.size();

        when(catalogCountRepository.selectAllByBranch(anyInt())).thenReturn(catalogCounts);

        //todo: make sure which structure keeps order of the records
        List<CatalogCountResponse> actualResponse = catalogCountImpl.selectAllWithTotalColumn(0);

        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(expectedRecordsSize, actualResponse.size());
        Assertions.assertEquals(expectedTotalForCatalogCount1, actualResponse.get(0).getTotal());
        Assertions.assertEquals(catalogCount1.getId(), actualResponse.get(0).getId());
        Assertions.assertEquals(expectedLocalDate1.toString(), actualResponse.get(0).getRegistrationDate());

        Assertions.assertEquals(expectedTotalForCatalogCount3, actualResponse.get(1).getTotal());
        Assertions.assertEquals(catalogCount3.getId(), actualResponse.get(1).getId());
        Assertions.assertEquals(expectedLocalDate3.toString(), actualResponse.get(1).getRegistrationDate());

        Assertions.assertEquals(expectedTotalForCatalogCount2, actualResponse.get(2).getTotal());
        Assertions.assertEquals(catalogCount2.getId(), actualResponse.get(2).getId());
        Assertions.assertEquals(expectedLocalDate2.toString(), actualResponse.get(2).getRegistrationDate());
    }

    private LocalDate convertToGMTMinus07Zone(long epochSec) {
        ZoneId zoneId = ZoneId.of("-7");
        ZonedDateTime zonedDateTime = Instant.ofEpochSecond(epochSec).atZone(zoneId);
        return zonedDateTime.toLocalDate();
    }

    @Test
    void name() {
        long epochSec = 1624592577;
        Instant instant = Instant.ofEpochSecond(epochSec);
        System.out.println("UTC human date: " + instant);
        System.out.println("Epoch Milli: " + instant.toEpochMilli());

        ZoneId zoneId = ZoneId.of("-7");
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        System.out.println(zonedDateTime);
        System.out.println(zonedDateTime.toLocalDate());
    }

    @Test
    void testReturnCorrectEpochMilliToLocalDate() {
        long epochSec = 1624592577;
        String expectedLocalDate = "2021-06-24";

        LocalDate localDate =  convertToGMTMinus07Zone(epochSec);
        Assertions.assertEquals(expectedLocalDate, localDate.toString());

    }
}