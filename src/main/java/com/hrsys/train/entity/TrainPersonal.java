package com.hrsys.train.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.hrsys.common.entity.BaseEntity;

/**
 * 个人培训记录实体类
 * @author Administrator
 *
 */

@Entity
@Table(name="t_trainPersonal")
public class TrainPersonal extends BaseEntity implements Serializable {
	
	private Long trainPersonalId;		//培训记录id
	private String trainPersonalNo;			//培训记录编号
	private String trainCourseNo;			//培训课程编号
	private String trainEmployeeNo;			//参与培训员工编号
	private String trainEmployeeName;		//员工姓名
	private Integer trainPersonalAssess;	//评估得分
	private String trainPersonalMark;		//备注
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getTrainPersonalId() {
		return trainPersonalId;
	}
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
	public String getTrainPersonalMark() {
		return trainPersonalMark;
	}
	public void setTrainPersonalId(Long trainPersonalId) {
		this.trainPersonalId = trainPersonalId;
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
	public void setTrainPersonalMark(String trainPersonalMark) {
		this.trainPersonalMark = trainPersonalMark;
	}
	
	@Override
	public String toString() {
		return "TrainPersonal [trainPersonalId=" + trainPersonalId + ", trainPersonalNo=" + trainPersonalNo
				+ ", trainCourseNo=" + trainCourseNo + ", trainEmployeeNo=" + trainEmployeeNo + ", trainEmployeeName="
				+ trainEmployeeName + ", trainPersonalAssess=" + trainPersonalAssess + ", trainPersonalMark="
				+ trainPersonalMark + "]";
	}

	
}
