package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Report;
import com.jtmc.apps.reforma.repository.mapper.ReportDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.ReportMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;

import java.util.Optional;

public class ReportRepository {

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<Report> selectByPeriod(int periodId) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            ReportMapper mapper = session.getMapper(ReportMapper.class);

            return mapper.selectOne(x -> x.where(ReportDynamicSqlSupport.periodid, SqlBuilder.isEqualTo(periodId)));
        }
    }
}
