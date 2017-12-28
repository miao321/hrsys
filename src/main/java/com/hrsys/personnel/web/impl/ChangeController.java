package com.hrsys.personnel.web.impl;

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
import com.hrsys.common.util.DateUtil;
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

	@RequestMapping(value = "/insertTestData")
	@ResponseBody
	public String insertTestData() {
		try {
			for(int i=0; i<100; i++) {
				Change change = new Change();
				change.setEmployNo("E00"+i);
				change.setEmployName("职工"+i);
				change.setFromDeptName("人事部");
				change.setToDeptName("招聘部");
				change.setLastLeaderNo("E001");
				change.setNowLeaderNo("E002");
				change.setApplyTime(DateUtil.stringToDay("2017-05-01"));
				change.setAgreeTime(DateUtil.stringToDay("2017-12-01"));
				
				changeService.saveOrUpdate(change);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Change change) {
		try {
			changeService.saveOrUpdate(change);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public ExtAjaxResponse delete(@RequestParam Integer id) {
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

	@RequestMapping(value = "/deleteChanges")
	@ResponseBody
	public ExtAjaxResponse deleteChanges(@RequestParam Integer[] ids) {
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

	@RequestMapping(value = "/findOne")
	@ResponseBody
	public Change findOne(@RequestParam Integer id) {
		return changeService.findOne(id);
	}

	@RequestMapping(value = "/findAll")
	@ResponseBody
	public List<Change> findAll() {
		return changeService.findAll();
	}

	@RequestMapping(value = "/findByPage")
	@ResponseBody
	public Page<Change> findByPage(ChangeQueryDTO changeQueryDTO, ExtPageable pageable) {
//		pageable.setPage(1);
		return changeService.findAll(ChangeQueryDTO.getSpecification(changeQueryDTO), pageable.getPageable());
	}
}
