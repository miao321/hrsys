package com.hrsys.system.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.annotation.SysLog;
import com.hrsys.system.dao.DeptRepository;
import com.hrsys.system.entity.Dept;
import com.hrsys.system.service.IDeptService;


@Service
@Transactional
public class DeptServiceImpl implements IDeptService {
	private static final Logger logger = LoggerFactory.getLogger(DeptServiceImpl.class);
	@Autowired
	private DeptRepository deptRepository;
	@SysLog(module="部门管理",methods="保存数据或者更新数据")
	public void saveOrUpdate(Dept dept) {
		deptRepository.save(dept);
	}
	@SysLog(module="部门管理",methods="删除数据")
	public void delete(Dept dept) {
		deptRepository.delete(dept);
	}
	@SysLog(module="部门管理",methods="删除多条数据")
	public void delete(List<Long> ids) {
		List<Dept> deptLists = (List<Dept>) deptRepository.findAll(ids);
		if (deptLists != null) {
			deptRepository.delete(deptLists);
		}			
	}
	@SysLog(module="部门管理",methods="查找一条数据")
	public Dept findOne(Long id) {
		return deptRepository.findOne(id);
	}
	@SysLog(module="部门管理",methods="查找所有数据")
	public List<Dept> findAll() {
		return (List<Dept>) deptRepository.findAll();
	}
	@SysLog(module="部门管理",methods="查找所有数据并分页排序")
	public Page<Dept> findAll(Specification<Dept> spec, Pageable pageable) {
		return deptRepository.findAll(spec, pageable);
	}

}
