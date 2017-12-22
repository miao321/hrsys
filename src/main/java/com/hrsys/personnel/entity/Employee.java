package com.hrsys.personnel.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 人事模块-职工类
 * @author Lofu
 *
 */
@Entity
@Table(name="t_employee")
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;					//职员表的id
	private String employeeNo;		//员工的id号
	private String employeeName;	//员工姓名
	private Short empSex;			//员工性别
	private String deptNo;			//所在部门
	private Integer salary;			//员工工资
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date hiredate;			//入职时间
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date birthday;			//员工生日
	private String leaderNo;		//直属领导
	private Short isMerry;			//是否结婚
	private Short isWorking;		//是否在职
	private String education;		//文化水平
	private String email;			//员工邮箱
	private String phone;			//手机号码
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmployeeNo() {
		return employeeNo;
	}
	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public Short getEmpSex() {
		return empSex;
	}
	public void setEmpSex(Short empSex) {
		this.empSex = empSex;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getLeaderNo() {
		return leaderNo;
	}
	public void setLeaderNo(String leaderNo) {
		this.leaderNo = leaderNo;
	}
	public Short getIsMerry() {
		return isMerry;
	}
	public void setIsMerry(Short isMerry) {
		this.isMerry = isMerry;
	}
	public Short getIsWorking() {
		return isWorking;
	}
	public void setIsWorking(Short isWorking) {
		this.isWorking = isWorking;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
