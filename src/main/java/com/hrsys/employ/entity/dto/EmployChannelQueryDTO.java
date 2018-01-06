package com.hrsys.employ.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.hrsys.employ.entity.EmployChannel;




/**
 * EmployChannelQueryDTO  封装查询条件 数据传输对象
 * @author Administrator
 *
 */

//UserQueryDTO 接收查询条件
//ExtPageable 接收分页条件

public class EmployChannelQueryDTO {
	
	private String employChannelNo; 			//招聘渠道编号
	private String employChannelName;			//招聘渠道名称
	private String employChannelPhone;			//招聘渠道联系电话
	
	public String getEmployChannelNo() {
		return employChannelNo;
	}
	public String getEmployChannelName() {
		return employChannelName;
	}
	public String getEmployChannelPhone() {
		return employChannelPhone;
	}

	public void setEmployChannelNo(String employChannelNo) {
		this.employChannelNo = employChannelNo;
	}
	public void setEmployChannelName(String employChannelName) {
		this.employChannelName = employChannelName;
	}
	public void setEmployChannelPhone(String employChannelPhone) {
		this.employChannelPhone = employChannelPhone;
	}
	
	//提供static的工具方法：根据当前 QueryDTO 对象来组装动态查询条件
	public static Specification<EmployChannel> getSpecification(EmployChannelQueryDTO employChannelQueryDTO)
	{
		Specification<EmployChannel> spec = new Specification<EmployChannel>() {
			public Predicate toPredicate(Root<EmployChannel> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//1.Predicate查询条件集合
				 List<Predicate> list = new ArrayList<Predicate>(); 
				 
				//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				 if(null != employChannelQueryDTO && !StringUtils.isEmpty(employChannelQueryDTO.getEmployChannelNo())) {
					 Predicate  p1 =  cb.like(root.get("employChannelNo").as(String.class),"%"+ employChannelQueryDTO.getEmployChannelNo() + "%");
					 list.add(p1);
				 }
				 if(null != employChannelQueryDTO && !StringUtils.isEmpty(employChannelQueryDTO.getEmployChannelName())) {
					 Predicate  p2 =  cb.like(root.get("employChannelName").as(String.class),"%"+ employChannelQueryDTO.getEmployChannelName() + "%");
					 list.add(p2);
				 }
				 if(null != employChannelQueryDTO && !StringUtils.isEmpty(employChannelQueryDTO.getEmployChannelPhone())) {
					 Predicate  p3 =  cb.like(root.get("employChannelPhone").as(String.class),"%"+ employChannelQueryDTO.getEmployChannelPhone() + "%");
					 list.add(p3);
				 }
				 //3.Predicate查询条件集合的 size 创建对应的Predicate查询条件数组
				 Predicate[] p = new Predicate[list.size()];  
				 //4.CriteriaBuilder的and 函数组装 查询条件数组
				 return cb.and(list.toArray(p));  
			}
		};
		return spec;
	}

	
}
