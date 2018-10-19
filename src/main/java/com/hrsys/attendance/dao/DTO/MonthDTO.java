package com.hrsys.attendance.dao.DTO;
/**
 * 人事模块-图表-人事变动数据传输对象
 * @author Lofu
 */
public class MonthDTO {
	public String month;	// 月份
	public int count;		// 数量
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "MonthDTO [month=" + month + ", count=" + count + "]";
	}
}
