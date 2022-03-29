package com.jtmc.apps.reforma.api.v1.login;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/login")
public interface LoginApi {

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    LoginResponse login(@FormParam("email") String email, @FormParam("password") String password);
}
