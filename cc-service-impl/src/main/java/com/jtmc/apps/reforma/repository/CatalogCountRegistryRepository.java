package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCountRegistry;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountRegistryDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountRegistryMapper;
import org.mybatis.dynamic.sql.SqlBuilder;

public class CatalogCountRegistryRepository {
    @Inject
    private CatalogCountRegistryMapper catalogCountRegistryMapper;

    public int insert(CatalogCountRegistry registry) {
        return catalogCountRegistryMapper.insertSelective(registry);
    }

    public CatalogCountRegistry findByCatalogCountIdAndInactiveIsNull(int catalogCountId) {
        return catalogCountRegistryMapper.selectOne(x -> x
                .where(CatalogCountRegistryDynamicSqlSupport.catalogcountid, SqlBuilder.isEqualTo(catalogCountId))
                .and(CatalogCountRegistryDynamicSqlSupport.inactivedate, SqlBuilder.isNull())).orElse(null);

    }
}
