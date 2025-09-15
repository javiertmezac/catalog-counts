package com.jtmc.apps.reforma.api.v1.persona;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.domain.PersonaDetails;
import com.jtmc.apps.reforma.impl.persona.PersonaImpl;
import com.jtmc.apps.reforma.impl.personadetails.PersonaDetailsImpl;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import jakarta.ws.rs.BadRequestException;
import jakarta.ws.rs.core.Response;
import org.apache.commons.lang3.StringUtils;

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

    @Inject
    private PersonaDetailsImpl personaDetailsImpl;

    @Inject
    private UserImpl user;

    @Override
    public PersonaResponseList selectAll() {
        List<Persona> personas = implementation.select();
        Stream<PersonaResponse> personaResponseStream = personas.stream().map(this::mapToPersonaResponse);

        PersonaResponseList response = new PersonaResponseList();
        response.setPersonas(personaResponseStream.collect(Collectors.toList()));
        return response;
    }

    private PersonaResponse mapToPersonaResponse(Persona p) {
        PersonaResponse r = new PersonaResponse();
        r.setName(p.getName());
        r.setLastname(p.getLastname());
        r.setId(p.getId());
        r.setRegistration(p.getRegistration().toString());
        r.setStatus(p.getStatus());
        return r;
    }

    @Override
    public PersonaResponse selectOne(int personaId) {
        Persona persona = implementation.selectOne(personaId);
        return mapToPersonaResponse(persona);
    }

    @Override
    public PersonaResponse personaDetails(int personaId) {
        Persona persona = implementation.selectOne(personaId);
        List<PersonaRequest.BranchAndRole> details = personaDetailsImpl.findByPersonaId(personaId).stream().map(x -> {
            PersonaRequest.BranchAndRole bar = new PersonaRequest.BranchAndRole();
            bar.branchId = x.getBranchid();
            bar.roleId = x.getRoleid();
            bar.entryDate = x.getRegistration().toString();
            return bar;
        }).toList();
        PersonaResponse r = mapToPersonaResponse(persona);
        r.setBranchesAndRoles(details);
        return r;
    }

    @Override
    public Response insert(PersonaRequest personaRequest) {
        validatePersonaRequest(personaRequest);

        Persona persona = new Persona();
        persona.setLastname(personaRequest.getLastname());
        persona.setName(personaRequest.getName());
        persona.setRegistration(Instant.now());

        implementation.insert(persona);
       return Response.noContent().build();
    }

    private void validatePersonaRequest(PersonaRequest personaRequest) {
        checkNotNull(personaRequest, "Invalid persona request");
        checkArgument(StringUtils.isNotBlank(personaRequest.getName()),"Invalid Persona name");
        checkArgument(StringUtils.isNotBlank(personaRequest.getLastname()),"Invalid Persona lastname");
    }

    @Override
    public Response update(int personaId, PersonaRequest personaRequest) {
        validatePersonaRequest(personaRequest);

        Persona persona = new Persona();
        persona.setId(personaId);
        persona.setLastname(personaRequest.getLastname());
        persona.setName(personaRequest.getName());
        persona.setStatus(personaRequest.isStatus());

        implementation.update(persona);
        return Response.noContent().build();
    }

    @Override
    public Response assignBranchAndRole(int personaId, PersonaRequest.BranchAndRole request) {
        user.validateAdminPermissionsForLoggedInUser();

        Persona persona = implementation.selectOne(personaId);
        if (!persona.getId().equals(personaId)) {
            throw new BadRequestException();
        }

        PersonaDetails details = new PersonaDetails();
        details.setPersonaid(persona.getId());
        details.setRegistration(Instant.now());
        details.setBranchid(request.branchId);
        details.setRoleid(request.roleId);
        personaDetailsImpl.insert(details);
        return Response.noContent().build();
    }
}
