package com.hrsys.common;

import com.hrsys.user.entity.User;

public class ExtAjaxResponse 
{
	private boolean success= true;
	private String msg= "";
	private User us;
	public ExtAjaxResponse() {}
	
	public ExtAjaxResponse(boolean success) {
		this.success = success;
	}
	
	public ExtAjaxResponse(boolean success,String msg) {
		this.success = success;
		this.msg = msg;
	}
	public ExtAjaxResponse(boolean success,User us) {
		this.success = success;
		this.us = us;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public String getMsg() {
		return msg;
	}

	public User getUs() {
		return us;
	}
	
}
