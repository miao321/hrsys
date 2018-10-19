package com.hrsys.personnel.dao.DTO;
/**
 * 人事模块-图表-性别比例数据传输对象
 * @author Lofu
 */
public class SexDTO {
	public String sex;	// 性别
	public int count; 	// 人数
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "SexDTO [sex=" + sex + ", count=" + count + "]";
	}
}
