package com.hrsys.user.entity.dto;
/**
 * Query DTO 封装查询条件  数据传输对象
 * @author Administrator
 *
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hrsys.user.entity.UserRole;

public class UserRoleQueryDTO {
	private Long id;
	private Long userId;
	private Long roleId;
	private String userName;
	private String roleName;
	private String deptName;	
	private String userNo;//职员编号
	private String password;//用户密码
	private String userNickName;//用户昵称
	private String sex;   //性别
	@DateTimeFormat(pattern="yyyy/MM/dd HH:mm:ss")
	private Date birthday;//出生日期
	private Integer age;//年龄
	private String nativePlace;//籍贯
	private String nation;//民族
	private String culture;//文化程度
	private String college;//毕业学校
	private String body;//健康情况
	private String marriage;//婚姻状况
	private String idCord;//身份证号码
	private String phone;//手机号
	private String familyPhone;//家庭电话
	private String email;//电子邮箱地址
	private String userAccount;//职工账号
	private String remark;//备注
	
	
	public UserRoleQueryDTO() {
		super();
	}
	public UserRoleQueryDTO(String userName, String roleName, String deptName) {		
		this.userName = userName;
		this.roleName = roleName;
		this.deptName = deptName;
	}
	
	public Long getId() {
		return id;
	}
	public Long getUserId() {
		return userId;
	}
	public Long getRoleId() {
		return roleId;
	}
	public String getUserName() {
		return userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public String getDeptName() {
		return deptName;
	}
	public String getUserNo() {
		return userNo;
	}
	public String getPassword() {
		return password;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public String getSex() {
		return sex;
	}
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss",timezone = "GMT+8")
	public Date getBirthday() {
		return birthday;
	}
	public Integer getAge() {
		return age;
	}
	public String getNativePlace() {
		return nativePlace;
	}
	public String getNation() {
		return nation;
	}
	public String getCulture() {
		return culture;
	}
	public String getCollege() {
		return college;
	}
	public String getBody() {
		return body;
	}
	public String getMarriage() {
		return marriage;
	}
	public String getIdCord() {
		return idCord;
	}
	public String getPhone() {
		return phone;
	}
	public String getFamilyPhone() {
		return familyPhone;
	}
	public String getEmail() {
		return email;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public String getRemark() {
		return remark;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public void setCulture(String culture) {
		this.culture = culture;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public void setIdCord(String idCord) {
		this.idCord = idCord;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setFamilyPhone(String familyPhone) {
		this.familyPhone = familyPhone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	//提供static的工具方法： 根据当前userQueryDTO对象来组装动态查询条件
	public static Specification<UserRole> getSpecification(UserRoleQueryDTO userQueryDTO){
		Specification<UserRole> spec = new Specification<UserRole>() {
			public Predicate toPredicate(Root<UserRole> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				//1.Predicate查询条件集合
				List<Predicate> list = new ArrayList<Predicate>();
				
				/*//2.根据QueryDTO数据字段的值进行判断以及条件的组装
				if(userQueryDTO != null && !StringUtils.isEmpty(userQueryDTO.getUserName())) {
					Predicate p1 = cb.like(root.get("userName").as(String.class),"%"+userQueryDTO.getUserName()+"%");
					list.add(p1);
				}
				if(userQueryDTO != null && !StringUtils.isEmpty(userQueryDTO.getPassword())) {
					Predicate p2 = cb.like(root.get("password").as(String.class),"%"+userQueryDTO.getPassword()+"%");
					list.add(p2);
				}*/
				//3.Predicate查询条件集合的size创建对应的Predicate查询条件数组
				Predicate[] p = new Predicate[list.size()];
				//4.CirteriaBuilder的and函数组装  查询条件数组
				return cb.and(list.toArray(p));				
			}
		};		
		return spec;
	}
	@Override
	public String toString() {
		return "UserRoleQueryDTO [id=" + id + ", userId=" + userId + ", roleId=" + roleId + ", userName=" + userName
				+ ", roleName=" + roleName + ", deptName=" + deptName + ", userNo=" + userNo + ", password=" + password
				+ ", userNickName=" + userNickName + ", sex=" + sex + ", birthday=" + birthday + ", age=" + age
				+ ", nativePlace=" + nativePlace + ", nation=" + nation + ", culture=" + culture + ", college="
				+ college + ", body=" + body + ", marriage=" + marriage + ", idCord=" + idCord + ", phone=" + phone
				+ ", familyPhone=" + familyPhone + ", email=" + email + ", userAccount=" + userAccount + ", remark="
				+ remark + "]";
	}
	

	
	
}
