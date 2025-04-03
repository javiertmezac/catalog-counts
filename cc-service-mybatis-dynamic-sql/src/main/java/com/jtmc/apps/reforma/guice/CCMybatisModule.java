package com.jtmc.apps.reforma.guice;

import com.google.inject.name.Names;
import com.jtmc.apps.reforma.repository.mapper.*;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class CCMybatisModule extends MyBatisModule {

    private final Logger logger = LoggerFactory.getLogger(CCMybatisModule.class);

    @Override
    protected void initialize() {
        bindDataSourceProviderType(PooledDataSourceProvider.class);
        bindTransactionFactoryType(JdbcTransactionFactory.class);

        addMapperClass(BranchMapper.class);
        addMapperClass(CatalogCountMapper.class);
        addMapperClass(CatalogCountEnumMapper.class);
        addMapperClass(LoginMapper.class);
        addMapperClass(PersonaMapper.class);
        addMapperClass(PersonaDetailsMapper.class);
        addMapperClass(RoleMapper.class);
        addMapperClass(PeriodMapper.class);
        addMapperClass(PeriodDetailsMapper.class);
        addMapperClass(ReportMapper.class);
        addMapperClass(TimezoneTypeMapper.class);
        addMapperClass(TransferRegistryMapper.class);
        addTypeHandlerClass(UuidTypeHandler.class);

        addMapperClass(CustomCatalogCountMapper.class);
        addMapperClass(CustomReportMapper.class);

        Names.bindProperties(binder(), setMyBatisProperties());
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

            myBatisProperties.setProperty("mybatis.environment.id", systemEnv);
            myBatisProperties.setProperty("JDBC.driver", "com.mysql.cj.jdbc.Driver");
            myBatisProperties.setProperty("JDBC.url", System.getenv("JDBC_URL"));
            myBatisProperties.setProperty("JDBC.username", System.getenv("JDBC_USERNAME"));
            myBatisProperties.setProperty("JDBC.password", System.getenv("JDBC_PASSWORD"));

        } catch (Exception ex) {
            logger.error("Couldn't set MyBatisProperties: ", ex);
        }

        return myBatisProperties;
    }

    private String getSystemEnvVariable() {
        String systemEnv = System.getenv("app_env");
        return  systemEnv == null ? "local" : systemEnv;
    }
}
