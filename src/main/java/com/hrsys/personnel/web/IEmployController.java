package com.hrsys.personnel.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.data.domain.Page;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.personnel.dao.DTO.EmployQueryDTO;
import com.hrsys.personnel.entity.Employ;

/**
 * 人事模块-职工类控制层接口
 * @author Lofu
 */
public interface IEmployController {
	
	/** 插入或更改职工数据 */
	public ExtAjaxResponse saveOrUpdate(Employ employ);
	
	/** 删除某个职工数据 */
	public ExtAjaxResponse delete(Integer id);
	
	/** 根据id删除职工数据 */
	public ExtAjaxResponse deleteEmploys(Integer[] ids);
	
	/** 根据id查找职工数据 */
	public Employ findOne(Integer id);
	
	/** 查找全部职工数据 */
	public List<Employ> findAll();
	
	/** 高级查询职工数据 */
	public Page<Employ> findByPage(EmployQueryDTO employQueryDTO, ExtPageable pageable);
	
	/** 下载职工数据的Excel数据报表 */
	public void downloadExcel(HttpServletResponse response);
}
