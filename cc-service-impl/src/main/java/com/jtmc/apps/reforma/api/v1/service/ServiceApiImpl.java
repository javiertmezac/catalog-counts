package com.jtmc.apps.reforma.api.v1.service;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.persona.PersonaResponse;
import com.jtmc.apps.reforma.domain.Attendance;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance.AttendanceMapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceApiImpl implements ServiceApi{

    @Inject
    private AttendanceMapper attendanceMapper;

    @Override
    public Response createService(ServiceRequest request) {
        return null;
    }

    @Override
    public Response getServiceByDate(String dateParam) {

        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(dateParam);
        } catch (ParseException e) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("Couldn't parse date string: " + e.getMessage())
                    .build());
        }
        return null;
    }

    @Override
    public AttendanceResponse getAttendanceList(int idService) {
        List<Attendance> attendances = attendanceMapper.selectAttendanceByIdService(idService);
        List<com.jtmc.apps.reforma.api.v1.service.Attendance> attendancesResponse =
                new ArrayList<>();
        for (Attendance a : attendances) {
            PersonaResponse p = new PersonaResponse();
            p.setId(a.getPersona().getId());
            p.setCompleteName(
                    String.format("%s %s", a.getPersona().getName(), a.getPersona().getLastname())
            );
            com.jtmc.apps.reforma.api.v1.service.Attendance response =
                    new com.jtmc.apps.reforma.api.v1.service.Attendance();
            response.setPersona(p);
            response.setAttended(a.isAttended());
           attendancesResponse.add(response);
        }
       AttendanceResponse actualResponse = new AttendanceResponse();
        actualResponse.setAttendanceList(attendancesResponse);
        return actualResponse;
    }

    @Override
    public Response saveAttendanceList(int idService, AttendanceRequest request) {
        return null;
    }
}
