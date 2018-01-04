package com.hrsys.employ.web.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.employ.entity.EmployActivity;
import com.hrsys.employ.entity.dto.EmployActivityQueryDTO;
import com.hrsys.employ.service.IEmployActivityService;
import com.hrsys.employ.web.IEmployActivityController;


/**
 * 招聘活动类Web层实现类
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/employActivity")
public class EmployActivityController implements IEmployActivityController {
	
	@Autowired
	private IEmployActivityService employActivityService;

	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(EmployActivity employActivity) 
	{
		try {
			employActivityService.saveOrUpdate(employActivity);
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
		
	}
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) 
	{
		try {
			EmployActivity employActivity =  employActivityService.findOne(id);
			if(null!=employActivity) {
				employActivityService.delete(employActivity);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
	}
	
	//批量删除
	@RequestMapping("/deletes")
	public@ResponseBody ExtAjaxResponse deletes(@RequestParam Long[] ids) 
	{
		try {
			List<Long>idLists = Arrays.asList(ids);
			if(null!=idLists) {
				employActivityService.delete(idLists);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
}

	
	@RequestMapping("/findOne")
	public @ResponseBody EmployActivity findOne(@RequestParam Long id) 
	{
		EmployActivity employActivity =  employActivityService.findOne(id);
		
		return employActivity;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<EmployActivity> findAll() 
	{
		 List<EmployActivity> lists =  employActivityService.findAll();
		
		return lists;
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<EmployActivity> findPage(EmployActivityQueryDTO employActivityQueryDTO,ExtPageable pageable) 
	{
		Page<EmployActivity> page =  employActivityService.findAll(EmployActivityQueryDTO.getSpecification(employActivityQueryDTO), pageable.getPageable());
		
		return page;
	}
}
