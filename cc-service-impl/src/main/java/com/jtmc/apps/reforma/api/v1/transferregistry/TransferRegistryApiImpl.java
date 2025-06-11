package com.jtmc.apps.reforma.api.v1.transferregistry;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.impl.branch.BranchImpl;
import com.jtmc.apps.reforma.impl.catalogcount.CatalogCountImpl;
import com.jtmc.apps.reforma.impl.transferregistry.TransferRegistryImpl;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.CatalogCountEnumRepository;
import jakarta.ws.rs.BadRequestException;
import org.mybatis.guice.transactional.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class TransferRegistryApiImpl implements TransferRegistryApi {
    private final Logger logger = LoggerFactory.getLogger(TransferRegistryApiImpl.class);
    @Inject
    private TransferRegistryImpl transferRegistryImpl;

    @Inject
    private BranchImpl branchImpl;

    @Inject
    private UserImpl userImpl;

    @Inject
    private CatalogCountImpl catalogCountImpl;

    @Inject
    private CatalogCountEnumRepository catalogCountEnumRepository;

    @Override
    public List<TransferRegistryResponse> get(Integer account) {
        BranchDetails branchDetails = branchImpl.selectOneBranch(account);
        List<CustomTransferRegistry> byAccount = transferRegistryImpl.findByAccount(account);
        return byAccount.stream().map(x -> {
            TransferRegistryResponse r = new TransferRegistryResponse();
            r.transferRegistryId = x.getTransferregistryid();
            r.toAccountId = x.getToaccountid();
            r.toAccountName = x.getToAccountName();
            r.fromAccountId = x.getFromaccountid();
            r.fromAccountName = x.getFromAccountName();
            r.fromAccountCatalogCountId = x.getFromaccountcatalogcountid();
            r.toAccountCatalogCountId = x.getToaccountcatalogcountid() == null ? 0 : x.getToaccountcatalogcountid();
            r.entryDate = x.getEntrydate();
            r.amount = x.getAmount();
            r.entryPersona = x.getEntryPersonName();
            r.entryDateText = x.getEntrydate().toString();
            r.acceptedDate = x.getAccepteddate() == null ? null : x.getAccepteddate();
            r.acceptedDateText = x.getAccepteddate() == null ? null : x.getAccepteddate().toString();
            r.acceptedPersona = x.getAcceptedpersonid() == null  ? null : x.getAcceptedPersonName();
            return r;
        }).toList();
    }

    @Override
    @Transactional
    public void acceptTransfer(Integer account, UUID transferId) {
        BranchDetails branchDetails = branchImpl.selectOneBranch(account);
        UserDetails userDetails = userImpl.validateWritePermissionsForLoggedInUser();

        TransferRegistry tr = transferRegistryImpl.findById(transferId);
        if (tr.getAccepteddate() != null) {
            logger.error("TransferRegistry[id: {}], already marked as accepted!", tr.getTransferregistryid());
            throw new BadRequestException();
        }

        if (!Objects.equals(tr.getToaccountid(), branchDetails.getBranch().getId())) {
            logger.error("TransferRegistry[id: {}], not valid for Branch[id: {}]", tr.getTransferregistryid(), branchDetails.getBranch().getId());
            throw new BadRequestException();
        }

        Instant entryDate = Instant.now();
        CatalogCountEnum byFamilyAndName = catalogCountEnumRepository.findByFamilyAndName("donations", "Donaciones")
                .orElseThrow(() -> new RuntimeException("Could not found proper CatalogCountEnum to TransferRegistry"));

        CatalogCount cc = new CatalogCount();
        cc.setAmount(tr.getAmount());
        cc.setDetails(tr.getDetails());
        cc.setBranchid(branchDetails.getBranch().getId());
        cc.setRegistration(entryDate);
        cc.setIsdeleted(false);
        cc.setCatalogcountenumid(byFamilyAndName.getId());
        catalogCountImpl.insertIntoCatalogCount(cc);
        if (cc.getId() == null) {
            throw new BadRequestException("Not able to insert TransferRegistry [new CatalogCount]");
        }

        tr.setAccepteddate(entryDate);
        tr.setAcceptedpersonid(userDetails.getPersonaId());
        tr.setToaccountcatalogcountid(cc.getId());
        transferRegistryImpl.update(tr);
    }
}
