package com.hrsys.system.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.hrsys.system.entity.Dept;
import com.hrsys.system.entity.Role;
import com.hrsys.user.entity.User;
@Repository
public interface DeptRepository extends PagingAndSortingRepository<Dept, Long>,JpaSpecificationExecutor<Dept> {
	/**
	 * 查询根节点
	 */
	@Query("from Dept o where o.parentName.id = null")
	public List<Dept> findParentNodes();
	/**
	 * 根据父节点ID查询出子节点, 父节点为null的时候被data jpa过滤掉。所以无法传null
	 */
	@Query("from Dept o where o.parentName.id = ?1")
	public List<Dept> findChildNodes(Long parentId);//null
	
	@Query("from Dept dept where dept.deptName =?1")
	public Dept findDept(String deptName);
}
