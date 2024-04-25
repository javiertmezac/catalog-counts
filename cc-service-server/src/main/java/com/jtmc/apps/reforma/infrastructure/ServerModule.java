package com.jtmc.apps.reforma.infrastructure;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.AbstractModule;
import com.jtmc.apps.reforma.guice.MyBatisConfigModule;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import com.jtmc.apps.reforma.repository.ICatalogCountRepository;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;

public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new MyBatisConfigModule());

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
