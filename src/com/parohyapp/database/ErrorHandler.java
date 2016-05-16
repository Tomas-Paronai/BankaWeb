package com.parohyapp.database;

public class ErrorHandler {
	
	public static String findError(int code){
		for(ErrorCode tmpE : ErrorCode.values()){
			if(tmpE.getCode() == code){
				return tmpE.toString();
			}
		}
		return "Uknown error code: "+code;
	}
}
