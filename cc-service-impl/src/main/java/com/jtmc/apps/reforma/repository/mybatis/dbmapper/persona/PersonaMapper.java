package com.jtmc.apps.reforma.repository.mybatis.dbmapper.persona;

import com.jtmc.apps.reforma.domain.legacy.Persona;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface PersonaMapper {

    @SelectProvider(
            type = PersonaMapperProvider.class,
            method = "selectAllPersonas"
    )
    List<Persona> selectAllPersonas();

    @InsertProvider(
            type = PersonaMapperProvider.class,
            method = "insertPersona"
    )
    void insertPersona(@Param("persona") Persona persona);
}
