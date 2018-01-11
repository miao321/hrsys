package com.hrsys.system.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrsys.common.entity.BaseEntity;
import com.hrsys.user.entity.User;
import com.hrsys.user.entity.UserRole;
@Entity
@Table(name="t_role")
public class Role extends BaseEntity implements Serializable {
	private Long id;
	private String roleName;//角色名称
	private String remark; //备注
	private Integer orderNo;//排序号	
	private String createModule;//创建模块	
	private String createBy;//创建人
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private	Date createTime;//创建时间
	private String updateBy;//修改人
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date updateTime;//修改时间
	
	
	private List<UserRole> userRoles = new ArrayList<UserRole>();
	private List<Permission> permission = new ArrayList<Permission>(); 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="role")
	@JsonIgnore
	public List<UserRole> getUserRoles() {
		return userRoles;
	}
	@ManyToMany(cascade={CascadeType.MERGE,CascadeType.PERSIST},  
			   mappedBy = "role", targetEntity = Permission.class) 
	@JsonIgnore
	public List<Permission> getPermission() {
		return permission;
	}
	/*public Set<Permission> getPermission() {
		return permission;
	}*/
	public String getRoleName() {
		return roleName;
	}
	
	
	public String getCreateModule() {
		return createModule;
	}
	public String getRemark() {
		return remark;
	}
	public Integer getOrderNo() {
		return orderNo;
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
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	public void setCreateModule(String createModule) {
		this.createModule = createModule;
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
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public void setPermission(List<Permission> permission) {
		this.permission = permission;
	}
	

}
