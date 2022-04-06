package com.jtmc.apps.reforma.api.v1.user;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.api.v1.annotations.JwtUserClaim;

@JwtRequired
public class UserApiImpl implements UserApi {

    @Inject
    JwtUserClaim userClaim;

    @Override
    public UserResponse getUserDetails() {
        System.out.println(userClaim.getSubject());
        return null;
    }
}
