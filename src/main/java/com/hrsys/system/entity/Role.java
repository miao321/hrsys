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
	private Long id;
	private String roleName;//角色名称
	private String remark; //备注
	private Integer orderNo;//排序号	
	private String createModule;//创建模块	
	private String createBy;//创建人
	private	Date createTime;//创建时间
	private String updateBy;//修改人
	private Date updateTime;//修改时间
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
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
	public Date getCreateTime() {
		return createTime;
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
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
