package com.test.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

    private static String config_path;
    
    private static final String config_path_file_name = "mybatis-config.xml";
    
    private static String config_properties;
    
    private static final String config_properties_file_name = "mybatis-config.properties";
    
    private static SqlSessionFactory sqlSessionFactory;
    
    static {
        try {
            config_path = Resources.getResourceURL(config_path_file_name).getFile();
            config_properties = Resources.getResourceURL(config_properties_file_name).getFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static synchronized SqlSessionFactory getSqlSqlSessionFactory() {
        if(sqlSessionFactory == null) {
            try {
                InputStream inputStream = Resources.getResourceAsStream(config_path_file_name);
                Properties properties = Resources.getResourceAsProperties(config_properties_file_name);
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream, properties);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sqlSessionFactory;
    }
    
}
