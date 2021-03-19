package com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance;

import com.jtmc.apps.reforma.domain.Persona;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface AttendanceMapper {

    @SelectProvider(
            type = AttendanceMapperProvider.class,
            method = "selectAttendanceByIdService"
    )
    @Results(value = {
            @Result(property = "name", column = "idService")
    })
    List<Persona> selectAttendanceByIdService();
}
