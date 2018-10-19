package com.hrsys.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.system.entity.Module;
import com.hrsys.system.entity.Role;
import com.hrsys.user.entity.User;
@Repository
public interface ModuleRepository extends PagingAndSortingRepository<Module, Long>,JpaSpecificationExecutor<Module> {
	/**
	 * 查询根节点
	 */
	@Query("from Module m where m.parentNode.id = null")
	public List<Module> findParentNodes();
	/**
	 * 根据父节点ID查询出子节点, 父节点为null的时候被data jpa过滤掉。所以无法传null
	 */
	@Query("from Module m where m.parentNode.id = ?1")
	public List<Module> findChildNodes(Long parentId);//null
	
	@Query("from Module module where module.moduleName =?1")
	public Module findModule(String moduleName);
}
