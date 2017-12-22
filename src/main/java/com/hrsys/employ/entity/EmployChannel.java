package com.hrsys.employ.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hrsys.common.entity.BaseEntity;

/**
 * 招聘渠道实体类
 * @author Administrator
 *
 */

@Entity
@Table(name="t_employChannel")
public class EmployChannel extends BaseEntity implements Serializable {
	
	private Integer employChannelId; 			//招聘渠道id
	private String employChannelName;			//招聘渠道名称
	private String employChannelPhone;			//招聘渠道联系电话
	private String employChannelDescription;	//招聘渠道简介
	private String employChannelMark;           //备注
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getEmployChannelId() {
		return employChannelId;
	}
	public String getEmployChannelName() {
		return employChannelName;
	}
	public String getEmployChannelPhone() {
		return employChannelPhone;
	}
	public String getEmployChannelDescription() {
		return employChannelDescription;
	}
	public String getEmployChannelMark() {
		return employChannelMark;
	}
	public void setEmployChannelId(Integer employChannelId) {
		this.employChannelId = employChannelId;
	}
	public void setEmployChannelName(String employChannelName) {
		this.employChannelName = employChannelName;
	}
	public void setEmployChannelPhone(String employChannelPhone) {
		this.employChannelPhone = employChannelPhone;
	}
	public void setEmployChannelDescription(String employChannelDescription) {
		this.employChannelDescription = employChannelDescription;
	}
	public void setEmployChannelMark(String employChannelMark) {
		this.employChannelMark = employChannelMark;
	}
	
	@Override
	public String toString() {
		return "EmployChannel [employChannelId=" + employChannelId + ", employChannelName=" + employChannelName
				+ ", employChannelPhone=" + employChannelPhone + ", employChannelDescription="
				+ employChannelDescription + ", employChannelMark=" + employChannelMark + "]";
	}
	
	

	
}
