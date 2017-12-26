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
	public @ResponseBody ExtAjaxResponse saveOrUpdate(Module module) {
		try {
			moduleService.saveOrUpdate(module);
			return new ExtAjaxResponse(true, "操作成功");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败");
		}	
	}	
	@RequestMapping("/delete")
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
	public @ResponseBody Module findOne(@RequestParam Long id) {
		Module module = moduleService.findOne(id);
		return module;
	}	
	@RequestMapping("/findAll")
	public @ResponseBody List<Module> findAll(){
		List<Module> moduleLists = moduleService.findAll();
		return moduleLists;		
	}	
	@RequestMapping("/findPage")
	public @ResponseBody Page<Module> findPage(ModuleQueryDTO moduleQueryDTO,ExtPageable extPageable){
		Page<Module> page = moduleService.findAll(moduleQueryDTO.getSpecification(moduleQueryDTO), extPageable.getPageable());
		return page;	
	}


}
