package com.hrsys.train.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.train.entity.TrainMaterial;



/**
 * 培训材料类Dao层
 * @author Administrator
 *
 */

@Repository
public interface ITrainMaterialDao extends PagingAndSortingRepository<TrainMaterial, Long>, JpaSpecificationExecutor<TrainMaterial> {

}