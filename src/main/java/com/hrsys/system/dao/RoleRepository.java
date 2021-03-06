package com.hrsys.system.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Repository;

import com.hrsys.system.entity.Role;
import com.hrsys.system.entity.dto.RolePermissionQueryDTO;
import com.hrsys.user.entity.User;

@Repository
public interface RoleRepository extends PagingAndSortingRepository<Role, Long>,JpaSpecificationExecutor<Role> {
	@Query(value="select p.url,r.roleName,r.remark,r.orderNo,r.createModule,r.createBy,r.createTime,r.updateBy,r.updateTime from t_role as r left join t_permission_t_role as pr on r.id=pr.role_id left join t_permission as p on p.id=pr.permission_id",nativeQuery=true)
	public List<Object[]> findRolePermission();
	
	@Query(value="select r.id,p.url from t_permission as p left join t_permission_t_role as pr on p.id=pr.permission_id left join t_role as r on r.id=pr.role_id",nativeQuery=true)
	public List<Object[]> findPermission();
	
	@Query("from Role role where role.roleName =?1")
	public Role findRole(String roleName);
}
