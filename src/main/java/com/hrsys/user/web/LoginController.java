/*package com.hrsys.user.web;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.user.service.ILoginService;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private ILoginService loginService;
	@Autowired
	HttpServletRequest request;
	@Autowired
	HttpServletResponse response;
	//登录
	@RequestMapping("/login")
	public @ResponseBody ExtAjaxResponse login(@RequestParam String userName,@RequestParam String password) throws Exception, IOException {
		logger.debug("login request: {userName={}, password={}}", userName, password);
		ExtAjaxResponse result = null;
		try {
			result = loginService.login(userName, password);
			return new ExtAjaxResponse(true, "登录成功");
		} catch (Exception e) {
			logger.error("{}", e);
			return new ExtAjaxResponse(true, "登录失败");
			//request.getRequestDispatcher("login").forward(request, response);		
		}
	}
	//修改密码
	@RequestMapping("/changePassword")
	public @ResponseBody ExtAjaxResponse changePassword(@RequestParam Long id,@RequestParam String password,@RequestParam String comfirPassword) {
		try {
			loginService.changePassword(id, password, comfirPassword);
			return new ExtAjaxResponse(true, "密码修改成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "密码修改失败");			
		}
	}
	//退出系统
	@RequestMapping("/logout")
	public @ResponseBody ExtAjaxResponse logout() {
		try {
			loginService.logout();
			return new ExtAjaxResponse(true, "退出成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "退出失败");
		}
	}
	//判断是否已经登录   ??有点问题
	@RequestMapping("/isLogined")
	public @ResponseBody ExtAjaxResponse isLogined() {
		try {
			loginService.isLogined();
			return new ExtAjaxResponse(true, "用户已登录");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "");
		}
	}
}
*/