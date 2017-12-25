package com.hrsys.user.entity.dto;
/**
 * Query DTO 封装查询条件  数据传输对象
 * @author Administrator
 *
 */

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.hrsys.user.entity.User;

public class UserQueryDTO {
	
	private String userName;
	private String password;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//提供static的工具方法： 根据当前userQueryDTO对象来组装动态查询条件
	public static Specification<User> getSpecification(UserQueryDTO userQueryDTO){
		Specification<User> spec = new Specification<User>() {
			public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();
				
				//2.根据QueryDTO数据字段的值进行判断以及条件的组装
				if(userQueryDTO != null && !StringUtils.isEmpty(userQueryDTO.getUserName())) {
					Predicate p1 = cb.like(root.get("userName").as(String.class),"%"+userQueryDTO.getUserName()+"%");
					list.add(p1);
				}
				if(userQueryDTO != null && !StringUtils.isEmpty(userQueryDTO.getPassword())) {
					Predicate p2 = cb.like(root.get("password").as(String.class),"%"+userQueryDTO.getPassword()+"%");
					list.add(p2);
				}
				//3.Predicate查询条件集合的size创建对应的Predicate查询条件数组
				Predicate[] p = new Predicate[list.size()];
				//4.CirteriaBuilder的and函数组装  查询条件数组
				return cb.and(list.toArray(p));				
			}
		};		
		return spec;
	}

}
