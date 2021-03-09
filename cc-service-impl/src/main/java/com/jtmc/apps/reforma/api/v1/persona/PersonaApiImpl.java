package com.jtmc.apps.reforma.api.v1.persona;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.impl.attendance.AttendanceImpl;

import java.util.ArrayList;
import java.util.List;

public class PersonaApiImpl implements PersonaApi {

    @Inject
    private AttendanceImpl attendanceImpl;

    @Override
    public PersonaResponseList selectPersonas() {
        List<Persona> personas = attendanceImpl.selectAllPersonas();
        List<PersonaResponse> personasResponse = new ArrayList<>();

        for (Persona p : personas) {
            PersonaResponse r = new PersonaResponse();
            r.setCompleteName(String.format("%s %s", p.getName(), p.getLastname()));
            r.setId(p.getId());
            personasResponse.add(r);
        }

        PersonaResponseList response = new PersonaResponseList();
        response.setPersonas(personasResponse);
        return response;
    }
}
