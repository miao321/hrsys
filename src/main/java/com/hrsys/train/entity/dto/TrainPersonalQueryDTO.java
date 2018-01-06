package com.hrsys.train.entity.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.hrsys.train.entity.TrainPersonal;



/**
 * TrainPersonalQueryDTO  封装查询条件 数据传输对象
 * @author Administrator
 *
 */
public class TrainPersonalQueryDTO {

	private String trainPersonalNo;			//培训记录编号
	private String trainCourseNo;			//培训课程编号
	private String trainEmployeeNo;			//参与培训员工编号
	private String trainEmployeeName;		//员工姓名
	private Integer trainPersonalAssess;	//评估得分
	
	public String getTrainPersonalNo() {
		return trainPersonalNo;
	}
	public String getTrainCourseNo() {
		return trainCourseNo;
	}
	public String getTrainEmployeeNo() {
		return trainEmployeeNo;
	}
	public String getTrainEmployeeName() {
		return trainEmployeeName;
	}
	public Integer getTrainPersonalAssess() {
		return trainPersonalAssess;
	}
	public void setTrainPersonalNo(String trainPersonalNo) {
		this.trainPersonalNo = trainPersonalNo;
	}
	public void setTrainCourseNo(String trainCourseNo) {
		this.trainCourseNo = trainCourseNo;
	}
	public void setTrainEmployeeNo(String trainEmployeeNo) {
		this.trainEmployeeNo = trainEmployeeNo;
	}
	public void setTrainEmployeeName(String trainEmployeeName) {
		this.trainEmployeeName = trainEmployeeName;
	}
	public void setTrainPersonalAssess(Integer trainPersonalAssess) {
		this.trainPersonalAssess = trainPersonalAssess;
	}

	//提供static的工具方法：根据当前 QueryDTO 对象来组装动态查询条件
		public static Specification<TrainPersonal> getSpecification(TrainPersonalQueryDTO trainPersonalQueryDTO)
		{
			Specification<TrainPersonal> spec = new Specification<TrainPersonal>() {
				public Predicate toPredicate(Root<TrainPersonal> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					//1.Predicate查询条件集合
					 List<Predicate> list = new ArrayList<Predicate>(); 
					 
					//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
					 if(null != trainPersonalQueryDTO && !StringUtils.isEmpty(trainPersonalQueryDTO.getTrainPersonalNo())) {
						 Predicate  p =  cb.like(root.get("trainPersonalNo").as(String.class),"%"+ trainPersonalQueryDTO.getTrainPersonalNo() + "%");
						 list.add(p);
					 }
					 if(null != trainPersonalQueryDTO && !StringUtils.isEmpty(trainPersonalQueryDTO.getTrainCourseNo())) {
						 Predicate  p =  cb.like(root.get("trainCourseNo").as(String.class),"%"+ trainPersonalQueryDTO.getTrainCourseNo() + "%");
						 list.add(p);
					 }
					 if(null != trainPersonalQueryDTO && !StringUtils.isEmpty(trainPersonalQueryDTO.getTrainEmployeeNo())) {
						 Predicate  p =  cb.like(root.get("trainEmployeeNo").as(String.class),"%"+ trainPersonalQueryDTO.getTrainEmployeeNo() + "%");
						 list.add(p);
					 }
					 if(null != trainPersonalQueryDTO && !StringUtils.isEmpty(trainPersonalQueryDTO.getTrainEmployeeName())) {
						 Predicate  p =  cb.like(root.get("trainEmployeeName").as(String.class),"%"+ trainPersonalQueryDTO.getTrainEmployeeName() + "%");
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
