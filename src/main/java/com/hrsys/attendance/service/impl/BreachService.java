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

import com.hrsys.attendance.dao.IBreachDao;
import com.hrsys.attendance.entity.Breach;
import com.hrsys.attendance.service.IBreachService;
import com.hrsys.common.util.DateUtil;

/**
 * 考勤模块-违规记录服务层实现类
 * 
 * @author Lofu
 */
@Service
@Transactional
public class BreachService implements IBreachService {

	@Autowired
	private IBreachDao breachDao;

	public void saveOrUpdate(Breach breach) {
		breachDao.save(breach);
	}

	public void delete(Breach breach) {
		breachDao.delete(breach);
	}

	public void delete(List<Integer> ids) {
		List<Breach> breachList = (List<Breach>) breachDao.findAll(ids);
		if (breachList != null) {
			breachDao.delete(breachList);
		}
	}

	@Transactional(readOnly = true)
	public Breach findOne(Integer id) {
		return breachDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Breach> findAll() {
		return (List<Breach>) breachDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Breach> findAll(Specification<Breach> spec, Pageable pageable) {
		return breachDao.findAll(spec, pageable);
	}

	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<Breach> breachList = (List<Breach>) breachDao.findAll();
		HSSFWorkbook workbook = null;
		if (breachList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("违规记录表");
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
			row0.createCell(3).setCellValue("违规内容");
			row0.createCell(4).setCellValue("违规日期");
			row0.createCell(5).setCellValue("记录人姓名");
			row0.createCell(6).setCellValue("记录日期");
			
			int index = 1;
			for(Breach breach : breachList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(breach.getEmployNo());
				row.createCell(1).setCellValue(breach.getEmployName());
				row.createCell(2).setCellValue(breach.getDeptName());
				row.createCell(3).setCellValue(breach.getContent());
				row.createCell(4).setCellValue(DateUtil.dateToString(breach.getBreachDate()));
				row.createCell(5).setCellValue(breach.getRecordMan());
				row.createCell(6).setCellValue(DateUtil.dateToString(breach.getRecordDate()));
			}
		}
		return workbook;
	}
}
