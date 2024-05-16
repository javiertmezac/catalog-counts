package com.jtmc.apps.reforma.guice;

import com.google.inject.name.Names;
import com.jtmc.apps.reforma.repository.CatalogCountEnumRepository;
import com.jtmc.apps.reforma.repository.ICatalogCountEnumRepository;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance.AttendanceMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.monthlytotal.MonthlyTotalMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.service.ServiceMapper;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
}

