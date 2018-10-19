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
import com.hrsys.employ.dao.IEmployApplyDao;
import com.hrsys.employ.entity.EmployApply;

import com.hrsys.employ.service.IEmployApplyService;

/**
 * 应聘者信息类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class EmployApplyService implements IEmployApplyService {
	@Autowired
	private IEmployApplyDao employApplyDao;
	
	public void saveOrUpdate(EmployApply employApply) {
		employApplyDao.save(employApply);
		
	}

	public void delete(EmployApply employApply) {
		employApplyDao.delete(employApply);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<EmployApply> employApplys =  (List<EmployApply>)employApplyDao.findAll(ids);
		if(employApplys!=null) {
			employApplyDao.delete(employApplys);
		}

	}
	@Transactional(readOnly = true)
	public EmployApply findOne(Long id) {
		return employApplyDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<EmployApply> findAll() {
		return (List<EmployApply>) employApplyDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<EmployApply> findAll(Specification<EmployApply> spec, Pageable pageable) {
		
		return employApplyDao.findAll(spec,pageable);
	}
	
	@Transactional(readOnly = true)
	public List<EmployApply> findByEmployApplyNum() {
		
		return (List<EmployApply>) employApplyDao.findByEmployApplyNum();
	}
	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<EmployApply> employApplyList = (List<EmployApply>) employApplyDao.findAll();
		HSSFWorkbook workbook = null;
		if (employApplyList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("求职者记录表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);

			// 设置指定列的列宽
//			sheet.setColumnWidth(5, 256 * 15);
			
			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("应聘者编号");
			row0.createCell(1).setCellValue("应聘者名字");
			row0.createCell(2).setCellValue("招聘职位名称");
			row0.createCell(3).setCellValue("性别");
			row0.createCell(4).setCellValue("籍贯");
			row0.createCell(5).setCellValue("出生日期");
			row0.createCell(6).setCellValue("毕业院校");
			row0.createCell(7).setCellValue("专业");
			row0.createCell(8).setCellValue("学历");
			row0.createCell(9).setCellValue("联系电话");
			row0.createCell(10).setCellValue("电子邮箱");	
			row0.createCell(11).setCellValue("录用情况");		
			int index = 1;
			for(EmployApply employApply : employApplyList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(employApply.getEmployApplyNo());
				row.createCell(1).setCellValue(employApply.getEmployApplyName());
				row.createCell(2).setCellValue(employApply.getEmployJobName());
				row.createCell(3).setCellValue(employApply.getEmployApplySex());
				row.createCell(4).setCellValue(employApply.getEmployApplyPlace());
				row.createCell(5).setCellValue(DateUtils.getNowDateShort(employApply.getEmployApplyBirth()));
				row.createCell(6).setCellValue(employApply.getEmployApplySchool());
				row.createCell(7).setCellValue(employApply.getEmployApplyMajor());
				row.createCell(8).setCellValue(employApply.getEmployApplyEducation());
				row.createCell(9).setCellValue(employApply.getEmployApplyPhone());
				row.createCell(10).setCellValue(employApply.getEmployApplyEmail());		
				row.createCell(11).setCellValue(employApply.getEmployApplySituation());					
			}
		}
		return workbook;
	}

/*	@Transactional(readOnly = true)
	public Page<EmployJob> findByEmployJob(Specification<EmployJob> spec, Pageable pageable) {
		
		return employApplyDao.findByEmployJob(spec,pageable);
	}*/
}
