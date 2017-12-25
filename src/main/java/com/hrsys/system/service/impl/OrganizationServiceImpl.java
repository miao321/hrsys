package com.hrsys.system.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.hrsys.system.dao.OrganizationRepository;
import com.hrsys.system.entity.Organization;
import com.hrsys.system.service.IOrganizationService;


@Service
public class OrganizationServiceImpl implements IOrganizationService {
	private static final Logger logger = LoggerFactory.getLogger(OrganizationServiceImpl.class);
	@Autowired
	private OrganizationRepository organizationRepository;
	@Override
	public void saveOrUpdate(Organization organization) {
		organizationRepository.save(organization);
	}

	@Override
	public void delete(Organization organization) {
		organizationRepository.delete(organization);
	}

	@Override
	public void delete(List<Long> ids) {
		List<Organization> organizationLists = (List<Organization>) organizationRepository.findAll(ids);
		if (organizationLists != null) {
			organizationRepository.delete(organizationLists);
		}			
	}

	@Override
	public Organization findOne(Long id) {
		return organizationRepository.findOne(id);
	}

	@Override
	public List<Organization> findAll() {
		return (List<Organization>) organizationRepository.findAll();
	}

	@Override
	public Page<Organization> findAll(Specification<Organization> spec, Pageable pageable) {
		return organizationRepository.findAll(spec, pageable);
	}

}
