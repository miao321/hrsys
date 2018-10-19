package com.hrsys.personnel.web.impl;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.personnel.dao.DTO.PdeptQueryDTO;
import com.hrsys.personnel.entity.Pdept;
import com.hrsys.personnel.service.IPdeptService;
import com.hrsys.personnel.web.IPdeptController;

/**
 * 人事模块-部门类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/personnel/dept")
public class PdeptController implements IPdeptController {
	
	@Autowired
	private IPdeptService deptService;

	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Pdept dept) {
		try {
			deptService.saveOrUpdate(dept);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public ExtAjaxResponse delete(@RequestParam Integer id) {
		try {
			Pdept dept = deptService.findOne(id);
			if (dept != null) {
				deptService.delete(dept);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/deleteDepts")
	@ResponseBody
	public ExtAjaxResponse deleteDepts(@RequestParam Integer[] ids) {
		try {
			List<Integer> idLists = Arrays.asList(ids);
			if (null != idLists) {
				deptService.delete(idLists);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/findOne")
	@ResponseBody
	public Pdept findOne(@RequestParam Integer id) {
		return deptService.findOne(id);
	}

	@RequestMapping(value = "/findAll")
	@ResponseBody
	public List<Pdept> findAll() {
		return deptService.findAll();
	}

	@RequestMapping(value = "/findByPage")
	@ResponseBody
	public Page<Pdept> findByPage(PdeptQueryDTO deptQueryDTO, ExtPageable pageable) {
//		pageable.setPage(1);
		return deptService.findAll(PdeptQueryDTO.getSpecification(deptQueryDTO), pageable.getPageable());
	}

	@RequestMapping(value = "/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		HSSFWorkbook workbook = deptService.downloadExcel();
		if(workbook != null) {
			try {
				OutputStream output = response.getOutputStream();
				response.reset();  
				response.setHeader("Content-disposition", "attachment; filename=dept.xls");  
				response.setContentType("application/msexcel");          
				workbook.write(output);  
				output.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
