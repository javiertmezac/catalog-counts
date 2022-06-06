package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Period;
import com.jtmc.apps.reforma.repository.mapper.PeriodDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.PeriodMapper;
import com.jtmc.apps.reforma.repository.mybatis.exception.MyBatisRepositoryMapperException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.util.Optional;

public class PeriodRepository {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<Period> selectOne(int toMonth, int year) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            PeriodMapper mapper = session.getMapper(PeriodMapper.class);

            SelectStatementProvider statementProvider = MyBatis3Utils.select(PeriodMapper.selectList,
                    PeriodDynamicSqlSupport.period, x -> x
                            .where(PeriodDynamicSqlSupport.tomonth, SqlBuilder.isEqualTo(toMonth))
                            .and(PeriodDynamicSqlSupport.year, SqlBuilder.isEqualTo(year))
                            .and(PeriodDynamicSqlSupport.status, SqlBuilder.isTrue())
            );
            return mapper.selectOne(statementProvider);
        }
    }

    public Optional<Period> selectOne(int periodId) {
         try(SqlSession session = sqlSessionFactory.openSession()) {
            PeriodMapper mapper = session.getMapper(PeriodMapper.class);
            return mapper.selectByPrimaryKey(periodId);
        }
    }
}
