package com.jtmc.apps.reforma.impl.service;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.persona.PersonaResponse;
import com.jtmc.apps.reforma.api.v1.service.Attendance;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.domain.Service;
import com.jtmc.apps.reforma.impl.exception.ImplementationException;
import com.jtmc.apps.reforma.impl.exception.ServiceNotFoundException;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.service.ServiceMapper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ServiceImpl {

    @Inject
    private ServiceMapper serviceMapper;

    public Attendance populateAttendanceResponse(Persona p, boolean attended) {
        Attendance response = new Attendance();
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

}
