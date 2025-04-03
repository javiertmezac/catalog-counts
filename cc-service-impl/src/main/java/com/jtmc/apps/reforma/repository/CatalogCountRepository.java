package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.CatalogCountCumulativeSumParams;
import com.jtmc.apps.reforma.domain.CustomCatalogCount;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountEnumDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountMapper;
import com.jtmc.apps.reforma.repository.mapper.CustomCatalogCountMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;

public class CatalogCountRepository implements ICatalogCountRepository {
    private final Logger logger = LoggerFactory.getLogger(CatalogCountRepository.class);

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    @Inject
    private CatalogCountMapper mapper;

    @Override
    public int insert(CatalogCount catalogCount) {
        return mapper.insert(catalogCount);
    }

    @Override
    public int update(CatalogCount catalogCount) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            CatalogCountMapper mapper = session.getMapper(CatalogCountMapper.class);
            return mapper.updateByPrimaryKeySelective(catalogCount);
        } catch (Exception ex) {
            logger.error("{}", ex);
            throw ex;
        }
    }

    public Collection<CustomCatalogCount> selectAllCumulativeSumByBranch(CatalogCountCumulativeSumParams params) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CustomCatalogCountMapper mapper = session.getMapper(CustomCatalogCountMapper.class);
            return mapper.selectManyDirect(params);
        }
    }

    public Collection<CustomCatalogCount> selectAllCumulativeSumByBranchAndPagination(CatalogCountCumulativeSumParams params) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CustomCatalogCountMapper mapper = session.getMapper(CustomCatalogCountMapper.class);
            return mapper.selectManyPagination(params);
        }
    }

    public long selectCountPagination(CatalogCountCumulativeSumParams params) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CustomCatalogCountMapper mapper = session.getMapper(CustomCatalogCountMapper.class);
            return mapper.selectManyPaginationCount(params);
        }
    }

    @Override
    public Collection<CustomCatalogCount> selectAllByBranch(Integer branchId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CustomCatalogCountMapper mapper = session.getMapper(CustomCatalogCountMapper.class);

            ArrayList<BasicColumn> list = new ArrayList<>(Arrays.asList(CatalogCountMapper.selectList));
            list.add(CatalogCountEnumDynamicSqlSupport.identifier);
            list.add(CatalogCountEnumDynamicSqlSupport.name);
            SelectStatementProvider statementProvider = MyBatis3Utils
                    .select(BasicColumn.columnList(list.toArray(new BasicColumn[0])), CatalogCountDynamicSqlSupport.catalogCount,
                            c -> c.join(CatalogCountEnumDynamicSqlSupport.catalogCountEnum)
                                    .on(CatalogCountDynamicSqlSupport.catalogcountenumid,
                                            SqlBuilder.equalTo(CatalogCountEnumDynamicSqlSupport.id))
                                    .where(CatalogCountDynamicSqlSupport.branchid, SqlBuilder.isEqualTo(branchId))
                                    .and(CatalogCountDynamicSqlSupport.isdeleted, SqlBuilder.isFalse())
                                    .orderBy(CatalogCountDynamicSqlSupport.registration ));
            return mapper.selectMany(statementProvider);
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
