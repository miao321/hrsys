package com.hrsys.train.web.impl;

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
import com.hrsys.train.entity.TrainCourse;
import com.hrsys.train.entity.TrainPlan;
import com.hrsys.train.entity.dto.TrainPlanQueryDTO;
import com.hrsys.train.service.ITrainPlanService;
import com.hrsys.train.web.ITrainPlanController;
/**
 * 培训计划类Web层实现类
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/trainPlan")
public class TrainPlanController implements ITrainPlanController {
	@Autowired
	private ITrainPlanService trainPlanService;

	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(TrainPlan trainPlan) 
	{
		try {
			trainPlanService.saveOrUpdate(trainPlan);
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
		
	}
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) 
	{
		try {
			TrainPlan trainPlan =  trainPlanService.findOne(id);
			if(null!=trainPlan) {
				trainPlanService.delete(trainPlan);
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
				trainPlanService.delete(idLists);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
}

	
	@RequestMapping("/findOne")
	public @ResponseBody TrainPlan findOne(@RequestParam Long id) 
	{
		TrainPlan trainPlan =  trainPlanService.findOne(id);
		
		return trainPlan;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<TrainPlan> findAll() 
	{
		 List<TrainPlan> lists =  trainPlanService.findAll();
		
		return lists;
	}
	
	@RequestMapping("/findAllJson")
	public @ResponseBody ExtJsonResult<TrainPlan> findAllJson() 
	{		
		
		List<TrainPlan> lists =trainPlanService.findByTrainPlanNum();
		return new ExtJsonResult<TrainPlan> (lists);
	}
	@RequestMapping("/findPage")
	public @ResponseBody Page<TrainPlan> findPage(TrainPlanQueryDTO trainPlanQueryDTO,ExtPageable pageable) 
	{
		Page<TrainPlan> page =  trainPlanService.findAll(TrainPlanQueryDTO.getSpecification(trainPlanQueryDTO), pageable.getPageable());
		
		return page;
	}
	
	@RequestMapping("/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		HSSFWorkbook workbook = trainPlanService.downloadExcel();
		if(workbook != null) {
			try {
				OutputStream output = response.getOutputStream();
				response.reset();  
				response.setHeader("Content-disposition", "attachment; filename=trainPlan.xls");  
				response.setContentType("application/msexcel");          
				workbook.write(output);  
				output.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
