package com.trustel.common;

/**
 * @author Administrator
 *
 * �ַ��������ַ�ת����
 */
public class StringMarkuper {
	/**
	 * ���ַ����е�xml�����ֽ���ת�������µ��ַ���
	 * <p>
	 * Ϊ���������а���xml�Ĺؼ���(��"<"��">"��)Ӱ��xml�����������ݴ������ݿ�ǰ�Ƚ�������ת��Ϊ�����ַ���
	 * xml�����ݿ���ȡ���󽫽����������ݾ���ԭ������ԭΪԭʼ���ݡ�
	 * 
	 * @param text �ַ���
	 * @return ���ַ�ת�����ַ���
	 */
	public static String markup(String text) {
		if (text == null) {
			return null;
		}

		StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			switch (c) {
				case '<' :
					buffer.append("&lt;");
					break;
				case '&' :
					buffer.append("&amp;");
					break;
				case '>' :
					buffer.append("&gt;");
					break;
				case '"' :
					buffer.append("&quot;");
					break;
				case '\'' :
					buffer.append("&apos;");
					break;
				default :
					buffer.append(c);
					break;
			}
		}

		return buffer.toString();
	}

	/**
	 * �������ַ�ת������ַ������з������ظ�ԭʼ����
	 * 
	 * @param text �ַ���
	 * @return ����ָ�����ַ���
	 */
	public static String restore(String text) {
		if (text == null) {
			return null;
		}

		int i = 0;
		StringBuffer buffer = new StringBuffer();
		while (i < text.length()) {
			char c = text.charAt(i);

			if (c == '&') {
				if (text.substring(i).indexOf("&lt;") == 0) {
					i += 4;
					buffer.append('<');
				} else if (text.substring(i).indexOf("&amp;") == 0) {
					i += 5;
					buffer.append('&');
				} else if (text.substring(i).indexOf("&gt;") == 0) {
					i += 4;
					buffer.append('>');
				} else if (text.substring(i).indexOf("&quot;") == 0) {
					i += 6;
					buffer.append('"');
				} else if (text.substring(i).indexOf("&apos;") == 0) {
					i += 6;
					buffer.append('\'');
				} else {
					buffer.append(c);
					i++;
				}
			} else {
				buffer.append(c);
				i++;
			}
		}

		return buffer.toString();
	}
}
