package com.jtmc.apps.reforma.api.v1.user;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.impl.user.UserImpl;

import javax.ws.rs.core.*;
import java.util.Map;
import java.util.Optional;

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

        Optional<Map.Entry<String, Cookie>> defaultBranchCookie = headers.getCookies()
                .entrySet()
                .stream()
                .filter(c -> c.getValue().getName().equals("x-cc-default-branch")).findFirst();
        if(defaultBranchCookie.isPresent()) {
            response.setDefaultBranch(Integer.parseInt(defaultBranchCookie.get().getValue().getValue()));
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
            NewCookie defaultBranchCookie = new NewCookie("x-cc-default-branch",
                    String.valueOf(defaultBranch), "/", "localhost", null, 60*60, false, false);
            return Response.ok().cookie(defaultBranchCookie).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
