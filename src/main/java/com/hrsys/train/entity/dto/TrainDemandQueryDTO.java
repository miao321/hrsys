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

import com.hrsys.train.entity.TrainDemand;



/**
 * TrainDemandQueryDTO  封装查询条件 数据传输对象
 * @author Administrator
 *
 */
public class TrainDemandQueryDTO {
	private String trainDemandNo;			//培训需求编号
	private String trainDemandName;			//培训课程需求
	private String trainDemandContent;		//培训需求内容
	private String trainDemandTarget;		//培训需求目标
	private Date trainDemandTime;			//提出时间
	private String trainDemandProposer;		//提出人
	private String trainDemandReviewer;		//审核人
	
	public String getTrainDemandNo() {
		return trainDemandNo;
	}
	public String getTrainDemandName() {
		return trainDemandName;
	}
	public String getTrainDemandContent() {
		return trainDemandContent;
	}
	public String getTrainDemandTarget() {
		return trainDemandTarget;
	}
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	public Date getTrainDemandTime() {
		return trainDemandTime;
	}
	public String getTrainDemandProposer() {
		return trainDemandProposer;
	}
	public String getTrainDemandReviewer() {
		return trainDemandReviewer;
	}
	public void setTrainDemandNo(String trainDemandNo) {
		this.trainDemandNo = trainDemandNo;
	}
	public void setTrainDemandName(String trainDemandName) {
		this.trainDemandName = trainDemandName;
	}
	public void setTrainDemandContent(String trainDemandContent) {
		this.trainDemandContent = trainDemandContent;
	}
	public void setTrainDemandTarget(String trainDemandTarget) {
		this.trainDemandTarget = trainDemandTarget;
	}
	public void setTrainDemandTime(Date trainDemandTime) {
		this.trainDemandTime = trainDemandTime;
	}
	public void setTrainDemandProposer(String trainDemandProposer) {
		this.trainDemandProposer = trainDemandProposer;
	}
	public void setTrainDemandReviewer(String trainDemandReviewer) {
		this.trainDemandReviewer = trainDemandReviewer;
	}
	
	//提供static的工具方法：根据当前 QueryDTO 对象来组装动态查询条件
		public static Specification<TrainDemand> getSpecification(TrainDemandQueryDTO trainDemandQueryDTO)
		{
			Specification<TrainDemand> spec = new Specification<TrainDemand>() {
				public Predicate toPredicate(Root<TrainDemand> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
					//1.Predicate查询条件集合
					 List<Predicate> list = new ArrayList<Predicate>(); 
					 
					//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
					 if(null != trainDemandQueryDTO && !StringUtils.isEmpty(trainDemandQueryDTO.getTrainDemandNo())) {
						 Predicate  p =  cb.like(root.get("trainDemandNo").as(String.class),"%"+ trainDemandQueryDTO.getTrainDemandNo() + "%");
						 list.add(p);
					 }
					 if(null != trainDemandQueryDTO && !StringUtils.isEmpty(trainDemandQueryDTO.getTrainDemandName())) {
						 Predicate  p =  cb.like(root.get("trainDemandName").as(String.class),"%"+ trainDemandQueryDTO.getTrainDemandName() + "%");
						 list.add(p);
					 }
					 if(null != trainDemandQueryDTO && !StringUtils.isEmpty(trainDemandQueryDTO.getTrainDemandContent())) {
						 Predicate  p =  cb.like(root.get("trainDemandContent").as(String.class),"%"+ trainDemandQueryDTO.getTrainDemandContent() + "%");
						 list.add(p);
					 }
					 if(null != trainDemandQueryDTO && !StringUtils.isEmpty(trainDemandQueryDTO.getTrainDemandTarget())) {
						 Predicate  p =  cb.like(root.get("trainDemandTarget").as(String.class),"%"+ trainDemandQueryDTO.getTrainDemandTarget() + "%");
						 list.add(p);
					 }

					if ( null != trainDemandQueryDTO && trainDemandQueryDTO.getTrainDemandTime() != null) {
							Predicate p = cb.equal(root.get("trainDemandTime").as(Date.class),
									trainDemandQueryDTO.getTrainDemandTime());
							list.add(p);
					}
					 
					if(null != trainDemandQueryDTO && !StringUtils.isEmpty(trainDemandQueryDTO.getTrainDemandProposer())) {
						 Predicate  p =  cb.like(root.get("trainDemandProposer").as(String.class),"%"+ trainDemandQueryDTO.getTrainDemandProposer() + "%");
						 list.add(p);
					 }
					if(null != trainDemandQueryDTO && !StringUtils.isEmpty(trainDemandQueryDTO.getTrainDemandReviewer())) {
						 Predicate  p =  cb.like(root.get("trainDemandReviewer").as(String.class),"%"+ trainDemandQueryDTO.getTrainDemandReviewer() + "%");
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
