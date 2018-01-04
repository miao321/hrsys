package com.hrsys.common;

import java.util.List;

public class ExtJsonResult<T> {
	private List<T> lists;
	public ExtJsonResult(List<T> lists) {		
		this.lists = lists;
	}
	public List<T> getLists() {
		return lists;
	}
}
