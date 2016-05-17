package com.parohyapp.api;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.parohyapp.database.ErrorCode;

public class HashGen {
	
	public static String getHash(String orig){
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(orig.getBytes());
			byte[] resBytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i< resBytes.length ;i++)
            {
                sb.append(Integer.toString((resBytes[i] & 0xff) + 0x100, 16).substring(1));
            }
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {			
			e.printStackTrace();
			return orig;
		}
	}
	
	public static int findUserId(String hash){
		for(int i = 1000; i < 2500; i++){
			if(hash.equals(getHash(String.valueOf(i)))){
				return i;
			}
		}
		return ErrorCode.NO_SUCH_USER.getCode();
	}
}
