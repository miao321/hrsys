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
import com.hrsys.common.ExtJason;
import com.hrsys.common.ExtPageable;
import com.hrsys.wage.entity.PaLV;
import com.hrsys.wage.entity.dto.PaLVQueryDTO;
import com.hrsys.wage.service.IPaLVService;








@Controller
@RequestMapping("/paLV")
public class  PaLVContreller 
{
	@Autowired
	private IPaLVService paLVService;
	
	
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(PaLV paLV) 
	{
		try {
			paLVService.saveOrUpdate(paLV);
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
		
	}
	
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) 
	{
		try {
			PaLV paLV =  paLVService.findOne(id);
			if(null!=paLV) {
				paLVService.delete(paLV);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
	}
	
	@RequestMapping("/deletePaLVs")
	public @ResponseBody ExtAjaxResponse deletePas(@RequestParam Long[] ids) 
	{
		try {
			List<Long> idLists = Arrays.asList(ids);
			if(null!=idLists) {
				paLVService.delete(idLists);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
	}
	
	@RequestMapping("/findOne")
	public @ResponseBody PaLV findOne(@RequestParam Long id) 
	{
		PaLV paLV =  paLVService.findOne(id);
		
		return paLV;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<PaLV> findAll() 
	{
		 List<PaLV> lists =  paLVService.findAll();
		
		return lists;
	}
	@RequestMapping("/findAllJson")
	public @ResponseBody ExtJason<PaLV> findAllJson() 
	{		
		
		List<PaLV> lists =paLVService.findByparank();
		return new ExtJason<PaLV> (lists);
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<PaLV> findPage(PaLVQueryDTO paLVQueryDTO,ExtPageable pageable) 
	{
		Page<PaLV> page =  paLVService.findAll(PaLVQueryDTO.getSpecification(paLVQueryDTO), pageable.getPageable());
		
		return page;
	}
	
	
	
}