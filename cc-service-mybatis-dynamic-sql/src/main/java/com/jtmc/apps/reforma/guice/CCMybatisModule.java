package com.jtmc.apps.reforma.guice;

import com.jtmc.apps.reforma.repository.mapper.*;
import org.mybatis.guice.MyBatisModule;

public class CCMybatisModule extends MyBatisModule {
    @Override
    protected void initialize() {
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

        addMapperClass(CustomCatalogCountMapper.class);
        addMapperClass(CustomReportMapper.class);
    }
}
