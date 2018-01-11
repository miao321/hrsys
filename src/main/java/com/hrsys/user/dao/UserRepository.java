package com.hrsys.user.dao;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.hrsys.common.ExtJsonResult;
import com.hrsys.user.entity.User;
import com.hrsys.user.entity.UserRole;
import com.hrsys.user.entity.dto.UserRoleQueryDTO;
@Repository 
public interface UserRepository extends PagingAndSortingRepository<User, Long>,JpaSpecificationExecutor<User> {
	@Query("from User user where user.userName =?1")
	public User findUser(String userName);
	@Query("from User user where user.userName = ?1 and user.password = ?2")
	public User findUser(String userName,String password);
	@Modifying
	@Query("update User user set user.password = ?2 where user.id = ?1")
	public void updateUser(Long id,String comfirPassword);
	
	
	@Query(value="select u.userName,u.deptName,r.roleName,u.userNo,u.password,u.userNickName,"
			+ "u.sex,u.birthday,u.age,u.nativePlace,u.nation,u.culture,u.college,u.body,u.marriage, "
			+ "u.idCord,u.phone,u.familyPhone,u.email,u.userAccount,u.remark from t_user as u left join t_user_role as ur on u.id=ur.userId left join t_role as r on r.id=ur.roleId",nativeQuery=true)
	public List<Object[]> findUserRole();
	
	@Query(value="select u.userName,u.deptName,r.roleName,u.userNo,u.password,u.userNickName,"
			+ "u.sex,u.birthday,u.age,u.nativePlace,u.nation,u.culture,u.college,u.body,u.marriage, "
			+ "u.idCord,u.phone,u.familyPhone,u.email,u.userAccount,u.remark from t_user as u left join t_user_role as ur on u.id=ur.userId left join t_role as r on r.id=ur.roleId",nativeQuery=true)
	public List<Object[]> findUserRole2();
	
	
}
