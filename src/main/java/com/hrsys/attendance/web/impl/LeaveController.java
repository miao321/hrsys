package com.hrsys.attendance.web.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.attendance.dao.DTO.LeaveQueryDTO;
import com.hrsys.attendance.entity.Leave;
import com.hrsys.attendance.service.ILeaveService;
import com.hrsys.attendance.web.ILeaveController;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;

/**
 * 考勤模块-请假记录类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/leave")
public class LeaveController implements ILeaveController {

	@Autowired
	private ILeaveService leaveService;

	@RequestMapping(value = "/insertTestDate")
	@ResponseBody
	public String insertTestDate() {
		try {
			for(int i=0; i<100; i++) {
				Leave leave = new Leave();
				leave.setEmployNo("E000"+i);
				leave.setEmployName("职工"+i);
				
				leaveService.saveOrUpdate(leave);
			}
			return "success";
		} catch (Exception e) {
			return "error";
		}
	}

	@RequestMapping("/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Leave leave) {
		try {
			leaveService.saveOrUpdate(leave);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public ExtAjaxResponse delete(Integer id) {
		try {
			Leave leave = leaveService.findOne(id);
			if (leave != null) {
				leaveService.delete(leave);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/deleteLeaves")
	@ResponseBody
	public ExtAjaxResponse deleteLeaves(Integer[] ids) {
		try {
			List<Integer> idLists = Arrays.asList(ids);
			if (null != idLists) {
				leaveService.delete(idLists);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping("/findOne")
	@ResponseBody
	public Leave findOne(Integer id) {
		return leaveService.findOne(id);
	}

	@RequestMapping("/findAll")
	@ResponseBody
	public List<Leave> findAll() {
		return leaveService.findAll();
	}

	@RequestMapping("/findByPage")
	@ResponseBody
	public Page<Leave> findByPage(LeaveQueryDTO leaveQueryDTO, ExtPageable pageable) {
		return leaveService.findAll(LeaveQueryDTO.getSpecification(leaveQueryDTO), pageable.getPageable());
	}
}
