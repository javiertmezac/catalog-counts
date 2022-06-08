package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Branch;
import com.jtmc.apps.reforma.repository.mapper.BranchMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class BranchRepository {
    private final Logger logger = LoggerFactory.getLogger(BranchRepository.class);

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<Branch> selectOneBranch(int branchId){
        try(SqlSession session = sqlSessionFactory.openSession()) {
            BranchMapper mapper = session.getMapper(BranchMapper.class);
            return mapper.selectByPrimaryKey(branchId);
        }
    }
    public List<Branch> selectAll(){
        try(SqlSession session = sqlSessionFactory.openSession()) {
            BranchMapper mapper = session.getMapper(BranchMapper.class);
            return mapper.select(SelectDSLCompleter.allRows());
        }
    }

    public int insertBranch(Branch branch) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            BranchMapper mapper = session.getMapper(BranchMapper.class);
            branch.setStatus(true);
            return mapper.insertSelective(branch);
        } catch (Exception ex) {
            logger.error("Error when inserting a new Branch.. Details {}: {}", branch, ex);
           throw ex;
        }
    }
}
