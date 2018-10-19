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
import com.hrsys.train.entity.dto.TrainCourseQueryDTO;
import com.hrsys.train.service.ITrainCourseService;
import com.hrsys.train.web.ITrainCourseController;
/**
 * 培训课程类Web层实现类
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/trainCourse")
public class TrainCourseController implements ITrainCourseController {
	@Autowired
	private ITrainCourseService trainCourseService;

	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(TrainCourse trainCourse) 
	{
		try {
			trainCourseService.saveOrUpdate(trainCourse);
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
		
	}
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) 
	{
		try {
			TrainCourse trainCourse =  trainCourseService.findOne(id);
			if(null!=trainCourse) {
				trainCourseService.delete(trainCourse);
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
				trainCourseService.delete(idLists);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
}

	
	@RequestMapping("/findOne")
	public @ResponseBody TrainCourse findOne(@RequestParam Long id) 
	{
		TrainCourse trainCourse =  trainCourseService.findOne(id);
		
		return trainCourse;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<TrainCourse> findAll() 
	{
		 List<TrainCourse> lists =  trainCourseService.findAll();
		
		return lists;
	}
	
	@RequestMapping("/findAllJson")
	public @ResponseBody ExtJsonResult<TrainCourse> findAllJson() 
	{		
		
		List<TrainCourse> lists =trainCourseService.findByTrainCourseNum();
		return new ExtJsonResult<TrainCourse> (lists);
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<TrainCourse> findPage(TrainCourseQueryDTO trainCourseQueryDTO,ExtPageable pageable) 
	{
		Page<TrainCourse> page =  trainCourseService.findAll(TrainCourseQueryDTO.getSpecification(trainCourseQueryDTO), pageable.getPageable());
		
		return page;
	}
	
	@RequestMapping("/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		HSSFWorkbook workbook = trainCourseService.downloadExcel();
		if(workbook != null) {
			try {
				OutputStream output = response.getOutputStream();
				response.reset();  
				response.setHeader("Content-disposition", "attachment; filename=trainCourse.xls");  
				response.setContentType("application/msexcel");          
				workbook.write(output);  
				output.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
