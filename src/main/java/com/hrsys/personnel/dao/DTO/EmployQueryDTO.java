package com.hrsys.personnel.dao.DTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.hrsys.personnel.entity.Employ;

/**
 * 职工类高级查询DTO
 * @author Lofu
 */
public class EmployQueryDTO {
	private String employName; // 员工姓名
	private String employSex; // 员工性别
	private String deptNo; // 所在部门
	private Date beginTime; // 合同开始时间
	private Date endTime; // 合同到期时间
	private Date hiredate; // 入职时间
	private Date birthday; // 员工生日
	private String education; // 文化水平
	public String getEmployName() {
		return employName;
	}
	public void setEmployName(String employName) {
		this.employName = employName;
	}
	public String getEmploySex() {
		return employSex;
	}
	public void setEmploySex(String employSex) {
		this.employSex = employSex;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}

	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}

	/** static的工具方法：根据当前 EmployQueryDTO 对象来组装动态查询条件 */
	public static Specification<Employ> getSpecification(EmployQueryDTO employQueryDTO) {
		Specification<Employ> spec = new Specification<Employ>() {
			public Predicate toPredicate(Root<Employ> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();

				// 2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				if (employQueryDTO != null && !StringUtils.isEmpty(employQueryDTO.getEmployName())) {
					Predicate p = cb.like(root.get("employName").as(String.class),
							"%" + employQueryDTO.getEmployName() + "%");
					list.add(p);
				}
				
				if (employQueryDTO != null && !StringUtils.isEmpty(employQueryDTO.getEmploySex())) {
					Predicate p = cb.equal(root.get("employSex").as(String.class),
							employQueryDTO.getEmploySex());
					list.add(p);
				}
				
				if (employQueryDTO != null && employQueryDTO.getBeginTime() != null) {
					Predicate p = cb.greaterThanOrEqualTo(root.get("beginTime").as(Date.class),
							employQueryDTO.getBeginTime());
					list.add(p);
				}
				
				if (employQueryDTO != null && employQueryDTO.getEndTime() != null) {
					Predicate p = cb.lessThanOrEqualTo(root.get("endTime").as(Date.class),
							employQueryDTO.getEndTime());
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
