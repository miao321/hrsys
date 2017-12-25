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

import com.hrsys.personnel.entity.Change;

/**
 * 人事调动类高级查询DTO
 * @author Lofu
 */
public class ChangeQueryDTO {
	private String employNo;	//员工id
	private String employName;	//员工姓名
	private Date applyTime;		//申请时间
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
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	
	/** static的工具方法：根据当前 ChangeQueryDTO 对象来组装动态查询条件 */
	public static Specification<Change> getSpecification(ChangeQueryDTO changeQueryDTO) {
		Specification<Change> spec = new Specification<Change>() {
			public Predicate toPredicate(Root<Change> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();

				// 2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				if (changeQueryDTO != null && !StringUtils.isEmpty(changeQueryDTO.getEmployName())) {
					Predicate p = cb.like(root.get("employName").as(String.class),
							"%" + changeQueryDTO.getEmployName() + "%");
					list.add(p);
				}
				
				if (changeQueryDTO != null && !StringUtils.isEmpty(changeQueryDTO.getEmployNo())) {
					Predicate p = cb.equal(root.get("employNo").as(String.class),
							changeQueryDTO.getEmployNo());
					list.add(p);
				}
				
				if (changeQueryDTO != null && changeQueryDTO.getApplyTime() != null) {
					Predicate p = cb.equal(root.get("applyTime").as(Date.class),
							changeQueryDTO.getApplyTime());
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
