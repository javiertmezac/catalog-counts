package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.TransferRegistry;
import com.jtmc.apps.reforma.repository.mapper.TransferRegistryMapper;

public class TransferRegistryRepository {

    @Inject
    private TransferRegistryMapper mapper;

    public int insert(TransferRegistry registry) {
        return mapper.insert(registry);
    }
}
