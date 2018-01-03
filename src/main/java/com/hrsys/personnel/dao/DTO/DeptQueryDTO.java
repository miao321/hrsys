package com.hrsys.personnel.dao.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.hrsys.personnel.entity.Dept;

/**
 * 部门类高级查询
 * @author Lofu
 */
public class DeptQueryDTO {
	private String deptNo;		//部门的id
	private String deptName;	//部门名称
	private String location;	//部门所在地
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	/** static的工具方法：根据当前 EmployQueryDTO 对象来组装动态查询条件 */
	public static Specification<Dept> getSpecification(DeptQueryDTO deptQueryDTO) {
		Specification<Dept> spec = new Specification<Dept>() {
			public Predicate toPredicate(Root<Dept> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();

				// 2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				if (deptQueryDTO != null && !StringUtils.isEmpty(deptQueryDTO.getDeptName())) {
					Predicate p = cb.like(root.get("deptName").as(String.class),
							"%" + deptQueryDTO.getDeptName() + "%");
					list.add(p);
				}
				
				if (deptQueryDTO != null && !StringUtils.isEmpty(deptQueryDTO.getLocation())) {
					Predicate p = cb.like(root.get("location").as(String.class),
							"%" + deptQueryDTO.getLocation() + "%");
					list.add(p);
				}
				
				if (deptQueryDTO != null && !StringUtils.isEmpty(deptQueryDTO.getDeptNo())) {
					Predicate p = cb.equal(root.get("deptNo").as(String.class),
							deptQueryDTO.getDeptNo());
					list.add(p);
				}

				// 3.Predicate查询条件集合的 size 创建对应的Predicate查询条件数组
				Predicate[] p = new Predicate[list.size()];

				// 4.CriteriaBuilder的and 函数组装 查询条件数组
				return cb.and(list.toArray(p));
			}
		};
		return spec;
	}
}
