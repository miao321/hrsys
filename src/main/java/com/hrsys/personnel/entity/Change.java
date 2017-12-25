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
 * 人事模块-人事变动类
 * @author Lofu
 */
@Entity
@Table(name = "t_change")
public class Change {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;			//调动记录表的id
	private String employNo;	//员工id
	private String employName;	//员工姓名
	private String fromDeptNo;	//调动前的部门id
	private String toDeptNo;	//调动后的部门id
	private String lastLeaderNo;//调动前的领导id
	private String nowLeaderId;	//调动后的领导id
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date applyTime;		//申请时间
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date agreeTime;		//通过时间
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
	public String getFromDeptNo() {
		return fromDeptNo;
	}
	public void setFromDeptNo(String fromDeptNo) {
		this.fromDeptNo = fromDeptNo;
	}
	public String getToDeptNo() {
		return toDeptNo;
	}
	public void setToDeptNo(String toDeptNo) {
		this.toDeptNo = toDeptNo;
	}
	public String getLastLeaderNo() {
		return lastLeaderNo;
	}
	public void setLastLeaderNo(String lastLeaderNo) {
		this.lastLeaderNo = lastLeaderNo;
	}
	public String getNowLeaderId() {
		return nowLeaderId;
	}
	public void setNowLeaderId(String nowLeaderId) {
		this.nowLeaderId = nowLeaderId;
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
