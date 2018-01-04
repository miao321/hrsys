package com.hrsys.train.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.hrsys.train.entity.TrainExecute;



/**
 * TrainExecuteQueryDTO  封装查询条件 数据传输对象
 * @author Administrator
 *
 */
public class TrainExecuteQueryDTO {
	
	private String trainCourseNo;			//培训课程编号
	private String trainCourseName;			//培训课程名称
	
	public String getTrainCourseNo() {
		return trainCourseNo;
	}
	public String getTrainCourseName() {
		return trainCourseName;
	}
	public void setTrainCourseNo(String trainCourseNo) {
		this.trainCourseNo = trainCourseNo;
	}
	public void setTrainCourseName(String trainCourseName) {
		this.trainCourseName = trainCourseName;
	}

	//提供static的工具方法：根据当前 QueryDTO 对象来组装动态查询条件
		public static Specification<TrainExecute> getSpecification(TrainExecuteQueryDTO trainExecuteQueryDTO)
		{
			Specification<TrainExecute> spec = new Specification<TrainExecute>() {
				public Predicate toPredicate(Root<TrainExecute> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					//1.Predicate查询条件集合
					 List<Predicate> list = new ArrayList<Predicate>(); 
					 
					//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
					 if(null != trainExecuteQueryDTO && !StringUtils.isEmpty(trainExecuteQueryDTO.getTrainCourseNo())) {
						 Predicate  p =  cb.like(root.get("trainCourseNo").as(String.class),"%"+ trainExecuteQueryDTO.getTrainCourseNo() + "%");
						 list.add(p);
					 }
					 if(null != trainExecuteQueryDTO && !StringUtils.isEmpty(trainExecuteQueryDTO.getTrainCourseName())) {
						 Predicate  p =  cb.like(root.get("trainCourseName").as(String.class),"%"+ trainExecuteQueryDTO.getTrainCourseName() + "%");
						 list.add(p);
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
