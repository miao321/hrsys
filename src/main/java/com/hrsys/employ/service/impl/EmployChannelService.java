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


import com.hrsys.employ.dao.IEmployChannelDao;
import com.hrsys.employ.entity.EmployChannel;

import com.hrsys.employ.service.IEmployChannelService;


/**
 * 招聘渠道类Service层实现类
 * @author Administrator
 *
 */

@Service
@Transactional
public class EmployChannelService implements IEmployChannelService {

	@Autowired
	private IEmployChannelDao employChannelDao;
	
	public void saveOrUpdate(EmployChannel employChannel) {
		employChannelDao.save(employChannel);
		
	}

	
	public void delete(EmployChannel employChannel) {
		employChannelDao.delete(employChannel);
	}

	//批量删除
	public void delete(List<Long> ids) {
		List<EmployChannel> employChannels =  (List<EmployChannel>) employChannelDao.findAll(ids);
		if(employChannels!=null) {
			employChannelDao.delete(employChannels);
		}

	}
		
	@Transactional(readOnly = true)
	public EmployChannel findOne(Long id) {
		return employChannelDao.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<EmployChannel> findAll() {
		return (List<EmployChannel>) employChannelDao.findAll();
	}

	@Transactional(readOnly = true)
	public Page<EmployChannel> findAll(Specification<EmployChannel> spec, Pageable pageable) {
		return employChannelDao.findAll(spec,pageable);
	}


	@Override
	public List<EmployChannel> findByEmployChannel() {
		return (List<EmployChannel>) employChannelDao.findByEmployChannel();
	}

	@Transactional(readOnly = true)
	public List<EmployChannel> findByEmployChannelNum() {
		
		return (List<EmployChannel>) employChannelDao.findByEmployChannelNum();
	}
	
	@Transactional(readOnly = true)
	public HSSFWorkbook downloadExcel() {
		List<EmployChannel> employChannelList = (List<EmployChannel>) employChannelDao.findAll();
		HSSFWorkbook workbook = null;
		if (employChannelList != null) {
			// 1.创建HSSFWorkbook对象(excel的文档对象)
			workbook = new HSSFWorkbook();
			// 2.建立新的sheet对象（excel的表单）
			HSSFSheet sheet = workbook.createSheet("招聘渠道记录表");
			// 设置缺省列高
			sheet.setDefaultRowHeightInPoints(20);
			// 设置缺省列宽
			sheet.setDefaultColumnWidth(10);

			// 3.在sheet里创建第一行，参数为行索引(excel的行)，从0开始
			HSSFRow row0 = sheet.createRow(0);

			// 设置指定列的列宽
//			sheet.setColumnWidth(5, 256 * 15);
			
			// 4.在第一行创建单元格并设置单元格内容
			row0.createCell(0).setCellValue("招聘渠道编号");
			row0.createCell(1).setCellValue("招聘渠道名称");
			row0.createCell(2).setCellValue("招聘渠道联系电话");
			row0.createCell(3).setCellValue("招聘渠道简介");
			row0.createCell(4).setCellValue("备注");
		
			int index = 1;
			for(EmployChannel employChannel : employChannelList) {
				HSSFRow row = sheet.createRow(index++);
				row.createCell(0).setCellValue(employChannel.getEmployChannelNo());
				row.createCell(1).setCellValue(employChannel.getEmployChannelName());
				row.createCell(2).setCellValue(employChannel.getEmployChannelPhone());
				row.createCell(3).setCellValue(employChannel.getEmployChannelDescription());
				row.createCell(4).setCellValue(employChannel.getEmployChannelMark());
				
			}
		}
		return workbook;
	}


	

}
