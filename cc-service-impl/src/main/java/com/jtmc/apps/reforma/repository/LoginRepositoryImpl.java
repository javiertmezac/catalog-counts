package com.jtmc.apps.reforma.repository;

import com.google.inject.Inject;
import com.jtmc.apps.reforma.domain.Login;
import com.jtmc.apps.reforma.repository.mapper.LoginMapper;
import com.jtmc.apps.reforma.repository.mapper.PersonaDynamicSqlSupport;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;

import java.util.Optional;

import static com.jtmc.apps.reforma.repository.mapper.LoginDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.SqlBuilder.isTrue;
import static org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils.select;

public class LoginRepositoryImpl {
    @Inject
    private SqlSessionFactory sqlSessionFactory;

    public Optional<Login> selectUser(String inputUsername, String base64Encoded) {
        try(SqlSession session = sqlSessionFactory.openSession()) {
            LoginMapper mapper = session.getMapper(LoginMapper.class);
            SelectStatementProvider statementProvider =
                    select(LoginMapper.selectList, login,
                            c -> c.join(PersonaDynamicSqlSupport.persona)
                                    .on(PersonaDynamicSqlSupport.id, SqlBuilder.equalTo(personaid))
                                    .where(username, isEqualTo(inputUsername))
                                    .and(password, isEqualTo(base64Encoded))
                                    .and(status, isTrue())
                    );
            return mapper.selectOne(statementProvider);
        }
    }

    public int insert(Login login) {
        try(SqlSession session = sqlSessionFactory.openSession(true)) {
            LoginMapper mapper = session.getMapper(LoginMapper.class);
            login.setStatus(true);
            return mapper.insert(login);
        }
    }
}
