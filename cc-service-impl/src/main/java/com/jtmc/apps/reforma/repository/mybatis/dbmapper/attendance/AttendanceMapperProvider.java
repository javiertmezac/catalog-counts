package com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance;

import org.apache.ibatis.jdbc.SQL;

public class AttendanceMapperProvider {
    private String tableName = "attendance";

    public String attendanceInnerJoinPersonaWhereIdServiceAndAttended() {
        return new SQL()
                .SELECT("p.id as personaId, p.name, p.lastname, a.attended")
                .FROM("attendance as a")
                .INNER_JOIN("persona as p on p.id = a.idPersona")
                .WHERE("idService = #{idService}")
                .AND()
                .WHERE("attended = true")
                .toString();
    }

    public String saveAttendance() {
        return new SQL()
                .INSERT_INTO(tableName)
                .INTO_COLUMNS("idService, idPersona, attended")
                .INTO_VALUES("#{serviceId}, #{attendance.persona.id}, #{attendance.attended}")
                .toString();
    }

    public String updateAttendance() {
        return new SQL()
                .UPDATE(tableName)
                .SET("attended = #{attendance.attended}")
                .WHERE("idService = #{serviceId}")
                .AND()
                .WHERE("idPersona = #{attendance.persona.id}")
                .toString();
    }
}
