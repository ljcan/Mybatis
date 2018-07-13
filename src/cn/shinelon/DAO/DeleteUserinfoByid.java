package cn.shinelon.DAO;

import org.apache.ibatis.session.SqlSession;

import cn.shinelon.util.GetSqlSession;

public class DeleteUserinfoByid {
	public static void main(String[] args){
		SqlSession sqlSession=GetSqlSession.GetSqlSession();
		sqlSession.delete("mybatis.deleteUserinfoByid", 3);
		sqlSession.commit();
		sqlSession.close();
	}
}
