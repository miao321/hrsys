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

import com.hrsys.attendance.entity.Overtime;

/**
 * 加班记录类高级查询DTO
 * @author Lofu
 */
public class OvertimeQueryDTO {
	private String employNo;	// 职工号
	private String employName;	// 职工姓名
	private String deptName;	// 所在部门

	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date overtimeDate;	// 加班日期
	
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
	public Date getOvertimeDate() {
		return overtimeDate;
	}
	public void setOvertimeDate(Date overtimeDate) {
		this.overtimeDate = overtimeDate;
	}
	
	/** static的工具方法：根据当前 ClockQueryDTO 对象来组装动态查询条件 */
	public static Specification<Overtime> getSpecification(OvertimeQueryDTO overtimeQueryDTO) {
		Specification<Overtime> spec = new Specification<Overtime>() {
			public Predicate toPredicate(Root<Overtime> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();

				// 2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				if(overtimeQueryDTO != null && !StringUtils.isEmpty(overtimeQueryDTO.getEmployNo())) {
					Predicate p = cb.like(root.get("employNo").as(String.class),
							"%" + overtimeQueryDTO.getEmployNo() + "%");
					list.add(p);
				}
				if(overtimeQueryDTO != null && !StringUtils.isEmpty(overtimeQueryDTO.getEmployName())) {
					Predicate p = cb.like(root.get("employName").as(String.class),
							"%" + overtimeQueryDTO.getEmployName() + "%");
					list.add(p);
				}
				if(overtimeQueryDTO != null && !StringUtils.isEmpty(overtimeQueryDTO.getDeptName())) {
					Predicate p = cb.like(root.get("deptName").as(String.class),
							"%" + overtimeQueryDTO.getDeptName() + "%");
					list.add(p);
				}
				if(overtimeQueryDTO != null && overtimeQueryDTO.getOvertimeDate() != null) {
					Predicate p = cb.equal(root.get("overtimeDate").as(Date.class),
							overtimeQueryDTO.getOvertimeDate());
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
