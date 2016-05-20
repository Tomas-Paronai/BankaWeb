package com.parohyapp.api;

import java.util.Random;

public class HashGen {
	
	public static String getCodedId(String id){
		int lenght = id.length();
		StringBuilder builder = new StringBuilder();
		for(int i = 1; i <= 5; i++){
			builder.append(randInt(0,9));
		}
		builder.append(lenght);
		builder.append(id);
		for(int i = 1; i <= 5; i++){
			builder.append(randInt(0,9));
		}
		return builder.toString();
	}
	
	public static String getDecodedId(String code){
		if(code.length()<6){
			return "4";
		}
		int val = code.charAt(5) - '0';
		StringBuilder builder = new StringBuilder();
		for(int i = 6; i < 6 + val; i++){
			builder.append(code.charAt(i));
		}
		return builder.toString();
	}
	
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}
}
