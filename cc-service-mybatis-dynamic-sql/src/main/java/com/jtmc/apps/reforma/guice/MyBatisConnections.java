package com.jtmc.apps.reforma.guice;

import com.google.inject.Inject;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.guice.session.SqlSessionFactoryProvider;

import java.io.IOException;
import java.io.Reader;

public class MyBatisConnections {
    private static SqlSessionFactory sqlSessionFactory;

    static {
//        try (Reader reader = Resources.getResourceAsReader("mybatis-config.xml")) {
//            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
//        } catch (IOException e) {
//            throw new RuntimeException("Error initializing MyBatis", e);
//        }
    }

    private static final ThreadLocal<SqlSession> threadLocalSession = new ThreadLocal<>();

    public static SqlSession getSession() {
        SqlSession session = threadLocalSession.get();
        if (session == null) {
            session = sqlSessionFactory.openSession();
            threadLocalSession.set(session);
        }
        return session;
    }

    public static void closeSession() {
        SqlSession session = threadLocalSession.get();
        if (session != null) {
            session.close();
            threadLocalSession.remove();
        }
    }
}
