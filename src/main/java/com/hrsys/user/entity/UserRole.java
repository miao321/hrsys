package com.hrsys.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

import com.hrsys.system.entity.Role;

@Entity
@Table(name = "t_user_role")
public class UserRole {
   
     private Long id;
     private User user;     
     private Role role;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     public Long getId() {
 		return id;
 	 }
     @ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.EAGER)
     @JoinColumn(name = "userId")
     public User getUser() {
		return user;
     }    
     @ManyToOne(cascade = CascadeType.MERGE,fetch=FetchType.EAGER)
	 @JoinColumn(name = "roleId")
     public Role getRole() {
		return role;
     }    
     public void setId(Long id) {
		this.id = id;
	}
	public void setUser(User user) {
		this.user = user;
    }
    public void setRole(Role role) {
    	this.role = role;
    }
	     
 }
