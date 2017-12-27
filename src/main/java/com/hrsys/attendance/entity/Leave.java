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
 * 考勤模块-请假记录表
 * @author Lofu
 */
@Entity
@Table(name = "t_leave")
public class Leave {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;			//请假表的id
	private String employNo;	//员工的id
	private String employName;	//员工的姓名
	
	@DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss", timezone = "GMT+8")
	private Date leaveBeginTime;//请假开始时间
	
	@DateTimeFormat(pattern="yyyy/MM/dd hh:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss", timezone = "GMT+8")
	private Date leaveEndTime;	//请假结束时间
	private String agreeMan;	//批准人姓名
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date applyTime;		//申请时间
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
	public Date getLeaveBeginTime() {
		return leaveBeginTime;
	}
	public void setLeaveBeginTime(Date leaveBeginTime) {
		this.leaveBeginTime = leaveBeginTime;
	}
	public Date getLeaveEndTime() {
		return leaveEndTime;
	}
	public void setLeaveEndTime(Date leaveEndTime) {
		this.leaveEndTime = leaveEndTime;
	}
	public String getAgreeMan() {
		return agreeMan;
	}
	public void setAgreeMan(String agreeMan) {
		this.agreeMan = agreeMan;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
}
