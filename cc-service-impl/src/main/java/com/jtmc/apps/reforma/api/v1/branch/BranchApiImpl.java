package com.jtmc.apps.reforma.api.v1.branch;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.annotations.JwtRequired;
import com.jtmc.apps.reforma.domain.Branch;
import com.jtmc.apps.reforma.domain.BranchDetails;
import com.jtmc.apps.reforma.domain.TimezoneType;
import com.jtmc.apps.reforma.impl.branch.BranchImpl;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

@JwtRequired
public class BranchApiImpl implements BranchApi {
    @Inject
    private BranchImpl branchImpl;

    @Override
    public BranchResponseList getBranches() {
        List<Branch> branchList = branchImpl.selectBranches();
        Stream<BranchResponse> mappedBranchList = branchList.stream().map(this::mapToBranchResponse);
        BranchResponseList response = new BranchResponseList();
        response.setBranchResponseList(mappedBranchList.collect(Collectors.toList()));
        return response;
    }

    @Override
    public BranchResponse getBranch(int branchId) {
        BranchDetails branch = branchImpl.selectOneBranch(branchId);
        BranchResponse response = mapToBranchResponse(branch.getBranch());
        Optional<BranchInitialAmount> initialAmount = branchImpl.getInitialAmount(branchId);
        initialAmount.ifPresent(response::setInitialAmount);
        return response;
    }

    @Override
    public Response insertBranch(BranchRequest branchRequest) {
        checkNotNull(branchRequest, "Invalid payload for Branch");
        checkArgument(StringUtils.isNotBlank(branchRequest.getName()), "Invalid NAme for branch");
        checkArgument(StringUtils.isNotBlank(branchRequest.getAddress()), "Invalid Address for branch");

        Branch b = new Branch();
        b.setAddress(branchRequest.getAddress());
        b.setName(branchRequest.getName());
        b.setRegistration(Instant.now());
        branchImpl.insertBranch(b);
        return Response.noContent().build();
    }

    private BranchResponse mapToBranchResponse(Branch branch) {
        BranchResponse response = new BranchResponse();
        response.setId(branch.getId());
        response.setName(branch.getName());
        response.setAddress(branch.getAddress());
        response.setRegistration(branch.getRegistration().toString());
        response.setStatus(branch.getStatus());
        return response;
    }

    @Override
    public Response insertBranchInitialAmount(int branchId, BranchInitialAmount branchInitialAmount) {
        checkArgument(branchId > 0, "invalid branch");
        checkNotNull(branchInitialAmount);
        checkArgument(branchInitialAmount.getAmount() > 0.0,
                "Invalid branch Initial Amount. should be > 0.0");

        BranchDetails branchDetails = branchImpl.selectOneBranch(branchId);
        if (!branchImpl.getInitialAmount(branchId).isPresent()) {
            branchImpl.insertInitialAmount(branchDetails.getBranch(), branchInitialAmount.getAmount());
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
