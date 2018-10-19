package com.hrsys.wage.web;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtJason;
import com.hrsys.common.ExtPageable;
import com.hrsys.wage.entity.Pa;
import com.hrsys.wage.entity.dto.PaQueryDTO;
import com.hrsys.wage.service.IPaService;



@Controller
@RequestMapping("/pa")
public class  PaContreller 
{
	@Autowired
	private IPaService paService;
	
	
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(Pa pa) 
	{
		try {
			paService.saveOrUpdate(pa);
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
		
	}
	
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) 
	{
		try {
			Pa pa =  paService.findOne(id);
			if(null!=pa) {
				paService.delete(pa);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
	}
	
	@RequestMapping("/deletePas")
	public @ResponseBody ExtAjaxResponse deletePas(@RequestParam Long[] ids) 
	{
		try {
			List<Long> idLists = Arrays.asList(ids);
			if(null!=idLists) {
				paService.delete(idLists);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
	}
	
	@RequestMapping("/findOne")
	public @ResponseBody Pa findOne(@RequestParam Long id) 
	{
		Pa pa =  paService.findOne(id);
		
		return pa;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<Pa> findAll() 
	{
		 List<Pa> lists =  paService.findAll();
		
		return lists;
	}
	@RequestMapping("/findAllJson")
	public @ResponseBody ExtJason<Pa> findAllJson() 
	{		
		
		List<Pa> lists =paService.findBypavaluesNum();
		return new ExtJason<Pa> (lists);
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<Pa> findPage(PaQueryDTO paQueryDTO,ExtPageable pageable) 
	{
		Page<Pa> page =  paService.findAll(PaQueryDTO.getSpecification(paQueryDTO), pageable.getPageable());
		
		return page;
	}
	@RequestMapping(value = "/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		HSSFWorkbook workbook = paService.downloadExcel();
		if(workbook != null) {
			try {
				OutputStream output = response.getOutputStream();
				response.reset();  
				response.setHeader("Content-disposition", "attachment; filename=pa.xls");  
				response.setContentType("application/msexcel");          
				workbook.write(output);  
				output.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	
	
}
