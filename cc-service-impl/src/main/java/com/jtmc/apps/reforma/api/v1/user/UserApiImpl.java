package com.jtmc.apps.reforma.api.v1.user;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.impl.user.UserImpl;

import javax.ws.rs.CookieParam;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.*;

@JwtRequired
public class UserApiImpl implements UserApi {

    @Inject
    private UserImpl userImpl;

    @Context
    private HttpHeaders headers;

    @Override
    public UserResponse getUserDetails() {
        UserDetails userDetails = userImpl.getLoggedInUserDetails();
        UserResponse response = new UserResponse();
        response.setUsername(userDetails.getUsername());
        response.setUserId(userDetails.getPersonaId());
        response.setRoles(userDetails.getRoles());
        response.setBranches(userDetails.getBranches());

        Cookie defaultBranch = headers.getCookies().get("defaultBranch");
        if(defaultBranch != null) {
            response.setDefaultBranch(Integer.parseInt(defaultBranch.getValue()));
        } else {
            int firstOption = 0;
            response.setDefaultBranch(userDetails.getBranches().get(firstOption));
        }

        return response;
    }
    @Override
    public Response changeDefaultBranch(int defaultBranch) {
        UserDetails userDetails = userImpl.getLoggedInUserDetails();
        if(userDetails.getBranches().contains(defaultBranch)) {
            Cookie cookie = new Cookie("defaultBranch", String.valueOf(defaultBranch));
            NewCookie newCookie = new NewCookie(cookie);
            return Response.ok().cookie(newCookie).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
