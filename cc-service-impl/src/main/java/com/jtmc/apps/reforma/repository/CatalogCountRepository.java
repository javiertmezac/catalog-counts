package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.Collection;
import java.util.Optional;


public class CatalogCountRepository implements ICatalogCountRepository {

    @Inject
    SqlSessionFactory sqlSessionFactory;

    @Override
    public int insert(CatalogCount catalogCount) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            CatalogCountMapper mapper = session.getMapper(CatalogCountMapper.class);
            return mapper.insert(catalogCount);
        }
    }

    @Override
    public Collection<CatalogCount> selectAllByBranch(Integer branchId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CatalogCountMapper mapper = session.getMapper(CatalogCountMapper.class);
            return mapper.select(c -> c.where(CatalogCountDynamicSqlSupport.branchid, SqlBuilder.isEqualTo(branchId)));
        }
    }

    @Override
    public int logicalDelete(CatalogCount catalogCount) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            CatalogCountMapper mapper = session.getMapper(CatalogCountMapper.class);
            catalogCount.setIsdeleted(true);
            return mapper.updateByPrimaryKeySelective(catalogCount);
        }
    }

    @Override
    public Optional<CatalogCount> selectOneRecord(Integer catalogCountId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CatalogCountMapper mapper = session.getMapper(CatalogCountMapper.class);
            return mapper.selectByPrimaryKey(catalogCountId);
        }
    }
}
