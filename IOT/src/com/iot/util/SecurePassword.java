package com.iot.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

public class SecurePassword {

	public static void main(String args[]) throws NoSuchAlgorithmException, NoSuchProviderException{
		String password="ritesh";
		
		String securePassword = getPassword(password);
        System.out.println(securePassword); //Prints 83ee5baeea20b6c21635e4ea67847f66
         
        String regeneratedPassowrdToVerify = getPassword(password);
        System.out.println(regeneratedPassowrdToVerify); //Prints 83ee5baeea20b6c21635e4ea67847f66
	}
	
	public static String getPassword(String password) throws NoSuchAlgorithmException, NoSuchProviderException{
		String generatePassword = null;
//		byte[] salt = getsalt();
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(password.getBytes());
			byte[] bytes = md.digest();
			StringBuilder str = new StringBuilder();
			for(int i=0;i<bytes.length;i++){
				str.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			generatePassword = str.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return generatePassword;
		
	}
}
