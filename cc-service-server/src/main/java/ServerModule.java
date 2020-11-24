import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.google.inject.AbstractModule;
import com.jtmc.apps.reforma.guice.MyBatisConfigModule;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import com.jtmc.apps.reforma.repository.mybatis.MyBatisCatalogCountRepository;


public class ServerModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new MyBatisConfigModule());


        ObjectMapper objectMapper = new ObjectMapper()
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        JacksonJsonProvider jsonProvider = new JacksonJsonProvider(objectMapper);

        bind(ObjectMapper.class).toInstance(objectMapper);
        bind(JacksonJsonProvider.class).toInstance(jsonProvider);
        bind(CatalogCountImpl.class);
        bind(CatalogCountRepository.class).to(MyBatisCatalogCountRepository.class);
    }
}
