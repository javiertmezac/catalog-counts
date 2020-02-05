package com.jtmc.apps.reforma.repository;

import com.jtmc.apps.reforma.domain.CatalogCounts;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class CatalogCountsRepositoryTest {

    @InjectMocks
    private CatalogCountsRepository catalogCountsRepository;

    private CatalogCounts mockCatalogCount;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test (expected = Exception.class)
    public void saveNullRecord_ThrowsException() throws Exception {

        mockCatalogCount = null;
        catalogCountsRepository.saveNewRecord(mockCatalogCount);
    }

    @Test (expected = Exception.class)
    public void saveNewRecord_ThrowsException_WhenAmount_LessEqualsZero() throws Exception {
       mockCatalogCount = new CatalogCounts();
       mockCatalogCount.setAmount(0.0);
       catalogCountsRepository.saveNewRecord(mockCatalogCount);
    }

}