package com.hrsys.wage.entity.dto;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.hrsys.wage.entity.PaLV;




public class PaLVQueryDTO {
	private String parank;    //考评等级
	private String valueup;   //成绩上限
	private String valuedown;   //成绩下限

	public String getParank() {
		return parank;
	}
	public String getValueup() {
		return valueup;
	}
	public String getValuedown() {
		return valuedown;
	}

	public void setParank(String parank) {
		this.parank = parank;
	}
	public void setValueup(String valueup) {
		this.valueup = valueup;
	}
	public void setValuedown(String valuedown) {
		this.valuedown = valuedown;
	}
	//提供static的工具方法：根据当前 paQueryDTO 对象来组装动态查询条件
		public static Specification<PaLV> getSpecification(PaLVQueryDTO paLVQueryDTO)
		{
			Specification<PaLV> spec = new Specification<PaLV>() {
				public Predicate toPredicate(Root<PaLV> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					//1.Predicate查询条件集合
					 List<Predicate> list = new ArrayList<Predicate>(); 
					 
					//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
					 if(null != paLVQueryDTO && !StringUtils.isEmpty(paLVQueryDTO.getParank())) {
						 Predicate  p3 =  cb.like(root.get("personnelName").as(String.class),"%"+ paLVQueryDTO.getParank() + "%");
						 list.add(p3);
					 }
						 
					 if(null != paLVQueryDTO && !StringUtils.isEmpty(paLVQueryDTO.getValueup())) {
						 Predicate  p3 =  cb.like(root.get("personnelName").as(String.class),"%"+ paLVQueryDTO.getValueup() + "%");
						 list.add(p3);
					 }
					 if(null != paLVQueryDTO && !StringUtils.isEmpty(paLVQueryDTO.getValuedown())) {
						 Predicate  p3 =  cb.like(root.get("personnelName").as(String.class),"%"+ paLVQueryDTO.getValuedown() + "%");
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
