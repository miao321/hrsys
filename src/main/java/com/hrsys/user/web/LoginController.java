package com.hrsys.user.web;



import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.annotation.SysControllerLog;
import com.hrsys.common.EncryptUtils;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtResponse;
import com.hrsys.user.entity.User;
import com.hrsys.user.service.ILoginService;
import com.hrsys.user.service.impl.LoginServiceImpl;


@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private ILoginService loginService;
	
	@RequestMapping(value="/login")
	//@SysControllerLog(module="系统登录",methods="登录系统")
	public String login(HttpServletRequest request,HttpSession session) throws Exception {		
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {			
                session.setAttribute("result", "账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(
					exceptionClassName)) {				
				session.setAttribute("result2", "用户名/密码错误");
			} else{
				//最终在异常处理器生成未知错误
				throw new Exception();
			}
		}
		return "login";
	}
	@RequestMapping(value="first")
	@SysControllerLog(module="系统登录",methods="登录系统")
   public String first(HttpSession session)throws Exception{	
		//从shiro的session中取User
		Subject subject = SecurityUtils.getSubject();
		//取身份信息
		String userName =  (String) subject.getPrincipal();
		session.setAttribute("userName", userName);
		User user = loginService.findUser(userName);
		session.setAttribute("user", user);
		session.setAttribute("userName", user.getUserName());
		session.setAttribute("userId", user.getId());
		session.setAttribute("password", user.getPassword());
		return "WEB-INF/pages/index";
	}	
	//修改密码
	@RequestMapping("/updatePassword")
	@SysControllerLog(module="用户管理",methods="修改密码")
	public @ResponseBody ExtAjaxResponse changePassword(@RequestParam Long id,@RequestParam String password,@RequestParam String  comfirPassword,HttpSession session) throws NoSuchAlgorithmException {		
		System.out.println(password);
		System.out.println("pass:"+session.getAttribute("password"));
		String comPassword = comfirPassword;
		if (!password.equals(session.getAttribute("password"))) {
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
	@SysControllerLog(module="用户管理",methods="修改个人信息")
	public @ResponseBody ExtResponse updateMessage(HttpSession session) throws NoSuchAlgorithmException {					
		User user = (User) session.getAttribute("user");
		if (user != null) {
			return new ExtResponse(true, "操作成功", user.getId(), user.getUserNo(), user.getUserName(), user.getPassword(), user.getUserNickName(), user.getSex(), user.getBirthday(), user.getAge(), user.getNativePlace(), user.getNation(),
					user.getCulture(), user.getCollege(), user.getBody(), user.getMarriage(), user.getIdCord(), user.getPhone(), user.getFamilyPhone(), user.getEmail(), user.getUserAccount(), user.getDeptName(), user.getRemark());
		}
		return new ExtResponse(false, "操作不成功");
	}
	
	//退出系统
	@RequestMapping(value="logout")
	@SysControllerLog(module="用户模块",methods="退出系统")
	public @ResponseBody ExtAjaxResponse logout(HttpServletRequest request) {
		request.getSession().invalidate();
		try {
			
			return new ExtAjaxResponse(true, "退出系统");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "退出系统失败");
		}
	}
	/*public String loginout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "WEB-INF/pages/logout";
	}*/

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