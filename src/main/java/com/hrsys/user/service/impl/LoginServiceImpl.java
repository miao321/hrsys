package com.hrsys.user.service.impl;


import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsys.user.dao.UserRepository;
import com.hrsys.user.entity.User;
import com.hrsys.user.service.ILoginService;
@Service
public class LoginServiceImpl implements ILoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);
	//public static final String LOGIN_KEY="LOGIN_USER_NAME";
	@Autowired
	private UserRepository userRepository;
	/*@Autowired
	private HttpSession session2;*/
	/*private HttpSession session; //http会话
	public LoginServiceImpl(HttpSession session) throws SQLException{
		this.session=session;
		
	}*/
	
	public User login(String userName, String password) {
		return userRepository.findUser(userName,password);
		/*if (userName == null || password == null || userName.equals("") || password.equals("")) {
			return new ExtAjaxResponse(false, "用户名或者密码不能为空");
		}
		User user = userRepository.findUser(userName);
		if (user.getUserName() == null) {
			return new ExtAjaxResponse(false, String.format("用户\"%s\"不存在", userName));
		}
		else if (!password.equals(user.getPassword())) {
			return new ExtAjaxResponse(false, "密码不正确！");
		}else {
			session.setAttribute(LOGIN_KEY, userName);
			return new ExtAjaxResponse(true, "登录成功1");
		}*/
		
	}	
	public User changePassword(Long id, String password, String comfirPassword) {
		return userRepository.updateUser(id, comfirPassword);
	}
		/*if (password != comfirPassword) {
			return new ExtAjaxResponse(false, "密码不一致");
		}
		userRepository.updateUser(id, comfirPassword);
		return new ExtAjaxResponse(true, "密码修改成功");
	}*/
	public User logout() {
		return null;
	}
		/*if(session.getAttribute(LOGIN_KEY) == null) {
			return new ExtAjaxResponse(false, "未登录");
		}
		session.setAttribute(LOGIN_KEY, null);
		return new ExtAjaxResponse(true, "注销成功");
	}*/

	public boolean isLogined() {
		/*Object userName = session.getAttribute(LOGIN_KEY);
		return userName != null&&!("".equals(userName));*/
		return true;
	}	
}
