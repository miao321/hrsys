package com.hrsys.attendance.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 考勤模块-打卡记录表
 * @author Lofu
 */
@Entity
@Table(name = "t_clock")
public class Clock {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;			// 打卡表的id
	private String employNo;	// 职工号
	private String employName;	// 职工姓名
	private String deptName;	// 所属部门
	private String clockType;	// 打卡类型(上班、下班)
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date clockDate;		// 打卡日期
	private String clockTime;	// 打卡时间

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmployNo() {
		return employNo;
	}
	public void setEmployNo(String employNo) {
		this.employNo = employNo;
	}
	public String getEmployName() {
		return employName;
	}
	public void setEmployName(String employName) {
		this.employName = employName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getClockType() {
		return clockType;
	}
	public void setClockType(String clockType) {
		this.clockType = clockType;
	}
	public Date getClockDate() {
		return clockDate;
	}
	public void setClockDate(Date clockDate) {
		this.clockDate = clockDate;
	}
	public String getClockTime() {
		return clockTime;
	}
	public void setClockTime(String clockTime) {
		this.clockTime = clockTime;
	}
}
