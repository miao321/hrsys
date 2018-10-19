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

import com.hrsys.train.dao.ITrainPlanDao;

import com.hrsys.train.entity.TrainPlan;
import com.hrsys.train.service.ITrainPlanService;
/**
 * 培训计划类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class TrainPlanService implements ITrainPlanService {

	@Autowired
	private ITrainPlanDao trainPlanDao;
	
	public void saveOrUpdate(TrainPlan trainPlan) {
		trainPlanDao.save(trainPlan);
		
	}

	public void delete(TrainPlan trainPlan) {
		trainPlanDao.delete(trainPlan);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<TrainPlan> trainPlans =  (List<TrainPlan>)trainPlanDao.findAll(ids);
		if(trainPlans!=null) {
			trainPlanDao.delete(trainPlans);
		}

	}
	@Transactional(readOnly = true)
	public TrainPlan findOne(Long id) {
		return trainPlanDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<TrainPlan> findAll() {
		return (List<TrainPlan>) trainPlanDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<TrainPlan> findAll(Specification<TrainPlan> spec, Pageable pageable) {
		
		return trainPlanDao.findAll(spec,pageable);
	}
	@Transactional(readOnly = true)
	public List<TrainPlan> findByTrainPlanNum() {
		
		return (List<TrainPlan>) trainPlanDao.findByTrainPlanNum();
	}
	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<TrainPlan> trainPlanList = (List<TrainPlan>) trainPlanDao.findAll();
		HSSFWorkbook workbook = null;
		if (trainPlanList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("培训计划记录表");
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
			row0.createCell(2).setCellValue("培训内容");
			row0.createCell(3).setCellValue("培训目标");
			row0.createCell(4).setCellValue("培训地点");
			row0.createCell(5).setCellValue("培训材料");
			row0.createCell(6).setCellValue("培训开始时间");
			row0.createCell(7).setCellValue("培训结束时间");
			row0.createCell(8).setCellValue("培训讲师");
		
			int index = 1;
			for(TrainPlan trainPlan : trainPlanList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(trainPlan.getTrainCourseNo());
				row.createCell(1).setCellValue(trainPlan.getTrainCourseName());
				row.createCell(2).setCellValue(trainPlan.getTrainPlanContent());
				row.createCell(3).setCellValue(trainPlan.getTrainPlanTarget());
				row.createCell(4).setCellValue(trainPlan.getTrainPlanPlace());
				row.createCell(5).setCellValue(trainPlan.getTrainMaterialNo());
				row.createCell(6).setCellValue(DateUtils.getNowDateShort(trainPlan.getTrainPlanStartTime()));
				row.createCell(7).setCellValue(DateUtils.getNowDateShort(trainPlan.getTrainPlanEndTime()));
				row.createCell(8).setCellValue(trainPlan.getTrainPlanTutor());		
			
			}
		}
		return workbook;
	}
}