package com.jtmc.apps.reforma.repository.mybatis.dbmapper.persona;

import com.jtmc.apps.reforma.domain.Persona;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

public interface PersonaMapper {

    @SelectProvider(
            type = PersonaMapperProvider.class,
            method = "selectAllPersonas"
    )
    List<Persona> selectAllPersonas();
}
