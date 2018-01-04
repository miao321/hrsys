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
import com.hrsys.employ.entity.EmployChannel;
import com.hrsys.employ.entity.EmployJob;
import com.hrsys.employ.entity.dto.EmployChannelQueryDTO;
import com.hrsys.employ.service.IEmployChannelService;
import com.hrsys.employ.web.IEmployChannelController;

/**
 * 招聘渠道类Web层实现类
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/employChannel")
public class EmployChannelController implements IEmployChannelController {
	
	@Autowired
	private IEmployChannelService employChannelService;

	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(EmployChannel employChannel) 
	{
		try {
			employChannelService.saveOrUpdate(employChannel);
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
		
	}
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) 
	{
		try {
			EmployChannel employChannel =  employChannelService.findOne(id);
			if(null!=employChannel) {
				employChannelService.delete(employChannel);
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
				employChannelService.delete(idLists);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
}

	
	@RequestMapping("/findOne")
	public @ResponseBody EmployChannel findOne(@RequestParam Long id) 
	{
		EmployChannel employChannel =  employChannelService.findOne(id);
		
		return employChannel;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<EmployChannel> findAll() 
	{
		 List<EmployChannel> lists =  employChannelService.findAll();
		
		return lists;
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<EmployChannel> findPage(EmployChannelQueryDTO employChannelQueryDTO,ExtPageable pageable) 
	{
		Page<EmployChannel> page =  employChannelService.findAll(EmployChannelQueryDTO.getSpecification(employChannelQueryDTO), pageable.getPageable());
		
		return page;
	}
}
