package com.hrsys.user.service;


import org.hibernate.boot.model.source.spi.PluralAttributeElementSourceBasic;


import com.hrsys.user.entity.User;

public interface ILoginService {
	//登录注销、修改密码
	public User login(String userName,String password);
	public void changePassword(Long id,String password,String comfirPassword);
	public User logout();
	public boolean isLogined();
	public User findUser(String userName); 

}
