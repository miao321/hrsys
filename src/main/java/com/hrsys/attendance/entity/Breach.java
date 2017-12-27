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
	private Integer id;			//违规表的id
	private String employNo;	//员工的id
	private String employName;	//员工的姓名
	private String content;		//违规内容（迟到、早退、旷工）
	private String recordMan;	//记录人姓名
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date breachTime;	//违规时间（年/月/日）
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date createTime;	//记录时间
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
	public Date getBreachTime() {
		return breachTime;
	}
	public void setBreachTime(Date breachTime) {
		this.breachTime = breachTime;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
