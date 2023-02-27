package kr.kh.test.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import kr.kh.test.vo.MemberVO;

public class LoginInterceptor extends HandlerInterceptorAdapter {

	@Override
	public void postHandle(
	    HttpServletRequest request, 
	    HttpServletResponse response, 
	    Object handler, 
	    ModelAndView modelAndView)
	    throws Exception {
		//컨트롤러가 mv에 담아 보낸 user정보를 가져옴
	    ModelMap modelMap = modelAndView.getModelMap();
	    MemberVO user = (MemberVO)modelMap.get("user");
	    if(user != null) {
	    	//회원정보가 있으면 세션에 회원정보추가
	        HttpSession session = request.getSession();
	        session.setAttribute("user", user);
	    }
	}

	public void logout(
		    HttpServletRequest request, 
		    HttpServletResponse response, 
		    Object handler, 
		    ModelAndView modelAndView) throws Exception
	{
		HttpSession session = request.getSession();
		session.setAttribute(null, session);
		
	}
}
