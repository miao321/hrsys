package com.hrsys.system.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrsys.user.entity.User;

@Entity
@Table(name = "t_permission")
public class Permission {  
    private Long id;
    //token 
    private String token;
    // 资源url 
    private String url;
    //权限说明
    private String description;
    //所属角色编号
    private Integer roleId;
    
    private List<Role> role = new ArrayList<Role>();
    private List<User> user = new ArrayList<User>();
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
    @ManyToMany(cascade=CascadeType.ALL)
    @JsonIgnore
	public List<Role> getRole() {
		return role;
	}
    @ManyToMany(cascade=CascadeType.ALL)
    @JsonIgnore
	public List<User> getUser() {
		return user;
	}
	public String getToken() {
		return token;
	}
	public String getUrl() {
		return url;
	}
	public String getDescription() {
		return description;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public void setRole(List<Role> role) {
		this.role = role;
	}
	public void setUser(List<User> user) {
		this.user = user;
	}
        
     
 }