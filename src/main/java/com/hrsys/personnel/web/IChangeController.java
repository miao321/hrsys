package com.hrsys.personnel.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.personnel.dao.DTO.ChangeQueryDTO;
import com.hrsys.personnel.entity.Change;

/**
 * 人事模块-人事变动类控制层接口
 * @author Lofu
 */
public interface IChangeController {
	
	/** 插入或更改人事变动数据 */
	public ExtAjaxResponse saveOrUpdate(Change change);
	
	/** 删除某个人事变动数据 */
	public ExtAjaxResponse delete(Integer id);
	
	/** 根据id删除人事变动数据 */
	public ExtAjaxResponse deleteChanges(Integer[] ids);
	
	/** 根据id查找人事变动数据 */
	public Change findOne(Integer id);
	
	/** 查找全部人事变动数据 */
	public List<Change> findAll();
	
	/** 高级查询人事变动数据 */
	public Page<Change> findByPage(ChangeQueryDTO changeQueryDTO, ExtPageable pageable);
	
	/** 下载人事变动数据的Excel数据报表 */
	public void downloadExcel(HttpServletResponse response);
}
