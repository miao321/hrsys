package com.hrsys.system.entity.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class RolePermissionQueryDTO {
	private Long id;
	private String url;
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
	public RolePermissionQueryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RolePermissionQueryDTO(Long id, String url, String roleName, String remark, Integer orderNo,
			String createModule, String createBy, Date createTime, String updateBy, Date updateTime) {
		super();
		this.id = id;
		this.url = url;
		this.roleName = roleName;
		this.remark = remark;
		this.orderNo = orderNo;
		this.createModule = createModule;
		this.createBy = createBy;
		this.createTime = createTime;
		this.updateBy = updateBy;
		this.updateTime = updateTime;
	}
	public Long getId() {
		return id;
	}
	public String getUrl() {
		return url;
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
	public String getCreateModule() {
		return createModule;
	}
	public String getCreateBy() {
		return createBy;
	}
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
	public Date getCreateTime() {
		return createTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUrl(String url) {
		this.url = url;
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
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	

}
