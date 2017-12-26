package com.hrsys.system.web;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.system.entity.Role;
import com.hrsys.system.entity.dto.RoleQueryDTO;
import com.hrsys.system.service.IRoleService;

@Controller
@RequestMapping("/role")
public class RoleController {
	private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
	@Autowired
	private IRoleService roleService;
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(Role role) {
		try {
			roleService.saveOrUpdate(role);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}	
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) {
		try {
			Role role = roleService.findOne(id);
			if (role != null) {
				roleService.delete(role);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}		
	}
	@RequestMapping("/deleteRoles")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long[] ids) {
		try {
			List<Long> idsLists = Arrays.asList(ids);
			if (idsLists != null) {
				roleService.delete(idsLists);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}
	}	
	@RequestMapping("/findOne")
	public @ResponseBody Role findOne(@RequestParam Long id) {
		Role role = roleService.findOne(id);
		return role;
	}	
	@RequestMapping("/findAll")
	public @ResponseBody List<Role> findAll(){
		List<Role> roleLists = roleService.findAll();
		return roleLists;		
	}	
	@RequestMapping("/findPage")
	public @ResponseBody Page<Role> findPage(RoleQueryDTO roleQueryDTO,ExtPageable extPageable){
		Page<Role> page = roleService.findAll(roleQueryDTO.getSpecification(roleQueryDTO), extPageable.getPageable());
		return page;	
	}


}
