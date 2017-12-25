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
import com.hrsys.personnel.dao.DTO.DeptQueryDTO;
import com.hrsys.personnel.entity.Dept;
import com.hrsys.personnel.service.IDeptService;
import com.hrsys.personnel.web.IDeptController;

/**
 * 人事模块-部门类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/personnel/dept")
public class DeptController implements IDeptController {
	
	@Autowired
	private IDeptService deptService;

	@RequestMapping(value = "/insertTestDate", method = RequestMethod.POST)
	@ResponseBody
	public String insertTestDate() {
		try {
			for(int i=0; i<100; i++) {
				Dept dept = new Dept();
				dept.setDeptName("部门00"+i);
				
				deptService.saveOrUpdate(dept);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Dept dept) {
		try {
			deptService.saveOrUpdate(dept);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public ExtAjaxResponse delete(@RequestParam Integer id) {
		try {
			Dept dept = deptService.findOne(id);
			if (dept != null) {
				deptService.delete(dept);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/deleteDepts")
	@ResponseBody
	public ExtAjaxResponse deleteDepts(@RequestParam Integer[] ids) {
		try {
			List<Integer> idLists = Arrays.asList(ids);
			if (null != idLists) {
				deptService.delete(idLists);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/findOne")
	@ResponseBody
	public Dept findOne(@RequestParam Integer id) {
		return deptService.findOne(id);
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public List<Dept> findAll() {
		return deptService.findAll();
	}

	@RequestMapping("/findByPage")
	@ResponseBody
	public Page<Dept> findByPage(DeptQueryDTO deptQueryDTO, ExtPageable pageable) {
		Page<Dept> deptPage = deptService.findAll(DeptQueryDTO.getSpecification(deptQueryDTO), pageable.getPageable());
		return deptPage;
	}
}
