package com.jtmc.apps.reforma.repository.mybatis;

import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountMapper;
import com.jtmc.apps.reforma.repository.mapper.CustomCatalogCountMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CatalogCountRepositoryTest {

    @InjectMocks
    private CatalogCountRepository myBatisRepository;

    @Mock
    private CatalogCountMapper mapper;

    @Mock
    private SqlSessionFactory sqlSessionFactory;

    @Mock
    private SqlSession mockSqlSession;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        when(sqlSessionFactory.openSession()).thenReturn(mockSqlSession);
        when(mockSqlSession.getMapper(CatalogCountMapper.class)).thenReturn(mapper);
    }

    @Test
    void testInsert_shouldCall_myBatisInsertRepo() {
        when(sqlSessionFactory.openSession(true)).thenReturn(mockSqlSession);
        myBatisRepository.insert(new CatalogCount());
        verify(mapper).insert(any(CatalogCount.class));
    }

    @Test
    void selectAll() {
        CustomCatalogCountMapper mock = mock(CustomCatalogCountMapper.class);
        when(mockSqlSession.getMapper(CustomCatalogCountMapper.class)).thenReturn(mock);
        myBatisRepository.selectAllByBranch(0);
        verify(mock).selectMany(any(SelectStatementProvider.class));
    }

    @Test
    void logicalDelete() {
        int expectedValue = 9;
        CatalogCount cc = new CatalogCount();
        cc.setId(expectedValue);

        when(sqlSessionFactory.openSession(true)).thenReturn(mockSqlSession);
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