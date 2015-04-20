package com.trustel.common;

import java.security.MessageDigest;

/**
 * @author Administrator
 *
 * MD5加密算法实现类
 */
public class MD5Implementor {
	/**
	 * 生成MD5字符串
	 * 
	 * @param origin 原始字符串
	 * @return 加密字符串
	 */
	public static String MD5Encode(String origin) {
		String resultString = null;

		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString =
				ByteFunc.getInstance().byteArrayToHexString(md.digest(resultString.getBytes()));
		} catch (Exception ex) {

		}

		return resultString;
	}
	
	/**
	 * 生成MD5字符串
	 * 
	 * @param origin 原始字符串
	 * @param hasBlackSpace 加密后的字符串是否包含空格(为了兼容以前的包含空格方法)
	 * @return 加密字符串
	 */
	public static String MD5Encode(String origin,boolean hasBlackSpace) {
		String result = MD5Encode(origin);
		if (hasBlackSpace) {
			return result;
		}else {
			return result==null?null:result.replaceAll(" ", "");
		}
	}
	
	/**
	 * 将pass密码进行二次加密
	 * @param pass	加密前的密码
	 * @param salt	密钥
	 * @param hasBlackSpace	是否包含空格
	 * @return		加密后的密码
	 */
	public static String MD5Encode2(String pass,String salt,boolean hasBlackSpace) {
		String result = null;
		if (hasBlackSpace) {
			result = MD5Encode(pass);
			result = MD5Encode(result+salt);
		}else {
			result = MD5Encode(pass,false);
			result = MD5Encode(result+salt,false);
		}
		return result;
	}
	
	

	/**
	 * 生成MD5字节串
	 * @param origin 原始字节串
	 * @return 加密字节串
	 */
	public static byte[] MD5Encode(byte[] origin) {
		byte[] resultBytes = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultBytes = md.digest(origin);
		} catch (Exception ex) {

		}

		return resultBytes;
	}
	public static void main(String[] args) {
		String pasString="qwe123"; 
		String salt="MYut6xsb";
		String encPaString = MD5Encode2(pasString, salt, false);
		System.out.println(encPaString);
	}
}
