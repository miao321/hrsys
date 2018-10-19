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
 * 考勤模块-违规记录表
 * @author Lofu
 */
@Entity
@Table(name = "t_breach")
public class Breach {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;			// 违规表的id
	private String employNo;	// 职工号
	private String employName;	// 职工姓名
	private String deptName;	// 所在部门
	private String content;		// 违规内容（迟到、早退、旷工）
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date breachDate;	// 违规日期（年/月/日）
	private String recordMan;	// 记录人姓名
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date recordDate;	// 记录日期
	
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
	public String getRecordMan() {
		return recordMan;
	}
	public void setRecordMan(String recordMan) {
		this.recordMan = recordMan;
	}
	public Date getBreachDate() {
		return breachDate;
	}
	public void setBreachDate(Date breachDate) {
		this.breachDate = breachDate;
	}
	public Date getRecordDate() {
		return recordDate;
	}
	public void setRecordDate(Date recordDate) {
		this.recordDate = recordDate;
	}
}
