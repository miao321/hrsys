package com.hrsys.employ.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.employ.entity.EmployChannel;



/**
 * 招聘渠道类Dao层
 * @author Administrator
 *
 */

@Repository
public interface IEmployChannelDao extends PagingAndSortingRepository<EmployChannel,Long>, JpaSpecificationExecutor<EmployChannel> {
	@Query("select distinct new map(e.employChannelName as employChannelName) from EmployChannel e")
	public List<EmployChannel> findByEmployChannel();
	
	//培训课程对象数目统计
	@Query("select new map(count(t.employChannelName) as employChannelNameNum,t.employChannelName as employChannelName) from EmployChannel t group by t.employChannelName")
	public List<EmployChannel> findByEmployChannelNum();

	
}
