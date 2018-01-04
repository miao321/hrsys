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

import com.hrsys.employ.entity.EmployJob;


/**
 * EmployJobQueryDTO  封装查询条件 数据传输对象
 * @author Administrator
 *
 */
public class EmployJobQueryDTO {
	private String employJobNo;			 //招聘职位编号
	private String employJobName;		 //招聘职位名称
	private Date employJobStartTime;	 //发布时间
	private Date employJobEndTime;		 //截止时间
	private String employJobDescription; //职位描述
	private String employJobDemand;		 //职位要求
	private String employJobSalary;		 //职位待遇
	private String employJobPlace;		 //工作地点
	private Date employJobDate;			 //需要到岗时间	
	private Integer employJobNum;		 //招聘人数
	private String employJobResponsible; //招聘负责人
	

	public String getEmployJobNo() {
		return employJobNo;
	}

	public String getEmployJobName() {
		return employJobName;
	}
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	public Date getEmployJobStartTime() {
		return employJobStartTime;
	}
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	public Date getEmployJobEndTime() {
		return employJobEndTime;
	}

	public String getEmployJobDescription() {
		return employJobDescription;
	}

	public String getEmployJobDemand() {
		return employJobDemand;
	}

	public String getEmployJobSalary() {
		return employJobSalary;
	}

	public String getEmployJobPlace() {
		return employJobPlace;
	}
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	public Date getEmployJobDate() {
		return employJobDate;
	}

	public Integer getEmployJobNum() {
		return employJobNum;
	}

	public String getEmployJobResponsible() {
		return employJobResponsible;
	}

	public void setEmployJobNo(String employJobNo) {
		this.employJobNo = employJobNo;
	}

	public void setEmployJobName(String employJobName) {
		this.employJobName = employJobName;
	}

	public void setEmployJobStartTime(Date employJobStartTime) {
		this.employJobStartTime = employJobStartTime;
	}

	public void setEmployJobEndTime(Date employJobEndTime) {
		this.employJobEndTime = employJobEndTime;
	}

	public void setEmployJobDescription(String employJobDescription) {
		this.employJobDescription = employJobDescription;
	}

	public void setEmployJobDemand(String employJobDemand) {
		this.employJobDemand = employJobDemand;
	}

	public void setEmployJobSalary(String employJobSalary) {
		this.employJobSalary = employJobSalary;
	}

	public void setEmployJobPlace(String employJobPlace) {
		this.employJobPlace = employJobPlace;
	}

	public void setEmployJobDate(Date employJobDate) {
		this.employJobDate = employJobDate;
	}

	public void setEmployJobNum(Integer employJobNum) {
		this.employJobNum = employJobNum;
	}

	public void setEmployJobResponsible(String employJobResponsible) {
		this.employJobResponsible = employJobResponsible;
	}



		//提供static的工具方法：根据当前 QueryDTO 对象来组装动态查询条件
		public static Specification<EmployJob> getSpecification(EmployJobQueryDTO employJobQueryDTO)
		{
			Specification<EmployJob> spec = new Specification<EmployJob>() {
				public Predicate toPredicate(Root<EmployJob> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					//1.Predicate查询条件集合
					 List<Predicate> list = new ArrayList<Predicate>(); 
					 
					//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
					 if(null != employJobQueryDTO && !StringUtils.isEmpty(employJobQueryDTO.getEmployJobNo())) {
						 Predicate  p1 =  cb.like(root.get("employJobNo").as(String.class),"%"+ employJobQueryDTO.getEmployJobNo() + "%");
						 list.add(p1);
					 }
					 if(null != employJobQueryDTO && !StringUtils.isEmpty(employJobQueryDTO.getEmployJobName())) {
						 Predicate  p2 =  cb.like(root.get("employJobName").as(String.class),"%"+ employJobQueryDTO.getEmployJobName() + "%");
						 list.add(p2);
					 }
					 if(null != employJobQueryDTO && employJobQueryDTO.getEmployJobStartTime() != null) {
						 Predicate  p3 =  cb.greaterThanOrEqualTo(root.get("employJobStartTime").as(Date.class), employJobQueryDTO.getEmployJobStartTime());
						 list.add(p3);
					 }
					 if(null != employJobQueryDTO && employJobQueryDTO.getEmployJobEndTime() != null) {
						 Predicate  p4 =  cb.lessThanOrEqualTo(root.get("employJobEndTime").as(Date.class), employJobQueryDTO.getEmployJobEndTime());
						 list.add(p4);
					 }

					 if(null != employJobQueryDTO && !StringUtils.isEmpty(employJobQueryDTO.getEmployJobPlace())) {
						 Predicate  p5 =  cb.like(root.get("employJobPlace").as(String.class),"%"+ employJobQueryDTO.getEmployJobPlace() + "%");
						 list.add(p5);
					 }
					if ( null != employJobQueryDTO && employJobQueryDTO.getEmployJobDate() != null) {
							Predicate p6 = cb.equal(root.get("employJobDate").as(Date.class),
									employJobQueryDTO.getEmployJobDate());
							list.add(p6);
					}
					if(null != employJobQueryDTO && !StringUtils.isEmpty(employJobQueryDTO.getEmployJobResponsible())) {
						 Predicate  p7 =  cb.like(root.get("employJobResponsible").as(String.class),"%"+ employJobQueryDTO.getEmployJobResponsible() + "%");
						 list.add(p7);
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
