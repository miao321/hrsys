package com.hrsys.train.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hrsys.common.entity.BaseEntity;

/**
 * 培训课程实体类
 * @author Administrator
 *
 */

@Entity
@Table(name="t_trainCourse")
public class TrainCourse extends BaseEntity implements Serializable {
	
	private Integer trainCourseId;			//培训课程id
	private String trainCourseNo;			//培训课程编号
	private String trainCourseName;			//培训课程名称
	private String trainCourseLanguage;		//培训语言
	private String trainCourseMethod;		//培训方式
	private String trainCourseObject;		//培训对象
	private String trainCourseTutor;		//培训讲师
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTrainCourseId() {
		return trainCourseId;
	}
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
	public void setTrainCourseId(Integer trainCourseId) {
		this.trainCourseId = trainCourseId;
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
	@Override
	public String toString() {
		return "TrainCourse [trainCourseId=" + trainCourseId + ", trainCourseNo=" + trainCourseNo + ", trainCourseName="
				+ trainCourseName + ", trainCourseLanguage=" + trainCourseLanguage + ", trainCourseMethod="
				+ trainCourseMethod + ", trainCourseObject=" + trainCourseObject + ", trainCourseTutor="
				+ trainCourseTutor + "]";
	}

	
}
