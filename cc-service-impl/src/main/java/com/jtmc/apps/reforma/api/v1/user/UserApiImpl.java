package com.jtmc.apps.reforma.api.v1.user;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.api.v1.annotations.JwtUserClaim;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.repository.UserRepositoryImpl;
import org.apache.commons.lang3.StringUtils;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@JwtRequired
public class UserApiImpl implements UserApi {

    @Inject
    JwtUserClaim userClaim;

    @Inject
    private UserRepositoryImpl userRepository;

    @Override
    public UserResponse getUserDetails() {
        checkNotNull(userClaim, "UserClaim Empty");
        checkArgument(StringUtils.isNotBlank(userClaim.getSubject()), "UserClaim not Valid");

        UserDetails userDetails = userRepository.selectUser(userClaim.getSubject());
        UserResponse response = new UserResponse();
        response.setUsername(userDetails.getUsername());
        response.setDefaultBranch(userDetails.getDefaultBranch());
        response.setRoles(userDetails.getRoles());
        return response;
    }
}
