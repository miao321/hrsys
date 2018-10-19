package com.hrsys.personnel.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.personnel.entity.Employ;

/**
 * 人事模块-职工类数据访问层
 * @author Lofu
 */
@Repository
public interface IEmployDao extends PagingAndSortingRepository<Employ,Integer>,JpaSpecificationExecutor<Employ> {
	
	/** 查找职工表中性别的人数 */
	@Query(value = "select employSex, count(*) from t_employ group by employSex", nativeQuery = true)
	public List<Object[]> countSex();
	
	/** 查找职工表中教育程度的人数 */
	@Query(value = "select education, count(*) from t_employ group by education", nativeQuery = true)
	public List<Object[]> countEducation();
	
	/** 查找职工表中部门的人数 */
	@Query(value = "select deptName, count(*) from t_employ group by deptName", nativeQuery = true)
	public List<Object[]> countDept();
}
