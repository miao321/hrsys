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
import com.hrsys.train.dao.ITrainDemandDao;
import com.hrsys.train.entity.TrainCourse;
import com.hrsys.train.entity.TrainDemand;
import com.hrsys.train.service.ITrainDemandService;
/**
 * 培训需求类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class TrainDemandService implements ITrainDemandService {

	@Autowired
	private ITrainDemandDao trainDemandDao;
	
	public void saveOrUpdate(TrainDemand trainDemand) {
		trainDemandDao.save(trainDemand);
		
	}

	public void delete(TrainDemand trainDemand) {
		trainDemandDao.delete(trainDemand);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<TrainDemand> trainDemands =  (List<TrainDemand>)trainDemandDao.findAll(ids);
		if(trainDemands!=null) {
			trainDemandDao.delete(trainDemands);
		}

	}
	@Transactional(readOnly = true)
	public TrainDemand findOne(Long id) {
		return trainDemandDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<TrainDemand> findAll() {
		return (List<TrainDemand>) trainDemandDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public Page<TrainDemand> findAll(Specification<TrainDemand> spec, Pageable pageable) {
		
		return trainDemandDao.findAll(spec,pageable);
	}
	
	@Transactional(readOnly = true)
	public List<TrainDemand> findByTrainDemandNum() {
		
		return (List<TrainDemand>) trainDemandDao.findByTrainDemandNum();
	}
	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<TrainDemand> trainDemandList = (List<TrainDemand>) trainDemandDao.findAll();
		HSSFWorkbook workbook = null;
		if (trainDemandList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("培训需求记录表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);

			// 设置指定列的列宽
//			sheet.setColumnWidth(5, 256 * 15);
			
			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("培训需求编号");
			row0.createCell(1).setCellValue("培训课程需求");
			row0.createCell(2).setCellValue("培训需求内容");
			row0.createCell(3).setCellValue("培训需求目标");
			row0.createCell(4).setCellValue("提出时间");
			row0.createCell(5).setCellValue("提出人");
			row0.createCell(6).setCellValue("审核人");
		
			int index = 1;
			for(TrainDemand trainDemand : trainDemandList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(trainDemand.getTrainDemandNo());
				row.createCell(1).setCellValue(trainDemand.getTrainDemandName());
				row.createCell(2).setCellValue(trainDemand.getTrainDemandContent());
				row.createCell(3).setCellValue(trainDemand.getTrainDemandTarget());
				row.createCell(4).setCellValue(DateUtils.getNowDateShort(trainDemand.getTrainDemandTime()));
				row.createCell(5).setCellValue(trainDemand.getTrainDemandProposer());
				row.createCell(6).setCellValue(trainDemand.getTrainDemandReviewer());
				
			
			}
		}
		return workbook;
	}
}