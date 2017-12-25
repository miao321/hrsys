package com.hrsys.wage.web;

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
import com.hrsys.wage.entity.Wage;
import com.hrsys.wage.entity.dto.WageQueryDTO;
import com.hrsys.wage.service.IWageService;

@Controller
@RequestMapping("/wage")
public class  WageContreller 
{
	@Autowired
	private IWageService wageService;
	
	
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(Wage wage) 
	{
		try {
			wageService.saveOrUpdate(wage);
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
		
	}
	
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) 
	{
		try {
			Wage wage =  wageService.findOne(id);
			if(null!=wage) {
				wageService.delete(wage);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
	}
	
	@RequestMapping("/deletePas")
	public @ResponseBody ExtAjaxResponse deleteWages(@RequestParam Long[] ids) 
	{
		try {
			List<Long> idLists = Arrays.asList(ids);
			if(null!=idLists) {
				wageService.delete(idLists);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
	}
	
	@RequestMapping("/findOne")
	public @ResponseBody Wage findOne(@RequestParam Long id) 
	{
		Wage wage =  wageService.findOne(id);
		
		return wage;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<Wage> findAll() 
	{
		 List<Wage> lists =  wageService.findAll();
		
		return lists;
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<Wage> findPage(WageQueryDTO wageQueryDTO,ExtPageable pageable) 
	{
		Page<Wage> page =  wageService.findAll(WageQueryDTO.getSpecification(wageQueryDTO), pageable.getPageable());
		
		return page;
	}
	
	
}
