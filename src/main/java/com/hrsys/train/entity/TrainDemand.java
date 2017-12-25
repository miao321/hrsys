package com.hrsys.train.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsys.common.entity.BaseEntity;

/**
 * 培训需求统计实体类
 * @author Administrator
 *
 */

@Entity
@Table(name="t_trainDemand")
public class TrainDemand extends BaseEntity implements Serializable {
	
	private Integer trainDemandId;			//培训需求id
	private String trainDemandNo;			//培训需求编号
	private String trainDemandName;			//培训课程需求
	private String trainDemandContent;		//培训需求内容
	private String trainDemandTarget;		//培训需求目标
	private Date trainDemandTime;			//提出时间
	private String trainDemandProposer;		//提出人
	private String trainDemandReviewer;		//审核人
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTrainDemandId() {
		return trainDemandId;
	}
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
	
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
	public Date getTrainDemandTime() {
		return trainDemandTime;
	}
	public String getTrainDemandProposer() {
		return trainDemandProposer;
	}
	public String getTrainDemandReviewer() {
		return trainDemandReviewer;
	}
	public void setTrainDemandId(Integer trainDemandId) {
		this.trainDemandId = trainDemandId;
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
	
	@Override
	public String toString() {
		return "TrainDemand [trainDemandId=" + trainDemandId + ", trainDemandNo=" + trainDemandNo + ", trainDemandName="
				+ trainDemandName + ", trainDemandContent=" + trainDemandContent + ", trainDemandTarget="
				+ trainDemandTarget + ", trainDemandTime=" + trainDemandTime + ", trainDemandProposer="
				+ trainDemandProposer + ", trainDemandReviewer=" + trainDemandReviewer + "]";
	}
	
	

}
