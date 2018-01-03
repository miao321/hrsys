package com.hrsys.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.hrsys.system.entity.Role;

@Entity
@Table(name = "t_user_role")
public class UserRole {
   
     private Long id;
    /* private Long roleId;
     private Long userId;*/
     private User user;     
     private Role role;
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     public Long getId() {
 		return id;
 	 }
     @ManyToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "userId")
     public User getUser() {
		return user;
     }
    
	 @ManyToOne(cascade = CascadeType.ALL)
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
