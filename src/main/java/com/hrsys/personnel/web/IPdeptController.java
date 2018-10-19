package com.hrsys.personnel.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.personnel.dao.DTO.PdeptQueryDTO;
import com.hrsys.personnel.entity.Pdept;

/**
 * 人事模块-部门类控制层接口
 * @author Lofu
 */
public interface IPdeptController {
	
	/** 插入或更改部门数据 */
	public ExtAjaxResponse saveOrUpdate(Pdept dept);
	
	/** 删除某个部门数据 */
	public ExtAjaxResponse delete(Integer id);
	
	/** 根据id删除部门数据 */
	public ExtAjaxResponse deleteDepts(Integer[] ids);
	
	/** 根据id查找部门数据 */
	public Pdept findOne(Integer id);
	
	/** 查找全部部门数据 */
	public List<Pdept> findAll();
	
	/** 高级查询部门数据 */
	public Page<Pdept> findByPage(PdeptQueryDTO deptQueryDTO, ExtPageable pageable);
	
	/** 下载部门数据的Excel数据报表 */
	public void downloadExcel(HttpServletResponse response);
}
