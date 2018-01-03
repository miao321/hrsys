package com.hrsys.user.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.omg.CORBA.PRIVATE_MEMBER;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hrsys.system.entity.Dept;
import com.hrsys.system.entity.Permission;
import com.hrsys.system.entity.Role;
@Entity
@Table(name="t_user")
public class User implements Serializable {
	private Long id;
	private String userNo;//职员编号
	private String userName;//用户姓名
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
	private Integer deptId;//部门编号
	private String roleName;  //角色名
	private String remark;//备注
	
	private List<UserRole> userRoles = new ArrayList<UserRole>();
	private List<Permission> permissions = new ArrayList<Permission>();
	//private Dept dept;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	@JsonIgnore
	public List<UserRole> getUserRoles() {
		return userRoles;
	}
//	@ManyToOne(cascade=CascadeType.ALL)
//	@JsonIgnore
//	public Dept getDept() {
//		return dept;
//	}
	@ManyToMany(cascade=CascadeType.ALL,mappedBy="user")
	@JsonIgnore
	public List<Permission> getPermissions() {
		return permissions;
	}
	
	public String getUserNo() {
		return userNo;
	}	
	public String getUserName() {
		return userName;
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
	public Integer getDeptId() {
		return deptId;
	}
	public String getRemark() {
		return remark;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	
//	public void setDept(Dept dept) {
//		this.dept = dept;
//	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", userNo=" + userNo + ", userName=" + userName + ", password=" + password
				+ ", userNickName=" + userNickName + ", sex=" + sex + ", birthday=" + birthday + ", age=" + age
				+ ", nativePlace=" + nativePlace + ", nation=" + nation + ", culture=" + culture + ", college="
				+ college + ", body=" + body + ", marriage=" + marriage + ", idCord=" + idCord + ", phone=" + phone
				+ ", familyPhone=" + familyPhone + ", email=" + email + ", userAccount=" + userAccount + ", deptId="
				+ deptId + ", remark=" + remark + "]";
	}
	
	

}
