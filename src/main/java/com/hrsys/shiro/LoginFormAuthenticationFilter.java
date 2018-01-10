package com.hrsys.shiro;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class LoginFormAuthenticationFilter extends FormAuthenticationFilter{
	private static final Logger LOGGER =  Logger.getLogger(LoginFormAuthenticationFilter.class);
	
	 protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {

	        WebUtils.getAndClearSavedRequest(request);
	        WebUtils.redirectToSavedRequest(request,response,"/index");

	        return false;
	    }
}