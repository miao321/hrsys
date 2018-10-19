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

import com.hrsys.common.util.DateUtil;
import com.hrsys.personnel.dao.IEmployDao;
import com.hrsys.personnel.entity.Employ;
import com.hrsys.personnel.service.IEmployService;

/**
 * 人事模块-职工类服务层实现类
 * @author Lofu
 */
@Service
@Transactional
public class EmployService implements IEmployService {

	@Autowired
	private IEmployDao employDao;

	public void saveOrUpdate(Employ employ) {
		employDao.save(employ);
	}

	public void delete(Employ employ) {
		employDao.delete(employ);
	}

	public void delete(List<Integer> ids) {
		List<Employ> employList = (List<Employ>) employDao.findAll(ids);
		if (employList != null) {
			employDao.delete(employList);
		}
	}

	@Transactional(readOnly = true)
	public Employ findOne(Integer id) {
		return employDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Employ> findAll() {
		return (List<Employ>) employDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<Employ> findAll(Specification<Employ> spec, Pageable pageable) {
		return employDao.findAll(spec, pageable);
	}

	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<Employ> employList = (List<Employ>) employDao.findAll();
		HSSFWorkbook workbook = null;
		if (employList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("职工表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);

			// 设置指定列的列宽
//			sheet.setColumnWidth(5, 256 * 15);
//			sheet.setColumnWidth(6, 256 * 15);
//			sheet.setColumnWidth(11, 256 * 25);
//			sheet.setColumnWidth(12, 256 * 20);

			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("职工号");
			row0.createCell(1).setCellValue("职工姓名");
			row0.createCell(2).setCellValue("职工性别");
			row0.createCell(3).setCellValue("所在部门");
			row0.createCell(4).setCellValue("职工职位");
			row0.createCell(5).setCellValue("个人工资");
			row0.createCell(6).setCellValue("合同开始时间");
			row0.createCell(7).setCellValue("合同结束时间");
			row0.createCell(8).setCellValue("入职日期");
			row0.createCell(9).setCellValue("出生日期");
			row0.createCell(10).setCellValue("教育程度");
			row0.createCell(11).setCellValue("毕业学校");
			row0.createCell(12).setCellValue("邮箱地址");
			row0.createCell(13).setCellValue("手机号码");
			row0.createCell(14).setCellValue("身份证号");
			row0.createCell(15).setCellValue("职工籍贯");

			int index = 1;
			for (Employ employ : employList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(employ.getEmployNo());
				row.createCell(1).setCellValue(employ.getEmployName());
				row.createCell(2).setCellValue(employ.getEmploySex());
				row.createCell(3).setCellValue(employ.getDeptName());
				row.createCell(4).setCellValue(employ.getPosition());
				row.createCell(5).setCellValue(employ.getSalary());
				row.createCell(6).setCellValue(DateUtil.dateToString(employ.getBeginTime()));
				row.createCell(7).setCellValue(DateUtil.dateToString(employ.getEndTime()));
				row.createCell(8).setCellValue(DateUtil.dateToString(employ.getHiredate()));
				row.createCell(9).setCellValue(DateUtil.dateToString(employ.getBirthday()));
				row.createCell(10).setCellValue(employ.getEducation());
				row.createCell(11).setCellValue(employ.getGraduate());
				row.createCell(12).setCellValue(employ.getEmail());
				row.createCell(13).setCellValue(employ.getPhone());
				row.createCell(14).setCellValue(employ.getIdCard());
				row.createCell(15).setCellValue(employ.getNativePlace());
			}
		}
		return workbook;
	}
}
