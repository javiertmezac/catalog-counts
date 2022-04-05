package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountEnumMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.guice.transactional.Transactional;

import java.util.List;
import java.util.Optional;

public class CatalogCountEnumRepository implements ICatalogCountEnumRepository {
    @Inject
    private SqlSessionFactory sqlSessionFactory;

    @Transactional
    public Optional<CatalogCountEnum> getCatalogCountEnum(Integer id) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CatalogCountEnumMapper mapper = session.getMapper(CatalogCountEnumMapper.class);
            return mapper.selectByPrimaryKey(id);
        }
    }

   public List<CatalogCountEnum> selectAllCatalogCountEnum() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CatalogCountEnumMapper mapper = session.getMapper(CatalogCountEnumMapper.class);
            return mapper.select(SelectDSLCompleter.allRows());
        }
   }

//   @Transactional
//    public void insertCatalogCountEnum(CatalogCountEnum catalogCountEnum) {
//        mapper.insertIntoCatalogCountEnum(catalogCountEnum);
//   }
}
