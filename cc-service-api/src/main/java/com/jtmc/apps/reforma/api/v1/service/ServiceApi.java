package com.jtmc.apps.reforma.api.v1.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/v1/service")
public interface ServiceApi {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response createService(ServiceRequest request);


    @GET
    @Path("/{idService}/attendance")
    @Produces(MediaType.APPLICATION_JSON)
    AttendanceResponse getAttendanceList(@PathParam("idService") int idService);

    @POST
    @Path("/{idService}/attendance")
    @Consumes(MediaType.APPLICATION_JSON)
    Response saveAttendanceList(@PathParam("idService") int idService, AttendanceRequest request);
}
