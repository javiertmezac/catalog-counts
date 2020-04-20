package com.jtmc.apps.reforma.dbmapper.catalogcount;

import com.jtmc.apps.reforma.domain.CatalogCount;
import org.apache.ibatis.annotations.*;

import java.util.Collection;

public interface CatalogCountMapper {

    @InsertProvider(
            type = CatalogCountMapperProvider.class,
            method = "insertCatalogCountSql"
    )
    void insertIntoCatalogCount(@Param("model") CatalogCount catalogCount);

    @SelectProvider(
            type = CatalogCountMapperProvider.class,
            method = "selectAllCatalogCountRecordsSql"
    )
    Collection<CatalogCount> selectAllRecords();

    @SelectProvider(
            type = CatalogCountMapperProvider.class,
            method = "selectOneCatalogCountRecordSql"
    )
    CatalogCount selectOneRecord(@Param("id") int id);

    @DeleteProvider(
            type = CatalogCountMapperProvider.class,
            method = "logicalDeleteOneCatalogCountRecordSql"
    )
    void logicalDeleteRecord(@Param("id") int id);
}
