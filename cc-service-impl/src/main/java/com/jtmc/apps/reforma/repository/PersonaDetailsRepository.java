package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.PersonaDetails;
import com.jtmc.apps.reforma.repository.mapper.PersonaDetailsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

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
}
