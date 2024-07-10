package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Branch;
import com.jtmc.apps.reforma.domain.TimezoneType;
import com.jtmc.apps.reforma.repository.mapper.BranchMapper;
import com.jtmc.apps.reforma.repository.mapper.TimezoneTypeMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class TimeZoneRepository {

    private final Logger logger = LoggerFactory.getLogger(TimeZoneRepository.class);

    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public List<TimezoneType> selectAll(){
        try(SqlSession session = sqlSessionFactory.openSession()) {
            TimezoneTypeMapper mapper = session.getMapper(TimezoneTypeMapper.class);
            return mapper.select(SelectDSLCompleter.allRows());
        }
    }
}
