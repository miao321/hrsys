package com.hrsys.system.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrsys.user.entity.User;
@Entity
@Table(name="t_log")
public class Log implements Serializable {
	private Long id;
	private String userName;
	private String method; //操作内容
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date operationTime;  //操作时间
	private String module;  //操作模块
	
	//private User user;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	/*@ManyToOne(cascade=CascadeType.ALL)
	@JsonIgnore
	public User getUser() {
		return user;
	}*/
	public String getUserName() {
		return userName;
	}
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
	public Date getOperationTime() {
		return operationTime;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public void setOperationTime(Date operationTime) {
		this.operationTime = operationTime;
	}
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	/*public void setUser(User user) {
		this.user = user;
	}*/

}
