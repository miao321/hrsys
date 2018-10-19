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
import com.hrsys.wage.dao.PaRepository;
import com.hrsys.wage.entity.Pa;






@Service
@Transactional
public class PaService implements IPaService{
	@Autowired
	private PaRepository paRepository;

	public void saveOrUpdate(Pa pa) {
		paRepository.save(pa);
	}
	public void delete(Pa pa) {
		paRepository.delete(pa);
	}
	
	public void delete(List<Long> ids) 
	{
		List<Pa> pas =  (List<Pa>) paRepository.findAll(ids);
		if(pas!=null) {
			paRepository.delete(pas);
		}
	}

	@Transactional(readOnly = true)
	public Pa findOne(Long id) {
		return paRepository.findOne(id);
	}
	@Transactional(readOnly = true)
	public List<Pa> findAll() {
		return (List<Pa>) paRepository.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<Pa> findAll(Specification<Pa> spec, Pageable pageable) {
		return paRepository.findAll(spec, pageable);
	}
	@Transactional(readOnly = true)
	public List<Pa> findBypavaluesNum(){
		return (List<Pa>) paRepository.findBypavaluesNum();
		
	}
	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<Pa> paList = (List<Pa>) paRepository.findAll();
		HSSFWorkbook workbook = null;
		if (paList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("绩效考评表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);

			
			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("考评号");
			row0.createCell(1).setCellValue("员工编号");
			row0.createCell(2).setCellValue("员工姓名");
			row0.createCell(3).setCellValue("部门");
			row0.createCell(4).setCellValue("职位");
			row0.createCell(5).setCellValue("考评时间");
			row0.createCell(6).setCellValue("考评分值");
			row0.createCell(7).setCellValue("考评评价");
			row0.createCell(8).setCellValue("考评人编号");
			row0.createCell(9).setCellValue("考评人姓名");
			row0.createCell(10).setCellValue("考评人职位");
			
			int index = 1;
			for(Pa pa : paList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(pa.getPaId());
				row.createCell(1).setCellValue(pa.getPersonnelId());
				row.createCell(2).setCellValue(pa.getPersonnelName());
				row.createCell(3).setCellValue(pa.getDepartment());
				row.createCell(4).setCellValue(pa.getPosition());
				row.createCell(5).setCellValue(DateUtil.dateToString(pa.getPatime()));
				row.createCell(6).setCellValue(pa.getPavalues());
				row.createCell(7).setCellValue(pa.getPaassessment());
				row.createCell(8).setCellValue(pa.getEvaluaterId());
				row.createCell(9).setCellValue(pa.getEvaluaterName());
				row.createCell(10).setCellValue(pa.getEvaluaterPosition());
				
			}
		}
		return workbook;
	}
}
