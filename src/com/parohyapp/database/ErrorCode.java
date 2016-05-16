package com.parohyapp.database;

public enum ErrorCode {
	
	INVALID_ACCESS("Wrong login",1),
	ACCOUNT_BLOCKED("Your account has been blocked",2);
	
	private final String message;
	private final int code;
	
	private ErrorCode(final String message, final int code){
		this.message = message;
		this.code = code;
	}

	@Override
	public String toString() {
		return message;
	}
	
	public int getCode(){
		return code;
	}
}
