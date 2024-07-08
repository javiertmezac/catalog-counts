package com.jtmc.apps.reforma.api.v1.user;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1/user")
public interface UserApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    UserResponse getUserDetails();
}
