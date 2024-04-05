package com.jtmc.apps.reforma.api.v1.user;

import org.apache.cxf.jaxrs.ext.PATCH;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/v1/user")
public interface UserApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    UserResponse getUserDetails();

    @PATCH
    @Path("/changeDefaultBranch")
    @Produces(MediaType.APPLICATION_JSON)
    Response changeDefaultBranch(@QueryParam("defaultBranch") int defaultBranch);
}
