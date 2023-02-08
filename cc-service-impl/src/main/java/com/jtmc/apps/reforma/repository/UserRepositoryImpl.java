package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Login;
import com.jtmc.apps.reforma.domain.Persona;
import com.jtmc.apps.reforma.domain.PersonaDetails;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.repository.exception.RepositoryException;
import com.jtmc.apps.reforma.repository.exception.UnauthorizedUserException;
import com.jtmc.apps.reforma.repository.mapper.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isTrue;
import static org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils.select;

public class UserRepositoryImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<Login> selectLoggedInUser(String username) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            LoginMapper mapper = session.getMapper(LoginMapper.class);
            return mapper.selectOne(c -> c.where(LoginDynamicSqlSupport.username, isEqualTo(username))
                    .and(LoginDynamicSqlSupport.status, isTrue()));
        }
    }

    public Collection<PersonaDetails> selectUserRoles(Integer personaId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            PersonaDetailsMapper mapper = session.getMapper(PersonaDetailsMapper.class);
            return mapper.select(c -> c.where(PersonaDetailsDynamicSqlSupport.personaid, isEqualTo(personaId))
                    .and(PersonaDetailsDynamicSqlSupport.status, isTrue()));
        }
    }
}
