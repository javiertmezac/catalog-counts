package com.jtmc.apps.reforma.api.v1.service;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.persona.PersonaResponse;
import com.jtmc.apps.reforma.domain.Attendance;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.domain.Service;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance.AttendanceMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.service.ServiceMapper;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceApiImpl implements ServiceApi {

    @Inject
    private AttendanceMapper attendanceMapper;

    @Inject
    private ServiceMapper serviceMapper;

    @Override
    public Response createService(ServiceRequest request) {
        return null;
    }

    @Override
    public ServiceResponse getServiceByDate(String dateParam) {

        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(dateParam);
            Service service = serviceMapper.getServiceByDate(dateParam);
            ServiceResponse response = new ServiceResponse();
            response.setId(service.getId());
            return response;
        } catch (ParseException e) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST)
                    .entity("Couldn't parse date string: " + e.getMessage())
                    .build());
        }
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
            response.setId(a.getId());
           attendancesResponse.add(response);
        }
       AttendanceResponse actualResponse = new AttendanceResponse();
        actualResponse.setAttendanceList(attendancesResponse);
        return actualResponse;
    }

    @Override
    public Response saveAttendanceList(int serviceId, AttendanceRequest request) {

        // verify service Exist
        Service service = serviceMapper.getServiceById(serviceId);

        if(service == null) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).build());
        }

        //todo
        // change insert/update approach
        // to have a combined kwy of idService and idPersona
        // and find a way to upsert in ibatis?

        //convert
        for (com.jtmc.apps.reforma.api.v1.service.Attendance a: request.getAttendanceList()) {

            Persona p = new Persona();
            p.setId(a.getPersona().getId());

            Attendance attendance = new Attendance();
            attendance.setId(a.getId());
            attendance.setAttended(a.isAttended());
            attendance.setPersona(p);

            int firstInsertion = 0;
            if (a.getId() != firstInsertion) {
                attendanceMapper.updateAttendances(serviceId, attendance);
            } else {
                attendanceMapper.saveAttendances(serviceId, attendance);
            }
        }
        return Response.noContent().build();
    }
}
