package com.hrsys.user.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.common.EncryptUtils;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.user.entity.User;
import com.hrsys.user.entity.dto.UserQueryDTO;
import com.hrsys.user.service.ILoginService;
import com.hrsys.user.service.IUserService;
import com.hrsys.user.service.impl.LoginServiceImpl;


@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private IUserService userService;
	@Autowired
	private ILoginService loginServiceImpl;
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(User user) {
		User user2 = loginServiceImpl.findUser(user.getUserName());
		if (user2 != null) {
			return new ExtAjaxResponse(false, "用户名已经存在");
		}
		try {
			user.setPassword(EncryptUtils.encript(user.getPassword()));
			userService.saveOrUpdate(user);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}
	@RequestMapping("/save")
	public @ResponseBody ExtAjaxResponse save(User user) {
		try {
			user.setPassword(EncryptUtils.encript(user.getPassword()));
			userService.saveOrUpdate(user);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}	
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) {
		try {
			User user = userService.findOne(id);
			if (user != null) {
				userService.delete(user);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}		
	}
	@RequestMapping("/deleteUsers")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long[] ids) {
		try {
			List<Long> idsLists = Arrays.asList(ids);
			if (idsLists != null) {
				userService.delete(idsLists);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}
	}	
	@RequestMapping("/findOne")
	public @ResponseBody User findOne(@RequestParam Long id) {
		User user = userService.findOne(id);
		return user;
	}	
	@RequestMapping("/findAll")
	public @ResponseBody List<User> findAll(){
		List<User> userLists = userService.findAll();
		return userLists;		
	}	
	@RequestMapping("/findPage")
	public @ResponseBody Page<User> findPage(UserQueryDTO userQueryDTO,ExtPageable extPageable){
		Page<User> page = userService.findAll(userQueryDTO.getSpecification(userQueryDTO), extPageable.getPageable());
		return page;	
	}

}
