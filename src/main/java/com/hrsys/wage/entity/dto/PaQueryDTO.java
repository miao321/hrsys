package com.hrsys.wage.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.hrsys.wage.entity.Pa;


public class PaQueryDTO {
	private int paId;    //考评号
	private String personnelId;   //员工编号
	private String personnelName;   //员工名字
	private String evaluaterId;   //考评人编号
	private String evaluaterName;  //考评人姓名
	
	
	public int getPaId() {
		return paId;
	}


	public String getPersonnelId() {
		return personnelId;
	}


	public String getPersonnelName() {
		return personnelName;
	}


	public String getEvaluaterId() {
		return evaluaterId;
	}


	public String getEvaluaterName() {
		return evaluaterName;
	}
	


	public void setPaId(int paId) {
		this.paId = paId;
	}


	public void setPersonnelId(String personnelId) {
		this.personnelId = personnelId;
	}


	public void setPersonnelName(String personnelName) {
		this.personnelName = personnelName;
	}


	public void setEvaluaterId(String evaluaterId) {
		this.evaluaterId = evaluaterId;
	}


	public void setEvaluaterName(String evaluaterName) {
		this.evaluaterName = evaluaterName;
	}


	//提供static的工具方法：根据当前 paQueryDTO 对象来组装动态查询条件
	public static Specification<Pa> getSpecification(PaQueryDTO paQueryDTO)
	{
		Specification<Pa> spec = new Specification<Pa>() {
			public Predicate toPredicate(Root<Pa> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//1.Predicate查询条件集合
				 List<Predicate> list = new ArrayList<Predicate>(); 
				 
				//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				 if(null != paQueryDTO && !StringUtils.isEmpty(paQueryDTO.getPaId())) {
					 Predicate  p1 =  cb.like(root.get("paId").as(String.class),"%"+ paQueryDTO.getPaId() + "%");
					 list.add(p1);
				 }
				 if(null != paQueryDTO && !StringUtils.isEmpty(paQueryDTO.getPersonnelId())) {
					 Predicate  p2 =  cb.like(root.get("personnelId").as(String.class),"%"+ paQueryDTO.getPersonnelId() + "%");
					 list.add(p2);
				 }
				 if(null != paQueryDTO && !StringUtils.isEmpty(paQueryDTO.getPersonnelName())) {
					 Predicate  p3 =  cb.like(root.get("personnelName").as(String.class),"%"+ paQueryDTO.getPersonnelName() + "%");
					 list.add(p3);
				 }
				 if(null != paQueryDTO && !StringUtils.isEmpty(paQueryDTO.getEvaluaterId())) {
					 Predicate  p4 =  cb.like(root.get("evaluaterId").as(String.class),"%"+ paQueryDTO.getEvaluaterId() + "%");
					 list.add(p4);
				 }
				 if(null != paQueryDTO && !StringUtils.isEmpty(paQueryDTO.getEvaluaterName())) {
					 Predicate  p5 =  cb.like(root.get("evaluaterName").as(String.class),"%"+ paQueryDTO.getEvaluaterName() + "%");
					 list.add(p5);
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
