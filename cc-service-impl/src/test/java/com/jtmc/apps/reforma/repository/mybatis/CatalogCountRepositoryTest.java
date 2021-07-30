package com.jtmc.apps.reforma.repository.mybatis;

import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.exception.RepositoryException;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.catalogcount.CatalogCountMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;

class CatalogCountRepositoryTest {

    @InjectMocks
    private CatalogCountRepository myBatisRepository;

    @Mock
    private CatalogCountMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testInsert_shouldCall_myBatisInsertRepo() {
        myBatisRepository.insert(new CatalogCount());
        verify(mapper).insertIntoCatalogCount(any(CatalogCount.class));
    }

    @Test
    void testInsert_shouldThrowException_whenCatalogCountNull() {
        Assertions.assertThrows(RepositoryException.class, () -> myBatisRepository.insert(null));
        verifyNoInteractions(mapper);
    }

    @Test
    void selectAll() {
        myBatisRepository.selectAll();
        verify(mapper).selectAllRecords();
    }

    @Test
    void logicalDelete() {
        int expectedValue = 9;
        myBatisRepository.logicalDelete(expectedValue);
        verify(mapper).logicalDeleteRecord(expectedValue);
    }

    @Test
    void selectOneRecord() {
        int expectedValue = 4;
        myBatisRepository.selectOneRecord(expectedValue);
        verify(mapper).selectOneRecord(expectedValue);
    }

}