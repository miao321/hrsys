package com.hrsys.personnel.web.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.personnel.dao.DTO.EmployQueryDTO;
import com.hrsys.personnel.entity.Employ;
import com.hrsys.personnel.service.IEmployService;
import com.hrsys.personnel.web.IEmployController;

/**
 * 人事模块-职工类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/personnel/employ")
public class EmployController implements IEmployController{
	
	@Autowired
	private IEmployService employService;

	@RequestMapping(value = "/insertTestDate", method = RequestMethod.POST)
	@ResponseBody
	public String insertTestDate() {
		try {
			for(int i=0; i<100; i++) {
				Employ employ = new Employ();
				employ.setEmployNo("E000"+i);
				employ.setEmployName("职工"+i);
				
				employService.saveOrUpdate(employ);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Employ employ) {
		try {
			employService.saveOrUpdate(employ);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public ExtAjaxResponse delete(@RequestParam Integer id) {
		try {
			Employ employ = employService.findOne(id);
			if (employ != null) {
				employService.delete(employ);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/deleteEmploys")
	@ResponseBody
	public ExtAjaxResponse deleteEmploys(@RequestParam Integer[] ids) {
		try {
			List<Integer> idLists = Arrays.asList(ids);
			if (null != idLists) {
				employService.delete(idLists);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/findOne")
	@ResponseBody
	public Employ findOne(@RequestParam Integer id) {
		return employService.findOne(id);
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public List<Employ> findAll() {
		return employService.findAll();
	}

	@RequestMapping("/findByPage")
	@ResponseBody
	public Page<Employ> findByPage(EmployQueryDTO employQueryDTO, ExtPageable pageable) {
		return employService.findAll(EmployQueryDTO.getSpecification(employQueryDTO), pageable.getPageable());
	}
}
