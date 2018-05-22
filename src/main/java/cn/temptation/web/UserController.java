package cn.temptation.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.temptation.domain.User;
import cn.temptation.service.UserService;

/**
 * ÓÃ»§¿ØÖÆÆ÷
 */
@Controller
@RequestMapping(value = "/user")
public class UserController extends Action{

	UserService userService = new UserService();
	
    @RequestMapping(value="/index.action",method = RequestMethod.GET)
    public ModelAndView index() {
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("login");
        return mav;
    }
    
    @ResponseBody
    @RequestMapping(value = "/loginCheck.action", method = RequestMethod.GET)
    public Map<String,Object> loginCheck(User model, HttpSession session) {
        Map<String,Object> map = userService.findByUsername(model.getUsername());

        if (map == null || !map.get("password").equals(model.getPassword())) {
        	map.put("flag", false);
            return map;
        } else {
            map.put("flag", true);
            return map;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/login.action", method = RequestMethod.GET)
    public ModelAndView login(HttpServletRequest request, HttpSession session) {
    	Map<String,Object> param = _getParameters(request);
        Map<String,Object> map = userService.findByUsername(param.get("username").toString());

        if (map == null || !map.get("password").equals(param.get("password"))) {
        	ModelAndView mav = new ModelAndView();
        	mav.setViewName("login");
            return mav;
        } else {
            session.setAttribute("user", param);
            session.setAttribute("name", map.get("name"));
            session.setAttribute("map", map);
            ModelAndView mav = new ModelAndView();
            mav.setViewName("main");
            return mav;
        }
    }
    
    @RequestMapping(value="/register.action",method = RequestMethod.GET)
    public ModelAndView register() {
    	ModelAndView mav = new ModelAndView();
    	mav.setViewName("register");
        return mav;
    }
    
    @ResponseBody
    @RequestMapping(value = "/insertUser.action", method = RequestMethod.GET)
    public Map<String,Object> insertUser(HttpServletRequest request) {
        Map<String,Object> map = _getParameters(request);
        int i = userService.insertUser(map);
        if (i>0) {
        	map.put("flag", true);
            return map;
        } else {
            map.put("flag", false);
            return map;
        }
    }
    
    @ResponseBody
    @RequestMapping(value = "/updateUser.action", method = RequestMethod.GET)
    public Map<String,Object> updateUser(HttpServletRequest request) {
        Map<String,Object> map = _getParameters(request);
        int i = userService.updateUser(map);
        if (i>0) {
        	map.put("flag", true);
            return map;
        } else {
            map.put("flag", false);
            return map;
        }
    }
}