package com.hrsys.employ.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.hrsys.employ.entity.EmployChannel;
import com.hrsys.employ.entity.EmployJob;



/**
 * 招聘渠道类Service层接口
 * @author Administrator
 *
 */
public interface IEmployChannelService {
	public void saveOrUpdate(EmployChannel employChannel);
	public void delete(EmployChannel employChannel);
	//批量删除
	public void delete(List<Long> ids);
	public EmployChannel findOne(Long id);
	public List<EmployChannel> findAll();
	//动态条件查询
	public Page<EmployChannel> findAll(Specification<EmployChannel> spec, Pageable pageable);
	public List<EmployChannel>findByEmployChannel();
	
	//获取EmployChannel数目
	public List<EmployChannel> findByEmployChannelNum();

	//记录表Excel下载
	public HSSFWorkbook downloadExcel();
}
