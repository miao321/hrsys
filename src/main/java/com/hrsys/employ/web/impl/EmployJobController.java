package com.hrsys.employ.web.impl;

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
import com.hrsys.common.ExtJsonResult;
import com.hrsys.common.ExtPageable;
import com.hrsys.employ.entity.EmployApply;
import com.hrsys.employ.entity.EmployJob;
import com.hrsys.employ.entity.dto.EmployJobQueryDTO;
import com.hrsys.employ.service.IEmployJobService;
import com.hrsys.employ.web.IEmployJobController;

/**
 * 招聘职位类Web层实现类
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/employJob")
public class EmployJobController implements IEmployJobController {
	
	@Autowired
	private IEmployJobService  employJobService;
	
	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(EmployJob employJob) 
	{
		try {
			employJobService.saveOrUpdate(employJob);
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
				employJobService.delete(idLists);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
}
	
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) 
	{
		try {
			EmployJob employJob =  employJobService.findOne(id);
			if(null!=employJob) {
				employJobService.delete(employJob);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
	}
	
	@RequestMapping("/findOne")
	public @ResponseBody EmployJob findOne(@RequestParam Long id) 
	{
		EmployJob employJob =  employJobService.findOne(id);
		
		return employJob;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<EmployJob> findAll() 
	{
		 List<EmployJob> lists =  employJobService.findAll();
		
		return lists;
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<EmployJob> findPage(EmployJobQueryDTO employJobQueryDTO,ExtPageable pageable) 
	{
		Page<EmployJob> page =  employJobService.findAll(EmployJobQueryDTO.getSpecification(employJobQueryDTO), pageable.getPageable());
		
		return page;
	}
	
	@RequestMapping("/findByEmployJob")
	public @ResponseBody ExtJsonResult<EmployJob> findByEmployJob() 
	{
		 List<EmployJob> lists =  employJobService.findByEmployJob();
		
		return new ExtJsonResult<>(lists);
	}
	@RequestMapping("/findAllJson")
	public @ResponseBody ExtJsonResult<EmployJob> findAllJson() 
	{		
		
		List<EmployJob> lists =employJobService.findByEmployJobNum();
		return new ExtJsonResult<EmployJob> (lists);
	}
	@RequestMapping("/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		HSSFWorkbook workbook = employJobService.downloadExcel();
		if(workbook != null) {
			try {
				OutputStream output = response.getOutputStream();
				response.reset();  
				response.setHeader("Content-disposition", "attachment; filename=employJob.xls");  
				response.setContentType("application/msexcel");          
				workbook.write(output);  
				output.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
