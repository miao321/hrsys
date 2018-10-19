package com.hrsys.employ.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsys.common.entity.BaseEntity;
/**
 * 招聘职位实体类
 * @author Administrator
 *
 */

@Entity
@Table(name="t_employJob")
public class EmployJob extends BaseEntity implements Serializable {
	
	private Long employJobId;         //招聘职位id
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
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getEmployJobId() {
		return employJobId;
	}
	public String getEmployJobNo() {
		return employJobNo;
	}
	public String getEmployJobName() {
		return employJobName;
	}
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
	public Date getEmployJobStartTime() {
		return employJobStartTime;
	}
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
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
	@JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
	public Date getEmployJobDate() {
		return employJobDate;
	}
	public Integer getEmployJobNum() {
		return employJobNum;
	}
	public String getEmployJobResponsible() {
		return employJobResponsible;
	}
	public void setEmployJobId(Long employJobId) {
		this.employJobId = employJobId;
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
	
	@Override
	public String toString() {
		return "EmployJob [employJobId=" + employJobId + ", employJobNo=" + employJobNo + ", employJobName="
				+ employJobName + ", employJobStartTime=" + employJobStartTime + ", employJobEndTime="
				+ employJobEndTime + ", employJobDescription=" + employJobDescription + ", employJobDemand="
				+ employJobDemand + ", employJobSalary=" + employJobSalary + ", employJobPlace=" + employJobPlace
				+ ", employJobDate=" + employJobDate + ", employJobNum=" + employJobNum + ", employJobResponsible="
				+ employJobResponsible + "]";
	} 
	
	
	

	
	
	

}
