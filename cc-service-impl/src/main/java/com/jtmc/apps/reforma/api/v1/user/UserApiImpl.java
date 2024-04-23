package com.jtmc.apps.reforma.api.v1.user;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.impl.user.UserImpl;

@JwtRequired
public class UserApiImpl implements UserApi {

    @Inject
    private UserImpl userImpl;

    @Override
    public UserResponse getUserDetails() {
        UserDetails userDetails = userImpl.getLoggedInUserDetails();
        UserResponse response = new UserResponse();
        response.setUsername(userDetails.getUsername());
        response.setUserId(userDetails.getPersonaId());
        response.setRoles(userDetails.getRoles());
        response.setBranches(userDetails.getBranches());
        int firstOption = 0;
        response.setDefaultBranch(userDetails.getBranches().get(firstOption));

        return response;
    }
}
