package com.jtmc.apps.reforma.repository.mybatis.dbmapper.service;

import com.jtmc.apps.reforma.domain.Service;
import org.apache.ibatis.annotations.*;

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

    //todo: problems getting last insert_id
    @Insert({"insert into service (date) values(#{date})"})
    void createService(String date);
}
