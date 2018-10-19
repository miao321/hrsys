package com.hrsys.personnel.service.impl;

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

import com.hrsys.common.util.DateUtil;
import com.hrsys.personnel.dao.IChangeDao;
import com.hrsys.personnel.entity.Change;
import com.hrsys.personnel.service.IChangeService;

/**
 * 人事模块-人事变动类服务层实现类
 * @author Lofu
 */
@Service
@Transactional
public class ChangeService implements IChangeService {

	@Autowired
	private IChangeDao changeDao;

	public void saveOrUpdate(Change change) {
		changeDao.save(change);
	}

	public void delete(Change change) {
		changeDao.delete(change);
	}

	public void delete(List<Integer> ids) {
		List<Change> changeList = (List<Change>) changeDao.findAll(ids);
		if (changeList != null) {
			changeDao.delete(changeList);
		}
	}

	@Transactional(readOnly = true)
	public Change findOne(Integer id) {
		return changeDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Change> findAll() {
		return (List<Change>) changeDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Change> findAll(Specification<Change> spec, Pageable pageable) {
		return changeDao.findAll(spec, pageable);
	}

	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<Change> changeList = (List<Change>) changeDao.findAll();
		HSSFWorkbook workbook = null;
		if (changeList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("人事变动表");
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
			row0.createCell(2).setCellValue("变动前部门");
			row0.createCell(3).setCellValue("变动后部门");
			row0.createCell(4).setCellValue("变动前职位");
			row0.createCell(5).setCellValue("变动后职位");
			row0.createCell(6).setCellValue("申请日期");
			row0.createCell(7).setCellValue("通过日期");
			
			int index = 1;
			for(Change change : changeList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(change.getEmployNo());
				row.createCell(1).setCellValue(change.getEmployName());
				row.createCell(2).setCellValue(change.getFromDeptName());
				row.createCell(3).setCellValue(change.getToDeptName());
				row.createCell(4).setCellValue(change.getLastPosition());
				row.createCell(5).setCellValue(change.getNowPosition());
				row.createCell(6).setCellValue(DateUtil.dateToString(change.getApplyTime()));
				row.createCell(7).setCellValue(DateUtil.dateToString(change.getAgreeTime()));
			}
		}
		return workbook;
	}
}
