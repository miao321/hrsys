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
import com.hrsys.system.dao.ModuleRepository;
import com.hrsys.system.entity.Module;
import com.hrsys.system.service.IModuleService;






@Service
@Transactional
public class ModuleServiceImpl implements IModuleService {
	private static final Logger logger = LoggerFactory.getLogger(ModuleServiceImpl.class);
	@Autowired
	private ModuleRepository moduleRepository;
	@SysLog(module="模块管理",methods="保存或者更新数据")
	public void saveOrUpdate(Module module) {
		moduleRepository.save(module);
	}
	@SysLog(module="模块管理",methods="删除一条数据")
	public void delete(Module module) {
		moduleRepository.delete(module);
	}
	@SysLog(module="模块管理",methods="删除多条数据")
	public void delete(List<Long> ids) {
		List<Module> moduleLists = (List<Module>) moduleRepository.findAll(ids);
		if (moduleLists != null) {
			moduleRepository.delete(moduleLists);
		}

	}
	@SysLog(module="模块管理",methods="查找一条数据")
	public Module findOne(Long id) {
		return moduleRepository.findOne(id);
	}
	@SysLog(module="模块管理",methods="查找所有数据")
	public List<Module> findAll() {
		return (List<Module>) moduleRepository.findAll();
	}
	@SysLog(module="模块管理",methods="查找所有数据并分页排序")
	public Page<Module> findAll(Specification<Module> spec, Pageable pageable) {
		return moduleRepository.findAll(spec, pageable);
	}
	@Override
	public Module findModule(String moduleName) {
		return moduleRepository.findModule(moduleName);
	}

}
