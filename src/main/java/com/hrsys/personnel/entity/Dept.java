package com.hrsys.personnel.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 人事模块-部门实体类
 * @author Lofu
 */
@Entity
@Table(name = "t_dept")
public class Dept {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;			//部门表的id
	private String deptNo;		//部门的id
	private String deptName;	//部门名称
	private String location;	//部门所在地
	private String leader;		//该部门领导
	private String deptPhone;	//部门联系电话
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLeader() {
		return leader;
	}
	public void setLeader(String leader) {
		this.leader = leader;
	}
	public String getDeptPhone() {
		return deptPhone;
	}
	public void setDeptPhone(String deptPhone) {
		this.deptPhone = deptPhone;
	}

}
