package com.jtmc.apps.reforma.impl.user;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtUserClaim;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.impl.exception.ImplementationException;
import com.jtmc.apps.reforma.impl.exception.NoWritePermissionsException;
import com.jtmc.apps.reforma.impl.persona.PersonaImpl;
import com.jtmc.apps.reforma.repository.PersonaRepository;
import com.jtmc.apps.reforma.repository.RoleRepository;
import com.jtmc.apps.reforma.repository.UserRepositoryImpl;
import com.jtmc.apps.reforma.repository.exception.UnauthorizedUserException;
import org.apache.commons.lang3.StringUtils;
import org.apache.xmlbeans.impl.xb.ltgfmt.impl.FileDescImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.ws.rs.ForbiddenException;

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

    @Inject
    private RoleRepository roleRepository;

    @Inject
    private PersonaImpl personaImpl;

    public UserDetails getLoggedInUserDetails() {
        checkNotNull(userClaim, "UserClaim Empty");
        checkArgument(StringUtils.isNotBlank(userClaim.getSubject()), "UserClaim not Valid");
        return selectUser(userClaim.getSubject(), userClaim.getId());
    }

    private UserDetails selectUser(String username, int userId) {
        UserDetails userDetails = new UserDetails();

        Persona persona = personaImpl.selectOne(userId);

        userDetails.setPersonaId(persona.getId());
        userDetails.setUsername(username);

        //todo: what to return when no role is assigned?
        Collection<PersonaDetails> personaDetails = userRepository.selectUserRoles(userId);
        Stream<Integer> rolesId = personaDetails.stream().map(PersonaDetails::getRoleid);
        userDetails.setRoles(rolesId.collect(Collectors.toList()));

        Optional<Integer> firstRole = userDetails.getRoles().stream().findFirst();
        firstRole.ifPresent(integer -> userDetails.setDefaultRole(roleRepository.selectOne(integer).orElse(new Role())));

        Stream<Integer> branches = personaDetails.stream().map(PersonaDetails::getBranchid);
        userDetails.setBranches(branches.collect(Collectors.toList()));
        return userDetails;
    }

    //todo: these might me in "some permissions implementation class"
    public UserDetails validateWritePermissionsForLoggedInUser() {
        UserDetails userDetails = this.getLoggedInUserDetails();
        if (!userDetails.getRoles().contains(Roles.SECRETARY.getValue())) {
            logger.error("No write permissions for user {}", userDetails.getUsername());
            throw new NoWritePermissionsException("No write permissions for user", 403);
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

