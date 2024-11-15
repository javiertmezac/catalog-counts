package com.jtmc.apps.reforma.api.v1.branch;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/v1/branch")
public interface BranchApi {

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    BranchResponseList getBranches();

    @GET
    @Path("/{branchId}")
    @Produces(MediaType.APPLICATION_JSON)
    BranchResponse getBranch(@PathParam("branchId") int branchId);

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response insertBranch(BranchRequest branchRequest);

    @POST
    @Path("/{branchId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response updateBranch(@PathParam("branchId") int branchId, BranchRequest branchRequest);

    @POST
    @Path("/{branchId}/initial-amount")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    Response insertBranchInitialAmount(@PathParam("branchId") int branchId, BranchInitialAmount initialAmount);
}
