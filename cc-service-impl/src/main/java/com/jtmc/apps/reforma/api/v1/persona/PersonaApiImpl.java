package com.jtmc.apps.reforma.api.v1.persona;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.impl.persona.PersonaImpl;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@JwtRequired
public class PersonaApiImpl implements PersonaApi {

    @Inject
    private PersonaImpl implementation;

    @Override
    public PersonaResponseList selectAll() {
        List<Persona> personas = implementation.select();
        Stream<PersonaResponse> personaResponseStream = personas.stream().map(p -> {
            PersonaResponse r = new PersonaResponse();
            r.setCompleteName(String.format("%s %s", p.getName(), p.getLastname()));
            r.setId(p.getId());
            return r;
        });

        PersonaResponseList response = new PersonaResponseList();
        response.setPersonas(personaResponseStream.collect(Collectors.toList()));
        return response;
    }

    @Override
    public Response insert(PersonaRequest personaRequest) {
        checkNotNull(personaRequest, "Invalid persona request");
        checkArgument(StringUtils.isNotBlank(personaRequest.getName()),"Invalid Persona name");
        checkArgument(StringUtils.isNotBlank(personaRequest.getLastname()),"Invalid Persona lastname");

        Persona persona = new Persona();
        persona.setLastname(personaRequest.getLastname());
        persona.setName(personaRequest.getName());
        persona.setRegistration(Instant.now());

        implementation.insert(persona);
       return Response.noContent().build();
    }
}
