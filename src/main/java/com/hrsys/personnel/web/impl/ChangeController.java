package com.hrsys.personnel.web.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.personnel.dao.DTO.ChangeQueryDTO;
import com.hrsys.personnel.entity.Change;
import com.hrsys.personnel.service.IChangeService;
import com.hrsys.personnel.web.IChangeController;

/**
 * 人事模块-人事变动类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/personnel/change")
public class ChangeController implements IChangeController {
	
	@Autowired
	private IChangeService changeService;

	@RequestMapping(value = "/insertTestDate", method = RequestMethod.POST)
	@ResponseBody
	public String insertTestDate() {
		try {
			for(int i=0; i<100; i++) {
				Change change = new Change();
				change.setEmployNo("E000"+i);
				change.setEmployName("职工"+i);
				
				changeService.saveOrUpdate(change);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Change change) {
		try {
			changeService.saveOrUpdate(change);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public ExtAjaxResponse delete(Integer id) {
		try {
			Change change = changeService.findOne(id);
			if (change != null) {
				changeService.delete(change);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/deleteChanges")
	@ResponseBody
	public ExtAjaxResponse deleteChanges(Integer[] ids) {
		try {
			List<Integer> idLists = Arrays.asList(ids);
			if (null != idLists) {
				changeService.delete(idLists);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/findOne")
	@ResponseBody
	public Change findOne(Integer id) {
		return changeService.findOne(id);
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public List<Change> findAll() {
		return changeService.findAll();
	}

	@RequestMapping("/findByPage")
	@ResponseBody
	public Page<Change> findByPage(ChangeQueryDTO deptQueryDTO, ExtPageable pageable) {
		Page<Change> changePage = changeService.findAll(deptQueryDTO.getSpecification(deptQueryDTO), pageable.getPageable());
		return null;
	}
}
