package cn.temptation.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Dao {
	private SqlSessionFactory sqlSessionFactory; 
	public SqlSession openSession(){
		InputStream inputStream;
		try {
			inputStream = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	} 
	
	public int insert(String str,Object param){
		SqlSession session = openSession();
		int i=session.insert(str, param);
		session.commit();
		session.close();
		return i;
	}
	
	public int insert(String str){
		SqlSession session = openSession();
		int i=session.insert(str);
		session.commit();
		session.close();
		return i;
	}
	
	public int delete(String str){
		SqlSession session = openSession();
		int i=session.delete(str);
		session.commit();
		session.close();
		return i;
	}
	
	public int delete(String str,Object param){
		SqlSession session = openSession();
		int i=session.delete(str, param);
		session.commit();
		session.close();
		return i;
	}
	
	public List<Map<String,Object>> select(String str,Object param){
		return openSession().selectList(str, param);
	}
	
	public List<Map<String,Object>> select(String str){
		return openSession().selectList(str);
	}
	
	public Map<String,Object> selectOne(String str,Object param){
		return openSession().selectOne(str, param);
	}
	
	public Map<String,Object> selectOne(String str){
		return openSession().selectOne(str);
	}
	
	public int update(String str,Object param){
		SqlSession session = openSession();
		int i=session.update(str, param);
		session.commit();
		session.close();
		return i;
	}
	
	public int update(String str){
		SqlSession session = openSession();
		int i=session.update(str);
		session.commit();
		session.close();
		return i;
	}

}
