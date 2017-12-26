package com.hrsys.user.web;



import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.loader.plan.exec.process.spi.ReturnReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.user.dao.UserRepository;
import com.hrsys.user.entity.User;
import com.hrsys.user.service.ILoginService;
import com.hrsys.user.service.IUserService;
import com.hrsys.user.service.impl.UserServiceImpl;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);	
	@Autowired
	private ILoginService loginService;
	//登录
	@RequestMapping("/login")
	public @ResponseBody ExtAjaxResponse login(@RequestParam String userName,@RequestParam String password,HttpSession session) throws Exception, IOException {
		logger.debug("login request: {userName={}, password={}}", userName, password);		
		User user = loginService.login(userName, password);
		if (user == null) {
			return new ExtAjaxResponse(false, String.format("用户\"%s\"不存在", userName));
		}
		if (!password.equals(user.getPassword())) {
			return new ExtAjaxResponse(false, "密码不正确！");
		}
		session.setAttribute("userName", userName);
		session.setAttribute("userId", user.getId());
		session.setAttribute("password", user.getPassword());
		try {
							
				User result = loginService.login(userName, password);
				return new ExtAjaxResponse(true, "登录成功2");						
		} catch (Exception e) {
			logger.error("{}", e);
			return new ExtAjaxResponse(false, "登录失败");
			//request.getRequestDispatcher("login").forward(request, response);		
		}
	}
	//修改密码
	@RequestMapping("/updatePassword")
	public @ResponseBody ExtAjaxResponse changePassword(@RequestParam Long id,@RequestParam String password,@RequestParam String comfirPassword,HttpSession session) {
		//System.out.println(id);
		//System.out.println(password);
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
