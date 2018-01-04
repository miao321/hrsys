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



import com.hrsys.train.entity.TrainMaterial;

/**
 * TrainMaterialQueryDTO  封装查询条件 数据传输对象
 * @author Administrator
 *
 */
public class TrainMaterialQueryDTO {

	private String trainMaterialNo;			//培训材料编号
	private String trainMaterialName;		//培训材料名称
	private String trainMaterialContent;	//培训材料内容
	private String trainMaterialSource;		//培训材料来源
	private String trainMaterialAuthor;		//培训材料作者
	
	public String getTrainMaterialNo() {
		return trainMaterialNo;
	}
	public String getTrainMaterialName() {
		return trainMaterialName;
	}
	public String getTrainMaterialContent() {
		return trainMaterialContent;
	}
	public String getTrainMaterialSource() {
		return trainMaterialSource;
	}
	public String getTrainMaterialAuthor() {
		return trainMaterialAuthor;
	}
	public void setTrainMaterialNo(String trainMaterialNo) {
		this.trainMaterialNo = trainMaterialNo;
	}
	public void setTrainMaterialName(String trainMaterialName) {
		this.trainMaterialName = trainMaterialName;
	}
	public void setTrainMaterialContent(String trainMaterialContent) {
		this.trainMaterialContent = trainMaterialContent;
	}
	public void setTrainMaterialSource(String trainMaterialSource) {
		this.trainMaterialSource = trainMaterialSource;
	}
	public void setTrainMaterialAuthor(String trainMaterialAuthor) {
		this.trainMaterialAuthor = trainMaterialAuthor;
	}
	
	//提供static的工具方法：根据当前 QueryDTO 对象来组装动态查询条件
	public static Specification<TrainMaterial> getSpecification(TrainMaterialQueryDTO trainMaterialQueryDTO)
	{
		Specification<TrainMaterial> spec = new Specification<TrainMaterial>() {
			public Predicate toPredicate(Root<TrainMaterial> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//1.Predicate查询条件集合
				 List<Predicate> list = new ArrayList<Predicate>(); 
				 
				//2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				 if(null != trainMaterialQueryDTO && !StringUtils.isEmpty(trainMaterialQueryDTO.getTrainMaterialNo())) {
					 Predicate  p =  cb.like(root.get("trainMaterialNo").as(String.class),"%"+ trainMaterialQueryDTO.getTrainMaterialNo() + "%");
					 list.add(p);
				 }
				 if(null != trainMaterialQueryDTO && !StringUtils.isEmpty(trainMaterialQueryDTO.getTrainMaterialName())) {
					 Predicate  p =  cb.like(root.get("trainMaterialName").as(String.class),"%"+ trainMaterialQueryDTO.getTrainMaterialName() + "%");
					 list.add(p);
				 }
				 if(null != trainMaterialQueryDTO && !StringUtils.isEmpty(trainMaterialQueryDTO.getTrainMaterialContent())) {
					 Predicate  p =  cb.like(root.get("trainMaterialContent").as(String.class),"%"+ trainMaterialQueryDTO.getTrainMaterialContent() + "%");
					 list.add(p);
				 }
				 if(null != trainMaterialQueryDTO && !StringUtils.isEmpty(trainMaterialQueryDTO.getTrainMaterialSource())) {
					 Predicate  p =  cb.like(root.get("trainMaterialSource").as(String.class),"%"+ trainMaterialQueryDTO.getTrainMaterialSource() + "%");
					 list.add(p);
				 }
				 if(null != trainMaterialQueryDTO && !StringUtils.isEmpty(trainMaterialQueryDTO.getTrainMaterialAuthor())) {
					 Predicate  p =  cb.like(root.get("trainMaterialAuthor").as(String.class),"%"+ trainMaterialQueryDTO.getTrainMaterialAuthor() + "%");
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
