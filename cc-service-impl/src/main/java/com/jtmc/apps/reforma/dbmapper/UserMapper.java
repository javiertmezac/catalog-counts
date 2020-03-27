package com.jtmc.apps.reforma.dbmapper;

import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import com.jtmc.apps.reforma.domain.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("SELECT * FROM user WHERE id = #{userId}")
    User getUser(@Param("userId") String userId);

    @Select("Select * from catalog_count_enum where id = #{cceId}")
    CatalogCountEnum getCatalogCountEnum(@Param("cceId") int cceId);

}
