package com.jtmc.apps.reforma.repository;


import com.jtmc.apps.reforma.domain.CatalogCount;

import java.util.Collection;
import java.util.Optional;

public interface ICatalogCountRepository {

   int insert(CatalogCount catalogCount);
   Collection<CatalogCount> selectAllByBranch(Integer branchId);
   int logicalDelete(CatalogCount catalogCount);
   Optional<CatalogCount> selectOneRecord(Integer id);
}
