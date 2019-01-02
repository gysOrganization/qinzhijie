package com.qzj.commos.vo;

import java.io.Serializable;

public class ResponseData<T> implements Serializable {
	private static final long serialVersionUID = 6655375642712424217L;

	private String code;

	private String message;

	private T data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
