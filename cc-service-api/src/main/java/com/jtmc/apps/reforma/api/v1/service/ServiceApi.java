package com.jtmc.apps.reforma.api.v1.service;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/service")
public interface ServiceApi {

    //todo: should this also be PUT?
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    ServiceResponse createService(ServiceRequest request);

    @GET
    @Path("/{date}")
    @Produces(MediaType.APPLICATION_JSON)
    ServiceResponse getServiceByDate(@PathParam("date") String date);


    @GET
    @Path("/{idService}/attendance")
    @Produces(MediaType.APPLICATION_JSON)
    AttendanceResponseList getAttendanceList(@PathParam("idService") int idService);

    @PUT
    @Path("/{idService}/attendance")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response saveAttendanceList(@PathParam("idService") int idService, AttendanceRequest request);
}
