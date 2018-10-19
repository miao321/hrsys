package com.hrsys.wage.entity;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
@Table(name="t_pa")
public class Pa  { 
	private Long Id;
	private String paId;    //考评号
	private String personnelId;   //员工编号
	private String personnelName;   //员工名字
	private String department;   //部门
	private String position;  //职位
	@DateTimeFormat(pattern="yyyy/MM")  
	private Date patime;    //考评时间
	private String pastytle;  //考评类型
	private String pavalues;  //分值
	private String paassessment;  //考评评价
	private String evaluaterId;   //考评人编号
	private String evaluaterName;  //考评人姓名
	private String evaluaterPosition;//考评人职位
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return Id;
	}
	public String getPaId() {
		return paId;
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
	@JsonFormat(pattern = "yyyy/MM",timezone = "GMT+8")
	public Date getPatime() {
		return patime;
	}
	public String getPastytle() {
		return pastytle;
	}
	public String getPavalues() {
		return pavalues;
	}
	public String getPaassessment() {
		return paassessment;
	}
	public String getEvaluaterId() {
		return evaluaterId;
	}
	public String getEvaluaterName() {
		return evaluaterName;
	}
	public String getEvaluaterPosition() {
		return evaluaterPosition;
	}
	
	public void setId(Long id) {
		Id = id;
	}
	public void setPaId(String paId) {
		this.paId = paId;
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
	public void setPatime(Date patime) {
		this.patime = patime;
	}
	public void setPastytle(String pastytle) {
		this.pastytle = pastytle;
	}
	public void setPavalues(String pavalues) {
		this.pavalues = pavalues;
	}
	public void setPaassessment(String paassessment) {
		this.paassessment = paassessment;
	}
	public void setEvaluaterId(String evaluaterId) {
		this.evaluaterId = evaluaterId;
	}
	public void setEvaluaterName(String evaluaterName) {
		this.evaluaterName = evaluaterName;
	}
	public void setEvaluaterPosition(String evaluaterPosition) {
		this.evaluaterPosition = evaluaterPosition;
	}
	@Override
	public String toString() {
		return "Pa [Id=" + Id + ", paId=" + paId + ", personnelId=" + personnelId + ", personnelName=" + personnelName
				+ ", department=" + department + ", position=" + position + ", patime=" + patime + ", pastytle="
				+ pastytle + ", pavalues=" + pavalues + ", paassessment=" + paassessment + ", evaluaterId="
				+ evaluaterId + ", evaluaterName=" + evaluaterName + ", evaluaterPosition=" + evaluaterPosition + "]";
	}

	
}
