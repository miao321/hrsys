package com.hrsys.attendance.dao.DTO;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.hrsys.attendance.entity.Clock;

/**
 * 打卡记录类高级查询DTO
 * @author Lofu
 */
public class ClockQueryDTO {
	private String employNo;	//员工的id
	private String employName;	//员工姓名
	private String deptName;	//所属部门
	private Short clockType;	//打卡类型
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
	public Short getClockType() {
		return clockType;
	}
	public void setClockType(Short clockType) {
		this.clockType = clockType;
	}
	
	/** static的工具方法：根据当前 ClockQueryDTO 对象来组装动态查询条件 */
	public static Specification<Clock> getSpecification(ClockQueryDTO clockQueryDTO) {
		Specification<Clock> spec = new Specification<Clock>() {
			public Predicate toPredicate(Root<Clock> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();

				// 2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				if (clockQueryDTO != null && !StringUtils.isEmpty(clockQueryDTO.getEmployNo())) {
					Predicate p = cb.equal(root.get("employNo").as(String.class),
							clockQueryDTO.getEmployNo());
					list.add(p);
				}
				
				if (clockQueryDTO != null && !StringUtils.isEmpty(clockQueryDTO.getEmployName())) {
					Predicate p = cb.like(root.get("employName").as(String.class),
							"%" + clockQueryDTO.getEmployName() + "%");
					list.add(p);
				}
				
				if (clockQueryDTO != null && !StringUtils.isEmpty(clockQueryDTO.getDeptName())) {
					Predicate p = cb.like(root.get("deptName").as(String.class),
							"%" + clockQueryDTO.getDeptName() + "%");
					list.add(p);
				}
				
				if (clockQueryDTO != null && clockQueryDTO.getClockType() != null) {
					Predicate p = cb.equal(root.get("clockType").as(Short.class),
							clockQueryDTO.getClockType());
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
