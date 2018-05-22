package cn.temptation.service;

import java.util.List;
import java.util.Map;

import cn.temptation.dao.Dao;

public class MainService {
	Dao dao = new Dao();

	//����΢��
	public int insertMicro(Map<String,Object> param) {
		param.put("status", 0);
		return dao.insert("main.insertMicro", param);
	}
	//ת��
	public int zhuanFaMicro(Map<String,Object> param) {
		return dao.insert("main.zhuanFaMicro", param);
	}
	//��ѯ������Ϣ
	public Map<String,Object> authorInfo(String param) {
		return dao.selectOne("main.authorInfo", param);
	}
	//��ѯָ��ĳ��΢����Ϣ
	public Map<String,Object> selectMicro(Map<String,Object> param){
		return dao.selectOne("main.selectMicro", param);
	}
	//��ҳ��ѯ���ж�̬
	public List<Map<String,Object>> index(){
		return dao.select("main.index");
	}
	//��ѯԭ����̬
	public List<Map<String,Object>> self(){
		return dao.select("main.self");
	}
	//��ѯͼƬ
	public List<Map<String,Object>> image(){
		return dao.select("main.image");
	}
	//�����ļ�·��
	public int importFile(Map<String,Object> param){
		return dao.insert("main.importFile", param);
	}
	//��ѯ�ϴ���δ�����ļ�
	public Map<String,Object> selectFile(){
		return dao.selectOne("main.selectFile");
	}
	//�����ļ�״̬
	public int updateFile(){
		return dao.update("main.updateFile");
	}
	//��ѯ�û�����΢��
	public Map<String,Object> selectUserZ(Map<String,Object> param) {
		return dao.selectOne("main.selectUserZ", param);
	}
	//�����û�����΢��id
	public int updateUserZ(Map<String,Object> param) {
		return dao.update("main.updateUserZ", param);
	}
	//��ѯ΢��������
	public Map<String,Object> selectMicroZ(Map<String,Object> param) {
		return dao.selectOne("main.selectMicroZ", param);
	}
	//����΢��������
	public int updateMicroZ(Map<String,Object> param) {
		return dao.update("main.updateMicroZ", param);
	}
	//ɾ���û����е���΢��
	public int deleteAllZan(Map<String,Object> param) {
		return dao.delete("maindeleteAllZan", param);
	}
	//��ѯ�û��ղ�΢��
	public Map<String,Object> selectUserS(Map<String,Object> param) {
		return dao.selectOne("main.selectUserS", param);
	}
	//��ѯ΢���ղ���
	public Map<String,Object> selectMicroS(Map<String,Object> param) {
		return dao.selectOne("main.selectMicroS", param);
	}
	//�����û��ղ�΢��
	public int updateUserS(Map<String,Object> param) {
		return dao.update("main.updateUserS", param);
	}
	//����΢���ղ���
	public int updateMicroS(Map<String,Object> param) {
		return dao.update("main.updateMicroS", param);
	}
	//��������
	public int insertPl(Map<String,Object> param) {
		return dao.insert("main.insertPl", param);
	}
	//��ѯһ������
	public List<Map<String,Object>> pingLun(Map<String,Object> param){
		return dao.select("main.pingLun",param);
	}
	//��ѯ��������
	public List<Map<String,Object>> huiFu(Map<String,Object> param){
		return dao.select("main.huiFu",param);
	}
	//��ѯ�����û���Ϣ
	public Map<String,Object> plid_2UInfo(String plid_2){
		return dao.selectOne("main.plid_2UInfo",plid_2);
	}
	
}
