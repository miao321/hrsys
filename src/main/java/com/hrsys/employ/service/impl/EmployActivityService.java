package com.hrsys.employ.service.impl;

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

import com.hrsys.common.util.DateUtils;
import com.hrsys.employ.dao.IEmployActivityDao;
import com.hrsys.employ.entity.EmployActivity;
import com.hrsys.employ.entity.EmployChannel;
import com.hrsys.employ.service.IEmployActivityService;

/**
 * 招聘活动类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class EmployActivityService implements IEmployActivityService {
	@Autowired
	private IEmployActivityDao employActivityDao;
	
	public void saveOrUpdate(EmployActivity employActivity) {
		employActivityDao.save(employActivity);
		
	}

	public void delete(EmployActivity employActivity) {
		employActivityDao.delete(employActivity);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<EmployActivity> employActivitys =  (List<EmployActivity>)employActivityDao.findAll(ids);
		if(employActivitys!=null) {
			employActivityDao.delete(employActivitys);
		}

	}
	@Transactional(readOnly = true)
	public EmployActivity findOne(Long id) {
		return employActivityDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<EmployActivity> findAll() {
		return (List<EmployActivity>) employActivityDao.findAll();
	}
	@Transactional(readOnly = true)
	public List<EmployActivity> findByEmployActivityNum() {
		
		return (List<EmployActivity>) employActivityDao.findByEmployActivityNum();
	}
	@Transactional(readOnly = true)
	public Page<EmployActivity> findAll(Specification<EmployActivity> spec, Pageable pageable) {
		
		return employActivityDao.findAll(spec,pageable);
	}
	
	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<EmployActivity> employActivityList = (List<EmployActivity>) employActivityDao.findAll();
		HSSFWorkbook workbook = null;
		if (employActivityList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("招聘活动记录表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);

			// 设置指定列的列宽
//			sheet.setColumnWidth(5, 256 * 15);
			
			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("招聘活动编号");
			row0.createCell(1).setCellValue("招聘活动名称");
			row0.createCell(2).setCellValue("招聘活动举办日期");
			row0.createCell(3).setCellValue("招聘活动举办地点");
			row0.createCell(4).setCellValue("招聘活动联系电话");
			row0.createCell(5).setCellValue("招聘活动内容详情");
			row0.createCell(6).setCellValue("备注");
	
			int index = 1;
			for(EmployActivity employActivity : employActivityList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(employActivity.getEmployActivityNo());
				row.createCell(1).setCellValue(employActivity.getEmployActivityName());
				row.createCell(2).setCellValue(DateUtils.getNowDateShort(employActivity.getEmployActivityDate()));
				row.createCell(3).setCellValue(employActivity.getEmployActivityPlace());
				row.createCell(4).setCellValue(employActivity.getEmployActivityPhone());
				row.createCell(5).setCellValue(employActivity.getEmployActivityContent());
				row.createCell(6).setCellValue(employActivity.getEmployActivityMark());
			
			
			}
		}
		return workbook;
	}
}
