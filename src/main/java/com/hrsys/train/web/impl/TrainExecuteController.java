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
import com.hrsys.train.entity.TrainExecute;
import com.hrsys.train.entity.dto.TrainExecuteQueryDTO;
import com.hrsys.train.service.ITrainExecuteService;
import com.hrsys.train.web.ITrainExecuteController;
/**
 * 培训实施类Web层实现类
 * @author Administrator
 *
 */

@Controller
@RequestMapping("/trainExecute")
public class TrainExecuteController implements ITrainExecuteController {
	@Autowired
	private ITrainExecuteService trainExecuteService;

	@RequestMapping("/saveOrUpdate")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(TrainExecute trainExecute) 
	{
		try {
			trainExecuteService.saveOrUpdate(trainExecute);
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
		
	}
	@RequestMapping("/delete")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) 
	{
		try {
			TrainExecute trainExecute =  trainExecuteService.findOne(id);
			if(null!=trainExecute) {
				trainExecuteService.delete(trainExecute);
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
				trainExecuteService.delete(idLists);
			}
			return new ExtAjaxResponse(true,"操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false,"操作失败！");
		}
}

	
	@RequestMapping("/findOne")
	public @ResponseBody TrainExecute findOne(@RequestParam Long id) 
	{
		TrainExecute trainExecute =  trainExecuteService.findOne(id);
		
		return trainExecute;
	}
	
	
	@RequestMapping("/findAll")
	public @ResponseBody List<TrainExecute> findAll() 
	{
		 List<TrainExecute> lists =  trainExecuteService.findAll();
		
		return lists;
	}
	
	@RequestMapping("/findPage")
	public @ResponseBody Page<TrainExecute> findPage(TrainExecuteQueryDTO trainExecuteQueryDTO,ExtPageable pageable) 
	{
		Page<TrainExecute> page =  trainExecuteService.findAll(TrainExecuteQueryDTO.getSpecification(trainExecuteQueryDTO), pageable.getPageable());
		
		return page;
	}
}
