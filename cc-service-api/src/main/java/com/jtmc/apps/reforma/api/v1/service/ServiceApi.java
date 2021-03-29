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
    @Path("/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    ServiceResponse getServiceByDate(@PathParam("date") String date);


    @GET
    @Path("/{idService}/attendance")
    @Produces(MediaType.APPLICATION_JSON)
    AttendanceResponse getAttendanceList(@PathParam("idService") int idService);

    @PUT
    @Path("/{idService}/attendance")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response saveAttendanceList(@PathParam("idService") int idService, AttendanceRequest request);
}
