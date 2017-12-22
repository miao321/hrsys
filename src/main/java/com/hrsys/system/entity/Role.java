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
@Table(name="t_role")
public class Role extends BaseEntity implements Serializable {
	private String roleId;
	private String roleName;//角色名称
	private String remark; //备注
	private Integer orderNo;//排序号	
	private String createModule;//创建模块	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getRoleId() {
		return roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getRemark() {
		return remark;
	}
	public Integer getOrderNo() {
		return orderNo;
	}	
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
}
