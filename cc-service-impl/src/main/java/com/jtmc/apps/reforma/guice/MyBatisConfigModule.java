package com.jtmc.apps.reforma.guice;

import com.google.inject.name.Names;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance.AttendanceMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.catalogcountenum.CatalogCountEnumMapper;
import com.jtmc.apps.reforma.api.v1.catalogcountenum.CatalogCountEnumMapperImpl;
import com.jtmc.apps.reforma.api.v1.catalogcountenum.ICatalogCountEnumService;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.catalogcount.CatalogCountMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.monthlytotal.MonthlyTotalMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.persona.PersonaMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.service.ServiceMapper;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.Properties;

public class MyBatisConfigModule extends MyBatisModule {
    private Logger Logger = LoggerFactory.getLogger(MyBatisModule.class);

    @Override
    protected void initialize() {
        bindDataSourceProviderType(PooledDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);

        addMapperClass(CatalogCountEnumMapper.class);
        addMapperClass(CatalogCountMapper.class);
        addMapperClass(MonthlyTotalMapper.class);
        addMapperClass(PersonaMapper.class);
        addMapperClass(AttendanceMapper.class);
        addMapperClass(ServiceMapper.class);

        Names.bindProperties(binder(), setMyBatisProperties());
        bind(ICatalogCountEnumService.class).to(CatalogCountEnumMapperImpl.class);

    }

    /*
        note: JDBC.url is used to set custom mysql-connector properties
        if helper is used: then JDBC properties can be set like:
            JDBC.host, JDBC.port, etc
            for this helper, JdbcHelper.MySQL should be installed.
     */
    //todo: consider serverTimezone property. server was configured with PDT
    private Properties setMyBatisProperties()  {

        final Properties myBatisProperties = new Properties();

        try {
            String systemEnv = getSystemEnvVariable();
//            Configuration config = propertiesConfiguration(systemEnv);

            Logger.info(System.getenv("JDBC.url"));

            myBatisProperties.setProperty("mybatis.environment.id", systemEnv);
            myBatisProperties.setProperty("JDBC.driver", "com.mysql.jdbc.Driver");
            myBatisProperties.setProperty("JDBC.url", System.getenv("JDBC_URL"));
            myBatisProperties.setProperty("JDBC.username", System.getenv("JDBC_USERNAME"));
            myBatisProperties.setProperty("JDBC.password", System.getenv("JDBC_PASSWORD"));


//            myBatisProperties.setProperty("JDBC.url", config.getString("JDBC.url"));
//            myBatisProperties.setProperty("JDBC.username", config.getString("JDBC.username"));
//            myBatisProperties.setProperty("JDBC.password", config.getString("JDBC.password"));

        } catch (Exception ex) {
            Logger.error("Couldn't set MyBatisProperties: ", ex);
        }

        return myBatisProperties;
    }

    private String getSystemEnvVariable() {
        String systemEnv = System.getenv("app_env");
        return  systemEnv == null ? "local" : systemEnv;
    }

    private Configuration propertiesConfiguration(String environment) throws ConfigurationException {
        String filePath = String.format("mybatis-config/%s-config.properties", environment);
        Configurations configurations = new Configurations();
       return configurations.properties(new File(getClass().getClassLoader().getResource(filePath).getFile()));
    }
}

