package com.hrsys.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;



public class ShiroExceptionResolver implements HandlerExceptionResolver {

   
	

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		// TODO Auto-generated method stub
		 if(ex instanceof UnauthorizedException) {
			 ModelAndView view = new ModelAndView(new MappingJackson2JsonView());  
		        view.addObject("success", false);  
		        view.addObject("msg", "您无权限,请跟管理员申请权限");  
		        return view;  
	            
	        }
	        return null;
		
	}

}
