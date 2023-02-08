package com.jtmc.apps.reforma.api.v1.login;

import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/login")
public interface LoginApi {

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    LoginResponse login(@FormParam("email") String email, @FormParam("password") String password);

    @JwtRequired
    @Path("/register")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response register(LoginRegistrationRequest request);
}
