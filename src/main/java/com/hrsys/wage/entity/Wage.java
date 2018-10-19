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
@Table(name="t_wage")
public class Wage  {
	private Long Id;
	private String wageId; //工资号
	private String personnelId;//员工编号
	private String personnelName;//员工姓名
	private String department;//部门
	private String position;//职位
	private Integer basicWage;//基本工资
	@DateTimeFormat(pattern="yyyy/MM")  
	private Date time;//工资时间
	private String insuranceStytle;//保险类型
	private Integer insuranceMoney;// 保险每月金额
	private String finedstytle;//罚金类型
	private Integer finedMoney;//罚金金额
	private String awardstytle;//获奖类型
	private Integer awardMoney;//奖励金额
	private Integer finalWage;//最终工资

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	public Long getId() {
		return Id;
	}
	
	
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

	public Integer getBasicWage() {
		return basicWage;
	}




	@JsonFormat(pattern = "yyyy/MM",timezone = "GMT+8")
	public Date getTime() {
		return time;
	}


	
	
	


	public String getInsuranceStytle() {
		return insuranceStytle;
	}


	public Integer getInsuranceMoney() {
		return insuranceMoney;
	}


	public String getFinedstytle() {
		return finedstytle;
	}


	public Integer getFinedMoney() {
		return finedMoney;
	}


	public String getAwardstytle() {
		return awardstytle;
	}


	public Integer getAwardMoney() {
		return awardMoney;
	}
	public Integer getFinalWage() {
		Integer a = (basicWage!=null) ? basicWage : 0;
		Integer  b = (awardMoney!=null) ? awardMoney : 0;
		Integer c = (insuranceMoney!=null) ? insuranceMoney : 0;
	Integer d = (finedMoney!=null) ? finedMoney : 0;
	 Integer sum=a+b;
	 Integer sum2=c+d;
		Integer sum3=sum-sum2;
		this.finalWage =sum3;
	
		return finalWage;
	}


	public void setId(Long id) {
		Id = id;
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

	public void setBasicWage(Integer basicWage) {
		this.basicWage = basicWage;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setInsuranceStytle(String insuranceStytle) {
		this.insuranceStytle = insuranceStytle;
	}

	public void setInsuranceMoney(Integer insuranceMoney) {
		this.insuranceMoney = insuranceMoney;
	}

	public void setFinedstytle(String finedstytle) {
		this.finedstytle = finedstytle;
	}


	public void setFinedMoney(Integer finedMoney) {
		this.finedMoney = finedMoney;
	}

	public void setAwardstytle(String awardstytle) {
		this.awardstytle = awardstytle;
	}


	public void setAwardMoney(Integer awardMoney) {
		this.awardMoney = awardMoney;
	}
	
	public void setFinalWage(Integer finalWage) {
		this.finalWage = finalWage;
	}

}
