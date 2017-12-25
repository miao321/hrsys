package com.hrsys.system.controller;

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
import com.hrsys.system.entity.Organization;
import com.hrsys.system.entity.dto.OrganizationQueryDTO;
import com.hrsys.system.service.IOrganizationService;

@Controller
@RequestMapping("/organization")
public class OrganizationController {
	private static final Logger logger = LoggerFactory.getLogger(OrganizationController.class);
	@Autowired
	private IOrganizationService organizationService;
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(Organization organization) {
		try {
			organizationService.saveOrUpdate(organization);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}	
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) {
		try {
			Organization organization = organizationService.findOne(id);
			if (organization != null) {
				organizationService.delete(organization);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}		
	}
	@RequestMapping("/deleteOrganizations")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long[] ids) {
		try {
			List<Long> idsLists = Arrays.asList(ids);
			if (idsLists != null) {
				organizationService.delete(idsLists);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}
	}	
	@RequestMapping("/findOne")
	public @ResponseBody Organization findOne(@RequestParam Long id) {
		Organization organization = organizationService.findOne(id);
		return organization;
	}	
	@RequestMapping("/findAll")
	public @ResponseBody List<Organization> findAll(){
		List<Organization> organizationLists = organizationService.findAll();
		return organizationLists;		
	}	
	@RequestMapping("/findPage")
	public @ResponseBody Page<Organization> findPage(OrganizationQueryDTO organizationQueryDTO,ExtPageable extPageable){
		Page<Organization> page = organizationService.findAll(organizationQueryDTO.getSpecification(organizationQueryDTO), extPageable.getPageable());
		return page;	
	}


}
