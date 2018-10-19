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
 * 考勤模块-加班记录表
 * @author Lofu
 */
@Entity
@Table(name = "t_overtime")
public class Overtime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;			// 加班表的id
	private String employNo;	// 职工号
	private String employName;	// 职工姓名
	private String deptName;	// 所在部门
	private String content;		// 加班内容
	
	@DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss", timezone = "GMT+8")
	private Date otBeginTime;	// 加班开始时间
	
	@DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss", timezone = "GMT+8")
	private Date otEndTime;		// 加班结束时间
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date overtimeDate;	// 加班日期
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getOtBeginTime() {
		return otBeginTime;
	}
	public void setOtBeginTime(Date otBeginTime) {
		this.otBeginTime = otBeginTime;
	}
	public Date getOtEndTime() {
		return otEndTime;
	}
	public void setOtEndTime(Date otEndTime) {
		this.otEndTime = otEndTime;
	}
	public Date getOvertimeDate() {
		return overtimeDate;
	}
	public void setOvertimeDate(Date overtimeDate) {
		this.overtimeDate = overtimeDate;
	}
}
