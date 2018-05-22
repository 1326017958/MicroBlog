package cn.temptation.service;

import java.util.List;
import java.util.Map;

import cn.temptation.dao.Dao;

public class MainService {
	Dao dao = new Dao();

	//发布微博
	public int insertMicro(Map<String,Object> param) {
		param.put("status", 0);
		return dao.insert("main.insertMicro", param);
	}
	//转发
	public int zhuanFaMicro(Map<String,Object> param) {
		return dao.insert("main.zhuanFaMicro", param);
	}
	//查询作者信息
	public Map<String,Object> authorInfo(String param) {
		return dao.selectOne("main.authorInfo", param);
	}
	//查询指定某条微博信息
	public Map<String,Object> selectMicro(Map<String,Object> param){
		return dao.selectOne("main.selectMicro", param);
	}
	//首页查询所有动态
	public List<Map<String,Object>> index(){
		return dao.select("main.index");
	}
	//查询原创动态
	public List<Map<String,Object>> self(){
		return dao.select("main.self");
	}
	//查询图片
	public List<Map<String,Object>> image(){
		return dao.select("main.image");
	}
	//插入文件路径
	public int importFile(Map<String,Object> param){
		return dao.insert("main.importFile", param);
	}
	//查询上传但未发表文件
	public Map<String,Object> selectFile(){
		return dao.selectOne("main.selectFile");
	}
	//更新文件状态
	public int updateFile(){
		return dao.update("main.updateFile");
	}
	//查询用户点赞微博
	public Map<String,Object> selectUserZ(Map<String,Object> param) {
		return dao.selectOne("main.selectUserZ", param);
	}
	//更新用户点赞微博id
	public int updateUserZ(Map<String,Object> param) {
		return dao.update("main.updateUserZ", param);
	}
	//查询微博点赞数
	public Map<String,Object> selectMicroZ(Map<String,Object> param) {
		return dao.selectOne("main.selectMicroZ", param);
	}
	//更新微博点赞数
	public int updateMicroZ(Map<String,Object> param) {
		return dao.update("main.updateMicroZ", param);
	}
	//删除用户所有点赞微博
	public int deleteAllZan(Map<String,Object> param) {
		return dao.delete("maindeleteAllZan", param);
	}
	//查询用户收藏微博
	public Map<String,Object> selectUserS(Map<String,Object> param) {
		return dao.selectOne("main.selectUserS", param);
	}
	//查询微博收藏数
	public Map<String,Object> selectMicroS(Map<String,Object> param) {
		return dao.selectOne("main.selectMicroS", param);
	}
	//更新用户收藏微博
	public int updateUserS(Map<String,Object> param) {
		return dao.update("main.updateUserS", param);
	}
	//更新微博收藏数
	public int updateMicroS(Map<String,Object> param) {
		return dao.update("main.updateMicroS", param);
	}
	//发表评论
	public int insertPl(Map<String,Object> param) {
		return dao.insert("main.insertPl", param);
	}
	//查询一级评论
	public List<Map<String,Object>> pingLun(Map<String,Object> param){
		return dao.select("main.pingLun",param);
	}
	//查询二级评论
	public List<Map<String,Object>> huiFu(Map<String,Object> param){
		return dao.select("main.huiFu",param);
	}
	//查询评论用户信息
	public Map<String,Object> plid_2UInfo(String plid_2){
		return dao.selectOne("main.plid_2UInfo",plid_2);
	}
	
}
