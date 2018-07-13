package cn.shinelon.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class GetSqlSession {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader; 
    private static SqlSession sqlSession;
    static{
        try{
//        	InputStream isRef=Resources.getResourceAsStream("db.properties");
//        	Properties pro=new Properties();
//        	pro.load(isRef);
        	reader= Resources.getResourceAsReader("Configuration.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader); //
        }catch(Exception e){
            e.printStackTrace();
        }
    }
	public static SqlSession GetSqlSession(){
	try {
		sqlSession=sqlSessionFactory.openSession();
		System.out.println("创建SqlSession");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return sqlSession;
	}	
}
