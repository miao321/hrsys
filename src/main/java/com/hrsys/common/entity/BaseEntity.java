package com.hrsys.common.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

public class BaseEntity implements Serializable{
	private String createBy;//创建人
	private	Date createTime;//创建时间
	private String updateBy;//修改人
	private Date updateTime;//修改时间
	public String getCreateBy() {
		return createBy;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public Date getUpdateTime() {
		return updateTime;
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
