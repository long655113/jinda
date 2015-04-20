package org.trustel.util;

public class StringUtils {
	public static String subfix = "...";

	public static String valueOf(String source, int maxlength) {
		return valueOf(source, "", maxlength);
	}

	public static String valueOf(String source) {
		return valueOf(source, "");
	}

	public static String valueOf(String source, String defaultValue) {
		return valueOf(source, defaultValue, 0);
	}

	public static String valueOf(String source, String defaultValue,
			int maxlength) {
		if (source == null || source.trim().equals(""))
			return defaultValue;

		if (maxlength < 1)
			return source.trim();
		source = source.trim();
		if (source.length() > maxlength + 1)
			source = source.substring(0, maxlength) + subfix;

		return source;
	}

	/**
	 * ���ַ���תΪHTML������Դ��ΪNULL���ʱ����&nbsp;
	 * 
	 * @param source
	 * @return
	 */
	public static String null2HTML(String source) {
		return null2HTML(source, 0);

	}

	/**
	 * ���ִ���������ʱ�ض���ʾ��ΪNULLʱ��ʾһ���ո�
	 * 
	 * @param source
	 * @param len
	 * @return
	 */
	public static String null2HTML(String source, int len) {
		return valueOf(source, "&nbsp;", len).trim();
	}

	/**
	 * ���ִ�����ָ������ʱ�ض�
	 * 
	 * @param source
	 *            Դ��
	 * @param max
	 *            ��󳤶�
	 * @return ���Ƴ��ȴ�
	 */
	public static String null2Str(String source, int max) {
		if (source == null)
			return "";
		byte[] b = source.getBytes();
		if (b.length > max)
			source = new String(b, 0, max);
		return source;
	}

	/**
	 * ������0��ǰ׺��ָ�����ȵ����к�
	 */
	public static String fixLength(String value, int fixLen) {
		return fixLength(value, fixLen, '0');
	}

	/**
	 * ����ָ�����ƺͳ����Լ�ָ��ǰ׺�����кţ�ͨ��ʹ��0��ǰ׺
	 */
	public static String fixLength(String value, int fixLen, char fixChar) {
		String stmp = "";
		for (int i = 0; i < fixLen - value.length(); i++) {
			stmp = stmp + fixChar;
		}

		return stmp + value;
	}

}
