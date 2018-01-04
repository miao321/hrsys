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
import com.hrsys.common.ExtJsonResult;
import com.hrsys.common.ExtPageable;
import com.hrsys.system.entity.Permission;
import com.hrsys.system.entity.dto.PermissionQueryDTO;
import com.hrsys.system.service.IPermissionService;

@Controller
@RequestMapping("/permission")
public class PermissionController {
	private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);
	@Autowired
	private IPermissionService permissionService;
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(Permission permission) {
		try {
			permissionService.saveOrUpdate(permission);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}	
	@RequestMapping("/delete")
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
	public @ResponseBody Permission findOne(@RequestParam Long id) {
		Permission permission = permissionService.findOne(id);
		return permission;
	}	
	/*@RequestMapping("/findAll")
	public @ResponseBody List<Permission> findAll(){
		List<Permission> permissionLists = permissionService.findAll();
		return permissionLists;		
	}*/
	@RequestMapping("/findAll")
	public @ResponseBody ExtJsonResult<Permission> findAll(){
		List<Permission> permissionLists = permissionService.findAll();
		return new ExtJsonResult<Permission>(permissionLists);
	}
	@RequestMapping("/findPage")
	public @ResponseBody Page<Permission> findPage(PermissionQueryDTO permissionQueryDTO,ExtPageable extPageable){
		Page<Permission> page = permissionService.findAll(permissionQueryDTO.getSpecification(permissionQueryDTO), extPageable.getPageable());
		return page;	
	}


}
