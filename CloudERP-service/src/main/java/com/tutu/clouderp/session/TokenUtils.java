package com.tutu.clouderp.session;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.tutu.clouderp.dto.auth.User;


public class TokenUtils
{

	public static final String MAGIC_KEY = "obfuscate";


	public static String createToken(User user)
	{
		/* Expires in one hour */
		long expires = System.currentTimeMillis() + 1000L * 60 * 60;

		StringBuilder tokenBuilder = new StringBuilder();
		tokenBuilder.append(user.getName());
		tokenBuilder.append(":");
		tokenBuilder.append(expires);
		tokenBuilder.append(":");
		tokenBuilder.append(TokenUtils.computeSignature(user, expires));

		return tokenBuilder.toString();
	}


	public static String computeSignature(User user, long expires)
	{
		StringBuilder signatureBuilder = new StringBuilder();
		signatureBuilder.append(user.getName());
		signatureBuilder.append(":");
		signatureBuilder.append(expires);
		signatureBuilder.append(":");
		signatureBuilder.append(user.getPassword());
		signatureBuilder.append(":");
		signatureBuilder.append(TokenUtils.MAGIC_KEY);

		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException("No MD5 algorithm available!");
		}

		return new String(Hex.encode(digest.digest(signatureBuilder.toString().getBytes())));
	}


	public static String getUserNameFromToken(String authToken)
	{
		if (null == authToken) {
			return null;
		}

		String[] parts = authToken.split(":");
		return parts[0];
	}


	public static boolean validateToken(String authToken, User user)
	{
		String[] parts = authToken.split(":");
		long expires = Long.parseLong(parts[1]);
		String signature = parts[2];

		if (expires < System.currentTimeMillis()) {
			return false;
		}

		return signature.equals(TokenUtils.computeSignature(user, expires));
	}
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
//		System.out.println("676f6e6731393837333137".equals(new String(Hex.encode("gong1987317".getBytes()))));
		System.out.println(PwdUtils.eccrypt("000000"));
//		System.out.println(Hex.decode("676f6e6731393837333137").toString());
//		User user=new User();
//		user.setEmail("gongxinong@gmail.com");
//		user.setPassword("676f6e6731393837333137");
//		//System.out.println(createToken(user));
//		System.out.println(validateToken("gongxinong@gmail.com:1416665304595:e493ddfbc9979d2f093dfa13cabb7ff3", user));
	}
}