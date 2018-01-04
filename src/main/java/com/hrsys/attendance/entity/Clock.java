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
	private Integer id;			//登记表的id
	private String employNo;	//员工的id
	private String employName;	//员工姓名
	private String deptName;	//所属部门
	private String clockType;	//打卡类型(上班、下班)
	
	@DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss", timezone = "GMT+8")
	private Date createTime;	//打卡时间

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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
