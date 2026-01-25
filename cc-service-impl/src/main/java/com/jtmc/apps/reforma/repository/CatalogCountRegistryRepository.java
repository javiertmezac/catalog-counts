package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCountRegistry;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountRegistryMapper;

public class CatalogCountRegistryRepository {
    @Inject
    private CatalogCountRegistryMapper catalogCountRegistryMapper;

    public int insert(CatalogCountRegistry registry) {
        return catalogCountRegistryMapper.insertSelective(registry);
    }
}
