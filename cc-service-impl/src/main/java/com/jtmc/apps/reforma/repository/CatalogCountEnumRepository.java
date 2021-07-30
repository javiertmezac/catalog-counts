package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import com.jtmc.apps.reforma.repository.mybatis.dbmapper.catalogcountenum.CatalogCountEnumMapper;
import org.mybatis.guice.transactional.Transactional;


import java.util.List;

public class CatalogCountEnumRepository implements ICatalogCountEnumRepository {
  
    @Inject
    private CatalogCountEnumMapper mapper;

    @Transactional
    public CatalogCountEnum getCatalogCountEnum(int userId) {
        return mapper.getCatalogCountEnum(userId);
    }

   public List<CatalogCountEnum> selectAllCatalogCountEnum() {
      return mapper.getAllCatalogCountEnum();
   }

   @Transactional
    public void insertCatalogCountEnum(CatalogCountEnum catalogCountEnum) {
        mapper.insertIntoCatalogCountEnum(catalogCountEnum);
   }
}
