package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.dbmapper.CatalogCountEnumMapper;
import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;

public class CatalogCountEnumMapperImpl implements ICatalogCountEnumService {

    @Inject
    private CatalogCountEnumMapper catalogCountEnumMapper;

    @Transactional
    public CatalogCountEnum getCatalogCountEnum(int userId) {
        return catalogCountEnumMapper.getCatalogCountEnum(userId);
    }

   public List<CatalogCountEnum> selectAllCatalogCountEnum() {
      return catalogCountEnumMapper.getAllCatalogCountEnum();
   }
}
