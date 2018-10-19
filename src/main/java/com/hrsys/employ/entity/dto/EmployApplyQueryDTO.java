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

import com.hrsys.employ.entity.EmployApply;



/**
 * EmployApplyQueryDTO  封装查询条件 数据传输对象
 * @author Administrator
 *
 */
public class EmployApplyQueryDTO {
	
	private String employApplyNo;		//应聘者编号
	private String employApplyName;		//应聘者名字
	private String employJobNo;			//招聘职位编号
	private String employJobName;		//招聘职位名称
	private String employApplySex;		//性别
	private String employApplyPlace;	//籍贯
	private Date employApplyBirth;		//出生日期
	private String employApplySchool;	//毕业院校
	private String employApplyMajor;	//专业
	private String employApplyEducation;//学历
	private String employApplyPhone;	//联系电话
	private String employApplyEmail;	//电子邮箱
	private String employApplySituation;//录用情况
	
	public String getEmployApplyNo() {
		return employApplyNo;
	}
	public String getEmployApplyName() {
		return employApplyName;
	}
	public String getEmployJobNo() {
		return employJobNo;
	}
	public String getEmployJobName() {
		return employJobName;
	}
	public String getEmployApplySex() {
		return employApplySex;
	}
	public String getEmployApplyPlace() {
		return employApplyPlace;
	}
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	public Date getEmployApplyBirth() {
		return employApplyBirth;
	}
	public String getEmployApplySchool() {
		return employApplySchool;
	}
	public String getEmployApplyMajor() {
		return employApplyMajor;
	}
	public String getEmployApplyEducation() {
		return employApplyEducation;
	}
	public String getEmployApplyPhone() {
		return employApplyPhone;
	}
	public String getEmployApplyEmail() {
		return employApplyEmail;
	}
	public String getEmployApplySituation() {
		return employApplySituation;
	}
	public void setEmployApplyNo(String employApplyNo) {
		this.employApplyNo = employApplyNo;
	}
	public void setEmployApplyName(String employApplyName) {
		this.employApplyName = employApplyName;
	}
	public void setEmployJobNo(String employJobNo) {
		this.employJobNo = employJobNo;
	}
	public void setEmployJobName(String employJobName) {
		this.employJobName = employJobName;
	}
	public void setEmployApplySex(String employApplySex) {
		this.employApplySex = employApplySex;
	}
	public void setEmployApplyPlace(String employApplyPlace) {
		this.employApplyPlace = employApplyPlace;
	}
	public void setEmployApplyBirth(Date employApplyBirth) {
		this.employApplyBirth = employApplyBirth;
	}
	public void setEmployApplySchool(String employApplySchool) {
		this.employApplySchool = employApplySchool;
	}
	public void setEmployApplyMajor(String employApplyMajor) {
		this.employApplyMajor = employApplyMajor;
	}
	public void setEmployApplyEducation(String employApplyEducation) {
		this.employApplyEducation = employApplyEducation;
	}
	public void setEmployApplyPhone(String employApplyPhone) {
		this.employApplyPhone = employApplyPhone;
	}
	public void setEmployApplyEmail(String employApplyEmail) {
		this.employApplyEmail = employApplyEmail;
	}
	public void setEmployApplySituation(String employApplySituation) {
		this.employApplySituation = employApplySituation;
	}
	
