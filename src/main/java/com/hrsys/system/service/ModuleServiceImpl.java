package com.hrsys.system.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsys.system.dao.ModuleRepository;
import com.hrsys.system.entity.Module;
@Service
public class ModuleServiceImpl implements IModuleService {
	private static final Logger logger = LoggerFactory.getLogger(ModuleServiceImpl.class);
	@Autowired
	private ModuleRepository moduleRepository;
	@Override
	public void saveOrUpdate(Module module) {
		moduleRepository.save(module);
	}

	@Override
	public void delete(Module module) {
		moduleRepository.delete(module);
	}

	@Override
	public void delete(List<Long> ids) {
		List<Module> moduleLists = (List<Module>) moduleRepository.findAll(ids);
		if (moduleLists != null) {
			moduleRepository.delete(moduleLists);
		}

	}

	@Override
	public Module findOne(Long id) {
		return moduleRepository.findOne(id);
	}

	@Override
	public List<Module> findAll() {
		return (List<Module>) moduleRepository.findAll();
	}

	@Override
	public Page<Module> findAll(Specification<Module> spec, Pageable pageable) {
		return moduleRepository.findAll(spec, pageable);
	}

}
