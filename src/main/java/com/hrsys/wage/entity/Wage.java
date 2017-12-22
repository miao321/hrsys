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
@Table(name="t_wage")
public class Wage extends BaseEntity implements Serializable {
	private int wageId; //工资号
	private String personnelId;//员工编号
	private String personnelName;//员工姓名
	private String department;//部门
	private String position;//职位
	private String basicWage;//基本工资
	private String finalWage;//实发工资
	private Date wageTime;//工资时间
	private String insurance;//保险
	private String subsidise;//补贴
	private String awardMoney;//奖金
	private String finedMoney;//罚金
	private String overtimePay;//加班费
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getWageId() {
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
	public String getBasicWage() {
		return basicWage;
	}
	public String getFinalWage() {
		return finalWage;
	}
	public Date getWageTime() {
		return wageTime;
	}
	public String getInsurance() {
		return insurance;
	}
	public String getSubsidise() {
		return subsidise;
	}
	public String getAwardMoney() {
		return awardMoney;
	}
	public String getFinedMoney() {
		return finedMoney;
	}
	public String getOvertimePay() {
		return overtimePay;
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
	public void setDepartment(String department) {
		this.department = department;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setBasicWage(String basicWage) {
		this.basicWage = basicWage;
	}
	public void setFinalWage(String finalWage) {
		this.finalWage = finalWage;
	}
	public void setWageTime(Date wageTime) {
		this.wageTime = wageTime;
	}
	public void setInsurance(String insurance) {
		this.insurance = insurance;
	}
	public void setSubsidise(String subsidise) {
		this.subsidise = subsidise;
	}
	public void setAwardMoney(String awardMoney) {
		this.awardMoney = awardMoney;
	}
	public void setFinedMoney(String finedMoney) {
		this.finedMoney = finedMoney;
	}
	public void setOvertimePay(String overtimePay) {
		this.overtimePay = overtimePay;
	}

	
	
}
