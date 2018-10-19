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

import com.hrsys.common.util.DateUtils;
import com.hrsys.employ.entity.EmployJob;
import com.hrsys.train.dao.ITrainCourseDao;
import com.hrsys.train.entity.TrainCourse;
import com.hrsys.train.service.ITrainCourseService;
/**
 * 培训课程类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class TrainCourseService implements ITrainCourseService {

	@Autowired
	private ITrainCourseDao trainCourseDao;
	
	public void saveOrUpdate(TrainCourse trainCourse) {
		trainCourseDao.save(trainCourse);
		
	}

	public void delete(TrainCourse trainCourse) {
		trainCourseDao.delete(trainCourse);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<TrainCourse> trainCourses =  (List<TrainCourse>)trainCourseDao.findAll(ids);
		if(trainCourses!=null) {
			trainCourseDao.delete(trainCourses);
		}

	}
	@Transactional(readOnly = true)
	public TrainCourse findOne(Long id) {
		return trainCourseDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<TrainCourse> findAll() {
		return (List<TrainCourse>) trainCourseDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<TrainCourse> findAll(Specification<TrainCourse> spec, Pageable pageable) {
		
		return trainCourseDao.findAll(spec,pageable);
	}
	
	@Transactional(readOnly = true)
	public List<TrainCourse> findByTrainCourseNum() {
		
		return (List<TrainCourse>) trainCourseDao.findByTrainCourseNum();
	}
	
	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<TrainCourse> trainCourseList = (List<TrainCourse>) trainCourseDao.findAll();
		HSSFWorkbook workbook = null;
		if (trainCourseList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("培训课程记录表");
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
			row0.createCell(2).setCellValue("培训语言");
			row0.createCell(3).setCellValue("培训方式");
			row0.createCell(4).setCellValue("培训对象");
			row0.createCell(5).setCellValue("培训讲师");
			
			int index = 1;
			for(TrainCourse trainCourse : trainCourseList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(trainCourse.getTrainCourseNo());
				row.createCell(1).setCellValue(trainCourse.getTrainCourseName());
				row.createCell(2).setCellValue(trainCourse.getTrainCourseLanguage());
				row.createCell(3).setCellValue(trainCourse.getTrainCourseMethod());
				row.createCell(4).setCellValue(trainCourse.getTrainCourseObject());
				row.createCell(5).setCellValue(trainCourse.getTrainCourseTutor());
		
			}
		}
		return workbook;
	}


}
