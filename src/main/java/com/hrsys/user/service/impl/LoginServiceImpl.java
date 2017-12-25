package com.hrsys.user.service.impl;
/*package com.hrsys.user.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.user.dao.UserRepository;
import com.hrsys.user.entity.User;
@Service
public class LoginService implements ILoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);
	public static final String LOGIN_KEY="LOGIN_USER_NAME";
	@Autowired
	private UserRepository userRepository;
	private HttpSession session; //http会话
	public LoginService(HttpSession session) throws SQLException{
		this.session=session;
		
	}
	@Override
	public ExtAjaxResponse login(String userName, String password) {
		if (userName == null || password == null || userName.equals("") || password.equals("")) {
			return new ExtAjaxResponse(false, "用户名或者密码不能为空");
		}
		//List<User> users = (List<User>) userRepository.findAll();
		User user =null;
		try {
			 user = userRepository.findUser(userName);
		} catch (Exception e) {
			logger.error("{}", e);
		}	
		if (user == null) {
			return new ExtAjaxResponse(false, String.format("用户\"%s\"不存在", userName));
		}
		if (!password.equals(user.getPassword())) {
			return new ExtAjaxResponse(false, "密码不正确！");
		}
		session.setAttribute(LOGIN_KEY, user.getUserName());
		return new ExtAjaxResponse(true, "登录成功");
	}	
	public ExtAjaxResponse changePassword(Long id, String password, String comfirPassword) {
		if (password != comfirPassword) {
			return new ExtAjaxResponse(false, "密码不一致");
		}
		userRepository.updateUser(id, comfirPassword);
		return new ExtAjaxResponse(true, "密码修改成功");
	}
	public ExtAjaxResponse logout() {
		if(session.getAttribute(LOGIN_KEY) == null) {
			return new ExtAjaxResponse(false, "未登录");
		}
		session.setAttribute(LOGIN_KEY, null);
		return new ExtAjaxResponse(true, "注销成功");
	}
	@Override
	public boolean isLogined() {
		Object userName = session.getAttribute(LOGIN_KEY);
		return userName != null&&!("".equals(userName));
	}	
}
*/