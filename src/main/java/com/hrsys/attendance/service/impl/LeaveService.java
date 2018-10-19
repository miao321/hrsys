package com.hrsys.attendance.service.impl;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.attendance.dao.ILeaveDao;
import com.hrsys.attendance.entity.Leave;
import com.hrsys.attendance.service.ILeaveService;
import com.hrsys.common.util.DateUtil;

/**
 * 考勤模块-请假记录服务层实现类
 * 
 * @author Lofu
 */
@Service
@Transactional
public class LeaveService implements ILeaveService {

	@Autowired
	private ILeaveDao leaveDao;

	public void saveOrUpdate(Leave leave) {
		leaveDao.save(leave);
	}

	public void delete(Leave leave) {
		leaveDao.delete(leave);
	}

	public void delete(List<Integer> ids) {
		List<Leave> leaveList = (List<Leave>) leaveDao.findAll(ids);
		if (leaveList != null) {
			leaveDao.delete(leaveList);
		}
	}

	@Transactional(readOnly = true)
	public Leave findOne(Integer id) {
		return leaveDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Leave> findAll() {
		return (List<Leave>) leaveDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Leave> findAll(Specification<Leave> spec, Pageable pageable) {
		return leaveDao.findAll(spec, pageable);
	}

	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<Leave> leaveList = (List<Leave>) leaveDao.findAll();
		HSSFWorkbook workbook = null;
		if (leaveList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("请假记录表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);

			// 设置指定列的列宽
			// sheet.setColumnWidth(5, 256 * 15);

			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("职工号");
			row0.createCell(1).setCellValue("职工姓名");
			row0.createCell(2).setCellValue("所属部门");
			row0.createCell(3).setCellValue("请假类型");
			row0.createCell(4).setCellValue("请假日期");
			row0.createCell(5).setCellValue("请假时长");
			row0.createCell(6).setCellValue("申请日期");
			row0.createCell(7).setCellValue("批注人姓名");
			
			int index = 1;
			for (Leave leave : leaveList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(leave.getEmployNo());
				row.createCell(1).setCellValue(leave.getEmployName());
				row.createCell(2).setCellValue(leave.getDeptName());
				row.createCell(3).setCellValue(leave.getLeaveType());
				row.createCell(4).setCellValue(DateUtil.dateToString(leave.getLeaveDate()));
				row.createCell(5).setCellValue(leave.getTimeLong());
				row.createCell(6).setCellValue(DateUtil.dateToString(leave.getApplyDate()));
				row.createCell(7).setCellValue(leave.getAgreeMan());
			}
		}
		return workbook;
	}
}
