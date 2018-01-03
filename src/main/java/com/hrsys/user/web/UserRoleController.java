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

import com.hrsys.common.EncryptUtils;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.system.dao.RoleRepository;
import com.hrsys.system.entity.Role;
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
	private RoleRepository roleRepository;
	@Autowired
	private UserRepository userRepository;
	@RequestMapping("/save")//@RequestParam Long roleId,@RequestParam Long userId
	@Scope("prototype")
	public @ResponseBody ExtAjaxResponse save(UserRoleQueryDTO userRoleQueryDTO) {
		User user = userRepository.findOne(userRoleQueryDTO.getUserId());
		Role role = roleRepository.findOne(userRoleQueryDTO.getRoleId());
		System.out.println("user:"+user);
		System.out.println("role:"+role);
		UserRole userRole = new UserRole();
		if (userRoleQueryDTO.getId() != null) {
			userRole.setId(userRoleQueryDTO.getId());
		}
		userRole.setUser(user);
		userRole.setRole(role);
		user.getUserRoles().add(userRole);
		role.getUserRoles().add(userRole);
		//try {			
			//userRoleService.saveOrUpdate(userRole);
		userService.saveOrUpdate(user);
			return new ExtAjaxResponse(true, "操作成功");
		//} catch (Exception e) {
		//	return new ExtAjaxResponse(false, "操作失败");
		//}	
	}		
}
