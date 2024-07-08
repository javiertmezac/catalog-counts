package com.jtmc.apps.reforma.api.v1.personadetails;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.PersonaDetails;
import com.jtmc.apps.reforma.impl.personadetails.PersonaDetailsImpl;

import jakarta.ws.rs.core.Response;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkNotNull;

@JwtRequired
public class PersonaDetailsApiImpl implements PersonaDetailsApi {

    @Inject
    private PersonaDetailsImpl implementation;

    @Override
    public PersonaDetailsResponseList selectAll() {
        List<PersonaDetails> list = implementation.select();
        Stream<PersonaDetailsResponse> streamResponseList = list.stream().map(x -> {
            PersonaDetailsResponse response = new PersonaDetailsResponse();
            response.setId(x.getId());
            response.setBranchId(x.getBranchid());
            response.setRoleId(x.getRoleid());
            response.setPersonaId(x.getPersonaid());
            return response;
        });
        PersonaDetailsResponseList responseList = new PersonaDetailsResponseList();
        responseList.setPersonas(streamResponseList.collect(Collectors.toList()));
        return responseList;
    }

    @Override
    public Response insert(PersonaDetailsRequest request) {
        checkNotNull(request, "Invalid personaDetails request");

        PersonaDetails persona = new PersonaDetails();
        persona.setBranchid(request.getBranchId());
        persona.setPersonaid(request.getPersonaId());
        persona.setRoleid(request.getRoleId());
        persona.setRegistration(Instant.now());

       implementation.insert(persona);
       return Response.noContent().build();
    }
}
