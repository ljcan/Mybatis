package cn.shinelon.DAO;

import java.util.ArrayList;
import java.util.Date;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.shinelon.pojo.Userinfo;
import cn.shinelon.util.GetSqlSession;

public class InsertUserinfoByid{
	public static void main(String[] args){
		SqlSession sqlSession=GetSqlSession.GetSqlSession();
		try {
//		Userinfo userinfo1=new Userinfo();
//		userinfo1.setUsername("刘军强");
//		userinfo1.setAge(18);
//		userinfo1.setInserttime(new Date());
			//使用map插入数据
			Map<String,Object> map1=new HashMap<String,Object>();
			map1.put("username", "刘军强");
			map1.put("age", 18);
			map1.put("inserttime", new Date());
			sqlSession.insert("mybatis.insertUserinfoByid", map1);
			Map<String,Object> map2=new HashMap<String,Object>();
			map2.put("username", "马玉成");
			map2.put("age", 19);
			map2.put("inserttime", new Date());
			sqlSession.insert("mybatis.insertUserinfoByid", map2);
			//这条记录会出错，测试回滚
			Map<String,Object> map3=new HashMap<String,Object>();
			//sql语句出错，将截断字符串或者二进制数，将抛出异常，事务回滚
			map3.put("username", "马伟_123456789_123456789_123456789");	
			map3.put("id", 2);
			map3.put("age", 20);
			map3.put("inserttime", new Date());	
			sqlSession.insert("mybatis.insertUserinfoByid", map3);
			sqlSession.commit();
		} catch (Exception e) {
			System.out.println("抛出异常");
			sqlSession.rollback();
		}finally{
			sqlSession.close();
		}
	}
}
