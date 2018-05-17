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
	//查询热微博
	public List<Map<String,Object>> rmmicro(){
		return dao.select("person.rmmicro");
	}
	//查询我的微博
	public List<Map<String,Object>> mymicro(Map<String,Object> param){
		return dao.select("person.mymicro",param);
	}
	
	public List<Map<String,Object>> myshoucang(Map<String,Object> param){
		return dao.select("person.myshoucang",param);
	}
}
