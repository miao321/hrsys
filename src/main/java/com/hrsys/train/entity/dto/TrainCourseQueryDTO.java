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

import com.hrsys.employ.entity.EmployApply;
import com.hrsys.employ.entity.dto.EmployApplyQueryDTO;
import com.hrsys.train.entity.TrainCourse;

/**
 * TrainCourseQueryDTO  封装查询条件 数据传输对象
 * @author Administrator
 *
 */
public class TrainCourseQueryDTO {
	private String trainCourseNo;			//培训课程编号
	private String trainCourseName;			//培训课程名称
	private String trainCourseLanguage;		//培训语言
	private String trainCourseMethod;		//培训方式
	private String trainCourseObject;		//培训对象
	private String trainCourseTutor;		//培训讲师
	
	public String getTrainCourseNo() {
		return trainCourseNo;
	}
	public String getTrainCourseName() {
		return trainCourseName;
	}
	public String getTrainCourseLanguage() {
		return trainCourseLanguage;
	}
	public String getTrainCourseMethod() {
		return trainCourseMethod;
	}
	public String getTrainCourseObject() {
		return trainCourseObject;
	}
	public String getTrainCourseTutor() {
		return trainCourseTutor;
	}
	public void setTrainCourseNo(String trainCourseNo) {
		this.trainCourseNo = trainCourseNo;
	}
	public void setTrainCourseName(String trainCourseName) {
		this.trainCourseName = trainCourseName;
	}
	public void setTrainCourseLanguage(String trainCourseLanguage) {
		this.trainCourseLanguage = trainCourseLanguage;
	}
	public void setTrainCourseMethod(String trainCourseMethod) {
		this.trainCourseMethod = trainCourseMethod;
	}
	public void setTrainCourseObject(String trainCourseObject) {
		this.trainCourseObject = trainCourseObject;
	}
	public void setTrainCourseTutor(String trainCourseTutor) {
		this.trainCourseTutor = trainCourseTutor;
	}
	
	//提供static的工具方法：根据当前 QueryDTO 对象来组装动态查询条件
	public static Specification<TrainCourse> getSpecification(TrainCourseQueryDTO trainCourseQueryDTO)
	{
		Specification<TrainCourse> spec = new Specification<TrainCourse>() {
			public Predicate toPredicate(Root<TrainCourse> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//1.Predicate查询条件集合
				 List<Predicate> list = new ArrayList<Predicate>(); 
				 
				//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				 if(null != trainCourseQueryDTO && !StringUtils.isEmpty(trainCourseQueryDTO.getTrainCourseNo())) {
					 Predicate  p =  cb.like(root.get("trainCourseNo").as(String.class),"%"+ trainCourseQueryDTO.getTrainCourseNo() + "%");
					 list.add(p);
				 }
				 if(null != trainCourseQueryDTO && !StringUtils.isEmpty(trainCourseQueryDTO.getTrainCourseName())) {
					 Predicate  p =  cb.like(root.get("trainCourseName").as(String.class),"%"+ trainCourseQueryDTO.getTrainCourseName() + "%");
					 list.add(p);
				 }
				 if(null != trainCourseQueryDTO && !StringUtils.isEmpty(trainCourseQueryDTO.getTrainCourseLanguage())) {
					 Predicate  p =  cb.like(root.get("trainCourseLanguage").as(String.class),"%"+ trainCourseQueryDTO.getTrainCourseLanguage() + "%");
					 list.add(p);
				 }
				 if(null != trainCourseQueryDTO && !StringUtils.isEmpty(trainCourseQueryDTO.getTrainCourseMethod())) {
					 Predicate  p =  cb.like(root.get("trainCourseMethod").as(String.class),"%"+ trainCourseQueryDTO.getTrainCourseMethod() + "%");
					 list.add(p);
				 }

				if(null != trainCourseQueryDTO && !StringUtils.isEmpty(trainCourseQueryDTO.getTrainCourseObject())) {
					 Predicate  p =  cb.like(root.get("trainCourseObject").as(String.class),"%"+ trainCourseQueryDTO.getTrainCourseObject() + "%");
					 list.add(p);
				 }
				if(null != trainCourseQueryDTO && !StringUtils.isEmpty(trainCourseQueryDTO.getTrainCourseTutor())) {
					 Predicate  p =  cb.like(root.get("trainCourseTutor").as(String.class),"%"+ trainCourseQueryDTO.getTrainCourseTutor() + "%");
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
