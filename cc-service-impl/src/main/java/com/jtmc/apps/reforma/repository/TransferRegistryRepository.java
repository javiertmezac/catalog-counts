package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CustomTransferRegistry;
import com.jtmc.apps.reforma.domain.TransferRegistry;
import com.jtmc.apps.reforma.repository.mapper.CustomTransferRegistryMapper;
import com.jtmc.apps.reforma.repository.mapper.TransferRegistryDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.TransferRegistryMapper;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TransferRegistryRepository {

    @Inject
    private CustomTransferRegistryMapper mapper;

    public int insert(TransferRegistry registry) {
        return mapper.insert(registry);
    }

    public TransferRegistry findByFromAccountCatalogCountId(Integer catalogCountId) {
        var tr = mapper.selectOne(x -> x.where(TransferRegistryDynamicSqlSupport.fromaccountcatalogcountid, SqlBuilder.isEqualTo(catalogCountId))
                .and(TransferRegistryDynamicSqlSupport.inactivedate, SqlBuilder.isNull()));
        return tr.orElse(null);
    }

    public List<TransferRegistry> findAll() {
        SelectStatementProvider statementProvider = MyBatis3Utils.select(TransferRegistryMapper.selectList,
                TransferRegistryDynamicSqlSupport.transferRegistry,
                dsl -> dsl.where(TransferRegistryDynamicSqlSupport.inactivedate, SqlBuilder.isNull()));
        return mapper.selectMany(statementProvider);
    }


    public List<CustomTransferRegistry> findByAccount(Integer account) {
        return mapper.selectManyCustomTransferRegistry(account);
    }

    public void update(TransferRegistry byCatalogCountId) {
        mapper.updateByPrimaryKeySelective(byCatalogCountId);
    }

    public Optional<TransferRegistry> findById(UUID transferId) {
        return mapper.selectOne(x -> x.where(TransferRegistryDynamicSqlSupport.transferregistryid, SqlBuilder.isEqualTo(transferId)).and(TransferRegistryDynamicSqlSupport.inactivedate, SqlBuilder.isNull()));
    }
}
