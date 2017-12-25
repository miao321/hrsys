package com.hrsys.attendance.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.attendance.entity.Break;

/**
 * 考勤模块-违规记录数据访问层
 * @author Lofu
 */
@Repository
public interface IBreakDao extends PagingAndSortingRepository<Break,Integer>,JpaSpecificationExecutor<Break> {

}
