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
import com.hrsys.train.entity.TrainDemand;
import com.hrsys.train.entity.dto.TrainDemandQueryDTO;
import com.hrsys.train.service.ITrainDemandService;
import com.hrsys.train.web.ITrainDemandController;
/**
 * 培训需求类Web层实现类
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/trainDemand")
public class TrainDemandController implements ITrainDemandController {
	@Autowired
	private ITrainDemandService trainDemandService;

	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(TrainDemand trainDemand) 
	{
		try {
			trainDemandService.saveOrUpdate(trainDemand);
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
		
	}
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) 
	{
		try {
			TrainDemand trainDemand =  trainDemandService.findOne(id);
			if(null!=trainDemand) {
				trainDemandService.delete(trainDemand);
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
				trainDemandService.delete(idLists);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
}

	
	@RequestMapping("/findOne")
	public @ResponseBody TrainDemand findOne(@RequestParam Long id) 
	{
		TrainDemand trainDemand =  trainDemandService.findOne(id);
		
		return trainDemand;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<TrainDemand> findAll() 
	{
		 List<TrainDemand> lists =  trainDemandService.findAll();
		
		return lists;
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<TrainDemand> findPage(TrainDemandQueryDTO trainDemandQueryDTO,ExtPageable pageable) 
	{
		Page<TrainDemand> page =  trainDemandService.findAll(TrainDemandQueryDTO.getSpecification(trainDemandQueryDTO), pageable.getPageable());
		
		return page;
	}
}
