package com.hrsys.train.entity.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import com.hrsys.train.entity.TrainPlan;


/**
 * TrainPlanQueryDTO  封装查询条件 数据传输对象
 * @author Administrator
 *
 */
public class TrainPlanQueryDTO {

	private String trainCourseNo;	//培训课程编号
	private String trainCourseName;	//培训课程名称
	private String trainPlanContent;//培训内容
	private String trainPlanTarget;	//培训目标
	private String trainPlanPlace;	//培训地点
	private String trainMaterialNo;	//培训材料
	private Date trainPlanStartTime;//培训开始时间
	private Date trainPlanEndTime;	//培训结束时间
	private String trainPlanTutor;	//培训讲师
	
	public String getTrainCourseNo() {
		return trainCourseNo;
	}
	public String getTrainCourseName() {
		return trainCourseName;
	}
	public String getTrainPlanContent() {
		return trainPlanContent;
	}
	public String getTrainPlanTarget() {
		return trainPlanTarget;
	}
	public String getTrainPlanPlace() {
		return trainPlanPlace;
	}
	public String getTrainMaterialNo() {
		return trainMaterialNo;
	}
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	public Date getTrainPlanStartTime() {
		return trainPlanStartTime;
	}
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	public Date getTrainPlanEndTime() {
		return trainPlanEndTime;
	}
	public String getTrainPlanTutor() {
		return trainPlanTutor;
	}
	public void setTrainCourseNo(String trainCourseNo) {
		this.trainCourseNo = trainCourseNo;
	}
	public void setTrainCourseName(String trainCourseName) {
		this.trainCourseName = trainCourseName;
	}
	public void setTrainPlanContent(String trainPlanContent) {
		this.trainPlanContent = trainPlanContent;
	}
	public void setTrainPlanTarget(String trainPlanTarget) {
		this.trainPlanTarget = trainPlanTarget;
	}
	public void setTrainPlanPlace(String trainPlanPlace) {
		this.trainPlanPlace = trainPlanPlace;
	}
	public void setTrainMaterialNo(String trainMaterialNo) {
		this.trainMaterialNo = trainMaterialNo;
	}
	public void setTrainPlanStartTime(Date trainPlanStartTime) {
		this.trainPlanStartTime = trainPlanStartTime;
	}
	public void setTrainPlanEndTime(Date trainPlanEndTime) {
		this.trainPlanEndTime = trainPlanEndTime;
	}
	public void setTrainPlanTutor(String trainPlanTutor) {
		this.trainPlanTutor = trainPlanTutor;
	}
	
	//提供static的工具方法：根据当前 QueryDTO 对象来组装动态查询条件
		public static Specification<TrainPlan> getSpecification(TrainPlanQueryDTO trainPlanQueryDTO)
		{
			Specification<TrainPlan> spec = new Specification<TrainPlan>() {
				public Predicate toPredicate(Root<TrainPlan> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					//1.Predicate查询条件集合
					 List<Predicate> list = new ArrayList<Predicate>(); 
					 
					//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
					 if(null != trainPlanQueryDTO && !StringUtils.isEmpty(trainPlanQueryDTO.getTrainCourseNo())) {
						 Predicate  p =  cb.like(root.get("trainCourseNo").as(String.class),"%"+ trainPlanQueryDTO.getTrainCourseNo() + "%");
						 list.add(p);
					 }
					 if(null != trainPlanQueryDTO && !StringUtils.isEmpty(trainPlanQueryDTO.getTrainCourseName())) {
						 Predicate  p =  cb.like(root.get("trainCourseName").as(String.class),"%"+ trainPlanQueryDTO.getTrainCourseName() + "%");
						 list.add(p);
					 }
					 if(null != trainPlanQueryDTO && !StringUtils.isEmpty(trainPlanQueryDTO.getTrainPlanContent())) {
						 Predicate  p =  cb.like(root.get("trainPlanContent").as(String.class),"%"+ trainPlanQueryDTO.getTrainPlanContent() + "%");
						 list.add(p);
					 }
					 if(null != trainPlanQueryDTO && !StringUtils.isEmpty(trainPlanQueryDTO.getTrainPlanTarget())) {
						 Predicate  p =  cb.like(root.get("trainPlanTarget").as(String.class),"%"+ trainPlanQueryDTO.getTrainPlanTarget() + "%");
						 list.add(p);
					 }
					 if(null != trainPlanQueryDTO && !StringUtils.isEmpty(trainPlanQueryDTO.getTrainPlanPlace())) {
						 Predicate  p =  cb.like(root.get("trainPlanPlace").as(String.class),"%"+ trainPlanQueryDTO.getTrainPlanPlace() + "%");
						 list.add(p);
					 }
					 if(null != trainPlanQueryDTO && !StringUtils.isEmpty(trainPlanQueryDTO.getTrainMaterialNo())) {
						 Predicate  p =  cb.like(root.get("trainMaterialNo").as(String.class),"%"+ trainPlanQueryDTO.getTrainMaterialNo() + "%");
						 list.add(p);
					 }
				
					 if(null != trainPlanQueryDTO && trainPlanQueryDTO.getTrainPlanStartTime() != null) {
						 Predicate  p =  cb.greaterThanOrEqualTo(root.get("trainPlanStartTime").as(Date.class), trainPlanQueryDTO.getTrainPlanStartTime());
						 list.add(p);
					 }
					 if(null != trainPlanQueryDTO && trainPlanQueryDTO.getTrainPlanEndTime() != null) {
						 Predicate  p =  cb.lessThanOrEqualTo(root.get("trainPlanEndTime").as(Date.class), trainPlanQueryDTO.getTrainPlanEndTime());
						 list.add(p);
					 }
					 if(null != trainPlanQueryDTO && !StringUtils.isEmpty(trainPlanQueryDTO.getTrainPlanTutor())) {
						 Predicate  p =  cb.like(root.get("trainPlanTutor").as(String.class),"%"+ trainPlanQueryDTO.getTrainPlanTutor() + "%");
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
