package com.jtmc.apps.reforma.repository.mybatis.dbmapper.service;

import com.jtmc.apps.reforma.domain.Service;
import org.apache.ibatis.annotations.*;
import org.mybatis.guice.transactional.Transactional;

import java.time.Instant;
import java.time.LocalDate;

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

    @Transactional
    @Insert({"insert into service (date) values(#{date})"})
    void createService(LocalDate date);
}
