package com.jtmc.apps.reforma.api.v1.service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Date;

@Path("/v1/service")
public interface ServiceApi {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    Response createService(ServiceRequest request);

    @GET
    @Path("/{date}")
    Response getServiceByDate(@PathParam("date") String date);


    @GET
    @Path("/{idService}/attendance")
    @Produces(MediaType.APPLICATION_JSON)
    AttendanceResponse getAttendanceList(@PathParam("idService") int idService);

    @POST
    @Path("/{idService}/attendance")
    @Consumes(MediaType.APPLICATION_JSON)
    Response saveAttendanceList(@PathParam("idService") int idService, AttendanceRequest request);
}
