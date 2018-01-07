package com.hrsys.user.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrsys.annotation.SysLog;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtJsonResult;
import com.hrsys.common.util.DateUtil;
import com.hrsys.user.dao.UserRepository;
import com.hrsys.user.entity.User;
import com.hrsys.user.entity.dto.UserRoleQueryDTO;
import com.hrsys.user.service.IUserService;
@Service
@Transactional
public class UserServiceImpl implements IUserService {
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	@Autowired
	private UserRepository userRepository;
	@SysLog(module="用户管理",methods="保存或者更新数据")
	public void saveOrUpdate(User user) {
		userRepository.save(user);		
	}
	@SysLog(module="用户管理",methods="删除一条数据")
	public void delete(User user) {
		userRepository.delete(user);	
	}
	@SysLog(module="用户管理",methods="删除多条数据")
	public void delete(List<Long> ids) {
		List<User> users = (List<User>) userRepository.findAll(ids);
		if (users != null) {
			userRepository.delete(users);
		}		
	}
	@SysLog(module="用户管理",methods="查找一条数据")
	@Transactional(readOnly = true)
	public User findOne(Long id) {
		return userRepository.findOne(id);
	}
	@SysLog(module="用户管理",methods="查找多条数据")
	@Transactional(readOnly = true)
	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}
	@SysLog(module="用户管理",methods="查找多条数据并分页排序")
	public Page<User> findAll(Specification<User> spec, Pageable pageable) {
		return userRepository.findAll(spec, pageable);
	}
	@SysLog(module="用户管理",methods="修改个人信息")
	public List<UserRoleQueryDTO> findUserRole() {
		List<UserRoleQueryDTO>  list = new ArrayList<UserRoleQueryDTO>();
		List<Object[]> userRole = userRepository.findUserRole();
		for(Object[] obj : userRole) {
			UserRoleQueryDTO dto = new UserRoleQueryDTO();			
			dto.setId(Long.parseLong(obj[0].toString()));
			dto.setUserName(obj[1]+"");
			dto.setDeptName(obj[2]+"");
			dto.setRoleName(obj[3]+"");
			dto.setUserNo(obj[4]+"");
			dto.setPassword(obj[5]+"");
			dto.setUserNickName(obj[6]+"");
			dto.setSex(obj[7]+"");
			//dto.setBirthday(DateUtil.StringToHMS(obj[8].toString()));
			//dto.setAge(Integer.valueOf(obj[9].toString()));
			dto.setNativePlace(obj[10]+"");
			dto.setNation(obj[11]+"");
			dto.setCulture(obj[12]+"");
			dto.setCollege(obj[13]+"");
			dto.setBody(obj[14]+"");
			dto.setMarriage(obj[15]+"");
			dto.setIdCord(obj[16]+"");
			dto.setPhone(obj[17]+"");
			dto.setFamilyPhone(obj[18]+"");
			dto.setEmail(obj[19]+"");
			dto.setUserAccount(obj[20]+"");
			dto.setRemark(obj[21]+"");
			
			System.out.println(dto);
			list.add(dto);
		}
		
		 
		return list;
	}
	@Override
	public List<User> find(String hql, Class<User> class1, String[] strings) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
