package com.hrsys.attendance.web.impl;

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

import com.hrsys.attendance.dao.DTO.BreachQueryDTO;
import com.hrsys.attendance.entity.Breach;
import com.hrsys.attendance.service.IBreachService;
import com.hrsys.attendance.web.IBreachController;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;

/**
 * 考勤模块-违规记录类控制器实现类
 * @author Lofu
 */
@Controller
@RequestMapping(value = "/attendance/breach")
public class BreachController implements IBreachController {
	
	@Autowired
	private IBreachService breachService;

	@RequestMapping(value = "/saveOrUpdate")
	@ResponseBody
	public ExtAjaxResponse saveOrUpdate(Breach breach) {
		try {
			breachService.saveOrUpdate(breach);
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/delete")
	@ResponseBody
	public ExtAjaxResponse delete(@RequestParam Integer id) {
		try {
			Breach breach = breachService.findOne(id);
			if (breach != null) {
				breachService.delete(breach);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/deleteBreachs")
	@ResponseBody
	public ExtAjaxResponse deleteBreachs(@RequestParam Integer[] ids) {
		try {
			List<Integer> idLists = Arrays.asList(ids);
			if (null != idLists) {
				breachService.delete(idLists);
			}
			return new ExtAjaxResponse(true, "操作成功！");
		} catch (Exception e) {
			return new ExtAjaxResponse(false, "操作失败！");
		}
	}

	@RequestMapping(value = "/findOne")
	@ResponseBody
	public Breach findOne(@RequestParam Integer id) {
		return breachService.findOne(id);
	}

	@RequestMapping(value = "/findAll")
	@ResponseBody
	public List<Breach> findAll() {
		return breachService.findAll();
	}

	@RequestMapping(value = "/findByPage")
	@ResponseBody
	public Page<Breach> findByPage(BreachQueryDTO breachQueryDTO, ExtPageable pageable) {
//		pageable.setPage(1);
		return breachService.findAll(BreachQueryDTO.getSpecification(breachQueryDTO), pageable.getPageable());
	}
	
	@RequestMapping(value = "/downloadExcel")
	public void downloadExcel(HttpServletResponse response) {
		HSSFWorkbook workbook = breachService.downloadExcel();
		if(workbook != null) {
			try {
				OutputStream output = response.getOutputStream();
				response.reset();  
				response.setHeader("Content-disposition", "attachment; filename=breach.xls");  
				response.setContentType("application/msexcel");          
				workbook.write(output);  
				output.close();  
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
	}
}
