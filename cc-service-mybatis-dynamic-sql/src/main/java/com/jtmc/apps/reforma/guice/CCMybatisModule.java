package com.jtmc.apps.reforma.guice;

import com.jtmc.apps.reforma.repository.mapper.*;
import org.mybatis.guice.MyBatisModule;

public class CCMybatisModule extends MyBatisModule {
    @Override
    protected void initialize() {
//        Properties myBatisProperties = new Properties();
//        myBatisProperties.setProperty("mybatis.environment.id", "test");
//        myBatisProperties.setProperty("JDBC.host", System.getenv("JDBC_HOST"));
//        myBatisProperties.setProperty("JDBC.port", System.getenv("JDBC_PORT"));
//        myBatisProperties.setProperty("JDBC.schema", System.getenv("JDBC_SCHEMA"));
//        myBatisProperties.setProperty("JDBC.username", System.getenv("JDBC_USER"));
//        myBatisProperties.setProperty("JDBC.password", System.getenv("JDBC_PASSWORD"));
//        myBatisProperties.setProperty("JDBC.autoCommit", "false");
//
//        bindDataSourceProviderType(PooledDataSourceProvider.class);
//        bindTransactionFactoryType(JdbcTransactionFactory.class);
//
//        Names.bindProperties(binder(), myBatisProperties);

        addMapperClass(BranchMapper.class);
        addMapperClass(CatalogCountMapper.class);
        addMapperClass(CatalogCountEnumMapper.class);
        addMapperClass(LoginMapper.class);
        addMapperClass(PersonaMapper.class);
        addMapperClass(PersonaDetailsMapper.class);
        addMapperClass(RoleMapper.class);
        addMapperClass(PeriodMapper.class);
        addMapperClass(PeriodDetailsMapper.class);

        addMapperClass(CustomCatalogCountMapper.class);
    }
}
