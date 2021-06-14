package com.jtmc.apps.reforma.impl.service;

import com.jtmc.apps.reforma.api.v1.persona.PersonaResponse;
import com.jtmc.apps.reforma.api.v1.service.Attendance;
import com.jtmc.apps.reforma.domain.Persona;

public class ServiceImpl {

    public Attendance populateAttendanceResponse(Persona p, boolean attended) {
        Attendance response = new Attendance();
        response.setPersona(convertToPersonaResponse(p));
        response.setAttended(attended);
        return  response;
    }

    public PersonaResponse convertToPersonaResponse(Persona p) {
        PersonaResponse personaResponse = new PersonaResponse();
        personaResponse.setId(p.getId());
        personaResponse.setCompleteName(
                String.format("%s %s", p.getName(), p.getLastname())
        );
        return personaResponse;
    }
}
