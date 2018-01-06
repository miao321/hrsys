package com.hrsys.user.web;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
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
import com.hrsys.system.dao.RoleRepository;
import com.hrsys.system.entity.Role;
import com.hrsys.system.entity.dto.RoleQueryDTO;
import com.hrsys.system.service.IRoleService;
import com.hrsys.user.dao.UserRepository;
import com.hrsys.user.entity.User;
import com.hrsys.user.entity.UserRole;
import com.hrsys.user.entity.dto.UserRoleQueryDTO;
import com.hrsys.user.service.ILoginService;
import com.hrsys.user.service.IUserRoleService;
import com.hrsys.user.service.IUserService;


@Controller
@RequestMapping("/userRole")
public class UserRoleController {
	private static final Logger logger = LoggerFactory.getLogger(UserRoleController.class);
	@Autowired
	private IUserRoleService userRoleService;
	@Autowired
	private IUserService userService;
	@Autowired
	private IRoleService roleService;
	@RequestMapping("/save")
	@SysControllerLog(module="用户管理",methods="添加用户")
	@Scope("prototype")
	public @ResponseBody ExtAjaxResponse save(UserRoleQueryDTO userRoleQueryDTO) {
		User user = userService.findOne(userRoleQueryDTO.getUserId());
		Role role = roleService.findOne(userRoleQueryDTO.getRoleId());
		UserRole userRole = new UserRole();
		if (userRoleQueryDTO.getId() != null) {
			userRole.setId(userRoleQueryDTO.getId());
		}
		userRole.setUser(user);
		userRole.setRole(role);
		//user.getUserRoles().add(userRole);
		//role.getUserRoles().add(userRole);
		try {	
			userRoleService.saveOrUpdate(userRole);
			//userService.saveOrUpdate(user);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}
	
	
	
	@RequestMapping("/saveOrUpdate")
	@SysControllerLog(module="用户管理",methods="保存或者更新数据")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(UserRole userRole) {
		try {
			userRoleService.saveOrUpdate(userRole);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}	
	@RequestMapping("/delete")
	@SysControllerLog(module="用户管理",methods="删除一条数据")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) {
		try {
			UserRole userRole = userRoleService.findOne(id);
			if (userRole != null) {
				userRoleService.delete(userRole);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}		
	}
	@RequestMapping("/deleteUserRoles")
	@SysControllerLog(module="用户管理",methods="删除多条数据")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long[] ids) {
		try {
			List<Long> idsLists = Arrays.asList(ids);
			if (idsLists != null) {
				userRoleService.delete(idsLists);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}
	}	
	@RequestMapping("/findOne")
	@SysControllerLog(module="用户管理",methods="查找一条数据")
	public @ResponseBody UserRole findOne(@RequestParam Long id) {
		UserRole userRole = userRoleService.findOne(id);
		return userRole;
	}	
	
	@RequestMapping("/findAll")
	@SysControllerLog(module="用户管理",methods="查找多条数据")
	public @ResponseBody ExtJsonResult<UserRole> findAll(){
		List<UserRole> userRoleLists = userRoleService.findAll();
		return new ExtJsonResult<UserRole>(userRoleLists);
	}	
	@RequestMapping("/findPage")
	@SysControllerLog(module="用户管理",methods="查找多条数据并分页排序")
	public @ResponseBody Page<UserRole> findPage(UserRoleQueryDTO userRoleQueryDTO,ExtPageable extPageable){
		Page<UserRole> page = userRoleService.findAll(userRoleQueryDTO.getSpecification(userRoleQueryDTO), extPageable.getPageable());
		return page;	
	}

}
