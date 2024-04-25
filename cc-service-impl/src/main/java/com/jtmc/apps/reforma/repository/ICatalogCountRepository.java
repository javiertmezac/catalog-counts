package com.jtmc.apps.reforma.repository;


import com.jtmc.apps.reforma.domain.CatalogCount;
import com.jtmc.apps.reforma.domain.CustomCatalogCount;

import java.util.Collection;
import java.util.Optional;

public interface ICatalogCountRepository {

   int insert(CatalogCount catalogCount);
   int update(CatalogCount catalogCount);
   Collection<CustomCatalogCount> selectAllByBranch(Integer branchId);
   Collection<CustomCatalogCount> selectAllCumulativeSumByBranch(Integer branchId);
   int logicalDelete(CatalogCount catalogCount);
   Optional<CatalogCount> selectOneRecord(Integer id);
}
