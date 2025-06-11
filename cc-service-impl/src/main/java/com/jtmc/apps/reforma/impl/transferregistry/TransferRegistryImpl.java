package com.jtmc.apps.reforma.impl.transferregistry;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.*;
import com.jtmc.apps.reforma.impl.branch.BranchImpl;
import com.jtmc.apps.reforma.impl.user.UserImpl;
import com.jtmc.apps.reforma.repository.CatalogCountEnumRepository;
import com.jtmc.apps.reforma.repository.TransferRegistryRepository;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class TransferRegistryImpl {
    @Inject
    private TransferRegistryRepository repository;

    @Inject
    private CatalogCountEnumRepository catalogCountEnumRepository;

    @Inject
    private BranchImpl branchImpl;

    @Inject
    private UserImpl userImpl;

    public void registerTransferTo(CatalogCount catalogCount, int transferToAccountId) {
        BranchDetails branchDetails = branchImpl.selectOneBranch(transferToAccountId);
        UserDetails loggedInUserDetails = userImpl.getLoggedInUserDetails();

        TransferRegistry transferRegistry = new TransferRegistry();
        transferRegistry.setTransferregistryid(UUID.randomUUID());
        transferRegistry.setFromaccountid(catalogCount.getBranchid());
        transferRegistry.setToaccountid(transferToAccountId);
        transferRegistry.setFromaccountcatalogcountid(catalogCount.getId());
        transferRegistry.setDetails(catalogCount.getDetails());
        transferRegistry.setAmount(catalogCount.getAmount());
        transferRegistry.setEntrypersonid(loggedInUserDetails.getPersonaId());
        transferRegistry.setEntrydate(catalogCount.getRegistration());
        repository.insert(transferRegistry);
    }

    public boolean validateIfTransferRegistryRequired(int catalogCountEnumId) {
        Optional<CatalogCountEnum> byFamilyAndName = catalogCountEnumRepository
                .findByFamilyAndName("helps", "Aportación a la región");
        return byFamilyAndName.filter(catalogCountEnum -> catalogCountEnum.getId() == catalogCountEnumId).isPresent();
    }

    public void delete(TransferRegistry byCatalogCountId) {
        byCatalogCountId.setInactivedate(Instant.now());
        repository.update(byCatalogCountId);
    }

    public List<CustomTransferRegistry> findByAccount(Integer account) {
        return repository.findByAccount(account);
    }

    public TransferRegistry findByFromAccountCatalogCountId(Integer id) {
        return repository.findByFromAccountCatalogCountId(id);
    }

    public TransferRegistry findById(UUID transferId) {
        return repository.findById(transferId).orElse(null);
    }

    public void update(TransferRegistry tr) {
        repository.update(tr);
    }
}
