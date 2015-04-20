package com.trustel.common;

import java.security.MessageDigest;

/**
 * @author Administrator
 *
 * MD5�����㷨ʵ����
 */
public class MD5Implementor {
	/**
	 * ����MD5�ַ���
	 * 
	 * @param origin ԭʼ�ַ���
	 * @return �����ַ���
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
	 * ����MD5�ַ���
	 * 
	 * @param origin ԭʼ�ַ���
	 * @param hasBlackSpace ���ܺ���ַ����Ƿ�����ո�(Ϊ�˼�����ǰ�İ����ո񷽷�)
	 * @return �����ַ���
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
	 * ��pass������ж��μ���
	 * @param pass	����ǰ������
	 * @param salt	��Կ
	 * @param hasBlackSpace	�Ƿ�����ո�
	 * @return		���ܺ������
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
	 * ����MD5�ֽڴ�
	 * @param origin ԭʼ�ֽڴ�
	 * @return �����ֽڴ�
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
