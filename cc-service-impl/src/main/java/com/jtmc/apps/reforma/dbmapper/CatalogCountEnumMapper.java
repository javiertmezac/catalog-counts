package com.jtmc.apps.reforma.dbmapper;

import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CatalogCountEnumMapper {

    @Select("Select * from catalog_count_enum where id = #{cceId}")
    CatalogCountEnum getCatalogCountEnum(@Param("cceId") int cceId);

    @Select("Select * from catalog_count_enum")
    List<CatalogCountEnum> getAllCatalogCountEnum();
}
