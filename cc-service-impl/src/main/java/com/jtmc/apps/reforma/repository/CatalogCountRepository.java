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
            return mapper.select(c -> c.where(CatalogCountDynamicSqlSupport.branchid, SqlBuilder.isEqualTo(branchId))
                    .and(CatalogCountDynamicSqlSupport.isdeleted, SqlBuilder.isFalse()).orderBy(CatalogCountDynamicSqlSupport.registration)
            );
        }
    }


//    public String selectAllCatalogCountRecordsSql () {
//        return new SQL()
//                .SELECT("cc.id as ccId , cc.registrationDate as ccRegistrationDate, cc.amount as ccAmount, " +
//                        "cc.details as ccDetails, cc.isDeleted as ccIsDeleted, cce.id as cceId, " +
//                        "cce.identifier as cceIdentifier, cce.name as cceName")
//                .FROM(tableName + " as cc ")
//                .INNER_JOIN("catalog_count_enum as cce on cc.catalogCountEnumId = cce.id")
//                .WHERE("cc.isDeleted = false")
//                .ORDER_BY("registrationDate asc")
//                .toString();
//    }

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
