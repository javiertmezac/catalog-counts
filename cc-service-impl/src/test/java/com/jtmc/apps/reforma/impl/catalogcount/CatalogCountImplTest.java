package com.jtmc.apps.reforma.impl.catalogcount;

import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponse;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.exception.RepositoryException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.Instant;
import java.time.Period;
import java.time.temporal.TemporalAmount;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CatalogCountImplTest {

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
       catalogCountImpl.selectAllRecordsWithTotalColumn(expectedTotal);
       verify(catalogCountRepository).selectAll();
    }

    @Test
    void testSelectAllRecords_shouldPropagateException() {

        when(catalogCountRepository.selectAll()).thenThrow(RepositoryException.class);

        RepositoryException actualException = Assertions.assertThrows(RepositoryException.class,
                () -> catalogCountRepository.selectAll());

        Assertions.assertNotNull(actualException);
    }

    @Test
    void testSelectAllRecords_returnsCorrectList_withCorrectTotalColumn() {
        double initialTotal = 1000.50;
        //todo: easyRandom
        CatalogCountEnum enum1 = new CatalogCountEnum();
        enum1.setId(1);

        CatalogCount catalogCount1 = new CatalogCount();
        catalogCount1.setId(1);
        catalogCount1.setAmount(500);
        catalogCount1.setCatalogCountEnum(enum1);
        catalogCount1.setRegistrationDate(Instant.now());
        double expectedTotalForCatalogCount1 = 1250.00;

        CatalogCountEnum enum2 = new CatalogCountEnum();
        enum2.setId(5);

        CatalogCount catalogCount2 = new CatalogCount();
        catalogCount2.setId(2);
        catalogCount2.setAmount(300.50);
        catalogCount2.setCatalogCountEnum(enum2);
        catalogCount2.setRegistrationDate(Instant.now().minus(Period.ofDays(3)));
        double expectedTotalForCatalogCount2 = 700.00;


        CatalogCountEnum enum3 = new CatalogCountEnum();
        enum3.setId(3);

        CatalogCount catalogCount3 = new CatalogCount();
        catalogCount3.setId(3);
        catalogCount3.setAmount(50);
        catalogCount3.setCatalogCountEnum(enum3);
        catalogCount3.setRegistrationDate(Instant.now().minus(Period.ofDays(1)));
        double expectedTotalForCatalogCount3 = 750.00;

        List<CatalogCount> catalogCounts = new ArrayList<>();
        catalogCounts.add(catalogCount1);
        catalogCounts.add(catalogCount3);
        catalogCounts.add(catalogCount2);
        int expectedRecordsSize = catalogCounts.size();

        when(catalogCountRepository.selectAll()).thenReturn(catalogCounts);

        //todo: make sure which structure keeps order of the records
        List<CatalogCountResponse> actualResponse = catalogCountImpl.selectAllRecordsWithTotalColumn(initialTotal);

        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(expectedRecordsSize, actualResponse.size());
        Assertions.assertEquals(expectedTotalForCatalogCount1, actualResponse.get(0).getTotal());
        Assertions.assertEquals(catalogCount1.getId(), actualResponse.get(0).getId());

        Assertions.assertEquals(expectedTotalForCatalogCount3, actualResponse.get(1).getTotal());
        Assertions.assertEquals(catalogCount3.getId(), actualResponse.get(1).getId());

        Assertions.assertEquals(expectedTotalForCatalogCount2, actualResponse.get(2).getTotal());
        Assertions.assertEquals(catalogCount2.getId(), actualResponse.get(2).getId());
    }
}