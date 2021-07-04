package com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance;

import com.jtmc.apps.reforma.domain.Attendance;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AttendanceMapper {

    @SelectProvider(
            type = AttendanceMapperProvider.class,
            method = "attendanceInnerJoinPersonaByIdService"
    )
    @Results(value = {
            @Result(property = "id", column = "attendanceId"),
            @Result(property = "attended", column = "attended"),
            @Result(property = "persona.id", column = "personaId"),
            @Result(property = "persona.name",column = "name"),
            @Result(property = "persona.lastname",column = "lastname")
    })
    List<Attendance> selectAttendanceInnerJoindPersonaByIdService(@Param("idService") int idService);

    @SelectProvider(
            type = AttendanceMapperProvider.class,
            method = "selectAttendanceListWhereServiceIdAndAttendedTrue"
    )
    @Results(value = {
            @Result(property = "id", column = "attendanceId"),
            @Result(property = "attended", column = "attended"),
            @Result(property = "persona.id", column = "personaId"),
            @Result(property = "persona.name",column = "name"),
            @Result(property = "persona.lastname",column = "lastname")
    })
    List<Attendance> selectWhereIdServiceAndAttendedTrue(@Param("idService") int idService);


    @InsertProvider(
            type = AttendanceMapperProvider.class,
            method = "saveAttendance"
    )
    void saveAttendances(@Param("serviceId") int serviceId,
                         @Param("attendance") Attendance attendance);

    @UpdateProvider(
            type = AttendanceMapperProvider.class,
            method = "updateAttendance"
    )
    void updateAttendances(@Param("serviceId") int serviceId,
                           @Param("attendance") Attendance attendance);

    @Insert("INSERT INTO attendance(idService, idPersona, attended) " +
            "VALUES(#{serviceId},#{attendance.persona.id},#{attendance.attended}) " +
            "ON DUPLICATE KEY UPDATE attended=VALUES(attendance.attended);")
    void upsertAttendance(@Param("serviceId") int serviceId,
                          @Param("attendance") Attendance attendance);
}
