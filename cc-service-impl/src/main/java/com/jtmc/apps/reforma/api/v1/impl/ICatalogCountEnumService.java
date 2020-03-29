package com.jtmc.apps.reforma.api.v1.impl;

import com.jtmc.apps.reforma.domain.CatalogCountEnum;

import java.util.List;

public interface ICatalogCountEnumService {

    CatalogCountEnum getCatalogCountEnum(int id);
    List<CatalogCountEnum> selectAllCatalogCountEnum();
    void insertCatalogCountEnum(CatalogCountEnum catalogCountEnum);
}
