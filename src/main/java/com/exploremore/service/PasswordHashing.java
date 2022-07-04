package com.exploremore.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
	
	public static String doHashing (String password)  {
		
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(password.getBytes());
			byte[] result = md.digest();
			StringBuilder sb = new StringBuilder();
			for(byte b : result) {
				sb.append(String.format("%02x", b));
			}
			return sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return "";
	}
}
