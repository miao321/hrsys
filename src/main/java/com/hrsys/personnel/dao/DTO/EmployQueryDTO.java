package com.hrsys.personnel.dao.DTO;

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

import com.hrsys.personnel.entity.Employ;

/**
 * 职工类高级查询DTO
 * @author Lofu
 */
public class EmployQueryDTO {
	private String employNo;	// 职工号
	private String employName;	// 职工姓名
	private String employSex;	// 职工性别
	private String deptName;	// 所属部门
	private String position;	// 职工职位
	private String education;	// 教育程度
	private String graduate;	// 毕业学校
	private String nativePlace;	// 职工籍贯

	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date birthday;		// 出生日期
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date beginTime;		// 入职开始时间
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private Date endTime;		// 入职截至时间

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
	public String getEmploySex() {
		return employSex;
	}
	public void setEmploySex(String employSex) {
		this.employSex = employSex;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getGraduate() {
		return graduate;
	}
	public void setGraduate(String graduate) {
		this.graduate = graduate;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	
	/** static的工具方法：根据当前 EmployQueryDTO 对象来组装动态查询条件 */
	public static Specification<Employ> getSpecification(EmployQueryDTO employQueryDTO) {
		Specification<Employ> spec = new Specification<Employ>() {
			public Predicate toPredicate(Root<Employ> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();

				// 2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				if(employQueryDTO != null && !StringUtils.isEmpty(employQueryDTO.getEmployNo())) {
					Predicate p = cb.like(root.get("employNo").as(String.class),
							"%" + employQueryDTO.getEmployNo() + "%");
					list.add(p);
				}
				if(employQueryDTO != null && !StringUtils.isEmpty(employQueryDTO.getEmployName())) {
					Predicate p = cb.like(root.get("employName").as(String.class),
							"%" + employQueryDTO.getEmployName() + "%");
					list.add(p);
				}
				if(employQueryDTO != null && !StringUtils.isEmpty(employQueryDTO.getEmploySex())) {
					Predicate p = cb.like(root.get("employSex").as(String.class),
							"%" + employQueryDTO.getEmploySex() + "%");
					list.add(p);
				}
				if(employQueryDTO != null && !StringUtils.isEmpty(employQueryDTO.getDeptName())) {
					Predicate p = cb.like(root.get("deptName").as(String.class),
							"%" + employQueryDTO.getDeptName() + "%");
					list.add(p);
				}
				if(employQueryDTO != null && !StringUtils.isEmpty(employQueryDTO.getPosition())) {
					Predicate p = cb.like(root.get("position").as(String.class),
							"%" + employQueryDTO.getPosition() + "%");
					list.add(p);
				}
				if(employQueryDTO != null && !StringUtils.isEmpty(employQueryDTO.getEducation())) {
					Predicate p = cb.like(root.get("education").as(String.class),
							"%" + employQueryDTO.getEducation() + "%");
					list.add(p);
				}
				if(employQueryDTO != null && !StringUtils.isEmpty(employQueryDTO.getGraduate())) {
					Predicate p = cb.like(root.get("graduate").as(String.class),
							"%" + employQueryDTO.getGraduate() + "%");
					list.add(p);
				}
				if(employQueryDTO != null && !StringUtils.isEmpty(employQueryDTO.getNativePlace())) {
					Predicate p = cb.like(root.get("nativePlace").as(String.class),
							"%" + employQueryDTO.getNativePlace() + "%");
					list.add(p);
				}
				if(employQueryDTO != null && employQueryDTO.getBirthday() != null) {
					Predicate p = cb.equal(root.get("birthday").as(Date.class),
							employQueryDTO.getBirthday());
					list.add(p);
				}
				if(employQueryDTO != null && employQueryDTO.getBeginTime() != null && employQueryDTO.getEndTime() != null) {
					Predicate p = cb.between(root.get("hiredate").as(Date.class), employQueryDTO.getBeginTime(),
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
