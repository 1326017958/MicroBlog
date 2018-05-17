package cn.temptation.web;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;

import cn.temptation.service.MainService;
import cn.temptation.service.UserService;
import net.sf.json.JSONArray;

@Controller
@RequestMapping(value = "/main")
public class MainController extends Action {
	UserService userService = new UserService();
	MainService mainService = new MainService();
	
	//发布微博
	@ResponseBody
	@RequestMapping(value = "/faBu.action", method = RequestMethod.POST)
	public Map<String,Object> faBu(HttpServletRequest request){
		Map<String,Object> param = _getParameters(request);
		Map<String,Object> map = userService.findByUsername(param.get("username").toString());
		param.put("userid", map.get("userid"));
		param.put("password", map.get("password"));
		Map<String,Object> file = mainService.selectFile();
		param.put("fileid", "");
		param.put("filepath", "");
		if(file!=null) {
			param.put("fileid", file.get("fileid"));
			param.put("filepath", file.get("filepath"));
		}
		int i = mainService.insertMicro(param);
		if(i>0) {
			if(file!=null) {
				mainService.updateFile();
			}
			param.put("flag", true);
		}else {
			param.put("flag", false);
		}
		return param;
	}
	
	//导入文件
	@ResponseBody
	@RequestMapping(value = "/importFile.action", method = RequestMethod.POST)
	public Map<String,Object> importFile(HttpServletRequest request) throws IllegalStateException, IOException {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
		Map<String,Object> param = new HashMap<String, Object>();
		param.put("flag", false);
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request))
        {
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
            while(iter.hasNext())
            {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null)
                {
                    String path=request.getServletContext().getRealPath("/images/");
                    String filename = file.getOriginalFilename();
                    File filepath = new File(path,filename);
                    if (!filepath.getParentFile().exists()) { 
                        filepath.getParentFile().mkdirs();
                    }
                    //上传
                    file.transferTo(new File(path + File.separator + filename));
                    String realpath = request.getContextPath()+"/images/";
                    param.put("filepath", realpath+filename);
                    param.put("status", 0);
                    param.put("flag", true);
                    mainService.importFile(param);
                }

            }
        }
        return param;
	}
	
	//转发微博
	@ResponseBody
	@RequestMapping(value = "/zhuanFaMicro.action", method = RequestMethod.POST)
	public Map<String,Object> zhuanFaMicro(HttpServletRequest request){
		Map<String,Object> param = _getParameters(request);
		Map<String,Object> map = userService.findByUsername(param.get("username").toString());
		param.put("userid", map.get("userid"));
		Map<String,Object> m = mainService.selectMicro(param);
		if(m.containsKey("zhuanfaid")) {
			param.put("zhuanfaid", m.get("zhuanfaid"));
		}else{
			param.put("zhuanfaid", m.get("microid"));
		}
		param.put("microdata", m.get("microdata"));
		if(m.containsKey("fileid")) {
			param.put("fileid", m.get("fileid"));
		}else {
			
		}
		param.put("password", map.get("password"));
		int i = mainService.zhuanFaMicro(param);
		if(i>0) {
			param.put("flag", true);
		}else {
			param.put("flag", false);
		}
		return param;
	}
	
	//对微博点赞
	@ResponseBody
	@RequestMapping(value = "/dianZan.action", method = RequestMethod.POST)
	public Map<String,Object> dianZan(HttpServletRequest request){
		Map<String,Object> param = _getParameters(request);
		Map<String,Object> map = userService.findByUsername(param.get("username").toString());
		Map<String,Object> m = mainService.selectUserZ(param);
		param.put("flag", true);
		param.put("msg", "成功为该微博点赞");
		Map<String,Object> f = mainService.selectMicroZ(param);
		if(m!=null) {
			StringBuffer ttt = new StringBuffer(m.get("dianzanid").toString());
			String dianzanid = m.get("dianzanid").toString();
			String[] a = dianzanid.split(",");
			for(int j=0;j<a.length;j++) {
				if(a[j].equals(param.get("microid").toString())) {
					param.put("flag", false);
					param.put("msg", "你已赞过该微博");
					break;
				}
			}
			if((boolean) param.get("flag")) {
				ttt.append(param.get("microid"));
				ttt.append(",");
				param.put("dianzanid", ttt.toString());
				int i = mainService.updateUserZ(param);
				if(i>0) {
					if(f==null) {
						param.put("zanshu", "1");
					}else {
						int zanshu = (int)f.get("zanshu");
						zanshu=zanshu+1;
						param.put("zanshu", zanshu);
					}
					mainService.updateMicroZ(param);
				}else {
					param.put("flag", false);
					param.put("msg", "为该微博点赞失败，请稍后重试");
				}
			}
		}else {
			String dianzanid = param.get("microid")+",";
			param.put("dianzanid", dianzanid);
			int i = mainService.updateUserZ(param);
			if(i>0) {
				if(f==null) {
					param.put("zanshu", "1");
				}else {
					int zanshu = (int)f.get("zanshu");
					zanshu=zanshu+1;
					param.put("zanshu", zanshu);
				}
				mainService.updateMicroZ(param);
			}else {
				param.put("flag", false);
				param.put("msg", "为该微博点赞失败，请稍后重试");
			}
		}
		param.put("password", map.get("password"));
		return param;
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/deleteZan.action", method = RequestMethod.POST)
	public Map<String,Object> deleteZan(HttpServletRequest request){
		Map<String,Object> param = _getParameters(request);
		Map<String,Object> m = mainService.selectUserZ(param);
		Map<String,Object> f = mainService.selectMicroZ(param);
		int j;
		String[] a = m.get("dianzanid").toString().split(",");
		StringBuffer ttt = new StringBuffer();
		for(int i=0;i<a.length;i++) {
			if(!a[i].equals(param.get("microid"))) {
				ttt.append(",");
				ttt.append(a[i]);
			}
		}
		if(a.length==1) {
			j = mainService.deleteAllZan(param);
		}else {
			param.put("dianzanid", ttt.toString());
			j = mainService.updateUserZ(param);
		}
		if(j>0) {
			if(f==null) {
				param.put("flag", false);
			}else {
				int zanshu = (int)f.get("zanshu");
				zanshu=zanshu-1;
				param.put("zanshu", zanshu);
			}
			int w = mainService.updateMicroZ(param);
			if(w>0) {
				param.put("flag", true);
			}else {
				param.put("flag", false);
			}
		}else {
			param.put("flag", false);
		}
		return param;
	}
	
	//收藏微博
	@ResponseBody
	@RequestMapping(value = "/shouCang.action", method = RequestMethod.POST)
	public Map<String,Object> shouCang(HttpServletRequest request){
		Map<String,Object> param = _getParameters(request);
		Map<String,Object> map = userService.findByUsername(param.get("username").toString());
		Map<String,Object> m = mainService.selectUserS(param);
		param.put("flag", true);
		param.put("msg", "成功收藏该微博");
		Map<String,Object> f = mainService.selectMicroS(param);
		if(m!=null) {
			StringBuffer ttt = new StringBuffer(m.get("shoucangid").toString());
			String shoucangid = m.get("shoucangid").toString();
			String[] a = shoucangid.split(",");
			for(int j=0;j<a.length;j++) {
				if(a[j].equals(param.get("microid").toString())) {
					param.put("flag", false);
					param.put("msg", "你已收藏过该微博");
					break;
				}
			}
			if((boolean) param.get("flag")) {
				ttt.append(param.get("microid"));
				ttt.append(",");
				param.put("shoucangid", ttt.toString());
				int i = mainService.updateUserS(param);
				if(i>0) {
					if(f==null) {
						param.put("cangshu", "1");
					}else {
						int cangshu = (int)f.get("cangshu");
						cangshu=cangshu+1;
						param.put("cangshu", cangshu);
					}
					mainService.updateMicroS(param);
				}else {
					param.put("flag", false);
					param.put("msg", "收藏该微博失败，请稍后重试");
				}
			}
		}else {
			String shoucangid = param.get("microid")+",";
			param.put("shoucangid", shoucangid);
			int i = mainService.updateUserS(param);
			if(i>0) {
				if(f==null) {
					param.put("cangshu", "1");
				}else {
					int zanshu = (int)f.get("cangshu");
					zanshu=zanshu+1;
					param.put("cangshu", zanshu);
				}
				mainService.updateMicroS(param);
			}else {
				param.put("flag", false);
				param.put("msg", "为该微博点赞失败，请稍后重试");
			}
		}
		param.put("password", map.get("password"));
		return param;
	}
	
	//热门首页
	@ResponseBody
	@RequestMapping(value = "/index.action", method = RequestMethod.POST)
	public List<Map<String,Object>> index(HttpServletRequest request){
		List<Map<String,Object>> list = mainService.index();
		Map<String,Object> param = _getParameters(request);
		Map<String,Object> map = mainService.selectUserZ(param);
		//为转发微博添加微博作者信息
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).containsKey("zhuanfaid")) {
				Map<String,Object> m = mainService.authorInfo(list.get(i).get("zhuanfaid").toString());
				list.get(i).put("authorid", m.get("userid"));
				list.get(i).put("authorusername", m.get("username"));
				list.get(i).put("authorname", m.get("name"));
			}
		}
		//查询用户点赞的微博id
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
	@RequestMapping(value = "/self.action", method = RequestMethod.POST)
	public List<Map<String,Object>> self(HttpServletRequest request){
		List<Map<String,Object>> list = mainService.self();
		//为转发微博添加微博作者信息
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).containsKey("zhuanfaid")) {
				Map<String,Object> m = mainService.authorInfo(list.get(i).get("zhuanfaid").toString());
				list.get(i).put("authorid", m.get("userid"));
				list.get(i).put("authorusername", m.get("username"));
				list.get(i).put("authorname", m.get("name"));
			}
		}
		//查询用户点赞的微博id
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
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/image.action", method = RequestMethod.POST)
	public List<Map<String,Object>> image(HttpServletRequest request){
		List<Map<String,Object>> list = mainService.image();
		//为转发微博添加微博作者信息
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).containsKey("zhuanfaid")) {
				Map<String,Object> m = mainService.authorInfo(list.get(i).get("zhuanfaid").toString());
				list.get(i).put("authorid", m.get("userid"));
				list.get(i).put("authorusername", m.get("username"));
				list.get(i).put("authorname", m.get("name"));
			}
		}
		//查询用户点赞的微博id
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
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/usergz.action", method = RequestMethod.GET)
	public ModelAndView usergz(HttpServletRequest request,HttpSession session){
		Map<String,Object> param = _getParameters(request);
		session.setAttribute("username", param.get("username"));
		session.setAttribute("name", param.get("name"));
		session.setAttribute("password", param.get("password"));
		ModelAndView mav =new ModelAndView();
		session.setAttribute("fenlei1", "mymain");
		session.setAttribute("fenlei2", "guanzhu");
		mav.setViewName("person");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/userfs.action", method = RequestMethod.GET)
	public ModelAndView userfs(HttpServletRequest request,HttpSession session){
		Map<String,Object> param = _getParameters(request);
		session.setAttribute("username", param.get("username"));
		session.setAttribute("name", param.get("name"));
		session.setAttribute("password", param.get("password"));
		ModelAndView mav =new ModelAndView();
		session.setAttribute("fenlei1", "mymain");
		session.setAttribute("fenlei2", "fensi");
		mav.setViewName("person");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/usersc.action", method = RequestMethod.GET)
	public ModelAndView usersc(HttpServletRequest request,HttpSession session){
		Map<String,Object> param = _getParameters(request);
		session.setAttribute("username", param.get("username"));
		session.setAttribute("name", param.get("name"));
		session.setAttribute("password", param.get("password"));
		ModelAndView mav =new ModelAndView();
		session.setAttribute("fenlei1", "mymain");
		session.setAttribute("fenlei2", "shoucang");
		mav.setViewName("person");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/userm.action", method = RequestMethod.GET)
	public ModelAndView userm(HttpServletRequest request,HttpSession session){
		Map<String,Object> param = _getParameters(request);
		session.setAttribute("username", param.get("username"));
		session.setAttribute("name", param.get("name"));
		session.setAttribute("password", param.get("password"));
		ModelAndView mav =new ModelAndView();
		session.setAttribute("fenlei1", "mymicro");
		session.setAttribute("fenlei2", "");
		mav.setViewName("person");
		return mav;
	}
	
	@ResponseBody
	@RequestMapping(value = "/userzl.action", method = RequestMethod.POST)
	public ModelAndView userzl(HttpServletRequest request,HttpSession session){
		Map<String,Object> param = _getParameters(request);
		session.setAttribute("username", param.get("username"));
		session.setAttribute("name", param.get("name"));
		session.setAttribute("password", param.get("password"));
		ModelAndView mav =new ModelAndView();
		session.setAttribute("fenlei", "myziliao");
		session.setAttribute("fenlei_", "");
		mav.setViewName("person");
		return mav;
	}
	
	

}
