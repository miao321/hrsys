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

import com.hrsys.attendance.dao.IClockDao;
import com.hrsys.attendance.entity.Clock;
import com.hrsys.attendance.service.IClockService;
import com.hrsys.common.util.DateUtil;

/**
 * 考勤模块-打卡记录服务层实现类
 * 
 * @author Lofu
 */
@Service
@Transactional
public class ClockService implements IClockService {

	@Autowired
	private IClockDao clockDao;

	public void saveOrUpdate(Clock clock) {
		clockDao.save(clock);
	}

	public void delete(Clock clock) {
		clockDao.delete(clock);
	}

	public void delete(List<Integer> ids) {
		List<Clock> clockList = (List<Clock>) clockDao.findAll(ids);
		if (clockList != null) {
			clockDao.delete(clockList);
		}
	}

	@Transactional(readOnly = true)
	public Clock findOne(Integer id) {
		return clockDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Clock> findAll() {
		return (List<Clock>) clockDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Clock> findAll(Specification<Clock> spec, Pageable pageable) {
		return clockDao.findAll(spec, pageable);
	}

	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<Clock> clockList = (List<Clock>) clockDao.findAll();
		HSSFWorkbook workbook = null;
		if (clockList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("打卡记录表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);

			// 设置指定列的列宽
//			sheet.setColumnWidth(5, 256 * 15);
			
			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("职工号");
			row0.createCell(1).setCellValue("职工姓名");
			row0.createCell(2).setCellValue("所属部门");
			row0.createCell(3).setCellValue("打卡类型");
			row0.createCell(4).setCellValue("打卡日期");
			row0.createCell(5).setCellValue("打卡时间");
			
			int index = 1;
			for(Clock clock : clockList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(clock.getEmployNo());
				row.createCell(1).setCellValue(clock.getEmployName());
				row.createCell(2).setCellValue(clock.getDeptName());
				row.createCell(3).setCellValue(clock.getClockType());
				row.createCell(4).setCellValue(DateUtil.dateToString(clock.getClockDate()));
				row.createCell(5).setCellValue(clock.getClockTime());
			}
		}
		return workbook;
	}
}
