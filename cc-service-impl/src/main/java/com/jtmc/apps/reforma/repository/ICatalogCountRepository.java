package com.jtmc.apps.reforma.repository;

import com.jtmc.apps.reforma.domain.CatalogCount;

import java.util.Collection;

public interface ICatalogCountRepository {

   void insert(CatalogCount catalogCount);
   Collection<CatalogCount> selectAll();
   void logicalDelete(int id);
   CatalogCount selectOneRecord(int id);
}
