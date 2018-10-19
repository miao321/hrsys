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
import com.hrsys.employ.dao.IEmployJobDao;
import com.hrsys.employ.entity.EmployJob;
import com.hrsys.employ.entity.dto.EmployJobQueryDTO;
import com.hrsys.employ.service.IEmployJobService;


/**
 * 招聘职位类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class EmployJobService implements IEmployJobService{

	@Autowired
	private IEmployJobDao employJobDao;
	
	public void saveOrUpdate(EmployJob employJob) {
		employJobDao.save(employJob);
		
	}

	public void delete(EmployJob employJob) {
		employJobDao.delete(employJob);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<EmployJob> employJobs =  (List<EmployJob>) employJobDao.findAll(ids);
		if(employJobs!=null) {
			employJobDao.delete(employJobs);
		}

	}
	@Transactional(readOnly = true)
	public EmployJob findOne(Long id) {
		return employJobDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<EmployJob> findAll() {
		return (List<EmployJob>) employJobDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<EmployJob> findAll(Specification<EmployJob> spec, Pageable pageable) {
		
		return employJobDao.findAll(spec,pageable);
	}

	@Transactional(readOnly = true)
	public List<EmployJob> findByEmployJob() {
		/*List<EmployJob> list = (List<EmployJob>) employJobDao.findByEmployJob();
		System.out.println(list);*/
		return (List<EmployJob>) employJobDao.findByEmployJob();
	}
	
	@Transactional(readOnly = true)
	public List<EmployJob> findByEmployJobNum() {
		
		return (List<EmployJob>) employJobDao.findByEmployJobNum();
	}
	
	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<EmployJob> employJobList = (List<EmployJob>) employJobDao.findAll();
		HSSFWorkbook workbook = null;
		if (employJobList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("招聘职位记录表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);

			// 设置指定列的列宽
//			sheet.setColumnWidth(5, 256 * 15);
			
			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("招聘职位编号");
			row0.createCell(1).setCellValue("招聘职位名称");
			row0.createCell(2).setCellValue("发布时间");
			row0.createCell(3).setCellValue("截止时间");
			row0.createCell(4).setCellValue("职位描述");
			row0.createCell(5).setCellValue("职位要求");
			row0.createCell(6).setCellValue("职位待遇");
			row0.createCell(7).setCellValue("工作地点");
			row0.createCell(8).setCellValue("需要到岗时间");
			row0.createCell(9).setCellValue("招聘人数");
			row0.createCell(10).setCellValue("招聘负责人");			
			int index = 1;
			for(EmployJob employJob : employJobList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(employJob.getEmployJobNo());
				row.createCell(1).setCellValue(employJob.getEmployJobName());
				row.createCell(2).setCellValue(DateUtils.getNowDateShort(employJob.getEmployJobStartTime()));
				row.createCell(3).setCellValue(DateUtils.getNowDateShort(employJob.getEmployJobEndTime()));
				row.createCell(4).setCellValue(employJob.getEmployJobDescription());
				row.createCell(5).setCellValue(employJob.getEmployJobDemand());
				row.createCell(6).setCellValue(employJob.getEmployJobSalary());
				row.createCell(7).setCellValue(employJob.getEmployJobPlace());
				row.createCell(8).setCellValue(DateUtils.getNowDateShort(employJob.getEmployJobDate()));
				row.createCell(9).setCellValue(employJob.getEmployJobNum());
				row.createCell(10).setCellValue(employJob.getEmployJobResponsible());		
			
			}
		}
		return workbook;
	}

}
