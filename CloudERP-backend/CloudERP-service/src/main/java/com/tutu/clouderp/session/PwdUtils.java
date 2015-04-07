package com.tutu.clouderp.session;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PwdUtils {
	private static MessageDigest md;
	/**
	 * md5加密
	 * @param info
	 * @return
	 * @throws NoSuchAlgorithmException
	 */
	public static String eccrypt(String pass) throws NoSuchAlgorithmException{  
		md = MessageDigest.getInstance("MD5");
        byte[] passBytes = pass.getBytes();
        md.reset();
        byte[] digested = md.digest(passBytes);
        StringBuffer sb = new StringBuffer();
        for(int i=0;i<digested.length;i++){
            sb.append(Integer.toHexString(0xff & digested[i]));
        }
        return sb.toString();
    }
}
