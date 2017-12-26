package com.hrsys.attendance.dao.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.hrsys.attendance.entity.Leave;

/**
 * 请假记录类高级查询DTO
 * @author Lofu
 */
public class LeaveQueryDTO {
	private String employNo;	//员工的id
	private String employName;	//员工的姓名
	private Date leaveBeginTime;//请假开始时间
	private Date leaveEndTime;	//请假结束时间
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
	public Date getLeaveBeginTime() {
		return leaveBeginTime;
	}
	public void setLeaveBeginTime(Date leaveBeginTime) {
		this.leaveBeginTime = leaveBeginTime;
	}
	public Date getLeaveEndTime() {
		return leaveEndTime;
	}
	public void setLeaveEndTime(Date leaveEndTime) {
		this.leaveEndTime = leaveEndTime;
	}
	/** static的工具方法：根据当前 ClockQueryDTO 对象来组装动态查询条件 */
	public static Specification<Leave> getSpecification(LeaveQueryDTO leaveQueryDTO) {
		Specification<Leave> spec = new Specification<Leave>() {
			public Predicate toPredicate(Root<Leave> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();

				// 2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				if (leaveQueryDTO != null && !StringUtils.isEmpty(leaveQueryDTO.getEmployNo())) {
					Predicate p = cb.equal(root.get("employNo").as(String.class),
							leaveQueryDTO.getEmployNo());
					list.add(p);
				}
				
				if (leaveQueryDTO != null && !StringUtils.isEmpty(leaveQueryDTO.getEmployName())) {
					Predicate p = cb.like(root.get("employName").as(String.class),
							"%" + leaveQueryDTO.getEmployName() + "%");
					list.add(p);
				}
				
				if (leaveQueryDTO != null && leaveQueryDTO.getLeaveBeginTime() != null) {
					Predicate p = cb.greaterThanOrEqualTo(root.get("leaveBeginTime").as(Date.class),
							leaveQueryDTO.getLeaveBeginTime());
					list.add(p);
				}
				
				if (leaveQueryDTO != null && leaveQueryDTO.getLeaveEndTime() != null) {
					Predicate p = cb.lessThanOrEqualTo(root.get("leaveEndTime").as(Date.class),
							leaveQueryDTO.getLeaveEndTime());
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
