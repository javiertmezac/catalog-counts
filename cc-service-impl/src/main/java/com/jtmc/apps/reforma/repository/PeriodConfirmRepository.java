package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.PeriodDetails;
import com.jtmc.apps.reforma.repository.mapper.PeriodDetailsMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PeriodConfirmRepository {
    final private Logger logger = LoggerFactory.getLogger(PeriodConfirmRepository.class);

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public int insertPeriodDetails(PeriodDetails periodDetails) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            PeriodDetailsMapper mapper = session.getMapper(PeriodDetailsMapper.class);
            return mapper.insert(periodDetails);
        } catch (Exception ex) {
           logger.error("{}", ex);
           throw  ex;
        }
    }
}
