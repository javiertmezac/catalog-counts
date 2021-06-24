package com.jtmc.apps.reforma.repository.mybatis.dbmapper.catalogcount;

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
    @Results(value = {
            @Result(property = "id", column = "ccId"),
            @Result(property = "registrationDate", column = "ccRegistrationDate"),
            @Result(property = "amount", column = "ccAmount"),
            @Result(property = "details",column = "ccDetails"),
            @Result(property = "isDeleted",column = "ccIsDeleted"),
            @Result(property = "catalogCountEnum.id",column = "cceId"),
            @Result(property = "catalogCountEnum.identifier",column = "cceIdentifier"),
            @Result(property = "catalogCountEnum.name",column = "cceName")
    })
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
