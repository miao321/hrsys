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
import com.hrsys.employ.entity.EmployApply;
import com.hrsys.employ.entity.dto.EmployApplyQueryDTO;
import com.hrsys.employ.service.IEmployApplyService;
import com.hrsys.employ.web.IEmployApplyController;

/**
 * 应聘者信息类Web层实现类
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/employApply")
public class EmployApplyController implements IEmployApplyController {
	
	@Autowired
	private IEmployApplyService employApplyService;

	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(EmployApply employApply) 
	{
		try {
			employApplyService.saveOrUpdate(employApply);
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
		
	}
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) 
	{
		try {
			EmployApply employApply =  employApplyService.findOne(id);
			if(null!=employApply) {
				employApplyService.delete(employApply);
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
				employApplyService.delete(idLists);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
}

	
	@RequestMapping("/findOne")
	public @ResponseBody EmployApply findOne(@RequestParam Long id) 
	{
		EmployApply employApply =  employApplyService.findOne(id);
		
		return employApply;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<EmployApply> findAll() 
	{
		 List<EmployApply> lists =  employApplyService.findAll();
		
		return lists;
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<EmployApply> findPage(EmployApplyQueryDTO employApplyQueryDTO,ExtPageable pageable) 
	{
		Page<EmployApply> page =  employApplyService.findAll(EmployApplyQueryDTO.getSpecification(employApplyQueryDTO), pageable.getPageable());
		
		return page;
	}
}
