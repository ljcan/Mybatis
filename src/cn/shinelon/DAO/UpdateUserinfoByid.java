package cn.shinelon.DAO;

import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import cn.shinelon.pojo.Userinfo;
import cn.shinelon.util.GetSqlSession;

public class UpdateUserinfoByid {

	public static void main(String[] args) {
		SqlSession sqlSession=GetSqlSession.GetSqlSession();
		Userinfo userinfo=new Userinfo();
		userinfo.setId(1);
		userinfo.setUsername("刘军强");
		userinfo.setAge(20);
		userinfo.setInserttime(new Date());
		sqlSession.update("mybatis.updateUserinfoByid", userinfo);
		sqlSession.commit();
		sqlSession.close();
	}

}
