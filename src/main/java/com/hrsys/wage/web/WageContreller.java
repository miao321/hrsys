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
		wage.getWageId();
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
			if(wage!=null) {
				wageService.delete(wage);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
	}
	
	@RequestMapping("/deleteWages")
	public @ResponseBody ExtAjaxResponse deleteWages(@RequestParam Long[] ids) 
	{
		try {
			List<Long> idLists = Arrays.asList(ids);
			if(idLists!=null) {
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
	@RequestMapping("/findAllJson")
	public @ResponseBody ExtJason<Wage> findAllJson() 
	{		
		
		List<Wage> lists =wageService.findByfinalWageNum();
		return new ExtJason<Wage> (lists);
	}
	@RequestMapping("/findAllJson1")
	public @ResponseBody ExtJason<Wage> findAllJson1() 
	{		
		
		List<Wage> lists =wageService.findByfinalWageSum();
		return new ExtJason<Wage> (lists);
	}
	@RequestMapping("/findPage")
	public @ResponseBody Page<Wage> findPage(WageQueryDTO wageQueryDTO,ExtPageable pageable) 
	{
		Page<Wage> page =  wageService.findAll(WageQueryDTO.getSpecification(wageQueryDTO), pageable.getPageable());
		
		return page;
	}
	@RequestMapping(value = "/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		HSSFWorkbook workbook = wageService.downloadExcel();
		if(workbook != null) {
			try {
				OutputStream output = response.getOutputStream();
				response.reset();  
				response.setHeader("Content-disposition", "attachment; filename=wage.xls");  
				response.setContentType("application/msexcel");          
				workbook.write(output);  
				output.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
	
}
