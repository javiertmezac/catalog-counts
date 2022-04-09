package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Login;
import com.jtmc.apps.reforma.domain.PersonaDetails;
import com.jtmc.apps.reforma.domain.UserDetails;
import com.jtmc.apps.reforma.repository.mapper.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isTrue;
import static org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils.select;

public class UserRepositoryImpl {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public UserDetails selectUser(String username) {
        UserDetails userDetails = new UserDetails();
        // branchId
        Optional<Login> loggedInUser = this.selectLoggedInUser(username);
        if(!loggedInUser.isPresent()) {
            throw new RuntimeException("No valid LoggedInUser");
        }
        // username
        userDetails.setUsername(username);
        // roles

        //todo: what to return when no role is assigned?
        Collection<PersonaDetails> personaDetails = this.selectUserRoles(loggedInUser.get().getPersonaid());
        Stream<Integer> rolesId = personaDetails.stream().map(PersonaDetails::getPersonaid);
        List<Integer> roles = rolesId.collect(Collectors.toList());
        userDetails.setRoles(roles);

        //todo: for now default branch will be the first value
        // for sure I know only one row per user will be registered in persona_details
        // version 0.5.0
        Optional<PersonaDetails> selectingBranch = personaDetails.stream().findFirst();
        userDetails.setDefaultBranch(selectingBranch.isPresent() ? selectingBranch.get().getBranchid() : 0);
        return userDetails;
    }

    private Optional<Login> selectLoggedInUser(String username) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            LoginMapper mapper = session.getMapper(LoginMapper.class);
            return mapper.selectOne(c -> c.where(LoginDynamicSqlSupport.username, isEqualTo(username))
                    .and(LoginDynamicSqlSupport.status, isTrue()));
        }
    }

    private Collection<PersonaDetails> selectUserRoles(Integer personaId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            PersonaDetailsMapper mapper = session.getMapper(PersonaDetailsMapper.class);
            return mapper.select(c -> c.where(PersonaDetailsDynamicSqlSupport.personaid, isEqualTo(personaId))
                    .and(PersonaDetailsDynamicSqlSupport.status, isTrue()));
        }
    }
}
