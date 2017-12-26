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

import com.hrsys.attendance.entity.Break;


/**
 * 违规记录类高级查询DTO
 * @author Lofu
 */
public class BreakQueryDTO {
	private String employNo;	//员工的id
	private String employName;	//员工的姓名
	private String content;		//违规内容（迟到、早退、旷工）
	private Date breakTime;		//违规时间（年/月/日）
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getBreakTime() {
		return breakTime;
	}
	public void setBreakTime(Date breakTime) {
		this.breakTime = breakTime;
	}
	/** static的工具方法：根据当前 ClockQueryDTO 对象来组装动态查询条件 */
	public static Specification<Break> getSpecification(BreakQueryDTO breakQueryDTO) {
		Specification<Break> spec = new Specification<Break>() {
			public Predicate toPredicate(Root<Break> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// 1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();

				// 2.根据 QueryDTO数据字段的值进行判断以及条件的组装
				if (breakQueryDTO != null && !StringUtils.isEmpty(breakQueryDTO.getEmployNo())) {
					Predicate p = cb.equal(root.get("employNo").as(String.class),
							breakQueryDTO.getEmployNo());
					list.add(p);
				}
				
				if (breakQueryDTO != null && !StringUtils.isEmpty(breakQueryDTO.getEmployName())) {
					Predicate p = cb.like(root.get("employName").as(String.class),
							"%" + breakQueryDTO.getEmployName() + "%");
					list.add(p);
				}
				
				if (breakQueryDTO != null && !StringUtils.isEmpty(breakQueryDTO.getContent())) {
					Predicate p = cb.like(root.get("content").as(String.class),
							"%" + breakQueryDTO.getContent() + "%");
					list.add(p);
				}
				
				if (breakQueryDTO != null && breakQueryDTO.getBreakTime() != null) {
					Predicate p = cb.equal(root.get("breakTime").as(Date.class),
							breakQueryDTO.getBreakTime());
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
