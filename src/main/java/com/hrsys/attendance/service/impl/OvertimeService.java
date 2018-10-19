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

import com.hrsys.attendance.dao.IOvertimeDao;
import com.hrsys.attendance.entity.Overtime;
import com.hrsys.attendance.service.IOvertimeService;
import com.hrsys.common.util.DateUtil;

/**
 * 考勤模块-加班记录服务层实现类
 * 
 * @author Lofu
 */
@Service
@Transactional
public class OvertimeService implements IOvertimeService {

	@Autowired
	private IOvertimeDao overtimeDao;

	public void saveOrUpdate(Overtime overtime) {
		overtimeDao.save(overtime);
	}

	public void delete(Overtime overtime) {
		overtimeDao.delete(overtime);
	}

	public void delete(List<Integer> ids) {
		List<Overtime> overtimeList = (List<Overtime>) overtimeDao.findAll(ids);
		if (overtimeList != null) {
			overtimeDao.delete(overtimeList);
		}
	}

	@Transactional(readOnly = true)
	public Overtime findOne(Integer id) {
		return overtimeDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Overtime> findAll() {
		return (List<Overtime>) overtimeDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Overtime> findAll(Specification<Overtime> spec, Pageable pageable) {
		return overtimeDao.findAll(spec, pageable);
	}

	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<Overtime> overtimeList = (List<Overtime>) overtimeDao.findAll();
		HSSFWorkbook workbook = null;
		if (overtimeList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("加班记录表");
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
			row0.createCell(3).setCellValue("加班内容");
			row0.createCell(4).setCellValue("加班日期");
			row0.createCell(5).setCellValue("加班开始时间");
			row0.createCell(6).setCellValue("加班结束时间");
			
			int index = 1;
			for(Overtime overtime : overtimeList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(overtime.getEmployNo());
				row.createCell(1).setCellValue(overtime.getEmployName());
				row.createCell(2).setCellValue(overtime.getDeptName());
				row.createCell(3).setCellValue(overtime.getContent());
				row.createCell(4).setCellValue(DateUtil.dateToString(overtime.getOvertimeDate()));
				row.createCell(5).setCellValue(DateUtil.dateToYMDHMS(overtime.getOtBeginTime()));
				row.createCell(6).setCellValue(DateUtil.dateToYMDHMS(overtime.getOtEndTime()));
			}
		}
		return workbook;
	}
}
