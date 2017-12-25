package com.hrsys.wage.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.hrsys.wage.entity.Wage;



public class WageQueryDTO  {
	private int wageId; //工资号
	private String personnelId;//员工编号
	private String personnelName;//员工姓名
	
	

	public int getWageId() {
		return wageId;
	}



	public String getPersonnelId() {
		return personnelId;
	}



	public String getPersonnelName() {
		return personnelName;
	}
	



	public void setWageId(int wageId) {
		this.wageId = wageId;
	}



	public void setPersonnelId(String personnelId) {
		this.personnelId = personnelId;
	}



	public void setPersonnelName(String personnelName) {
		this.personnelName = personnelName;
	}



	//提供static的工具方法：根据当前 wageQueryDTO 对象来组装动态查询条件
	public static Specification<Wage> getSpecification(WageQueryDTO wageQueryDTO)
	{
		Specification<Wage> spec = new Specification<Wage>() {
			public Predicate toPredicate(Root<Wage> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//1.Predicate查询条件集合
				 List<Predicate> list = new ArrayList<Predicate>(); 
				 
				//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				 if(null != wageQueryDTO && !StringUtils.isEmpty(wageQueryDTO.getWageId())) {
					 Predicate  p1 =  cb.like(root.get("wageId").as(String.class),"%"+ wageQueryDTO.getWageId() + "%");
					 list.add(p1);
				 }
				 if(null != wageQueryDTO && !StringUtils.isEmpty(wageQueryDTO.getPersonnelId())) {
					 Predicate  p2 =  cb.like(root.get("personnelId").as(String.class),"%"+ wageQueryDTO.getPersonnelId() + "%");
					 list.add(p2);
				 }
				 if(null != wageQueryDTO && !StringUtils.isEmpty(wageQueryDTO.getPersonnelName())) {
					 Predicate  p3 =  cb.like(root.get("personnelName").as(String.class),"%"+ wageQueryDTO.getPersonnelName() + "%");
					 list.add(p3);
				 }
				
				 //3.Predicate查询条件集合的 size 创建对应的Predicate查询条件数组
				 Predicate[] p = new Predicate[list.size()];  
				 //4.CriteriaBuilder的and 函数组装 查询条件数组
				 return cb.and(list.toArray(p));  
			}
		};
		return spec;
	}
	
}