package com.hrsys.wage.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsys.wage.entity.Wage;




public class WageQueryDTO  {
	private String wageId; //工资号
	private String personnelId;//员工编号
	private String personnelName;//员工姓名
	private String department;//部门
	private String position;//职位
	@DateTimeFormat(pattern="yyyy/MM")  
	private Date time;//工资时间
	private String insuranceStytle;//保险类型
	private String finedstytle;//罚金类型
	private String awardstytle;//获奖类型
	

	public String getWageId() {
		return wageId;
	}

	public String getPersonnelId() {
		return personnelId;
	}


	public String getPersonnelName() {
		return personnelName;
	}

	public String getDepartment() {
		return department;
	}


	public String getPosition() {
		return position;
	}
	
	public Date getTime() {
		return time;
	}
	public String getInsuranceStytle() {
		return insuranceStytle;
	}

	public String getFinedstytle() {
		return finedstytle;
	}

	public String getAwardstytle() {
		return awardstytle;
	}

	public void setWageId(String wageId) {
		this.wageId = wageId;
	}

	public void setPersonnelId(String personnelId) {
		this.personnelId = personnelId;
	}

	public void setPersonnelName(String personnelName) {
		this.personnelName = personnelName;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public void setTime(Date time) {
		this.time = time;
	}
	public void setInsuranceStytle(String insuranceStytle) {
		this.insuranceStytle = insuranceStytle;
	}

	public void setFinedstytle(String finedstytle) {
		this.finedstytle = finedstytle;
	}

	public void setAwardstytle(String awardstytle) {
		this.awardstytle = awardstytle;
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
					 Predicate  p2 =  cb.equal(root.get("wageId").as(String.class),wageQueryDTO.getWageId() );
					 list.add(p2);
				 }
				 if(null != wageQueryDTO && !StringUtils.isEmpty(wageQueryDTO.getPersonnelId())) {
					 Predicate  p2 =  cb.equal(root.get("personnelId").as(String.class),wageQueryDTO.getPersonnelId() );
					 list.add(p2);
				 }
				 if(null != wageQueryDTO && !StringUtils.isEmpty(wageQueryDTO.getPersonnelName())) {
					 Predicate  p3 =  cb.like(root.get("personnelName").as(String.class),"%"+ wageQueryDTO.getPersonnelName() + "%");
					 list.add(p3);
				 } 
				 if(null != wageQueryDTO && !StringUtils.isEmpty(wageQueryDTO.getDepartment())) {
					 Predicate  p3 =  cb.like(root.get("department").as(String.class),"%"+ wageQueryDTO.getDepartment() + "%");
					 list.add(p3);
				 }
				 if(null != wageQueryDTO && !StringUtils.isEmpty(wageQueryDTO.getPosition())) {
					 Predicate  p3 =  cb.like(root.get("position").as(String.class),"%"+ wageQueryDTO.getPosition() + "%");
					 list.add(p3);
				 }
				 if(null != wageQueryDTO && !StringUtils.isEmpty(wageQueryDTO.getTime())) {
					 Predicate  p2 =  cb.equal(root.get("time").as(Date.class),wageQueryDTO.getTime() );
					 list.add(p2);
				 }

				 if(null != wageQueryDTO && !StringUtils.isEmpty(wageQueryDTO.getInsuranceStytle())) {
					 Predicate  p3 =  cb.like(root.get("insuranceStytle").as(String.class),"%"+ wageQueryDTO.getInsuranceStytle() + "%");
					 list.add(p3);
				 }
				 if(null != wageQueryDTO && !StringUtils.isEmpty(wageQueryDTO.getFinedstytle())) {
					 Predicate  p4 =  cb.equal(root.get("finedstytle").as(String.class), wageQueryDTO.getFinedstytle() );
					 list.add(p4);
					 }
				 if(null != wageQueryDTO && !StringUtils.isEmpty(wageQueryDTO.getAwardstytle())) {
					 Predicate  p4 =  cb.equal(root.get("awardstytle").as(String.class), wageQueryDTO.getAwardstytle() );
					 list.add(p4);
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