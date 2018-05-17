package cn.temptation.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.temptation.service.MainService;
import cn.temptation.service.PersonService;
import cn.temptation.service.UserService;
import net.sf.json.JSONArray;
@Controller
@RequestMapping(value = "/person")
public class PersonController extends Action {
	PersonService personService = new PersonService();
	UserService userService = new UserService();
	MainService mainService = new MainService();
	@ResponseBody
	@RequestMapping(value = "/guanzhu.action", method = RequestMethod.GET)
	public PageInfo guanzhu(HttpServletRequest request) {
		Map<String,Object> param = _getParameters(request);
		int a =Integer.parseInt(param.get("pn").toString());
		PageHelper.startPage(a, 6);
		List<Map<String,Object>> list = personService.guanzhu(param);
		PageInfo page = new PageInfo<>(list,6);
		return page;
	}
	
	@ResponseBody
	@RequestMapping(value = "/rmmicro.action", method = RequestMethod.GET)
	public PageInfo rmmicro(HttpServletRequest request) {
		PageHelper.startPage(1, 6);
		List<Map<String,Object>> list = personService.rmmicro();
		
		//查询用户点赞的id
		Map<String,Object> param = _getParameters(request);
		Map<String,Object> map = mainService.selectUserZ(param);
		if(map!=null) {
			String[] a = map.get("dianzanid").toString().split(",");
			JSONArray json = JSONArray.fromObject(a);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).put("dianzanid", json);
			}
		}
		//查询用户收藏的微博id
		Map<String,Object> map1 = mainService.selectUserS(param);
		if(map1!=null) {
			String[] a = map1.get("shoucangid").toString().split(",");
			JSONArray json = JSONArray.fromObject(a);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).put("shoucangid", json);
			}
		}
		PageInfo page = new PageInfo<>(list,6);
		return page;
	}
	
	@ResponseBody
	@RequestMapping(value = "/mymicro.action", method = RequestMethod.GET)
	public List<Map<String,Object>> mymicro(HttpServletRequest request) {
		Map<String,Object> param = _getParameters(request);
		Map<String,Object> param2 = userService.findByUsername(param.get("username").toString());
		List<Map<String,Object>> list = personService.mymicro(param2);
		//查询用户点赞的微博id
		Map<String,Object> map = mainService.selectUserZ(param);
		if(map!=null) {
			String[] a = map.get("dianzanid").toString().split(",");
			JSONArray json = JSONArray.fromObject(a);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).put("dianzanid", json);
			}
		}
		//查询用户收藏的微博id
		Map<String,Object> map1 = mainService.selectUserS(param);
		if(map1!=null) {
			String[] a = map1.get("shoucangid").toString().split(",");
			JSONArray json = JSONArray.fromObject(a);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).put("shoucangid", json);
			}
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/myshoucang.action", method = RequestMethod.GET)
	public List<Map<String,Object>> myshoucang(HttpServletRequest request) {
		Map<String,Object> param = _getParameters(request);
		List<Map<String,Object>> list = personService.myshoucang(param);
		//查询用户点赞的微博id
		Map<String,Object> map = mainService.selectUserZ(param);
		if(map!=null) {
			String[] a = map.get("dianzanid").toString().split(",");
			JSONArray json = JSONArray.fromObject(a);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).put("dianzanid", json);
			}
		}
		//查询用户收藏的微博id
		Map<String,Object> map1 = mainService.selectUserS(param);
		if(map1!=null) {
			String[] a = map1.get("shoucangid").toString().split(",");
			JSONArray json = JSONArray.fromObject(a);
			for (int i = 0; i < list.size(); i++) {
				list.get(i).put("shoucangid", json);
			}
		}
		return list;
	}

}
