package com.hrsys.train.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


import com.hrsys.train.entity.TrainPersonal;

/**
 * 个人培训记录类Dao层
 * @author Administrator
 *
 */

@Repository
public interface ITrainPersonalDao extends PagingAndSortingRepository<TrainPersonal, Long>, JpaSpecificationExecutor<TrainPersonal> {

}