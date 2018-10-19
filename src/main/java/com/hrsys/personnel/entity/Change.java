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
 * 人事模块-人事变动表
 * @author Lofu
 */
@Entity
@Table(name = "t_change")
public class Change {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;			// 变动表ID
	private String employNo;	// 职工号
	private String employName;	// 职工姓名
	private String fromDeptName;// 变动前部门
	private String toDeptName;	// 变动后部门
	private String lastPosition;// 变动前职位
	private String nowPosition;	// 变动后职位
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date applyTime;		// 申请日期
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date agreeTime;		// 通过日期

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
	public String getFromDeptName() {
		return fromDeptName;
	}
	public void setFromDeptName(String fromDeptName) {
		this.fromDeptName = fromDeptName;
	}
	public String getToDeptName() {
		return toDeptName;
	}
	public void setToDeptName(String toDeptName) {
		this.toDeptName = toDeptName;
	}
	public String getLastPosition() {
		return lastPosition;
	}
	public void setLastPosition(String lastPosition) {
		this.lastPosition = lastPosition;
	}
	public String getNowPosition() {
		return nowPosition;
	}
	public void setNowPosition(String nowPosition) {
		this.nowPosition = nowPosition;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	public Date getAgreeTime() {
		return agreeTime;
	}
	public void setAgreeTime(Date agreeTime) {
		this.agreeTime = agreeTime;
	}
}
