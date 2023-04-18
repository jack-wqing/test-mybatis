package com.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.test.factory.SqlSessionFactoryUtils;
import com.test.model.User;

public class MybatisTest {

    private static final String user_namespace = "com.test.mapper.User.";
    
    @Test
    public void testAdd() {
        String sql = "insert";
        SqlSessionFactory sessionFactory =  SqlSessionFactoryUtils.getSqlSqlSessionFactory();
        SqlSession session = null;
        try {
            session = sessionFactory.openSession(true);
            User user = new User(null, "liuwenqing", 32, new Date(), null);
            int result = session.insert(findSql(sql, user_namespace), user);
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          if(session != null) {
              session.close();
          }  
        }
    }
    @Test
    public void testSelect() {
        String sql = "select";
        SqlSessionFactory sessionFactory =  SqlSessionFactoryUtils.getSqlSqlSessionFactory();
        SqlSession session = null;
        try {
            session = sessionFactory.openSession(true);
            List<Object> list = session.selectList(findSql(sql, user_namespace));
            System.out.println(list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
          if(session != null) {
              session.close();
          }  
        }
    }
    
    
    private String findSql(String sql, String namespace) {
        return namespace + sql;
    }
    
}
