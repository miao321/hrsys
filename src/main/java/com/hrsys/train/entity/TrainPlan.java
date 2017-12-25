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
 * 培训计划实体类
 * @author Administrator
 *
 */

@Entity
@Table(name="t_trainPlan")
public class TrainPlan extends BaseEntity implements Serializable {
	
	private Integer	trainPlanId;	//培训计划id
	private String trainCourseNo;	//培训课程编号
	private String trainCourseName;	//培训课程名称
	private String trainPlanContent;//培训内容
	private String trainPlanTarget;	//培训目标
	private String trainPlanPlace;	//培训地点
	private String trainMaterialNo;	//培训材料
	private Date trainPlanStartTime;//培训开始时间
	private Date trainPlanEndTime;	//培训结束时间
	private String trainPlanTutor;	//培训讲师
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTrainPlanId() {
		return trainPlanId;
	}
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
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
	public Date getTrainPlanStartTime() {
		return trainPlanStartTime;
	}
	@DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
	public Date getTrainPlanEndTime() {
		return trainPlanEndTime;
	}
	public String getTrainPlanTutor() {
		return trainPlanTutor;
	}
	public void setTrainPlanId(Integer trainPlanId) {
		this.trainPlanId = trainPlanId;
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
	
	@Override
	public String toString() {
		return "TrainPlan [trainPlanId=" + trainPlanId + ", trainCourseNo=" + trainCourseNo + ", trainCourseName="
				+ trainCourseName + ", trainPlanContent=" + trainPlanContent + ", trainPlanTarget=" + trainPlanTarget
				+ ", trainPlanPlace=" + trainPlanPlace + ", trainMaterialNo=" + trainMaterialNo
				+ ", trainPlanStartTime=" + trainPlanStartTime + ", trainPlanEndTime=" + trainPlanEndTime
				+ ", trainPlanTutor=" + trainPlanTutor + "]";
	}
	
	

}
