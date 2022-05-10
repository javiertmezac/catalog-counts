package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Branch;
import com.jtmc.apps.reforma.repository.mapper.BranchMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Optional;

public class BranchRepository {
        @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<Branch> selectOneBranch(int branchId){
        try(SqlSession session = sqlSessionFactory.openSession()) {
            BranchMapper mapper = session.getMapper(BranchMapper.class);
            return mapper.selectByPrimaryKey(branchId);
        }
    }
}
