package com.jtmc.apps.reforma.api.v1.user;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/v1/user")
public interface UserApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    UserResponse getUserDetails();
}
