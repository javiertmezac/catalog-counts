package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.PeriodDetails;
import com.jtmc.apps.reforma.repository.exception.RepositoryException;
import com.jtmc.apps.reforma.repository.mapper.PeriodDetailsDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.PeriodDetailsMapper;
import com.jtmc.apps.reforma.repository.mapper.PeriodDynamicSqlSupport;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

public class PeriodConfirmRepository {
    final private Logger logger = LoggerFactory.getLogger(PeriodConfirmRepository.class);

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public int insert(PeriodDetails periodDetails) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            PeriodDetailsMapper mapper = session.getMapper(PeriodDetailsMapper.class);
            periodDetails.setStatus(true);
            return mapper.insert(periodDetails);
        } catch (Exception ex) {
           logger.error("{}", ex);
           throw new RepositoryException("Error in PeriodConfirmRepository", 500);
        }
    }

    public Optional<PeriodDetails> selectOne(int branchId, int periodId, int confirmedBy) {
         try(SqlSession session = sqlSessionFactory.openSession()) {
             PeriodDetailsMapper mapper = session.getMapper(PeriodDetailsMapper.class);
            return mapper.selectByPrimaryKey(branchId, periodId, confirmedBy);
        } catch (Exception ex) {
           logger.error("{}", ex);
           throw new RepositoryException("Error in PeriodConfirmRepository", 500);
        }
    }

    public List<PeriodDetails> select(int branchId, int periodId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            PeriodDetailsMapper mapper = session.getMapper(PeriodDetailsMapper.class);
            SelectStatementProvider statementProvider = MyBatis3Utils.select(PeriodDetailsMapper.selectList,
                    PeriodDetailsDynamicSqlSupport.periodDetails,
                    x -> x.where(PeriodDetailsDynamicSqlSupport.branchid, SqlBuilder.isEqualTo(branchId))
                            .and(PeriodDetailsDynamicSqlSupport.periodid, SqlBuilder.isEqualTo(periodId))
            );
            return mapper.selectMany(statementProvider);
        } catch (Exception ex) {
            logger.error("{}", ex);
            throw new RepositoryException("Error in PeriodConfirmRepository", 500);
        }
    }
}
