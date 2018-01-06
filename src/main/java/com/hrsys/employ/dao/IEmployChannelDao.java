package com.hrsys.employ.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
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

}
