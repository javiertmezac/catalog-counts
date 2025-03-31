package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.TransferRegistry;
import com.jtmc.apps.reforma.repository.mapper.TransferRegistryMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TransferRegistryRepository {
    @Inject
    private SqlSessionFactory sqlSessionFactory;

    @Inject
    private SqlSession sqlSession;

    public int insert(TransferRegistry registry) {
//        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
//
//        }
        TransferRegistryMapper mapper = sqlSession.getMapper(TransferRegistryMapper.class);
        return mapper.insert(registry);
    }
}
