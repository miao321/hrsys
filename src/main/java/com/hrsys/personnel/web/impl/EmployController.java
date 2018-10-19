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
import com.hrsys.personnel.dao.DTO.EmployQueryDTO;
import com.hrsys.personnel.entity.Employ;
import com.hrsys.personnel.service.IEmployService;
import com.hrsys.personnel.web.IEmployController;

/**
 * 人事模块-职工类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/personnel/employ")
public class EmployController implements IEmployController {
	
	@Autowired
	private IEmployService employService;

	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Employ employ) {
		try {
			employService.saveOrUpdate(employ);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public ExtAjaxResponse delete(@RequestParam Integer id) {
		try {
			Employ employ = employService.findOne(id);
			if (employ != null) {
				employService.delete(employ);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/deleteEmploys")
	@ResponseBody
	public ExtAjaxResponse deleteEmploys(@RequestParam Integer[] ids) {
		try {
			List<Integer> idLists = Arrays.asList(ids);
			if (null != idLists) {
				employService.delete(idLists);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/findOne")
	@ResponseBody
	public Employ findOne(@RequestParam Integer id) {
		return employService.findOne(id);
	}

	@RequestMapping(value = "/findAll")
	@ResponseBody
	public List<Employ> findAll() {
		return employService.findAll();
	}

	@RequestMapping(value = "/findByPage")
	@ResponseBody
	public Page<Employ> findByPage(EmployQueryDTO employQueryDTO, ExtPageable pageable) {
//		pageable.setPage(1);
		return employService.findAll(EmployQueryDTO.getSpecification(employQueryDTO), pageable.getPageable());
	}

	@RequestMapping(value = "/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		HSSFWorkbook workbook = employService.downloadExcel();
		if(workbook != null) {
			try {
				OutputStream output = response.getOutputStream();
				response.reset();  
				response.setHeader("Content-disposition", "attachment; filename=employ.xls");  
				response.setContentType("application/msexcel");          
				workbook.write(output);  
				output.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
