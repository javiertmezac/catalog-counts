package com.jtmc.apps.reforma.impl.service;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.persona.PersonaResponse;
import com.jtmc.apps.reforma.api.v1.service.AttendanceResponse;
import com.jtmc.apps.reforma.domain.Attendance;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.domain.Service;
import com.jtmc.apps.reforma.impl.exception.ServiceNotFoundException;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.attendance.AttendanceMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.persona.PersonaMapper;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.service.ServiceMapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class ServiceImpl {

    @Inject
    private ServiceMapper serviceMapper;

    @Inject
    private AttendanceMapper attendanceMapper;

    @Inject
    private PersonaMapper personaMapper;

    public AttendanceResponse populateAttendanceResponse(Persona p, boolean attended) {
        AttendanceResponse response = new AttendanceResponse();
        response.setPersona(convertToPersonaResponse(p));
        response.setAttended(attended);
        return  response;
    }

    private PersonaResponse convertToPersonaResponse(Persona p) {
        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.setId(p.getId());
        personaResponse.setCompleteName(
                String.format("%s %s", p.getName(), p.getLastname())
        );
        return personaResponse;
    }

    public void validateDateFormat(String date) throws ParseException {
        final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.parse(date);
    }

    public Service getServiceByDate(String date) {

        Service service = serviceMapper.getServiceByDate(date);
        if (service == null) {
            throw new ServiceNotFoundException("Service not found", 404);
        }
        return service;
    }

    public Collection<Attendance> getAttendanceListByServiceId(int idService) {
        //get/select all personas and set attendance false
        List<Persona> personas = personaMapper.selectAllPersonas();

        // get attendance where service and attendance true
        List<Attendance> attendances =
                attendanceMapper.selectWhereIdServiceAndAttendedTrue(idService);

        // for to loop and change persona attendance
        Stream<Persona> filteredPersonas = personas.stream().filter(persona ->
                attendances.stream().noneMatch(
                        attendance -> attendance.getPersona().getId() == persona.getId())
        );

        filteredPersonas.forEach(persona -> {
            Attendance attendance = new Attendance();
            attendance.setPersona(persona);
            attendance.setAttended(false);
            attendances.add(attendance);
        });
        return attendances;
    }
}
