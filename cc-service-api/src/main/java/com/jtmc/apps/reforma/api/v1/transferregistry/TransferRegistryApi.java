package com.jtmc.apps.reforma.api.v1.transferregistry;

import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;
import java.util.UUID;

@Path("/v1/branch")
@JwtRequired
public interface TransferRegistryApi {

    @GET
    @Path("/{branchId}/transferregistry")
    @Produces(MediaType.APPLICATION_JSON)
    List<TransferRegistryResponse> get(@PathParam("branchId") Integer account);

    @POST
    @Path("/{branchId}/transferregistry/{transferId}")
    void acceptTransfer(@PathParam("branchId") Integer account, @PathParam("transferId") UUID transferId);
}
