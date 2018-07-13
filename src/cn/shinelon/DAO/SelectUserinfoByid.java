package cn.shinelon.DAO;

import org.apache.ibatis.session.SqlSession;

import cn.shinelon.pojo.Userinfo;
import cn.shinelon.util.GetSqlSession;

public class SelectUserinfoByid {
	public static void main(String[] args){
		SqlSession sqlSession=GetSqlSession.GetSqlSession();
		Userinfo userinfo=sqlSession.selectOne("mybatis.getUserinfoByid", 1);
		sqlSession.commit();
		System.out.println(userinfo.getId());
		System.out.println(userinfo.getUsername());
		System.out.println(userinfo.getAge());
		System.out.println(userinfo.getInserttime().toString());
		sqlSession.close();
	}
}
