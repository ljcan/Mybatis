package cn.shinelon.DAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.shinelon.pojo.Userinfo;
import cn.shinelon.util.GetSqlSession;

public class SelectAllUserinfo {
	public static void main(String[] args){
		SqlSession sqlSession=GetSqlSession.GetSqlSession();
		List<Userinfo> list=sqlSession.selectList("mybatis.getAllUserinfo");
		sqlSession.commit();
		for(Userinfo userinfo:list){
			System.out.println(userinfo.getId());
			System.out.println(userinfo.getUsername());
			System.out.println(userinfo.getAge());
			System.out.println(userinfo.getInserttime());
			System.out.println("############################");
		}
		sqlSession.close();
	}
}
