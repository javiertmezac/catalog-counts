package com.jtmc.apps.reforma.impl.catalogcount;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponse;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.exception.RepositoryException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Collection;
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
        CatalogCount catalogCount1 = new CatalogCount();
        catalogCount1.setAmount(500);
        catalogCount1.setCatalogCountEnumId(1);
        double expectedTotalForCatalogCount1 = 1500.50;

        CatalogCount catalogCount2 = new CatalogCount();
        catalogCount2.setAmount(300.50);
        catalogCount2.setCatalogCountEnumId(5);
        double expectedTotalForCatalogCount2 = 1200.00;

        List<CatalogCount> catalogCounts = new ArrayList<>();
        catalogCounts.add(catalogCount1);
        catalogCounts.add(catalogCount2);
        int expectedRecordsSize = catalogCounts.size();

        when(catalogCountRepository.selectAll()).thenReturn(catalogCounts);

        //todo: make sure which structure keeps order of the records
        List<CatalogCountResponse> actualResponse = catalogCountImpl.selectAllRecordsWithTotalColumn(initialTotal);

        Assertions.assertNotNull(actualResponse);
        Assertions.assertEquals(expectedRecordsSize, actualResponse.size());
        Assertions.assertEquals(expectedTotalForCatalogCount1, actualResponse.get(0).getTotal());
        Assertions.assertEquals(expectedTotalForCatalogCount2, actualResponse.get(1).getTotal());
    }



}