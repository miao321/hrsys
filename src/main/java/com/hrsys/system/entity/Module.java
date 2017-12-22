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
@Table(name="t_module")
public class Module extends BaseEntity implements Serializable {
	private Long moduleId;
	private String parentId;
	private String parentName;//父节点名字
	private String moduleName;//模块名
	private Integer layerNum;//层数
	private Integer isLaey;//是否是叶子节点
	private String cpermission;//权限标识
	private Integer state;//状态 0停用  1启用
	private String belong;//从属
	private String remark;//备注
	private Integer orderNo;//排序号
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getModuleId() {
		return moduleId;
	}
	public String getParentId() {
		return parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public String getModuleName() {
		return moduleName;
	}
	public Integer getLayerNum() {
		return layerNum;
	}
	public Integer getIsLaey() {
		return isLaey;
	}
	public String getCpermission() {
		return cpermission;
	}
	public Integer getState() {
		return state;
	}
	public String getBelong() {
		return belong;
	}
	public String getRemark() {
		return remark;
	}
	public Integer getOrderNo() {
		return orderNo;
	}
	public void setModuleId(Long moduleId) {
		this.moduleId = moduleId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	public void setLayerNum(Integer layerNum) {
		this.layerNum = layerNum;
	}
	public void setIsLaey(Integer isLaey) {
		this.isLaey = isLaey;
	}
	public void setCpermission(String cpermission) {
		this.cpermission = cpermission;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public void setBelong(String belong) {
		this.belong = belong;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}
	
	

}
