package com.hrsys.employ.entity.dto;

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

import com.hrsys.employ.entity.EmployActivity;

/**
 * EmployActivityQueryDTO  封装查询条件 数据传输对象
 * @author Administrator
 *
 */

public class EmployActivityQueryDTO {
	
	private String employActivityNo;		//招聘活动编号
	private String employActivityName;		//招聘活动名称
	private Date employActivityDate;		//招聘活动举办日期
	private String employActivityPlace;		//招聘活动举办地点
	private String employActivityPhone;		//招聘活动联系电话
	public String getEmployActivityNo() {
		return employActivityNo;
	}
	public String getEmployActivityName() {
		return employActivityName;
	}
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	public Date getEmployActivityDate() {
		return employActivityDate;
	}
	public String getEmployActivityPlace() {
		return employActivityPlace;
	}
	public String getEmployActivityPhone() {
		return employActivityPhone;
	}
	public void setEmployActivityNo(String employActivityNo) {
		this.employActivityNo = employActivityNo;
	}
	public void setEmployActivityName(String employActivityName) {
		this.employActivityName = employActivityName;
	}
	public void setEmployActivityDate(Date employActivityDate) {
		this.employActivityDate = employActivityDate;
	}
	public void setEmployActivityPlace(String employActivityPlace) {
		this.employActivityPlace = employActivityPlace;
	}
	public void setEmployActivityPhone(String employActivityPhone) {
		this.employActivityPhone = employActivityPhone;
	}
	
	//提供static的工具方法：根据当前 QueryDTO 对象来组装动态查询条件
			public static Specification<EmployActivity> getSpecification(EmployActivityQueryDTO employActivityQueryDTO)
			{
				Specification<EmployActivity> spec = new Specification<EmployActivity>() {
					public Predicate toPredicate(Root<EmployActivity> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
						//1.Predicate查询条件集合
						 List<Predicate> list = new ArrayList<Predicate>(); 
						 
						//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
						 if(null != employActivityQueryDTO && !StringUtils.isEmpty(employActivityQueryDTO.getEmployActivityNo())) {
							 Predicate  p1 =  cb.like(root.get("employActivityNo").as(String.class),"%"+ employActivityQueryDTO.getEmployActivityNo() + "%");
							 list.add(p1);
						 }
						 if(null != employActivityQueryDTO && !StringUtils.isEmpty(employActivityQueryDTO.getEmployActivityName())) {
							 Predicate  p2 =  cb.like(root.get("employActivityName").as(String.class),"%"+ employActivityQueryDTO.getEmployActivityName() + "%");
							 list.add(p2);
						 }
						

						 if(null != employActivityQueryDTO && !StringUtils.isEmpty(employActivityQueryDTO.getEmployActivityPlace())) {
							 Predicate  p3 =  cb.like(root.get("employActivityPlace").as(String.class),"%"+ employActivityQueryDTO.getEmployActivityPlace() + "%");
							 list.add(p3);
						 }
						if ( null != employActivityQueryDTO && employActivityQueryDTO.getEmployActivityDate() != null) {
								Predicate p4 = cb.equal(root.get("employActivityDate").as(Date.class),
										employActivityQueryDTO.getEmployActivityDate());
								list.add(p4);
						}
						 if(null != employActivityQueryDTO && !StringUtils.isEmpty(employActivityQueryDTO.getEmployActivityPhone())) {
							 Predicate  p5 =  cb.like(root.get("employActivityPhone").as(String.class),"%"+ employActivityQueryDTO.getEmployActivityPhone() + "%");
							 list.add(p5);
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
