package com.hrsys.wage.service;



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
import com.hrsys.wage.dao.WageRepository;
import com.hrsys.wage.entity.Wage;







@Service
@Transactional
public class WageService implements IWageService{
	@Autowired
	private WageRepository wageRepository;


	public void saveOrUpdate(Wage wage) {
		wageRepository.save(wage);
	}
	
	public void delete(Wage wage) {
		wageRepository.delete(wage);
	}
	
	public void delete(List<Long> ids) 
	{
		List<Wage> wages =  (List<Wage>) wageRepository.findAll(ids);
		if(wages!=null) {
			wageRepository.delete(wages);
		}
	}

	@Transactional(readOnly = true)
	public Wage findOne(Long id) {
		return wageRepository.findOne(id); 
	}
	@Transactional(readOnly = true)
	public List<Wage> findAll() {
		return (List<Wage>) wageRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<Wage> findAll(Specification<Wage> spec, Pageable pageable) {
		return wageRepository.findAll(spec, pageable);
	}
	
	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<Wage> wageList = (List<Wage>) wageRepository.findAll();
		HSSFWorkbook workbook = null;
		if (wageList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("工资表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);

			
			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("工资号");
			row0.createCell(1).setCellValue("员工编号");
			row0.createCell(2).setCellValue("员工姓名");
			row0.createCell(3).setCellValue("部门");
			row0.createCell(4).setCellValue("职位");
			row0.createCell(5).setCellValue("工资时间");
			row0.createCell(6).setCellValue("基本工资");
			row0.createCell(7).setCellValue("保险每月金额");
			row0.createCell(8).setCellValue("罚金金额");
			row0.createCell(9).setCellValue("奖励金额");
			row0.createCell(10).setCellValue("最终工资");
			
			int index = 1;
			for(Wage wage : wageList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(wage.getWageId());
				row.createCell(1).setCellValue(wage.getPersonnelId());
				row.createCell(2).setCellValue(wage.getPersonnelName());
				row.createCell(3).setCellValue(wage.getDepartment());
				row.createCell(4).setCellValue(wage.getPosition());
				row.createCell(5).setCellValue(DateUtil.dateToString(wage.getTime()));
				row.createCell(6).setCellValue(wage.getBasicWage());
				row.createCell(7).setCellValue(wage.getInsuranceMoney());
				row.createCell(8).setCellValue(wage.getFinedMoney());
				row.createCell(9).setCellValue(wage.getAwardMoney());
				row.createCell(10).setCellValue(wage.getFinalWage());
			}
		}
		return workbook;
	}
	@Transactional(readOnly = true)
	public List<Wage> findByfinalWageNum(){
		return (List<Wage>) wageRepository.findByfinalWageNum();
	}
	
	@Transactional(readOnly = true)
	public List<Wage> findByfinalWageSum(){
		return (List<Wage>) wageRepository.findByfinalWageSum();
	}
	
	

	
}