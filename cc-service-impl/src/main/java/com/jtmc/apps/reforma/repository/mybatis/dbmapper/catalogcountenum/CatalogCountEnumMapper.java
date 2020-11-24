package com.jtmc.apps.reforma.repository.mybatis.dbmapper.catalogcountenum;

import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

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
