package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.PersonaDetails;
import com.jtmc.apps.reforma.repository.mapper.PersonaDetailsDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.PersonaDetailsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class PersonaDetailsRepository {
    private final Logger logger = LoggerFactory.getLogger(PersonaDetailsRepository.class);

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public List<PersonaDetails> selectAll(){
        try(SqlSession session = sqlSessionFactory.openSession()) {
            PersonaDetailsMapper mapper = session.getMapper(PersonaDetailsMapper.class);
            return mapper.select(SelectDSLCompleter.allRows());
        }
    }

    public int insert(PersonaDetails personaDetails) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            PersonaDetailsMapper mapper = session.getMapper(PersonaDetailsMapper.class);
            personaDetails.setStatus(true);
            return mapper.insertSelective(personaDetails);
        } catch (Exception ex) {
            logger.error("Error when inserting a new personaDetails.. Details {}: {}", personaDetails, ex);
           throw ex;
        }
    }

    public Optional<PersonaDetails> selectOne(int personaId, int branchId) {
         try(SqlSession session = sqlSessionFactory.openSession()) {
            PersonaDetailsMapper mapper = session.getMapper(PersonaDetailsMapper.class);
            return mapper.selectOne(x -> x
                    .where(PersonaDetailsDynamicSqlSupport.personaid, SqlBuilder.isEqualTo(personaId))
                    .and(PersonaDetailsDynamicSqlSupport.branchid, SqlBuilder.isEqualTo(branchId))
                    .and(PersonaDetailsDynamicSqlSupport.status, SqlBuilder.isTrue())
            );
        }
    }

    public List<PersonaDetails> selectByBranch(int branchId) {
         try(SqlSession session = sqlSessionFactory.openSession()) {
            PersonaDetailsMapper mapper = session.getMapper(PersonaDetailsMapper.class);
            return mapper.select(x -> x.where(PersonaDetailsDynamicSqlSupport.branchid, SqlBuilder.isEqualTo(branchId)));
        }
    }

    public List<PersonaDetails> selectByPersonaId(int personaId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            PersonaDetailsMapper mapper = session.getMapper(PersonaDetailsMapper.class);
            return mapper.select(x -> x.where(PersonaDetailsDynamicSqlSupport.personaid, SqlBuilder.isEqualTo(personaId)));
        }
    }
}
