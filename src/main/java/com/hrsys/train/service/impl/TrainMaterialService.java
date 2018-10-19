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
import com.hrsys.train.dao.ITrainMaterialDao;
import com.hrsys.train.entity.TrainCourse;
import com.hrsys.train.entity.TrainMaterial;
import com.hrsys.train.service.ITrainMaterialService;
/**
 * 培训材料类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class TrainMaterialService implements ITrainMaterialService {

	@Autowired
	private ITrainMaterialDao trainMaterialDao;
	
	public void saveOrUpdate(TrainMaterial trainMaterial) {
		trainMaterialDao.save(trainMaterial);
		
	}

	public void delete(TrainMaterial trainMaterial) {
		trainMaterialDao.delete(trainMaterial);
		
	}
	//批量删除
	public void delete(List<Long> ids) {
		List<TrainMaterial> trainMaterials =  (List<TrainMaterial>)trainMaterialDao.findAll(ids);
		if(trainMaterials!=null) {
			trainMaterialDao.delete(trainMaterials);
		}

	}
	@Transactional(readOnly = true)
	public TrainMaterial findOne(Long id) {
		return trainMaterialDao.findOne(id);
	}
	
	@Transactional(readOnly = true)
	public List<TrainMaterial> findAll() {
		return (List<TrainMaterial>) trainMaterialDao.findAll();
	}
	@Transactional(readOnly = true)
	public List<TrainMaterial> findByTrainMaterialNum() {
		
		return (List<TrainMaterial>) trainMaterialDao.findByTrainMaterialNum();
	}
	@Transactional(readOnly = true)
	public Page<TrainMaterial> findAll(Specification<TrainMaterial> spec, Pageable pageable) {
		
		return trainMaterialDao.findAll(spec,pageable);
	}
	
	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<TrainMaterial> trainMaterialList = (List<TrainMaterial>) trainMaterialDao.findAll();
		HSSFWorkbook workbook = null;
		if (trainMaterialList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("培训材料记录表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);

			// 设置指定列的列宽
//			sheet.setColumnWidth(5, 256 * 15);
			
			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("培训材料编号");
			row0.createCell(1).setCellValue("培训材料名称");
			row0.createCell(2).setCellValue("培训材料内容");
			row0.createCell(3).setCellValue("培训材料来源");
			row0.createCell(4).setCellValue("培训材料作者");
		
			int index = 1;
			for(TrainMaterial trainMaterial : trainMaterialList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(trainMaterial.getTrainMaterialNo());
				row.createCell(1).setCellValue(trainMaterial.getTrainMaterialName());
				row.createCell(2).setCellValue(trainMaterial.getTrainMaterialContent());
				row.createCell(3).setCellValue(trainMaterial.getTrainMaterialSource());
				row.createCell(4).setCellValue(trainMaterial.getTrainMaterialAuthor());
			
			}
		}
		return workbook;
	}
}