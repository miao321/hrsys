package com.hrsys.common;

import java.util.List;

public class ExtJason<T> {
	private List<T> result;

	public List<T> getResult() {
		return result;
	}
	public void setResult(List<T> result) {
		this.result = result;
	}

	public ExtJason(List<T> result) {
		super();
		this.result = result;
	}
}
