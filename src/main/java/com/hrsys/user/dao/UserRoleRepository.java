package com.hrsys.user.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.user.entity.UserRole;
@Repository 
public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long>,JpaSpecificationExecutor<UserRole> {
	/*@Query("from User user where user.userName =?1")
	public User findUser(String userName);
	@Query("from User user where user.userName = ?1 and user.password = ?2")
	public User findUser(String userName,String password);
	@Modifying
	@Query("update User user set user.password = ?2 where user.id = ?1")
	public void updateUser(Long id,String comfirPassword);*/
	
	/*public User getByUserName(String userName);
	public Set<String> getRoles(String userName);
    public Set<String> getPermissions(String userName);*/
}
