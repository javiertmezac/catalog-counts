package com.jtmc.apps.reforma.dbmapper;

import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CatalogCountEnumMapper {

    @SelectProvider(
            type = CatalogCountEnumMapperProvider.class,
            method = "selectCatalogCountEnumWhereIdSql"
    )
    CatalogCountEnum getCatalogCountEnum(@Param("id") int cceId);

    @Select("Select * from catalog_count_enum")
    List<CatalogCountEnum> getAllCatalogCountEnum();

    @InsertProvider(
            type = CatalogCountEnumMapperProvider.class,
            method = "insertCatalogCountEnumSql"
    )
    void insertIntoCatalogCountEnum(CatalogCountEnum catalogCountEnum);

}
