package com.hrsys.system.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.hrsys.system.entity.Permission;


public class PermissionQueryDTO {
	private Long id;
	private Long permission_id;
	private Long role_id;
	private String roleName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(Long permission_id) {
		this.permission_id = permission_id;
	}
	public Long getRole_id() {
		return role_id;
	}
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	//提供static的工具方法： 根据当前userQueryDTO对象来组装动态查询条件
	public static Specification<Permission> getSpecification(PermissionQueryDTO permissionQueryDTO){
		Specification<Permission> spec = new Specification<Permission>() {
			public Predicate toPredicate(Root<Permission> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();
				
				/*//2.根据QueryDTO数据字段的值进行判断以及条件的组装
				if(userQueryDTO != null && !StringUtils.isEmpty(userQueryDTO.getUserName())) {
					Predicate p1 = cb.like(root.get("userName").as(String.class),"%"+userQueryDTO.getUserName()+"%");
					list.add(p1);
				}
				if(userQueryDTO != null && !StringUtils.isEmpty(userQueryDTO.getPassword())) {
					Predicate p2 = cb.like(root.get("password").as(String.class),"%"+userQueryDTO.getPassword()+"%");
					list.add(p2);
				}*/
				//3.Predicate查询条件集合的size创建对应的Predicate查询条件数组
				Predicate[] p = new Predicate[list.size()];
				//4.CirteriaBuilder的and函数组装  查询条件数组
				return cb.and(list.toArray(p));				
			}
		};		
		return spec;
	}
}
