package cn.temptation.service;

import java.util.Map;

import cn.temptation.dao.Dao;

public class UserService {
	Dao dao = new Dao();
	public Map<String,Object> findByUsername(String username) {
		return dao.selectOne("user.findByUsername", username);
	}
	
	public int insertUser(Map<String,Object> map) {
		return dao.insert("user.insertUser", map);
	}

}
