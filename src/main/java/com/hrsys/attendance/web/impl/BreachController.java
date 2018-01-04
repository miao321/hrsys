package com.hrsys.attendance.web.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.attendance.dao.DTO.BreachQueryDTO;
import com.hrsys.attendance.entity.Breach;
import com.hrsys.attendance.service.IBreachService;
import com.hrsys.attendance.web.IBreachController;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.common.util.DateUtil;

/**
 * 考勤模块-违规记录类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/breach")
public class BreachController implements IBreachController {
	
	@Autowired
	private IBreachService breachService;

	@RequestMapping(value = "/insertTestData")
	@ResponseBody
	public String insertTestData() {
		try {
			for(int i=0; i<100; i++) {
				Breach breach = new Breach();
				breach.setEmployNo("E00"+i);
				breach.setEmployName("职工"+i);
				breach.setContent("旷工");
				breach.setRecordMan("考勤部");
				breach.setBreachTime(DateUtil.stringToDay("2017-12-26"));
				breach.setCreateTime(DateUtil.stringToDay("2017-12-27"));
				
				breachService.saveOrUpdate(breach);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Breach breach) {
		try {
			breachService.saveOrUpdate(breach);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public ExtAjaxResponse delete(@RequestParam Integer id) {
		try {
			Breach breach = breachService.findOne(id);
			if (breach != null) {
				breachService.delete(breach);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/deleteBreachs")
	@ResponseBody
	public ExtAjaxResponse deleteBreachs(@RequestParam Integer[] ids) {
		try {
			List<Integer> idLists = Arrays.asList(ids);
			if (null != idLists) {
				breachService.delete(idLists);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/findOne")
	@ResponseBody
	public Breach findOne(@RequestParam Integer id) {
		return breachService.findOne(id);
	}

	@RequestMapping(value = "/findAll")
	@ResponseBody
	public List<Breach> findAll() {
		return breachService.findAll();
	}

	@RequestMapping(value = "/findByPage")
	@ResponseBody
	public Page<Breach> findByPage(BreachQueryDTO breachQueryDTO, ExtPageable pageable) {
//		pageable.setPage(1);
		return breachService.findAll(BreachQueryDTO.getSpecification(breachQueryDTO), pageable.getPageable());
	}
}
