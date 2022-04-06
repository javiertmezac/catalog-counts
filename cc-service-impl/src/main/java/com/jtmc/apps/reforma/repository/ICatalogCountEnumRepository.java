package com.jtmc.apps.reforma.repository;

import com.jtmc.apps.reforma.domain.CatalogCountEnum;

import java.util.List;
import java.util.Optional;

public interface ICatalogCountEnumRepository {

    Optional<CatalogCountEnum> getCatalogCountEnum(Integer id);
    List<CatalogCountEnum> selectAllCatalogCountEnum();
//    void insertCatalogCountEnum(CatalogCountEnum catalogCountEnum);
}
