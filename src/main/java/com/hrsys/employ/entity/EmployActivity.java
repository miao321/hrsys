package com.hrsys.employ.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsys.common.entity.BaseEntity;

/**
 * 招聘活动实体类
 * @author Administrator
 *
 */

@Entity
@Table(name="t_employActivity")
public class EmployActivity extends BaseEntity implements Serializable {
	
	private Long employActivityId;		//招聘活动id
	private String employActivityNo;		//招聘活动编号
	private String employActivityName;		//招聘活动名称
	private Date employActivityDate;		//招聘活动举办日期
	private String employActivityPlace;		//招聘活动举办地点
	private String employActivityPhone;		//招聘活动联系电话
	private String employActivityContent;	//招聘活动内容详情
	private String employActivityMark;		//备注
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getEmployActivityId() {
		return employActivityId;
	}
	
	public String getEmployActivityNo() {
		return employActivityNo;
	}

	public String getEmployActivityName() {
		return employActivityName;
	}
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	@JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
	public Date getEmployActivityDate() {
		return employActivityDate;
	}
	public String getEmployActivityPlace() {
		return employActivityPlace;
	}
	public String getEmployActivityPhone() {
		return employActivityPhone;
	}
	public String getEmployActivityContent() {
		return employActivityContent;
	}
	public String getEmployActivityMark() {
		return employActivityMark;
	}
	public void setEmployActivityId(Long employActivityId) {
		this.employActivityId = employActivityId;
	}
	public void setEmployActivityNo(String employActivityNo) {
		this.employActivityNo = employActivityNo;
	}
	public void setEmployActivityName(String employActivityName) {
		this.employActivityName = employActivityName;
	}
	public void setEmployActivityDate(Date employActivityDate) {
		this.employActivityDate = employActivityDate;
	}
	public void setEmployActivityPlace(String employActivityPlace) {
		this.employActivityPlace = employActivityPlace;
	}
	public void setEmployActivityPhone(String employActivityPhone) {
		this.employActivityPhone = employActivityPhone;
	}
	public void setEmployActivityContent(String employActivityContent) {
		this.employActivityContent = employActivityContent;
	}
	public void setEmployActivityMark(String employActivityMark) {
		this.employActivityMark = employActivityMark;
	}

	@Override
	public String toString() {
		return "EmployActivity [employActivityId=" + employActivityId + ", employActivityNo=" + employActivityNo
				+ ", employActivityName=" + employActivityName + ", employActivityDate=" + employActivityDate
				+ ", employActivityPlace=" + employActivityPlace + ", employActivityPhone=" + employActivityPhone
				+ ", employActivityContent=" + employActivityContent + ", employActivityMark=" + employActivityMark
				+ "]";
	}
	


	
}
