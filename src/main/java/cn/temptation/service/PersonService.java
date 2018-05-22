package cn.temptation.service;

import java.util.List;
import java.util.Map;

import cn.temptation.dao.Dao;

public class PersonService {

	Dao dao = new Dao();
	//查询用户关注人
	public List<Map<String,Object>> guanzhu(Map<String,Object> param){
		return dao.select("person.guanzhu", param);
	}
	//查询我的粉丝
	public List<Map<String,Object>> myfensi(Map<String,Object> param){
		return dao.select("person.myfensi", param);
	}
	//查询热微博
	public List<Map<String,Object>> rmmicro(){
		return dao.select("person.rmmicro");
	}
	//查询我的微博
	public List<Map<String,Object>> mymicro(Map<String,Object> param){
		return dao.select("person.mymicro",param);
	}
	//查询我的收藏
	public List<Map<String,Object>> myshoucang(Map<String,Object> param){
		return dao.select("person.myshoucang",param);
	}
	//搜索用户
	public List<Map<String,Object>> SearchUser(Map<String,Object> param){
		return dao.select("person.SearchUser",param);
	}
	//查询当前用户是否关注搜索用户
	public Map<String,Object> count_(Map<String,Object> param){
		return dao.selectOne("person.count_",param);
	}
}
