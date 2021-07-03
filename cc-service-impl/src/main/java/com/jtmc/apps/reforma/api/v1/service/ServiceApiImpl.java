package com.jtmc.apps.reforma.api.v1.service;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.exception.GenericResponseErrorMessage;
import com.jtmc.apps.reforma.api.v1.persona.PersonaResponse;
import com.jtmc.apps.reforma.domain.Attendance;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.domain.Service;
import com.jtmc.apps.reforma.impl.service.ServiceImpl;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance.AttendanceMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.persona.PersonaMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.service.ServiceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.TemporalField;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServiceApiImpl implements ServiceApi {

    private Logger logger = LoggerFactory.getLogger(ServiceApiImpl.class);

    @Inject
    private AttendanceMapper attendanceMapper;

    @Inject
    private ServiceMapper serviceMapper;

    @Inject
    private ServiceImpl serviceImpl;

    @Inject
    private PersonaMapper personaMapper;

    @Override
    public ServiceResponse createService(ServiceRequest request) {

        validateDateFormat(request.getDate());

        serviceMapper.createService(request.getDate());
        Service service = serviceImpl.getServiceByDate(request.getDate());

        ServiceResponse response = new ServiceResponse();
        response.setId(service.getId());
        return response;
    }

    @Override
    public ServiceResponse getServiceByDate(String dateParam) {

        validateDateFormat(dateParam);

        Service service = serviceImpl.getServiceByDate(dateParam);

        ServiceResponse response = new ServiceResponse();
        response.setId(service.getId());
        return response;
    }

    private void validateDateFormat(String dateParam) {
        try {
            serviceImpl.validateDateFormat(dateParam);
        } catch (ParseException e) {
            throw new WebApplicationException(e.getMessage(), Response.Status.BAD_REQUEST);
        }
    }

    @Override
    public AttendanceResponse getAttendanceList(int idService) {
        /*
          todo:
           fix error:
             after attendanceList is created, new members are not added into the list
             as new members are picked from personaMapper and not from
             attendanceMapper.
         */
        List<Attendance> attendances = attendanceMapper.selectAttendanceByIdService(idService);
        List<com.jtmc.apps.reforma.api.v1.service.Attendance> attendancesResponse =
                new ArrayList<>();
        for (Attendance a : attendances) {
           attendancesResponse.add(
                   serviceImpl.populateAttendanceResponse(a.getPersona(), a.isAttended())
           );
        }

        if (attendancesResponse.size() == 0) {
            List<Persona> personas = personaMapper.selectAllPersonas();
            for (Persona p: personas) {
                attendancesResponse.add(
                        serviceImpl.populateAttendanceResponse(p, false)
                );
            }
        }

       AttendanceResponse actualResponse = new AttendanceResponse();
        actualResponse.setAttendanceList(attendancesResponse);
        return actualResponse;
    }

    @Override
    public Response saveAttendanceList(int serviceId, AttendanceRequest request) {

        Service service = serviceMapper.getServiceById(serviceId);

        if(service == null) {
            throw new WebApplicationException(Response.status(Response.Status.BAD_REQUEST).build());
        }

        for (com.jtmc.apps.reforma.api.v1.service.Attendance a: request.getAttendanceList()) {

            Persona p = new Persona();
            p.setId(a.getPersona().getId());

            Attendance attendance = new Attendance();
            attendance.setAttended(a.isAttended());
            attendance.setPersona(p);

            attendanceMapper.upsertAttendance(serviceId, attendance);
        }
        return Response.noContent().build();
    }
}
