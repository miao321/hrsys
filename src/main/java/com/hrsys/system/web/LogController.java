package com.hrsys.system.web;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.annotation.SysControllerLog;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtJsonResult;
import com.hrsys.common.ExtPageable;
import com.hrsys.system.entity.Log;
import com.hrsys.system.entity.dto.LogQueryDTO;
import com.hrsys.system.service.ILogService;

@Controller
@RequestMapping("/log")
public class LogController {
	private static final Logger logger = LoggerFactory.getLogger(LogController.class);
	@Autowired
	private ILogService logService;
	@RequestMapping("/saveOrUpdate")
	@SysControllerLog(module="日志管理",methods="保存或者更新数据")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(Log log) {
		try {
			logService.saveOrUpdate(log);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}	
	@RequestMapping("/delete")
	@SysControllerLog(module="日志管理",methods="删除一条数据")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) {
		try {
			Log log = logService.findOne(id);
			if (log != null) {
				logService.delete(log);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}		
	}
	@RequestMapping("/deleteLogs")
	@SysControllerLog(module="日志管理",methods="删除多条数据")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long[] ids) {
		try {
			List<Long> idsLists = Arrays.asList(ids);
			if (idsLists != null) {
				logService.delete(idsLists);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}
	}	
	@RequestMapping("/findOne")
	@SysControllerLog(module="日志管理",methods="查找一条数据")
	public @ResponseBody Log findOne(@RequestParam Long id) {
		Log log = logService.findOne(id);
		return log;
	}	
	
	@RequestMapping("/findAll")
	@SysControllerLog(module="日志管理",methods="查找所有数据")
	public @ResponseBody ExtJsonResult<Log> findAll(){
		List<Log> logLists = logService.findAll();
		return new ExtJsonResult<Log>(logLists);
	}
	@RequestMapping("/findPage")
	@SysControllerLog(module="日志管理",methods="查找所有数据并分页排序")
	public @ResponseBody Page<Log> findPage(LogQueryDTO logQueryDTO,ExtPageable extPageable){
		Page<Log> page = logService.findAll(logQueryDTO.getSpecification(logQueryDTO), extPageable.getPageable());
		return page;	
	}


}
