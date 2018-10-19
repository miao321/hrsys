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
import com.hrsys.train.entity.TrainMaterial;
import com.hrsys.train.entity.dto.TrainMaterialQueryDTO;
import com.hrsys.train.service.ITrainMaterialService;
import com.hrsys.train.web.ITrainMaterialController;
/**
 * 培训材料类Web层实现类
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/trainMaterial")
public class TrainMaterialController implements ITrainMaterialController {
	@Autowired
	private ITrainMaterialService trainMaterialService;

	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(TrainMaterial trainMaterial) 
	{
		try {
			trainMaterialService.saveOrUpdate(trainMaterial);
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
		
	}
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) 
	{
		try {
			TrainMaterial trainMaterial =  trainMaterialService.findOne(id);
			if(null!=trainMaterial) {
				trainMaterialService.delete(trainMaterial);
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
				trainMaterialService.delete(idLists);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
}

	
	@RequestMapping("/findOne")
	public @ResponseBody TrainMaterial findOne(@RequestParam Long id) 
	{
		TrainMaterial trainMaterial =  trainMaterialService.findOne(id);
		
		return trainMaterial;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<TrainMaterial> findAll() 
	{
		 List<TrainMaterial> lists =  trainMaterialService.findAll();
		
		return lists;
	}
	@RequestMapping("/findAllJson")
	public @ResponseBody ExtJsonResult<TrainMaterial> findAllJson() 
	{		
		
		List<TrainMaterial> lists =trainMaterialService.findByTrainMaterialNum();
		return new ExtJsonResult<TrainMaterial> (lists);
	}
	@RequestMapping("/findPage")
	public @ResponseBody Page<TrainMaterial> findPage(TrainMaterialQueryDTO trainMaterialQueryDTO,ExtPageable pageable) 
	{
		Page<TrainMaterial> page =  trainMaterialService.findAll(TrainMaterialQueryDTO.getSpecification(trainMaterialQueryDTO), pageable.getPageable());
		
		return page;
	}
	
	@RequestMapping("/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		HSSFWorkbook workbook = trainMaterialService.downloadExcel();
		if(workbook != null) {
			try {
				OutputStream output = response.getOutputStream();
				response.reset();  
				response.setHeader("Content-disposition", "attachment; filename=trainMaterial.xls");  
				response.setContentType("application/msexcel");          
				workbook.write(output);  
				output.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
