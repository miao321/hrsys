package com.hrsys.employ.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsys.common.entity.BaseEntity;

/**
 * 应聘者信息实体类
 * @author Administrator
 *
 */

@Entity
@Table(name="t_employApply")
public class EmployApply extends BaseEntity implements Serializable {
	
	private Long employApplyId;		//应聘者id
	private String employApplyNo;		//应聘者编号
	private String employApplyName;		//应聘者名字

//	private EmployJob employJob;
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
	private String employApplyProfile;	//简历
	private String employApplySituation;//录用情况
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getEmployApplyId() {
		return employApplyId;
	}
	public String getEmployApplyNo() {
		return employApplyNo;
	}
	public String getEmployApplyName() {
		return employApplyName;
	}	
/*	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="employJobNo")
	public EmployJob getEmployJob() {
		return employJob;
	}
*/
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
	@JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
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
	public String getEmployApplyProfile() {
		return employApplyProfile;
	}
	public String getEmployApplySituation() {
		return employApplySituation;
	}
	public void setEmployApplyId(Long employApplyId) {
		this.employApplyId = employApplyId;
	}
	public void setEmployApplyNo(String employApplyNo) {
		this.employApplyNo = employApplyNo;
	}
	public void setEmployApplyName(String employApplyName) {
		this.employApplyName = employApplyName;
	}
	
/*	public void setEmployJob(EmployJob employJob) {
		this.employJob = employJob;
	}*/
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
	public void setEmployApplyProfile(String employApplyProfile) {
		this.employApplyProfile = employApplyProfile;
	}
	public void setEmployApplySituation(String employApplySituation) {
		this.employApplySituation = employApplySituation;
	}
	


	
}
