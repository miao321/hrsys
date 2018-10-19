package com.hrsys.personnel.service.impl;

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

import com.hrsys.personnel.dao.IPdeptDao;
import com.hrsys.personnel.entity.Pdept;
import com.hrsys.personnel.service.IPdeptService;

/**
 * 人事模块-部门类服务层实现类
 * 
 * @author Lofu
 */
@Service
@Transactional
public class PdeptService implements IPdeptService {

	@Autowired
	private IPdeptDao deptDao;

	public void saveOrUpdate(Pdept dept) {
		deptDao.save(dept);
	}

	public void delete(Pdept dept) {
		deptDao.delete(dept);
	}

	public void delete(List<Integer> ids) {
		List<Pdept> deptList = (List<Pdept>) deptDao.findAll(ids);
		if (deptList != null) {
			deptDao.delete(deptList);
		}
	}

	@Transactional(readOnly = true)
	public Pdept findOne(Integer id) {
		return deptDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Pdept> findAll() {
		return (List<Pdept>) deptDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Pdept> findAll(Specification<Pdept> spec, Pageable pageable) {
		return deptDao.findAll(spec, pageable);
	}

	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<Pdept> deptList = (List<Pdept>) deptDao.findAll();
		HSSFWorkbook workbook = null;
		if (deptList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("部门表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);
			
			// 设置指定列的列宽
			sheet.setColumnWidth(4, 256 * 15);

			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("部门号");
			row0.createCell(1).setCellValue("部门名");
			row0.createCell(2).setCellValue("部门所在地");
			row0.createCell(3).setCellValue("部门领导");
			row0.createCell(4).setCellValue("办公电话");
			
			int index = 1;
			for (Pdept dept : deptList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(dept.getDeptNo());
				row.createCell(3).setCellValue(dept.getDeptName());
				row.createCell(1).setCellValue(dept.getLocation());
				row.createCell(2).setCellValue(dept.getLeader());
				row.createCell(4).setCellValue(dept.getDeptPhone());
			}
		}
		return workbook;
	}
}
