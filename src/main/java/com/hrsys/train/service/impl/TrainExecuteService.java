package com.hrsys.train.service.impl;

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


import com.hrsys.train.dao.ITrainExecuteDao;
import com.hrsys.train.entity.TrainCourse;
import com.hrsys.train.entity.TrainExecute;
import com.hrsys.train.service.ITrainExecuteService;
/**
 * 培训实施类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class TrainExecuteService implements ITrainExecuteService {

	@Autowired
	private ITrainExecuteDao trainExecuteDao;
	
	public void saveOrUpdate(TrainExecute trainExecute) {
		trainExecuteDao.save(trainExecute);
		
	}

	public void delete(TrainExecute trainExecute) {
		trainExecuteDao.delete(trainExecute);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<TrainExecute> trainExecutes =  (List<TrainExecute>)trainExecuteDao.findAll(ids);
		if(trainExecutes!=null) {
			trainExecuteDao.delete(trainExecutes);
		}

	}
	@Transactional(readOnly = true)
	public TrainExecute findOne(Long id) {
		return trainExecuteDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<TrainExecute> findAll() {
		return (List<TrainExecute>) trainExecuteDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<TrainExecute> findAll(Specification<TrainExecute> spec, Pageable pageable) {
		
		return trainExecuteDao.findAll(spec,pageable);
	}
	@Transactional(readOnly = true)
	public List<TrainExecute> findByTrainExecuteNum() {
		
		return (List<TrainExecute>) trainExecuteDao.findByTrainExecuteNum();
	}
	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<TrainExecute> trainExecuteList = (List<TrainExecute>) trainExecuteDao.findAll();
		HSSFWorkbook workbook = null;
		if (trainExecuteList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("培训实施记录表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);

			// 设置指定列的列宽
//			sheet.setColumnWidth(5, 256 * 15);
			
			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("培训课程编号");
			row0.createCell(1).setCellValue("培训课程名称");
			row0.createCell(2).setCellValue("培训参与人数");
			row0.createCell(3).setCellValue("费用预算");
	
			int index = 1;
			for(TrainExecute trainExecute : trainExecuteList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(trainExecute.getTrainCourseNo());
				row.createCell(1).setCellValue(trainExecute.getTrainCourseName());
				row.createCell(2).setCellValue(trainExecute.getTrainExecuteApplyNum());
				row.createCell(3).setCellValue(trainExecute.getTrainExecuteBudget());
				
			}
		}
		return workbook;
	}
}