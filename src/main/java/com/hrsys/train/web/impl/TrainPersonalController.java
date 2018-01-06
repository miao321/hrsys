package com.hrsys.train.web.impl;

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
import com.hrsys.train.entity.TrainPersonal;
import com.hrsys.train.entity.dto.TrainPersonalQueryDTO;
import com.hrsys.train.service.ITrainPersonalService;
import com.hrsys.train.web.ITrainPersonalController;
/**
 * 个人培训记录类Web层实现类
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/trainPersonal")
public class TrainPersonalController implements ITrainPersonalController {
	@Autowired
	private ITrainPersonalService trainPlanService;

	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(TrainPersonal trainPlan) 
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
			TrainPersonal trainPlan =  trainPlanService.findOne(id);
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
	public @ResponseBody TrainPersonal findOne(@RequestParam Long id) 
	{
		TrainPersonal trainPlan =  trainPlanService.findOne(id);
		
		return trainPlan;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<TrainPersonal> findAll() 
	{
		 List<TrainPersonal> lists =  trainPlanService.findAll();
		
		return lists;
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<TrainPersonal> findPage(TrainPersonalQueryDTO trainPlanQueryDTO,ExtPageable pageable) 
	{
		Page<TrainPersonal> page =  trainPlanService.findAll(TrainPersonalQueryDTO.getSpecification(trainPlanQueryDTO), pageable.getPageable());
		
		return page;
	}
}
