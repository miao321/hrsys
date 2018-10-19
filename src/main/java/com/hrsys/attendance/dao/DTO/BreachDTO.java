package com.hrsys.attendance.dao.DTO;
/**
 * 人事模块-图表-人事变动数据传输对象
 * @author Lofu
 */
public class BreachDTO {
	public String type;		// 类型
	public int count;		// 数量
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "BreachDTO [type=" + type + ", count=" + count + "]";
	}
}
