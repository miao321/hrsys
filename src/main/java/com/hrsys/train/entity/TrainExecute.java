package com.hrsys.train.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hrsys.common.entity.BaseEntity;

/**
 * 培训实施实体类
 * @author Administrator
 *
 */

@Entity
@Table(name="t_trainExecute")
public class TrainExecute extends BaseEntity implements Serializable {
	
	private Integer trainExecuteId;			//培训实施id
	private String trainCourseNo;			//培训课程编号
	private String trainCourseName;			//培训课程名称
	private Integer trainExecuteApplyNum;	//培训参与人数
	private Integer trainExecuteBudget;		//费用预算
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getTrainExecuteId() {
		return trainExecuteId;
	}
	public String getTrainCourseNo() {
		return trainCourseNo;
	}
	public String getTrainCourseName() {
		return trainCourseName;
	}
	public Integer getTrainExecuteApplyNum() {
		return trainExecuteApplyNum;
	}
	public Integer getTrainExecuteBudget() {
		return trainExecuteBudget;
	}
	public void setTrainExecuteId(Integer trainExecuteId) {
		this.trainExecuteId = trainExecuteId;
	}
	public void setTrainCourseNo(String trainCourseNo) {
		this.trainCourseNo = trainCourseNo;
	}
	public void setTrainCourseName(String trainCourseName) {
		this.trainCourseName = trainCourseName;
	}
	public void setTrainExecuteApplyNum(Integer trainExecuteApplyNum) {
		this.trainExecuteApplyNum = trainExecuteApplyNum;
	}
	public void setTrainExecuteBudget(Integer trainExecuteBudget) {
		this.trainExecuteBudget = trainExecuteBudget;
	}
	
	@Override
	public String toString() {
		return "TrainExecute [trainExecuteId=" + trainExecuteId + ", trainCourseNo=" + trainCourseNo
				+ ", trainCourseName=" + trainCourseName + ", trainExecuteApplyNum=" + trainExecuteApplyNum
				+ ", trainExecuteBudget=" + trainExecuteBudget + "]";
	}
	
	
	

}
