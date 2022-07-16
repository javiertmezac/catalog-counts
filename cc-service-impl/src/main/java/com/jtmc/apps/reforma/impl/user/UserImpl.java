package com.jtmc.apps.reforma.impl.user;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtUserClaim;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.impl.exception.ImplementationException;
import com.jtmc.apps.reforma.impl.exception.NoWritePermissionsException;
import com.jtmc.apps.reforma.repository.PersonaRepository;
import com.jtmc.apps.reforma.repository.UserRepositoryImpl;
import com.jtmc.apps.reforma.repository.exception.UnauthorizedUserException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.ForbiddenException;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class UserImpl {
    private Logger logger = LoggerFactory.getLogger(UserImpl.class);

    @Inject
    private JwtUserClaim userClaim;

    @Inject
    private UserRepositoryImpl userRepository;

    @Inject
    private PersonaRepository personaRepository;

    public UserDetails getLoggedInUserDetails() {
        checkNotNull(userClaim, "UserClaim Empty");
        checkArgument(StringUtils.isNotBlank(userClaim.getSubject()), "UserClaim not Valid");
        return selectUser(userClaim.getSubject());
    }

    private UserDetails selectUser(String username) {
        UserDetails userDetails = new UserDetails();

        Login loggedInUser = fetchLoggedInUser(username);
        userDetails.setUsername(username);

        Persona persona = fetchLoggedInPersona(loggedInUser);
        userDetails.setPersonaId(persona.getId());

        //todo: what to return when no role is assigned?
        Collection<PersonaDetails> personaDetails = userRepository.selectUserRoles(loggedInUser.getPersonaid());
        Stream<Integer> rolesId = personaDetails.stream().map(PersonaDetails::getRoleid);
        userDetails.setRoles(rolesId.collect(Collectors.toList()));

        //todo: for now default branch will be the first value
        // for sure I know only one row per user will be registered in persona_details
        // version 0.5.0
        Optional<PersonaDetails> selectingBranch = personaDetails.stream().findFirst();
        userDetails.setDefaultBranch(selectingBranch.isPresent() ? selectingBranch.get().getBranchid() : 0);
        return userDetails;
    }

    private Login fetchLoggedInUser(String username) {
        Optional<Login> loggedInUser = userRepository.selectLoggedInUser(username);
        if(!loggedInUser.isPresent()) {
            logger.error("Login registration for username {}, not found", username);
            throw new UnauthorizedUserException("No valid LoggedInUser", 401);
        }
        return loggedInUser.get();
    }

    private Persona fetchLoggedInPersona(Login loggedInUser) {
        Optional<Persona> persona = personaRepository.selectOne(loggedInUser.getPersonaid());
        if(!persona.isPresent()) {
            logger.error("No persona found (either no active or doesn't exist) " +
                    "for username {} and personaId {}", loggedInUser.getUsername(), loggedInUser.getPersonaid());
            throw new ImplementationException("No valid LoggedInUser", 400);
        }
        return persona.get();
    }

    //todo: these might me in "some permissions implementation class"
    public UserDetails validateWritePermissionsForLoggedInUser() {
        UserDetails userDetails = this.getLoggedInUserDetails();
        if (!userDetails.getRoles().contains(Roles.SECRETARY.getValue())) {
            logger.error("No write permissions for user {}", userDetails.getUsername());
            throw new NoWritePermissionsException("No write permissions for user", 401);
        }
        return userDetails;
    }

    public UserDetails validateAdminPermissionsForLoggedInUser() {
        UserDetails userDetails = this.getLoggedInUserDetails();
        if (!userDetails.getRoles().contains(Roles.SUPER_ADMIN.getValue())) {
            logger.error("No super_admin permissions for user {}", userDetails.getUsername());
            throw new ForbiddenException();
        }
        return userDetails;
    }
}

