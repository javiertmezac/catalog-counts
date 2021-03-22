package com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance;

import com.jtmc.apps.reforma.domain.Attendance;
import org.apache.ibatis.annotations.Param;
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
            @Result(property = "id", column = "attendanceId"),
            @Result(property = "attended", column = "attended"),
            @Result(property = "persona.id", column = "personaId"),
            @Result(property = "persona.name",column = "name"),
            @Result(property = "persona.lastname",column = "lastname")
    })
    List<Attendance> selectAttendanceByIdService(@Param("idService") int idService);
}
