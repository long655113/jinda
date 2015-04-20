package com.trustel.common;

import java.io.UnsupportedEncodingException;

/**
 * @author Administrator
 *
 * �ַ�����ת����
 */
public class CharsetConverter {
	/**
	 * ��GBKת��ΪUnicode
	 * 
	 * @param source �����ַ���
	 * @return ����ַ���
	 */
	public static String fromGBKtoUnicode(String source) {	
		return transcode(source, "GBK", "ISO-8859-1");
	}
	
	/**
	 * ��Unicodeת��ΪGBK
	 * 
	 * @param source �����ַ���
	 * @return ����ַ���
	 */
	public static String fromUnicodetoGBK(String source) {	
		return transcode(source, "ISO-8859-1", "GBK");
	}
	
	/**
	 * ��UTF-8ת��ΪUnicode
	 * 
	 * @param source �����ַ���
	 * @return ����ַ���
	 */
	public static String fromUTF8toUnicode(String source) {		
		return transcode(source, "UTF-8", "ISO-8859-1");
	}
	
	/**
	 * ��Unicodeת��ΪUTF-8
	 * 
	 * @param source �����ַ���
	 * @return ����ַ���
	 */
	public static String fromUnicodetoUTF8(String source) {		
		return transcode(source, "ISO-8859-1", "UTF-8");
	}
	
	/**
	 * ת���ַ���
	 * 
	 * @param source �����ַ���
	 * @param fromCharSet Դ�ַ���
	 * @param toCharSet Ŀ���ַ���
	 * @return ����ַ���
	 */
	public static String transcode(String source, String fromCharSet, String toCharSet) {
		String dest = null;
		try {
			dest = new String(source.getBytes(fromCharSet), toCharSet);
		} catch (UnsupportedEncodingException e) {
			dest = e.getMessage();
		}
		
		return dest;
	}
}
