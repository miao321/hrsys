package com.hrsys.user.web;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrsys.common.EncryptUtils;
import com.hrsys.common.ExtAjaxResponse;
import com.hrsys.common.ExtPageable;
import com.hrsys.user.entity.UserRole;
import com.hrsys.user.entity.dto.UserRoleQueryDTO;
import com.hrsys.user.service.ILoginService;
import com.hrsys.user.service.IUserRoleService;


@Controller
@RequestMapping("/userRole")
public class UserRoleController {
	private static final Logger logger = LoggerFactory.getLogger(UserRoleController.class);
	@Autowired
	private IUserRoleService userRoleService;	
	@RequestMapping("/save")//@RequestParam Long roleId,@RequestParam Long userId
	public @ResponseBody ExtAjaxResponse save(UserRoleQueryDTO userRole) {
		//try {			
			userRoleService.saveOrUpdate(userRole);
			return new ExtAjaxResponse(true, "操作成功");
		//} catch (Exception e) {
		//	return new ExtAjaxResponse(false, "操作失败");
		//}	
	}		
}
