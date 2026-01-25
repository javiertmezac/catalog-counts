package com.jtmc.apps.reforma.impl.catalogcount;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.CatalogCountRegistry;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.repository.CatalogCountRegistryRepository;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;

import java.util.UUID;

public class CatalogCountRegistryService {

    @Inject
    private CatalogCountRegistryRepository repository;

    @Inject
    private ObjectMapper mapper;

    public enum RegistryType {
        NEW,
        UPDATE,
        DELETE
    }

    public void insert (UserDetails userDetails, RegistryType registryType, CatalogCount old, CatalogCount newEntry) throws JsonProcessingException {
        CatalogCountRegistry catalogCountRegistry = switch (registryType) {
            case RegistryType.NEW -> {
                CatalogCountRegistry registry = new CatalogCountRegistry();
                registry.setBranchid(newEntry.getBranchid());
                registry.setRegistrytype(RegistryType.NEW.name());
                registry.setCatalogcountregistryid(UUID.randomUUID());
                registry.setEntrypersonid(userDetails.getPersonaId());

                String details = mapper.writeValueAsString(newEntry);
                registry.setDetails(details);
                yield registry;

            }
            case RegistryType.UPDATE -> {
                CatalogCountRegistry registry = new CatalogCountRegistry();
                registry.setBranchid(old.getBranchid());
                registry.setRegistrytype(RegistryType.UPDATE.name());
                registry.setCatalogcountregistryid(UUID.randomUUID());
                registry.setEntrypersonid(userDetails.getPersonaId());

                String details  = mapper.writeValueAsString(new CatalogCountRegistryUpdate(old, newEntry));
                registry.setDetails(details);
                yield registry;
            }
            case RegistryType.DELETE -> {
                CatalogCountRegistry registry = new CatalogCountRegistry();
                registry.setBranchid(old.getBranchid());
                registry.setRegistrytype(RegistryType.DELETE.name());
                registry.setCatalogcountregistryid(UUID.randomUUID());
                registry.setEntrypersonid(userDetails.getPersonaId());

                String details = mapper.writeValueAsString(old);
                registry.setDetails(details);
                yield registry;
            }
        };

        repository.insert(catalogCountRegistry);
    }

    public record CatalogCountRegistryUpdate(CatalogCount oldCatalogCount, CatalogCount newCatalogCount) {}
}
