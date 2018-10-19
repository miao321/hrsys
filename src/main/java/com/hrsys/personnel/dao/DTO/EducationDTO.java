package com.hrsys.personnel.dao.DTO;
/**
 * 人事模块-图表-教育程度人数数据传输对象
 * @author Lofu
 */
public class EducationDTO {
	private String education;	// 教育程度
	private int count;			// 人数
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "EducationDTO [education=" + education + ", count=" + count + "]";
	}
}
