package com.hrsys.system.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsys.common.entity.BaseEntity;
import com.hrsys.user.entity.User;
@Entity
@Table(name="t_dept")
public class Dept extends BaseEntity implements Serializable {
	private Long id;
	private Integer deptId;//部门编号
	private String deptName;//部门名字
	private Integer deptPhone;//部门联系电话
	private String deptEmail;//部门传真号
	private String deptGrade;//部门级别
	private String deptOlder;//部门负责人
	private String deptSign;//部门标记
	private String remark;//备注
	private String createBy;//创建人
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private	Date createTime;//创建时间
	private String updateBy;//修改人
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date updateTime;//修改时间
	
	private Dept parentName;//父部门
	private List<Dept> childDept = new ArrayList<Dept>();
	private List<User> userList = new ArrayList<User>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	public Dept getParentName() {
		return parentName;
	}
	@OneToMany(cascade=CascadeType.ALL,mappedBy="parentName",fetch=FetchType.EAGER)
	public List<Dept> getChildDept() {
		return childDept;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="dept")
	public List<User> getUserList() {
		return userList;
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
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setId(Long id) {
		this.id = id;
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
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	public void setParentName(Dept parentName) {
		this.parentName = parentName;
	}
	
	public void setChildDept(List<Dept> childDept) {
		this.childDept = childDept;
	}
	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	

}
