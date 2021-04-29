package com.sapient.graphql.exceptions;

import lombok.Getter;

@Getter
public class ApiException extends Exception{

	private static final long serialVersionUID = 1L;
	private final int code;
	private final String message;
	
	public ApiException(int code, String message) {
		this.code=code;
		this.message= message;
	}
	
}
