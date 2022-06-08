package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.repository.mapper.PersonaMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class PersonaRepository {
        private final Logger logger = LoggerFactory.getLogger(PersonaRepository.class);

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<Persona> selectOne(int id){
        try(SqlSession session = sqlSessionFactory.openSession()) {
            PersonaMapper mapper = session.getMapper(PersonaMapper.class);
            return mapper.selectByPrimaryKey(id);
        }
    }
    public List<Persona> selectAll(){
        try(SqlSession session = sqlSessionFactory.openSession()) {
            PersonaMapper mapper = session.getMapper(PersonaMapper.class);
            return mapper.select(SelectDSLCompleter.allRows());
        }
    }

    public int insert(Persona persona) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            PersonaMapper mapper = session.getMapper(PersonaMapper.class);
            persona.setStatus(true);
            return mapper.insertSelective(persona);
        } catch (Exception ex) {
            logger.error("Error when inserting a new persona.. Details {}: {}", persona, ex);
           throw ex;
        }
    }
}
