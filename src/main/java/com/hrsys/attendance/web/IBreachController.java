package com.hrsys.attendance.web;

import java.util.List;

import org.springframework.data.domain.Page;

import com.hrsys.attendance.dao.DTO.BreachQueryDTO;
import com.hrsys.attendance.entity.Breach;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;

/**
 * 考勤模块-违规记录类控制层接口
 * @author Lofu
 */
public interface IBreachController {
	/** 插入一些测试数据 */
	public String insertTestDate();
	
	/** 插入或更改违规记录数据 */
	public ExtAjaxResponse saveOrUpdate(Breach breach);
	
	/** 删除违规记录数据 */
	public ExtAjaxResponse delete(Integer id);
	
	/** 根据id删除违规记录数据 */
	public ExtAjaxResponse deleteBreachs(Integer[] ids);
	
	/** 根据id查找违规记录数据 */
	public Breach findOne(Integer id);
	
	/** 查找全部违规记录数据 */
	public List<Breach> findAll();
	
	/** 高级查询违规记录数据 */
	public Page<Breach> findByPage(BreachQueryDTO breachQueryDTO, ExtPageable pageable);
}
