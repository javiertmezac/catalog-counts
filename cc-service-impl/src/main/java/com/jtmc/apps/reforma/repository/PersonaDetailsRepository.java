package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.PersonaDetails;
import com.jtmc.apps.reforma.repository.mapper.PersonaDetailsDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.PersonaDetailsMapper;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class PersonaDetailsRepository {
    private final Logger logger = LoggerFactory.getLogger(PersonaDetailsRepository.class);

    @Inject
    PersonaDetailsMapper mapper;

    public List<PersonaDetails> selectAll(){
            return mapper.select(SelectDSLCompleter.allRows());
    }

    public int insert(PersonaDetails personaDetails) {
        personaDetails.setStatus(true);
        return mapper.insertSelective(personaDetails);
    }

    public Optional<PersonaDetails> selectOne(int personaId, int branchId) {
        return mapper.selectOne(x -> x
                .where(PersonaDetailsDynamicSqlSupport.personaid, SqlBuilder.isEqualTo(personaId))
                .and(PersonaDetailsDynamicSqlSupport.branchid, SqlBuilder.isEqualTo(branchId))
                .and(PersonaDetailsDynamicSqlSupport.status, SqlBuilder.isTrue())
        );
    }

    public List<PersonaDetails> selectByBranch(int branchId) {
        return mapper.select(x -> x.where(PersonaDetailsDynamicSqlSupport.branchid, SqlBuilder.isEqualTo(branchId)));
    }

    public List<PersonaDetails> selectByPersonaId(int personaId) {
        return mapper.select(x -> x.where(PersonaDetailsDynamicSqlSupport.personaid, SqlBuilder.isEqualTo(personaId)));
    }
}
