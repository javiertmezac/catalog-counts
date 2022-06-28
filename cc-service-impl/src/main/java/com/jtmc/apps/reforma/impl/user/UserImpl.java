package com.jtmc.apps.reforma.impl.user;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtUserClaim;
import com.jtmc.apps.reforma.domain.Roles;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.impl.exception.NoWritePermissionsException;
import com.jtmc.apps.reforma.repository.UserRepositoryImpl;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

public class UserImpl {
    private Logger logger = LoggerFactory.getLogger(UserImpl.class);

    @Inject
    private JwtUserClaim userClaim;

    @Inject
    private UserRepositoryImpl userRepository;

    public UserDetails getLoggedInUserDetails() {
        checkNotNull(userClaim, "UserClaim Empty");
        checkArgument(StringUtils.isNotBlank(userClaim.getSubject()), "UserClaim not Valid");
        return userRepository.selectUser(userClaim.getSubject());
    }

    public UserDetails validateWritePermissionsForLoggedInUser() {
        UserDetails userDetails = this.getLoggedInUserDetails();
        if (!userDetails.getRoles().contains(Roles.SECRETARY.getValue())) {
            logger.error("No write permissions for user {}", userDetails.getUsername());
            throw new NoWritePermissionsException("No write permissions for user", 401);
        }
        return userDetails;
    }
}

