package com.jtmc.apps.reforma.api.v1.catalogcountenum;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import com.jtmc.apps.reforma.repository.CatalogCountEnumRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CatalogCountEnumApiImpl implements CatalogCountEnumApi {

    @Inject
    private CatalogCountEnumRepository catalogCountEnumRepository;

    @Override
    public CatalogCountEnumResponseList getCatalogCountEnums() {
        List<CatalogCountEnum> catalogCountEnumList = catalogCountEnumRepository.selectAllCatalogCountEnum();
        CatalogCountEnum initialAmountEnum = catalogCountEnumRepository.getInitialAmountEnum();

        List<CatalogCountEnumResponse> response = new ArrayList<>();
        catalogCountEnumList.stream()
                .filter(x -> !Objects.equals(x.getIdentifier(), initialAmountEnum.getIdentifier()))
                .forEach(catalogCountEnum -> {
                    String label = String.format("%s - %s", catalogCountEnum.getIdentifier(), catalogCountEnum.getName());

                    CatalogCountEnumResponse catalogCountEnumResponse = new CatalogCountEnumResponse();
                    catalogCountEnumResponse.setLabel(label);
                    catalogCountEnumResponse.setValue(catalogCountEnum.getId());

                    response.add(catalogCountEnumResponse);
                });

        CatalogCountEnumResponseList actualResponse = new CatalogCountEnumResponseList();
        actualResponse.setCatalogCountEnumList(response);
        return actualResponse;
    }
}
