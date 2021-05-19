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

    @Inject
    private ServiceImpl serviceImpl;

    @Inject
    private PersonaMapper personaMapper;

    @Override
    public ServiceResponse createService(ServiceRequest request) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String format = formatter.format(request.getDate());
            serviceMapper.createService(format);
            Service service = serviceMapper.getServiceByDate(format);

            ServiceResponse response = new ServiceResponse();
            response.setId(service.getId());
            return response;
        } catch (Exception ex) {
            throw new WebApplicationException(Response.Status.BAD_REQUEST);
        }
    }

    @Override
    public ServiceResponse getServiceByDate(String dateParam) {

        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(dateParam);
            Service service = serviceMapper.getServiceByDate(dateParam);

            if (service == null) {
                GenericResponseErrorMessage errorMessage =
                        new GenericResponseErrorMessage(
                                400,
                                "Service not Found",
                                "ServiceNotFoundMessage"
                        );
                throw new WebApplicationException(
                        Response.status(errorMessage.getStatus()).entity(errorMessage).build()
                );
            }

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
           attendancesResponse.add(serviceImpl.populateAttendanceResponse(a.getPersona(), a.isAttended()));
        }

        if (attendancesResponse.size() == 0) {
            List<Persona> personas = personaMapper.selectAllPersonas();
            for (Persona p: personas) {
                attendancesResponse.add(serviceImpl.populateAttendanceResponse(p, false));
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
