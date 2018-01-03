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
import com.hrsys.system.entity.Dept;
import com.hrsys.system.entity.dto.DeptQueryDTO;
import com.hrsys.system.service.IDeptService;

@Controller
@RequestMapping("/dept")
public class DeptController {
	private static final Logger logger = LoggerFactory.getLogger(DeptController.class);
	@Autowired
	private IDeptService deptService;
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(Dept dept) {
		try {
			deptService.saveOrUpdate(dept);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}	
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) {
		try {
			Dept dept = deptService.findOne(id);
			if (dept != null) {
				deptService.delete(dept);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}		
	}
	@RequestMapping("/deletedepts")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long[] ids) {
		try {
			List<Long> idsLists = Arrays.asList(ids);
			if (idsLists != null) {
				deptService.delete(idsLists);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}
	}	
	@RequestMapping("/findOne")
	public @ResponseBody Dept findOne(@RequestParam Long id) {
		Dept dept = deptService.findOne(id);
		return dept;
	}	
	@RequestMapping("/findAll")
	public @ResponseBody List<Dept> findAll(){
		List<Dept> deptLists = deptService.findAll();
		return deptLists;		
	}	
	@RequestMapping("/findPage")
	public @ResponseBody Page<Dept> findPage(DeptQueryDTO deptQueryDTO,ExtPageable extPageable){
		Page<Dept> page = deptService.findAll(deptQueryDTO.getSpecification(deptQueryDTO), extPageable.getPageable());
		return page;	
	}


}