package com.hrsys.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hrsys.common.entity.BaseEntity;
@Entity
@Table(name="t_organization")
public class Organization extends BaseEntity implements Serializable {
	private String organizationId;
	private Integer deptId;//部门编号
	private String deptName;//部门名字
	private Integer deptPhone;//部门联系电话
	private String deptEmail;//部门传真号
	private String deptGrade;//部门级别
	private String deptOlder;//部门负责人
	private String deptSign;//部门标记
	private String remark;//备注
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getOrganizationId() {
		return organizationId;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public String getDeptName() {
		return deptName;
	}
	public Integer getDeptPhone() {
		return deptPhone;
	}
	public String getDeptEmail() {
		return deptEmail;
	}
	public String getDeptGrade() {
		return deptGrade;
	}
	public String getDeptOlder() {
		return deptOlder;
	}
	
	public String getDeptSign() {
		return deptSign;
	}
	public String getRemark() {
		return remark;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public void setDeptPhone(Integer deptPhone) {
		this.deptPhone = deptPhone;
	}
	public void setDeptEmail(String deptEmail) {
		this.deptEmail = deptEmail;
	}
	public void setDeptGrade(String deptGrade) {
		this.deptGrade = deptGrade;
	}
	public void setDeptOlder(String deptOlder) {
		this.deptOlder = deptOlder;
	}	
	public void setDeptSign(String deptSign) {
		this.deptSign = deptSign;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	

}
