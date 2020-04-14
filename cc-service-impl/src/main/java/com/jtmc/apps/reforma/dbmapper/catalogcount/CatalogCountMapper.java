package com.jtmc.apps.reforma.dbmapper.catalogcount;

import com.jtmc.apps.reforma.domain.CatalogCount;
import org.apache.ibatis.annotations.InsertProvider;

public interface CatalogCountMapper {

    @InsertProvider(
            type = CatalogCountMapperProvider.class,
            method = "insertCatalogCountSql"
    )
    void insertIntoCatalogCount(CatalogCount catalogCount);
}
