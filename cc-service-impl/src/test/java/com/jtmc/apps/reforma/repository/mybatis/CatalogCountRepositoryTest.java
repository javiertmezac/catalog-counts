package com.jtmc.apps.reforma.repository.mybatis;

import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.exception.RepositoryException;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;

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
        verify(mapper).insert(any(CatalogCount.class));
    }

    @Test
    void testInsert_shouldThrowException_whenCatalogCountNull() {
        Assertions.assertThrows(RepositoryException.class, () -> myBatisRepository.insert(null));
        verifyNoInteractions(mapper);
    }

    @Test
    void selectAll() {
        myBatisRepository.selectAllByBranch(0);
        verify(mapper).select(SelectDSLCompleter.allRows());
    }

    @Test
    void logicalDelete() {
        int expectedValue = 9;
        CatalogCount cc = new CatalogCount();
        cc.setId(expectedValue);
        myBatisRepository.logicalDelete(cc);
        verify(mapper).updateByPrimaryKeySelective(cc);
    }

    @Test
    void selectOneRecord() {
        int expectedValue = 4;
        myBatisRepository.selectOneRecord(expectedValue);
        verify(mapper).selectByPrimaryKey(expectedValue);
    }

}