package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Role;
import com.jtmc.apps.reforma.repository.mapper.RoleMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class RoleRepository {

    private final Logger logger = LoggerFactory.getLogger(RoleRepository.class);

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<Role> selectOne(int roleId){
        try(SqlSession session = sqlSessionFactory.openSession()) {
            RoleMapper mapper = session.getMapper(RoleMapper.class);
            return mapper.selectByPrimaryKey(roleId);
        }
    }

}
