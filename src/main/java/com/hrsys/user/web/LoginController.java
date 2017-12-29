package com.hrsys.user.web;



import java.io.IOException;
import java.security.NoSuchAlgorithmException;
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

import com.hrsys.common.EncryptUtils;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtResponse;
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
		User user = loginService.login(userName,EncryptUtils.encript(password) );
		
		if (user == null) {
			return new ExtAjaxResponse(false, String.format("用户\"%s\"不存在", userName));
		}
		if (!EncryptUtils.encript(password).equals(user.getPassword())) {
			return new ExtAjaxResponse(false, "密码不正确！");
		}
		session.setAttribute("user", user);
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
	public @ResponseBody ExtAjaxResponse changePassword(@RequestParam Long id,@RequestParam String password,@RequestParam String  comfirPassword,HttpSession session) throws NoSuchAlgorithmException {		
		System.out.println(password);
		System.out.println("pass:"+session.getAttribute("password"));
		String comPassword = EncryptUtils.encript(comfirPassword);
		if (!EncryptUtils.encript(password).equals(session.getAttribute("password"))) {
			return new ExtAjaxResponse(false, "密码错误，请重新输入");
		}
		try {
			loginService.changePassword(id, EncryptUtils.encript(password), comPassword);			
			return new ExtAjaxResponse(true, "密码修改成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "密码修改失败");			
		}
	}
	
	//修改个人信息
		@RequestMapping("/updateMessage")
		public @ResponseBody ExtResponse updateMessage(HttpSession session) throws NoSuchAlgorithmException {					
			User user = (User) session.getAttribute("user");
			if (user != null) {
				return new ExtResponse(true, "操作成功", user.getId(), user.getUserNo(), user.getUserName(), user.getPassword(), user.getUserNickName(), user.getSex(), user.getBirthday(), user.getAge(), user.getNativePlace(), user.getNation(),
						user.getCulture(), user.getCollege(), user.getBody(), user.getMarriage(), user.getIdCord(), user.getPhone(), user.getFamilyPhone(), user.getEmail(), user.getUserAccount(), user.getDeptId(), user.getRemark());
			}
			return new ExtResponse(false, "操作不成功");
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
