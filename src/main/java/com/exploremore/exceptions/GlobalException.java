package com.exploremore.exceptions;

public class GlobalException extends Exception{


	String msg;
	public GlobalException(String msg) {
		this.msg = "Service Error!";
	}
	@Override
	public String getMessage() {
		return this.msg;
	}
}
