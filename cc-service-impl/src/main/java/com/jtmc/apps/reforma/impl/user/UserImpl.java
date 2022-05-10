package com.jtmc.apps.reforma.impl.user;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtUserClaim;
import com.jtmc.apps.reforma.domain.Role;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.repository.UserRepositoryImpl;
import org.apache.commons.lang3.StringUtils;

import static com.google.common.base.Preconditions.*;

public class UserImpl {

    @Inject
    private JwtUserClaim userClaim;

    @Inject
    private UserRepositoryImpl userRepository;

    public UserDetails getLoggedInUserDetails() {
        checkNotNull(userClaim, "UserClaim Empty");
        checkArgument(StringUtils.isNotBlank(userClaim.getSubject()), "UserClaim not Valid");
        return userRepository.selectUser(userClaim.getSubject());
    }

    public boolean hasLoggedInUserWritePermissions(UserDetails userDetails) {
        return userDetails.getRoles().contains(Roles.SECRETARY.value);
    }

    private enum Roles {
        TREASURE(1),
        SECRETARY (2);

        private int value;

        Roles(int value) {
           this.value = value;
        }
    }

}
