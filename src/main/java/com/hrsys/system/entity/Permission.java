package com.hrsys.system.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
    @ManyToMany(cascade = { CascadeType.PERSIST },targetEntity = Role.class,  fetch = FetchType.EAGER)  
    @JoinTable(name = "t_permission_t_role", joinColumns = { @JoinColumn(name = "permission_id", updatable = true) }, inverseJoinColumns = { @JoinColumn(name = "role_id", updatable = true) })  
    @Cascade(value = { org.hibernate.annotations.CascadeType.SAVE_UPDATE })  
    @JsonIgnore
    public List<Role> getRole() {
		return role;
	}
   /* public Set<Role> getRole() {
		return role;
	}*/
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
	/*public void setRole(Set<Role> role) {
		this.role = role;
	}  */
	public void setRole(List<Role> role) {
		this.role = role;
	}
     
 }