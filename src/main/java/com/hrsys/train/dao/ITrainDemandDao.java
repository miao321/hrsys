package com.hrsys.train.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.hrsys.train.entity.TrainDemand;

/**
 * 培训需求类Dao层
 * @author Administrator
 *
 */

@Repository
public interface ITrainDemandDao extends PagingAndSortingRepository<TrainDemand, Long>, JpaSpecificationExecutor<TrainDemand> {

}