package cn.temptation.web;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public abstract class Action {
	public static Map<String,Object> _getParameters(HttpServletRequest request){
		Map<String,Object> m = new HashMap<>();
		Enumeration<?> en = request.getParameterNames();
		while(en.hasMoreElements()) {
			Object enN = en.nextElement();
			String para = request.getParameter(enN.toString()).trim();
			m.put(enN.toString(), "undefined".equals(para) ? "" : para.trim());
		}
		return m;
	}

}
