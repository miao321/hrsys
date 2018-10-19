package com.hrsys.attendance.dao.DTO;
/**
 * 考勤模块-图表-打卡数据传输对象
 * @author Lofu
 */
public class ClockDTO {
	public String month;	// 月份
	public int inCount;		// 上班打卡人数
	public int outCount;	// 下班打卡人数
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getInCount() {
		return inCount;
	}
	public void setInCount(int inCount) {
		this.inCount = inCount;
	}
	public int getOutCount() {
		return outCount;
	}
	public void setOutCount(int outCount) {
		this.outCount = outCount;
	}
	@Override
	public String toString() {
		return "ClockDTO [month=" + month + ", inCount=" + inCount + ", outCount=" + outCount + "]";
	}
	
}
