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
	//��ѯ�ҵķ�˿
	public List<Map<String,Object>> myfensi(Map<String,Object> param){
		return dao.select("person.myfensi", param);
	}
	//��ѯ��΢��
	public List<Map<String,Object>> rmmicro(){
		return dao.select("person.rmmicro");
	}
	//��ѯ�ҵ�΢��
	public List<Map<String,Object>> mymicro(Map<String,Object> param){
		return dao.select("person.mymicro",param);
	}
	//��ѯ�ҵ��ղ�
	public List<Map<String,Object>> myshoucang(Map<String,Object> param){
		return dao.select("person.myshoucang",param);
	}
	//�����û�
	public List<Map<String,Object>> SearchUser(Map<String,Object> param){
		return dao.select("person.SearchUser",param);
	}
	//��ѯ��ǰ�û��Ƿ��ע�����û�
	public Map<String,Object> count_(Map<String,Object> param){
		return dao.selectOne("person.count_",param);
	}
}
