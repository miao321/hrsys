package com.hrsys.user.service.impl;


import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.user.dao.UserRepository;
import com.hrsys.user.entity.User;
import com.hrsys.user.service.ILoginService;
@Service
@Transactional
public class LoginServiceImpl implements ILoginService {
	private static final Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);	
	@Autowired
	private UserRepository userRepository;	
	public User login(String userName, String password) {
		return userRepository.findUser(userName);		
	}	
	public void changePassword(Long id, String password, String comfirPassword) {
//		System.out.println(id);
//		System.out.println(comfirPassword);
		 userRepository.updateUser(id, comfirPassword);
	}		
	public User logout() {
		return null;
	}	
	public boolean isLogined() {
		/*Object userName = session.getAttribute(LOGIN_KEY);
		return userName != null&&!("".equals(userName));*/
		return true;
	}
	@Override
	public User findUser(String userName) {
		
		return userRepository.findUser(userName);
	}	
}
