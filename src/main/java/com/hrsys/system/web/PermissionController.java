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

import com.hrsys.annotation.SysControllerLog;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtJsonResult;
import com.hrsys.common.ExtPageable;
import com.hrsys.system.entity.Permission;
import com.hrsys.system.entity.Role;
import com.hrsys.system.entity.dto.PermissionQueryDTO;
import com.hrsys.system.service.IPermissionService;
import com.hrsys.system.service.IRoleService;
import com.hrsys.system.service.impl.RoleServiceImpl;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);
	@Autowired
	private IPermissionService permissionService;
	@Autowired
	private IRoleService roleService;
	@RequestMapping("/saveOrUpdate")
	@SysControllerLog(module="用户权限分配",methods="保存或者更新数据")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(Permission permission) {
		if (permission.getToken() != null) {
			return new ExtAjaxResponse(false, "此权限已经存在，请在列表找");
		}		
		try {
			permissionService.saveOrUpdate(permission);		   
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}
	@RequestMapping("/save")
	@SysControllerLog(module="用户权限分配",methods="添加权限")
	public @ResponseBody ExtAjaxResponse save(PermissionQueryDTO permissionQueryDTO) {
		if (permissionQueryDTO.getRole_id() != null) {
			return new ExtAjaxResponse(false, "该角色已经拥有此权限");
		}
		Role role3 = roleService.findRole(permissionQueryDTO.getRoleName());
		System.out.println("role3:"+role3);
		Role role = roleService.findOne(permissionQueryDTO.getRole_id());
		Permission permission = permissionService.findOne(permissionQueryDTO.getPermission_id());		
		permission.getRole().add(role);
		Role role2 = new Role();
		role2.getPermission().add(permission);
		//role.getPermission().add(permission);
		permissionQueryDTO.setRole_id(role3.getId());
		try {
			permissionService.saveOrUpdate(permission);	
			//roleService.saveOrUpdate(role2);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}	
	@RequestMapping("/delete")
	@SysControllerLog(module="用户权限分配",methods="删除一条数据")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) {
		try {
			Permission permission = permissionService.findOne(id);
			if (permission != null) {
				permissionService.delete(permission);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}		
	}
	@RequestMapping("/deletePermissions")
	@SysControllerLog(module="用户权限分配",methods="删除多条数据")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long[] ids) {
		try {
			List<Long> idsLists = Arrays.asList(ids);
			if (idsLists != null) {
				permissionService.delete(idsLists);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}
	}	
	@RequestMapping("/findOne")
	@SysControllerLog(module="用户权限分配",methods="查找一条数据")
	public @ResponseBody Permission findOne(@RequestParam Long id) {
		Permission permission = permissionService.findOne(id);
		return permission;
	}	
	@RequestMapping("/findAll")
	@SysControllerLog(module="用户权限分配",methods="查找所有数据")
	public @ResponseBody ExtJsonResult<Permission> findAll(){
		List<Permission> permissionLists = permissionService.findAll();
		return new ExtJsonResult<Permission>(permissionLists);
	}
	@RequestMapping("/findPage")
	@SysControllerLog(module="用户权限分配",methods="查找所有数据并分页排序")
	public @ResponseBody Page<Permission> findPage(PermissionQueryDTO permissionQueryDTO,ExtPageable extPageable){
		Page<Permission> page = permissionService.findAll(permissionQueryDTO.getSpecification(permissionQueryDTO), extPageable.getPageable());
		return page;	
	}


}
