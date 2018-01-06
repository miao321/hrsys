package com.hrsys.train.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.hrsys.train.entity.TrainExecute;

/**
 * 培训实施类Dao层
 * @author Administrator
 *
 */

@Repository
public interface ITrainExecuteDao extends PagingAndSortingRepository<TrainExecute, Long>, JpaSpecificationExecutor<TrainExecute> {

}