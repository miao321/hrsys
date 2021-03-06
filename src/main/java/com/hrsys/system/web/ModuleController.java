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
import com.hrsys.common.ExtPageable;
import com.hrsys.system.entity.Module;
import com.hrsys.system.entity.dto.ModuleQueryDTO;
import com.hrsys.system.service.IModuleService;

@Controller
@RequestMapping("/module")
public class ModuleController {
	private static final Logger logger = LoggerFactory.getLogger(ModuleController.class);
	@Autowired
	private IModuleService moduleService;
	@RequestMapping("/saveOrUpdate")
	@SysControllerLog(module="模块管理",methods="保存或者更新数据")
	public @ResponseBody ExtAjaxResponse saveOrUpdate(Module module) {
		
		if (moduleService.findModule(module.getModuleName()) != null) {
			return new ExtAjaxResponse(false, "该模块已经存在不用再添加");
		}
		try {
			moduleService.saveOrUpdate(module);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}	
	@RequestMapping("/delete")
	@SysControllerLog(module="模块管理",methods="删除一条数据")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long id) {
		try {
			Module module = moduleService.findOne(id);
			if (module != null) {
				moduleService.delete(module);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}		
	}
	@RequestMapping("/deleteModules")
	@SysControllerLog(module="模块管理",methods="删除多条数据")
	public @ResponseBody ExtAjaxResponse delete(@RequestParam Long[] ids) {
		try {
			List<Long> idsLists = Arrays.asList(ids);
			if (idsLists != null) {
				moduleService.delete(idsLists);
			}
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}
	}	
	@RequestMapping("/findOne")
	@SysControllerLog(module="模块管理",methods="查找一条数据")
	public @ResponseBody Module findOne(@RequestParam Long id) {
		Module module = moduleService.findOne(id);
		return module;
	}	
	@RequestMapping("/findAll")
	@SysControllerLog(module="模块管理",methods="查找所有数据")
	public @ResponseBody List<Module> findAll(){
		List<Module> moduleLists = moduleService.findAll();
		return moduleLists;		
	}	
	@RequestMapping("/findPage")
	@SysControllerLog(module="模块管理",methods="查找所有数据并分页排序")
	public @ResponseBody Page<Module> findPage(ModuleQueryDTO moduleQueryDTO,ExtPageable extPageable){
		Page<Module> page = moduleService.findAll(moduleQueryDTO.getSpecification(moduleQueryDTO), extPageable.getPageable());
		return page;	
	}


}