	//提供static的工具方法：根据当前 QueryDTO 对象来组装动态查询条件
	public static Specification<EmployApply> getSpecification(EmployApplyQueryDTO employApplyQueryDTO)
	{
		Specification<EmployApply> spec = new Specification<EmployApply>() {
			public Predicate toPredicate(Root<EmployApply> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//1.Predicate查询条件集合
				 List<Predicate> list = new ArrayList<Predicate>(); 
				 
				//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				 if(null != employApplyQueryDTO && !StringUtils.isEmpty(employApplyQueryDTO.getEmployApplyNo())) {
					 Predicate  p =  cb.like(root.get("employApplyNo").as(String.class),"%"+ employApplyQueryDTO.getEmployApplyNo() + "%");
					 list.add(p);
				 }
				 if(null != employApplyQueryDTO && !StringUtils.isEmpty(employApplyQueryDTO.getEmployApplyName())) {
					 Predicate  p =  cb.like(root.get("employApplyName").as(String.class),"%"+ employApplyQueryDTO.getEmployApplyName() + "%");
					 list.add(p);
				 }
				 if(null != employApplyQueryDTO && !StringUtils.isEmpty(employApplyQueryDTO.getEmployJobNo())) {
					 Predicate  p =  cb.like(root.get("employJobNo").as(String.class),"%"+ employApplyQueryDTO.getEmployJobNo() + "%");
					 list.add(p);
				 }
				 if(null != employApplyQueryDTO && !StringUtils.isEmpty(employApplyQueryDTO.getEmployJobName())) {
					 Predicate  p =  cb.like(root.get("employJobName").as(String.class),"%"+ employApplyQueryDTO.getEmployJobName() + "%");
					 list.add(p);
				 }
				 if(null != employApplyQueryDTO && !StringUtils.isEmpty(employApplyQueryDTO.getEmployApplySex())) {
					 Predicate  p =  cb.like(root.get("employApplySex").as(String.class),"%"+ employApplyQueryDTO.getEmployApplySex() + "%");
					 list.add(p);
				 }

				 if(null != employApplyQueryDTO && !StringUtils.isEmpty(employApplyQueryDTO.getEmployApplyPlace())) {
					 Predicate  p =  cb.like(root.get("employApplyPlace").as(String.class),"%"+ employApplyQueryDTO.getEmployApplyPlace() + "%");
					 list.add(p);
				 }
				if ( null != employApplyQueryDTO && employApplyQueryDTO.getEmployApplyBirth() != null) {
						Predicate p = cb.equal(root.get("employApplyBirth").as(Date.class),
								employApplyQueryDTO.getEmployApplyBirth());
						list.add(p);
				}
				if(null != employApplyQueryDTO && !StringUtils.isEmpty(employApplyQueryDTO.getEmployApplySchool())) {
					 Predicate  p =  cb.like(root.get("employApplySchool").as(String.class),"%"+ employApplyQueryDTO.getEmployApplySchool() + "%");
					 list.add(p);
				 }
				if(null != employApplyQueryDTO && !StringUtils.isEmpty(employApplyQueryDTO.getEmployApplyMajor())) {
					 Predicate  p =  cb.like(root.get("employApplyMajor").as(String.class),"%"+ employApplyQueryDTO.getEmployApplyMajor() + "%");
					 list.add(p);
				 }
				if(null != employApplyQueryDTO && !StringUtils.isEmpty(employApplyQueryDTO.getEmployApplyEducation())) {
					 Predicate  p =  cb.equal(root.get("employApplyEducation").as(String.class),employApplyQueryDTO.getEmployApplyEducation());
					 list.add(p);
				 }
				if(null != employApplyQueryDTO && !StringUtils.isEmpty(employApplyQueryDTO.getEmployApplyPhone())) {
					 Predicate  p =  cb.like(root.get("employApplyPhone").as(String.class),"%"+ employApplyQueryDTO.getEmployApplyPhone() + "%");
					 list.add(p);
				 }
				if(null != employApplyQueryDTO && !StringUtils.isEmpty(employApplyQueryDTO.getEmployApplyEmail())) {
					 Predicate  p =  cb.like(root.get("employApplyEmail").as(String.class),"%"+ employApplyQueryDTO.getEmployApplyEmail() + "%");
					 list.add(p);
				 }
				if(null != employApplyQueryDTO && !StringUtils.isEmpty(employApplyQueryDTO.getEmployApplySituation())) {
					 Predicate  p =  cb.equal(root.get("employApplySituation").as(String.class),employApplyQueryDTO.getEmployApplySituation());
					 list.add(p);
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
