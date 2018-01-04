package com.hrsys.train.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hrsys.common.entity.BaseEntity;

/**
 * 培训材料实体类
 * @author Administrator
 *
 */

@Entity
@Table(name="t_trainMaterial")
public class TrainMaterial extends BaseEntity implements Serializable {
	
	private Long trainMaterialId;		//培训材料id
	private String trainMaterialNo;			//培训材料编号
	private String trainMaterialName;		//培训材料名称
	private String trainMaterialContent;	//培训材料内容
	private String trainMaterialSource;		//培训材料来源
	private String trainMaterialAuthor;		//培训材料作者
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getTrainMaterialId() {
		return trainMaterialId;
	}
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
	public void setTrainMaterialId(Long trainMaterialId) {
		this.trainMaterialId = trainMaterialId;
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
	
	@Override
	public String toString() {
		return "TrainMaterial [trainMaterialId=" + trainMaterialId + ", trainMaterialNo=" + trainMaterialNo
				+ ", trainMaterialName=" + trainMaterialName + ", trainMaterialContent=" + trainMaterialContent
				+ ", trainMaterialSource=" + trainMaterialSource + ", trainMaterialAuthor=" + trainMaterialAuthor + "]";
	}
			
			

}
