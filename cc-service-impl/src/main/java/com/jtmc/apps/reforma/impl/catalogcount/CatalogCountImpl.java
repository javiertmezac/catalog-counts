package com.jtmc.apps.reforma.impl.catalogcount;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.api.v1.catalogcount.CatalogCountResponse;
import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.CustomCatalogCount;
import com.jtmc.apps.reforma.repository.CatalogCountRepository;
import org.mybatis.guice.transactional.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CatalogCountImpl {
    final private Logger logger = LoggerFactory.getLogger(CatalogCountImpl.class);

    @Inject
    private CatalogCountRepository catalogCountRepository;

    public List<CatalogCountResponse> selectAllWithTotalColumn(Integer branchId) {
        Collection<CustomCatalogCount> catalogCounts = catalogCountRepository.selectAllByBranch(branchId);
        final double[] total = {0};
        Stream<CatalogCountResponse> catalogCountResponseStream = catalogCounts.stream().map((cc) -> {
            total[0] = calculateTotalColumn(cc, total[0]);
            return new CatalogCountResponse(
                    cc.getId(),
                    cc.getRegistration().toString(),
                    String.format("%s - %s", cc.getIdentifier(), cc.getName()),
                    cc.getAmount(),
                    cc.getDetails(),
                    total[0]
            );
        });

        List<CatalogCountResponse> responseList = catalogCountResponseStream.collect(Collectors.toList());
        Collections.reverse(responseList);
        return responseList;
    }

    private double calculateTotalColumn(CatalogCount catalogCount, double saldo) {
        //todo: this will only work if first 3 rows from CatalogCountEnum are "incoming values"
        int incomingEnums = 3;
        if (catalogCount.getCatalogcountenumid() <= incomingEnums)  {
            saldo = saldo + catalogCount.getAmount();
        } else {
            saldo = saldo - catalogCount.getAmount();
        }
        return saldo;
    }

    @Transactional
    public void insertIntoCatalogCount(CatalogCount catalogCount) {
        catalogCountRepository.insert(catalogCount);
    }

    @Transactional
    public void updateCatalogCount(CatalogCount catalogCount) {
        catalogCountRepository.update(catalogCount);
    }

    public CatalogCount selectOneRecord(int id) {
        Optional<CatalogCount> catalogCount = catalogCountRepository.selectOneRecord(id);
        if(!catalogCount.isPresent()) {
            //todo: improve this exception
            throw new RuntimeException("CatalogCount not found");
        }
        return catalogCount.get();
    }

    @Transactional
    public void logicalDeleteRecord(int id) {
        CatalogCount cc = new CatalogCount();
        cc.setId(id);
        if (catalogCountRepository.logicalDelete(cc) != 1) {
            logger.error("logicalDelete for record catalog-count {} was not successfully done", id);
            throw new RuntimeException("something wrong happened on deletion for catalog-count");
        }
    }
}
