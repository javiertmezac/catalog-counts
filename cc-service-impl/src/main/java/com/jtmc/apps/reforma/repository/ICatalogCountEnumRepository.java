package com.jtmc.apps.reforma.repository;

import com.jtmc.apps.reforma.domain.CatalogCountEnum;

import java.util.List;

public interface ICatalogCountEnumRepository {

    CatalogCountEnum getCatalogCountEnum(int id);
    List<CatalogCountEnum> selectAllCatalogCountEnum();
    void insertCatalogCountEnum(CatalogCountEnum catalogCountEnum);
}
