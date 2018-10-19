package com.hrsys.attendance.dao.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.StringUtils;

import com.hrsys.attendance.entity.Leave;

/**
 * 请假记录类高级查询DTO
 * @author Lofu
 */
public class LeaveQueryDTO {
	private String employNo;	// 职工号
	private String employName;	// 职工姓名
	private String deptName;	// 所在部门
	private String leaveType;	// 请假类型
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date applyDate;		// 请假申请日期
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date leaveDate;		// 请假日期
	
	public String getEmployNo() {
		return employNo;
	}
	public void setEmployNo(String employNo) {
		this.employNo = employNo;
	}
	public String getEmployName() {
		return employName;
	}
	public void setEmployName(String employName) {
		this.employName = employName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getLeaveType() {
		return leaveType;
	}
	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}
	public Date getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}
	public Date getLeaveDate() {
		return leaveDate;
	}
	public void setLeaveDate(Date leaveDate) {
		this.leaveDate = leaveDate;
	}
	
	/** static的工具方法：根据当前 ClockQueryDTO 对象来组装动态查询条件 */
	public static Specification<Leave> getSpecification(LeaveQueryDTO leaveQueryDTO) {
		Specification<Leave> spec = new Specification<Leave>() {
			public Predicate toPredicate(Root<Leave> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();

				// 2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				if(leaveQueryDTO != null && !StringUtils.isEmpty(leaveQueryDTO.getEmployNo())) {
					Predicate p = cb.like(root.get("employNo").as(String.class),
							"%" + leaveQueryDTO.getEmployNo() + "%");
					list.add(p);
				}
				if(leaveQueryDTO != null && !StringUtils.isEmpty(leaveQueryDTO.getEmployName())) {
					Predicate p = cb.like(root.get("employName").as(String.class),
							"%" + leaveQueryDTO.getEmployName() + "%");
					list.add(p);
				}
				if(leaveQueryDTO != null && !StringUtils.isEmpty(leaveQueryDTO.getDeptName())) {
					Predicate p = cb.like(root.get("deptName").as(String.class),
							"%" + leaveQueryDTO.getDeptName() + "%");
					list.add(p);
				}
				if(leaveQueryDTO != null && !StringUtils.isEmpty(leaveQueryDTO.getLeaveType())) {
					Predicate p = cb.like(root.get("leaveType").as(String.class),
							"%" + leaveQueryDTO.getLeaveType() + "%");
					list.add(p);
				}
				if(leaveQueryDTO != null && leaveQueryDTO.getLeaveDate() != null) {
					Predicate p = cb.equal(root.get("leaveDate").as(Date.class),
							leaveQueryDTO.getLeaveDate());
					list.add(p);
				}
				if(leaveQueryDTO != null && leaveQueryDTO.getApplyDate() != null) {
					Predicate p = cb.equal(root.get("applyDate").as(Date.class),
							leaveQueryDTO.getApplyDate());
					list.add(p);
				}

				// 3.Predicate查询条件集合的 size 创建对应的Predicate查询条件数组
				Predicate[] p = new Predicate[list.size()];

				// 4.CriteriaBuilder的and 函数组装 查询条件数组
				return cb.and(list.toArray(p));
			}
		};
		return spec;
	}
}
