package com.hrsys.user.web;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.annotation.SysControllerLog;
import com.hrsys.common.EncryptUtils;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtJsonResult;
import com.hrsys.common.ExtPageable;
import com.hrsys.user.entity.User;
import com.hrsys.user.entity.dto.UserQueryDTO;
import com.hrsys.user.entity.dto.UserRoleQueryDTO;
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
	@SysControllerLog(module="用户管理",methods="添加用户")
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
	@SysControllerLog(module="用户管理",methods="保存或者更新数据")
	public @ResponseBody ExtAjaxResponse save(User user,@RequestParam Long id) {
		try {
			//user.setPassword(EncryptUtils.encript(user.getPassword()));
			userService.saveOrUpdate(user);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}	
	@RequestMapping("/delete")
	@SysControllerLog(module="用户管理",methods="删除一条数据")
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
	@SysControllerLog(module="用户管理",methods="删除多条数据")
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
	@SysControllerLog(module="用户管理",methods="查找一条数据")
	public @ResponseBody User findOne(@RequestParam Long id) {
		User user = userService.findOne(id);
		return user;
	}	
	@RequestMapping("/findAll")
	@SysControllerLog(module="用户管理",methods="查找所有数据")
	public @ResponseBody List<User> findAll(){
		List<User> userLists = userService.findAll();
		return userLists;		
	}	
	@RequestMapping("/findPage")
	@SysControllerLog(module="用户管理",methods="查找所有数据")
	public @ResponseBody Page<User> findPage(UserQueryDTO userQueryDTO,ExtPageable extPageable){
		Page<User> page = userService.findAll(userQueryDTO.getSpecification(userQueryDTO), extPageable.getPageable());
		return page;	
	}
	
	/**/
	@RequestMapping("/findUserRole")
	@SysControllerLog(module="用户管理",methods="用户角色关联")
	public @ResponseBody ExtJsonResult<UserRoleQueryDTO> findUserRole(){
		List<UserRoleQueryDTO> findUserRole = userService.findUserRole();
		return new ExtJsonResult<UserRoleQueryDTO>(findUserRole);
		//return new ExtAjaxResponse(true, "操作成功");
	}
	
}
