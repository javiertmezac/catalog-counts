package com.jtmc.apps.reforma.guice;

import com.google.inject.name.Names;
import com.jtmc.apps.reforma.repository.CatalogCountEnumRepository;
import com.jtmc.apps.reforma.repository.ICatalogCountEnumRepository;
import com.jtmc.apps.reforma.repository.mapper.*;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance.AttendanceMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.auditreport.AuditReportMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.monthlytotal.MonthlyTotalMapper;
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

        addMapperClass(MonthlyTotalMapper.class);
        addMapperClass(AttendanceMapper.class);
        addMapperClass(ServiceMapper.class);
        addMapperClass(AuditReportMapper.class);

//        addMapperClass(BranchMapper.class);
//        addMapperClass(CatalogCountMapper.class);
//        addMapperClass(CatalogCountEnumMapper.class);
//        addMapperClass(LoginMapper.class);
//        addMapperClass(PersonaMapper.class);
//        addMapperClass(PersonaDetailsMapper.class);
//        addMapperClass(RoleMapper.class);

        Names.bindProperties(binder(), setMyBatisProperties());
        bind(ICatalogCountEnumRepository.class).to(CatalogCountEnumRepository.class);

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

            Logger.info(System.getenv("JDBC.url"));

            myBatisProperties.setProperty("mybatis.environment.id", systemEnv);
            myBatisProperties.setProperty("JDBC.driver", "com.mysql.cj.jdbc.Driver");
            myBatisProperties.setProperty("JDBC.url", System.getenv("JDBC_URL"));
            myBatisProperties.setProperty("JDBC.username", System.getenv("JDBC_USERNAME"));
            myBatisProperties.setProperty("JDBC.password", System.getenv("JDBC_PASSWORD"));

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

