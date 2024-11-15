package com.jtmc.apps.reforma.infrastructure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jakarta.rs.json.JacksonJsonProvider;
import com.google.inject.AbstractModule;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.ICatalogCountRepository;

public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {

        ObjectMapper objectMapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModules(new JavaTimeModule());

        JacksonJsonProvider jsonProvider = new JacksonJsonProvider(objectMapper);

        bind(ObjectMapper.class).toInstance(objectMapper);
        bind(JacksonJsonProvider.class).toInstance(jsonProvider);
        bind(ICatalogCountRepository.class).to(CatalogCountRepository.class);
    }
}
