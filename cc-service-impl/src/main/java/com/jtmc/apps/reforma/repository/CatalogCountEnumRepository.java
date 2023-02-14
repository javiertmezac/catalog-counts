package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.CatalogCountEnum;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountEnumDynamicSqlSupport;
import com.jtmc.apps.reforma.repository.mapper.CatalogCountEnumMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.DefaultSelectStatementProvider;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.mybatis.dynamic.sql.where.WhereDSL;
import org.mybatis.guice.transactional.Transactional;

import javax.ws.rs.NotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

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

    public CatalogCountEnum getInitialAmountEnum() {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            CatalogCountEnumMapper mapper = session.getMapper(CatalogCountEnumMapper.class);
            String initialAmountIdentifier = "0.1";
            Optional<CatalogCountEnum> optionalEnum = mapper.selectOne(c -> c.where(CatalogCountEnumDynamicSqlSupport.identifier,
                    SqlBuilder.isEqualTo(initialAmountIdentifier)));
//            return optionalEnum.orElseThrow(NotFoundException::new);
            CatalogCountEnum empty = new CatalogCountEnum();
            return optionalEnum.orElse(empty);
        }
    }

   public Stream<CatalogCountEnum> getIncomeCatalogCountEnums() {
        Boolean isOutcome = true;
        return this.selectAllCatalogCountEnum().stream().filter(x -> x.getType() != isOutcome);
   }

//   @Transactional
//    public void insertCatalogCountEnum(CatalogCountEnum catalogCountEnum) {
//        mapper.insertIntoCatalogCountEnum(catalogCountEnum);
//   }
}
