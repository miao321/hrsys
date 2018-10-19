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

import com.hrsys.attendance.entity.Breach;

/**
 * 违规记录类高级查询DTO
 * @author Lofu
 */
public class BreachQueryDTO {
	private String employNo;	// 职工号
	private String employName;	// 职工姓名
	private String deptName;	// 所在部门
	private String content;		// 违规内容（迟到、早退、旷工）
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date breachDate;	// 违规日期（年/月/日）
	
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBreachDate() {
		return breachDate;
	}
	public void setBreachDate(Date breachDate) {
		this.breachDate = breachDate;
	}
	
	/** static的工具方法：根据当前 ClockQueryDTO 对象来组装动态查询条件 */
	public static Specification<Breach> getSpecification(BreachQueryDTO breachQueryDTO) {
		Specification<Breach> spec = new Specification<Breach>() {
			public Predicate toPredicate(Root<Breach> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();

				// 2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				if(breachQueryDTO != null && !StringUtils.isEmpty(breachQueryDTO.getEmployNo())) {
					Predicate p = cb.like(root.get("employNo").as(String.class),
							"%" + breachQueryDTO.getEmployNo() + "%");
					list.add(p);
				}
				if(breachQueryDTO != null && !StringUtils.isEmpty(breachQueryDTO.getEmployName())) {
					Predicate p = cb.like(root.get("employName").as(String.class),
							"%" + breachQueryDTO.getEmployName() + "%");
					list.add(p);
				}
				if(breachQueryDTO != null && !StringUtils.isEmpty(breachQueryDTO.getDeptName())) {
					Predicate p = cb.like(root.get("deptName").as(String.class),
							"%" + breachQueryDTO.getDeptName() + "%");
					list.add(p);
				}
				if(breachQueryDTO != null && !StringUtils.isEmpty(breachQueryDTO.getContent())) {
					Predicate p = cb.like(root.get("content").as(String.class),
							"%" + breachQueryDTO.getContent() + "%");
					list.add(p);
				}
				if(breachQueryDTO != null && breachQueryDTO.getBreachDate() != null) {
					Predicate p = cb.equal(root.get("breachDate").as(Date.class),
							breachQueryDTO.getBreachDate());
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
