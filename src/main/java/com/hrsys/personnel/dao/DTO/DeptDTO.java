package com.hrsys.personnel.dao.DTO;
/**
 * 人事模块-图表-部门人数比例数据传输对象
 * @author Lofu
 */
public class DeptDTO {
	public String deptName;		// 部门名
	public int count;			// 部门人数
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "DeptDTO [deptName=" + deptName + ", count=" + count + "]";
	}
}
