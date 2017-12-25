package com.hrsys.user.service;


import org.hibernate.boot.model.source.spi.PluralAttributeElementSourceBasic;

import com.hrsys.common.ExtAjaxResponse;

public interface ILoginService {
	//登录注销、修改密码
	public ExtAjaxResponse login(String userName,String password);
	public ExtAjaxResponse changePassword(Long id,String password,String comfirPassword);
	public ExtAjaxResponse logout();
	public boolean isLogined();

}
