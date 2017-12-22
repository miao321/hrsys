package com.hrsys.wage.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hrsys.common.entity.BaseEntity;

@Entity
@Table(name="t_pa")
public class Pa extends BaseEntity implements Serializable { 
	private int paId;    //考评号
	private String personnelId;   //员工编号
	private String personnelName;   //员工名字
	private String department;   //部门
	private String position;  //职位
	private Date patime;    //考评时间
	private String pastytle;  //考评类型
	private String pavalues;  //分值
	private String paassessment;  //考评评价
	private String evaluaterId;   //考评编号
	private String evaluaterName;  //考评姓名
	private String evaluaterPosition;//考评职位
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getPaId() {
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
	public void setPaId(int paId) {
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

	
}
