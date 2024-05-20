package com.jtmc.apps.reforma.repository;


import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.CatalogCountCumulativeSumParams;
import com.jtmc.apps.reforma.domain.CustomCatalogCount;

import java.util.Collection;
import java.util.Optional;

public interface ICatalogCountRepository {

   int insert(CatalogCount catalogCount);
   int update(CatalogCount catalogCount);
   Collection<CustomCatalogCount> selectAllByBranch(Integer branchId);
   Collection<CustomCatalogCount> selectAllCumulativeSumByBranch(CatalogCountCumulativeSumParams params);
   int logicalDelete(CatalogCount catalogCount);
   Optional<CatalogCount> selectOneRecord(Integer id);
}
