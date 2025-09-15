package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Branch;
import com.jtmc.apps.reforma.domain.TimezoneType;
import com.jtmc.apps.reforma.repository.mapper.BranchDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.BranchMapper;
import com.jtmc.apps.reforma.repository.mapper.TimezoneTypeDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.TimezoneTypeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
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
            return mapper.selectOne(x -> x
                    .where(BranchDynamicSqlSupport.id, SqlBuilder.isEqualTo(branchId))
                    .and(BranchDynamicSqlSupport.status, SqlBuilder.isTrue()));
        }
    }

    public Optional<TimezoneType> getBranchTimeZone(int branchId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            TimezoneTypeMapper mapper = session.getMapper(TimezoneTypeMapper.class);
            return mapper.selectOne(x -> x
                    .join(BranchDynamicSqlSupport.branch)
                    .on(BranchDynamicSqlSupport.timezoneId, SqlBuilder.equalTo(TimezoneTypeDynamicSqlSupport.id))
                    .where(BranchDynamicSqlSupport.id, SqlBuilder.isEqualTo(branchId))
                    .and(BranchDynamicSqlSupport.status, SqlBuilder.isTrue())
            );
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
            logger.error("Error when inserting a new Branch.. Details: ", ex);
            throw ex;
        }
    }

    public int updateBranch(Branch branch) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            BranchMapper mapper = session.getMapper(BranchMapper.class);
            return mapper.updateByPrimaryKeySelective(branch);
        } catch (Exception ex) {
            logger.error("Error updating Branch.. Details: ", ex);
            throw ex;
        }
    }
}
