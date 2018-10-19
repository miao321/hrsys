package com.hrsys.train.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.hrsys.train.entity.TrainCourse;
import com.hrsys.train.entity.TrainMaterial;



/**
 * 培训材料类Dao层
 * @author Administrator
 *
 */

@Repository
public interface ITrainMaterialDao extends PagingAndSortingRepository<TrainMaterial, Long>, JpaSpecificationExecutor<TrainMaterial> {
	@Query("select new map(count(t.trainMaterialSource) as trainMaterialSourceNum,t.trainMaterialSource as trainMaterialSource) from TrainMaterial t group by t.trainMaterialSource")
	public List<TrainMaterial> findByTrainMaterialNum();
}