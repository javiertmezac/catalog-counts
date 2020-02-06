package com.jtmc.apps.reforma.repository;

import com.jtmc.apps.reforma.domain.CatalogCounts;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CatalogCountsStoreInJsonRepositoryTest {

    @InjectMocks
    private CatalogCountsStoreInJsonRepository storeInJsonRepository;

    @Mock
    private CatalogCounts mockCatalogCounts;

    public CatalogCountsStoreInJsonRepositoryTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test (expected = Exception.class)
    public void save_TrowsException_WhenNullObject() throws Exception {
        storeInJsonRepository.saveCatalogCounts(null);
    }

}