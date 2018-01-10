package com.hrsys.system.web;

import java.util.Arrays;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.annotation.SysControllerLog;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtJsonResult;
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
	//@SysControllerLog(module="角色管理",methods="保存或者更新数据")
	@RequiresPermissions("role/saveOrUpdate")
	@RequiresRoles("管理员")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(Role role) {
		try {
			roleService.saveOrUpdate(role);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}	
	@RequestMapping("/delete")
	@SysControllerLog(module="角色管理",methods="删除一条数据")
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
	@SysControllerLog(module="角色管理",methods="删除多条数据")
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
	@SysControllerLog(module="角色管理",methods="查找一条数据")
	public @ResponseBody Role findOne(@RequestParam Long id) {
		Role role = roleService.findOne(id);
		return role;
	}	
	
	@RequestMapping("/findAll")
	@SysControllerLog(module="角色管理",methods="查找所有数据")
	public @ResponseBody ExtJsonResult<Role> findAll(){
		List<Role> roleLists = roleService.findAll();
		return new ExtJsonResult<Role>(roleLists);
	}
	@RequestMapping("/findPage")
	@SysControllerLog(module="角色管理",methods="查找所有数据并分页排序")
	public @ResponseBody Page<Role> findPage(RoleQueryDTO roleQueryDTO,ExtPageable extPageable){
		Page<Role> page = roleService.findAll(roleQueryDTO.getSpecification(roleQueryDTO), extPageable.getPageable());
		return page;	
	}


}
