package com.jtmc.apps.reforma.api.v1.branch;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
    Response insertBranchInitialAmount(@PathParam("branchId") int branchId, BranchInitialAmount initialAmount);
}
