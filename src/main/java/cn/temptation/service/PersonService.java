package cn.temptation.service;

import java.util.List;
import java.util.Map;

import cn.temptation.dao.Dao;

public class PersonService {

	Dao dao = new Dao();
	//��ѯ�û���ע��
	public List<Map<String,Object>> guanzhu(Map<String,Object> param){
		return dao.select("person.guanzhu", param);
	}
	//��ѯ��΢��
	public List<Map<String,Object>> rmmicro(){
		return dao.select("person.rmmicro");
	}
	//��ѯ�ҵ�΢��
	public List<Map<String,Object>> mymicro(Map<String,Object> param){
		return dao.select("person.mymicro",param);
	}
	
	public List<Map<String,Object>> myshoucang(Map<String,Object> param){
		return dao.select("person.myshoucang",param);
	}
}
