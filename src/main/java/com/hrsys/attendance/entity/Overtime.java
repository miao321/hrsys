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
	private Integer id;			//加班表的id
	private String employNo;	//员工的id
	private String employName;	//员工姓名
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date otBeginTime;	//加班开始时间
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date otEndTime;		//加班结束时间
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date createTime;	//创建时间
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
