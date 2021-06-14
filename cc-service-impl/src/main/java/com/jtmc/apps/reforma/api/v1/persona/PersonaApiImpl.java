package com.jtmc.apps.reforma.api.v1.persona;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.persona.PersonaMapper;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

public class PersonaApiImpl implements PersonaApi {

    @Inject
    private PersonaMapper personaMapper;

    @Override
    public PersonaResponseList selectPersonas() {
        List<Persona> personas = personaMapper.selectAllPersonas();
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

    @Override
    public Response insertPersona(PersonaRequest personaRequest) {

        Persona persona = new Persona();
        persona.setLastname(personaRequest.getLastname());
        persona.setName(personaRequest.getName());

        personaMapper.insertPersona(persona);
       return Response.ok().build();
    }
}
