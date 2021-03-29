package com.jtmc.apps.reforma.repository.mybatis.dbmapper.service;

import com.jtmc.apps.reforma.domain.Service;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

public interface ServiceMapper {

    @SelectProvider(
            type = ServiceMapperProvider.class,
            method = "getServiceByDate"
    )
    Service getServiceByDate(@Param("date") String date);

    @SelectProvider(
            type = ServiceMapperProvider.class,
            method = "getServiceById"
    )
    Service getServiceById(int serviceId);
}
