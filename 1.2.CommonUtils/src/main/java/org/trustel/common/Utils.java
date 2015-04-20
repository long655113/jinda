package org.trustel.common;

import java.util.Date;
import java.util.List;

import org.trustel.util.ArrayUtils;
import org.trustel.util.DateUtils;
import org.trustel.util.HTMLUtils;
import org.trustel.util.NumberUtils;
import org.trustel.util.StringUtils;

/**
 * ͨ�ù�����
 * 
 * @author ��־��
 * 
 * @version V4.0 2011��3��2�� ��V3.0�汾��2008��12�£��ϸĽ����
 * 
 * <pre>
 *   1.�ṩ��������ת�������ݸ�ʽ������;
 *   2.��HTML�����Ϣ������������б���״�б��Լ���ť��ȣ�;
 *   3.�ṩ����������ʱ��ת�������ڲ���ͼӼ�ȥ���ȣ�
 *   4.�ṩ�б�����ת��
 * 
 * </pre>
 */
public class Utils extends DateUtils {

	/**
	 * ������ת��Ϊ�б�
	 * 
	 * @param items
	 *            ��������
	 * @return �б�
	 * 
	 */
	public static List<?> arrayToList(Object[] items) {
		return ArrayUtils.arrayToList(items);
	}

	/**
	 * ������תΪ�ض���ʽ���ַ���
	 * 
	 * Example: values = new String[] { '1', '2', '3' };<br>
	 * System.out.println('delete from User where code in (' +
	 * Utils.arrayToSting(values, ',', true) + ')');<br>
	 * System.out.println('delete from User where code in (' +
	 * Utils.arrayToSting(values, ',', false) + ')');
	 * 
	 * @param values
	 *            �ַ�����
	 * @param split
	 *            �ָ���
	 * @param asNumber
	 *            ��Ϊ���ַָ�
	 * @return
	 */
	public static String arrayToSting(String[] values, String split,
			boolean asNumber) {
		return ArrayUtils.arrayToSting(values, split, asNumber);
	}

	/**
	 * ����תΪ�ַ���
	 * 
	 * @param items
	 * @param splitChar
	 * @return
	 */
	public static String arrayToString(int[] items, String splitChar) {
		return ArrayUtils.arrayToString(items, splitChar);
	}

	/**
	 * ����תΪ�ַ���
	 * 
	 * @param items
	 * @param splitChar
	 * @return
	 */
	public static String arrayToString(Object[] items, String splitChar) {
		return ArrayUtils.arrayToString(items, splitChar);
	}

	/**
	 * ת��List<String>��List<?>Ϊ��������
	 */
	public static int[] convert(List<?> items) {
		return ArrayUtils.convert(items);
	}

	/**
	 * ת���ַ�������Ϊ��������
	 */
	public static int[] convert(String[] items) {
		return ArrayUtils.convert(items);
	}

	/**
	 * ת����ֵͨ--�����б�ΪIListItem�б���������ת�����б����
	 * 
	 * @param items
	 *            ��ֵ--���Ʊ����������,�԰�Ƕ��ŷָ�
	 * @return IListItem�б�
	 */
	public static List<?> convertList(String[] items, String split) {
		return ArrayUtils.convertList(items, split);
	}

	/**
	 * ȡ�������ڵĲ�ֵ
	 * 
	 * @param from
	 *            ��ʼʱ��
	 * @param to
	 *            ����ʱ��
	 * @param part
	 *            Time_Minute--��ض��ٷ�,Time_HourOfDay-ʱ��other-��
	 * @return ��ֵ
	 */
	public static long diff(Date from, Date to, int part) {
		return DateUtils.diff(from, to, part);
	}

	/**
	 * ��ϴ�б������
	 * 
	 * @param items
	 *            IListItem�б�
	 * @param codes
	 *            ������
	 * @return items IListItem�б�
	 */
	public static List<?> filterList(List<?> items, String[] arrCode) {
		return ArrayUtils.filterList(items, arrCode, false);
	}

	/**
	 * ��ϴ�б������
	 * 
	 * @param items
	 *            IListItem�б�
	 * @param codes
	 *            ������
	 * @param excludes
	 *            true ���ؽ�����ų�codes�еĶ��� ����ֻ���� codes�еĶ���
	 * @return items IListItem�б�
	 */
	public static List<?> filterList(List<?> items, String[] arrCode,
			boolean excludes) {
		return ArrayUtils.filterList(items, arrCode, excludes);
	}

	/**
	 * ������0��ǰ׺��ָ�����ȵ����к�
	 */
	public static String fixLength(String value, int fixLen) {
		return StringUtils.fixLength(value, fixLen);
	}

	/**
	 * ����ָ�����ƺͳ����Լ�ָ��ǰ׺�����кţ�ͨ��ʹ��0��ǰ׺
	 */
	public static String fixLength(String value, int fixLen, char fixChar) {
		return StringUtils.fixLength(value, fixLen, fixChar);
	}

	public static String format(double d, int scale) {
		return NumberUtils.format(d, scale);
	}

	public static String getButtonsByList(List<?> list, int defaultValue,
			String buttonName, String ext, boolean radio) {
		return getButtonsByList(list, String.valueOf(defaultValue), buttonName,
				ext, radio);
	}

	public static String getButtonsByList(List<?> list, String defaultValue,
			String buttonName, String ext, boolean radio) {
		return HTMLUtils.getButtonsByList(list, defaultValue, buttonName, ext,
				radio);
	}

	/**
	 * ͨ�����ⷵ�ر���
	 * 
	 * @param list
	 *            IListItem�б�
	 * @param code
	 *            ����
	 * @return ���ƻ����
	 */
	public static String getCodeByTitle(List<?> list, String title) {
		return HTMLUtils.getCodeByTitle(list, title);
	}

	/**
	 * ���ص�����EXCEL���ļ���
	 */
	public static String getContentDisposition(String fileName, String pattern) {
		return "attachment;filename="
				+ getExportExcelFileName(fileName, pattern);
	}

	public static String getContentTypeForHTML(String charset, boolean xhtml) {
		String ret = "<meta http-equiv='Content-Type' content='text/html; charset="
				+ charset + "'";
		if (xhtml)
			return ret + " />";
		else
			return ret + ">";

	}

	/**
	 * ��ǰȱʡֵ���ڲ�ѯ�������֮����Ҫ����ȡ�����������´κϳɲ�ѯ����ʱ�ı�
	 * ��ʱ������б�ʱ��û�в�ѯ������Ĭ�ϵ�һ��Ϊ��ѯ��ֵ����ʱ������Ҫȡ����ǰ�б��ȱʡֵ��ʲô��
	 * 
	 * @return
	 */
	public static String getCurrentValue() {
		return HTMLUtils.getCurrentValue();
	}

	public static String getExcelContentType(String charset) {
		return "application/vnd.ms-excel; charset=" + charset;
	}

	/**
	 * ȡ��׼�ĵ����ļ���
	 * 
	 * @param functionName
	 *            ��������
	 * @param pattern
	 *            ���ڸ�ʽ ��yyyy-MM-dd_HHmm
	 * @return �ļ���
	 */
	public static String getExportExcelFileName(String functionName,
			String pattern) {

		Date d = new Date();
		String fileName = functionName + "["
				+ Utils.format(d, pattern, "GMT+8") + "]" + ".xls";
		try {
			return new String(fileName.getBytes("gb2312"), "iso8859-1");
		} catch (Exception e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			return fileName;
		}
	}

	/**
	 * ���ݱ���ȡ��Ӧ����
	 * 
	 * @param list
	 *            IListItem�����б�
	 * @param code
	 *            ����ID
	 * @return IListItem
	 */
	public static IListItem getItemById(List<?> list, int code) {
		return HTMLUtils.getItemById(list, code);
	}

	/**
	 * ���ݱ���ȡ��Ӧ����
	 * 
	 * @param list
	 *            IItemList�����б�
	 * @param code
	 *            ����ID
	 * @return IListItem
	 */
	public static IListItem getItemById(List<?> list, String code) {
		return HTMLUtils.getItemById(list, code);
	}

	/**
	 * ���ݱ���ȡ��Ӧ����
	 * 
	 * @param list
	 *            IListItem�����б�
	 * @param title
	 *            ����
	 * @return IListItem
	 */
	public static IListItem getItemByTitle(List<?> list, String Title) {
		return HTMLUtils.getItemByTitle(list, Title);
	}

	/**
	 * ���ɴ�from��to����������ѡ��
	 * 
	 * @param from
	 *            ��ʼʱ��
	 * @param to
	 *            ����ʱ��
	 * @param format
	 *            ���ڸ�ʽ�ַ���
	 * @param titleformat
	 *            ��ʾ���ݸ�ʽ��
	 * @return �����б�ѡ��
	 */
	public static String getMonthOption(Date from, Date to, String format,
			String titleformat, String defaultvalue) {
		return HTMLUtils.getMonthOption(from, to, format, titleformat,
				defaultvalue);
	}

	/**
	 * ���������б�ѡ�
	 * 
	 * @param list
	 *            IListItem�б�
	 * @param defaultValue
	 *            ��ǰѡ�е�ֵ������Ϊ�ա�
	 * @return HTML����
	 */
	public static String getOptionsAsTree(List<?> list, int defaultValue) {
		return HTMLUtils.getOptionsAsTree(list, defaultValue);
	}

	/**
	 * ���������б�ѡ�
	 * 
	 * @param list
	 *            IListItem�б�
	 * @param defaultValue
	 *            ��ǰѡ�е�ֵ������Ϊ�ա�
	 * @param allowSelectTop
	 *            �ǳ���ѡ�񶥼���
	 * @return HTML����
	 */
	public static String getOptionsAsTree(List<?> list, int defaultValue,
			boolean allowSelectTop) {
		return HTMLUtils.getOptionsAsTree(list, defaultValue, allowSelectTop);
	}

	/**
	 * ���������б�ѡ�
	 * 
	 * @param list
	 *            IListItem�б�
	 * @param defaultValue
	 *            ��ǰѡ�е�ֵ������Ϊ�ա�
	 * @return HTML����
	 */
	public static String getOptionsAsTree(List<?> list, String defaultValue) {
		return getOptionsAsTree(list, defaultValue, true);
	}

	/**
	 * ���������б�ѡ�
	 * 
	 * @param list
	 *            IListItem�б�
	 * @param defaultValue
	 *            ��ǰѡ�е�ֵ������Ϊ�ա�
	 * @param allowSelectTop
	 *            �ǳ���ѡ�񶥼���
	 * @return HTML����
	 */
	public static String getOptionsAsTree(List<?> list, String defaultValue,
			boolean allowSelectTop) {
		return HTMLUtils.getOptionsAsTree(list, defaultValue, allowSelectTop);
	}

	/**
	 * ���������б�ѡ�
	 * 
	 * @param list
	 *            IListItem�б�
	 * @param defaultValue
	 *            ��ǰѡ�е�ֵ������Ϊ�ա�
	 * @return HTML����
	 */
	public static String getOptionsByList(List<?> list, int defaultValue) {
		return HTMLUtils.getOptionsByList(list, defaultValue);
	}

	/**
	 * 
	 * @param name
	 *            The name of Checkbox Control
	 * @param list
	 *            The key-value list of checkbos
	 * @param checkeds
	 *            The values that checked;
	 * @return
	 */
	public static String getCheckBoxGroupByList(String name, List<?> list,
			String[] checkedValues) {
		return HTMLUtils.getCheckBoxGroupByList(name, list, checkedValues);
	}

	/**
	 * ���������б�ѡ�
	 * 
	 * @param list
	 *            IListItem�б�
	 * @param defaultValue
	 *            ��ǰѡ�е�ֵ������Ϊ�ա�
	 * @return HTML����
	 */
	public static String getOptionsByList(List<?> list, String defaultValue) {
		return HTMLUtils.getOptionsByList(list, defaultValue);
	}

	/**
	 * 
	 * @param from
	 *            ��ʼ����
	 * @param to
	 *            ��ֹ����
	 * @param format
	 *            Option-value�е����ʽ
	 * @param defaultvalue
	 *            ��ǰȱʡֵ
	 * @return ���������б�
	 */
	public static String getSeasonOption(Date from, Date to, String format,
			String defaultvalue) {
		return HTMLUtils.getSeasonOption(from, to, format, defaultvalue);

	}

	/**
	 * 
	 * from 1 to 100 step 1 from 100 to 1 step -1
	 */
	public static String getSequenceOptions(int from, int to, int defaultvalue) {
		return HTMLUtils.getSequenceOptions(from, to, defaultvalue, 1);
	}

	public static String getSequenceOptions(int from, int to, int defaultvalue,
			int step) {
		return HTMLUtils.getSequenceOptions(from, to, defaultvalue, step);
	}

	/**
	 * ͨ�����뷵�����ƻ����
	 * 
	 * @param list
	 *            IListItem�б�
	 * @param code
	 *            ����
	 * @return ���ƻ����
	 */
	public static String getTitleByList(List<?> list, int code) {
		return HTMLUtils.getTitleByList(list, code);
	}

	/**
	 * ͨ�����뷵�����ƻ����
	 * 
	 * @param list
	 *            IListItem�б�
	 * @param code
	 *            ����
	 * @return ���ƻ����
	 */
	public static String getTitleByList(List<?> list, String code) {
		return HTMLUtils.getTitleByList(list, code);
	}

	/**
	 * ͨ�����뷵��Tip
	 * 
	 * @param list
	 *            IListItem�б�
	 * @param code
	 *            ����
	 * @return ���ƻ����
	 */
	public static String getTipByList(List<?> list, int code) {
		return HTMLUtils.getTipByList(list, code);
	}

	/**
	 * ͨ�����뷵��Tip
	 * 
	 * @param list
	 *            IListItem�б�
	 * @param code
	 *            ����
	 * @return ���ƻ����
	 */
	public static String getTipByList(List<?> list, String code) {
		return HTMLUtils.getTipByList(list, code);
	}

	/**
	 * ���ַ����б�ת��Ϊ�ַ�������
	 * 
	 * @param list
	 * @return
	 */
	public static String[] listToArray(List<?> list) {
		return ArrayUtils.listToArray(list);
	}

	/**
	 * ���ַ���תΪHTML������Դ��ΪNULL���ʱ����&nbsp;
	 * 
	 * @param source
	 * @return
	 */
	public static String null2HTML(String source) {
		return StringUtils.null2HTML(source);

	}

	/**
	 * ���ִ���������ʱ�ض���ʾ��ΪNULLʱ��ʾһ���ո�
	 * 
	 * @param source
	 * @param len
	 * @return
	 */
	public static String null2HTML(String source, int len) {
		return StringUtils.null2HTML(source, len);
	}

	public static String null2Str(Date value, String format, String timeZone) {
		return format(value, format, timeZone);
	}

	public static String null2Str(String source) {
		return null2Str(source, "");
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
		return StringUtils.null2Str(source, max);
	}

	public static String null2Str(String source, String defaultValue) {
		return valueOf(source, defaultValue, 0);
	}

	/**
	 * 
	 * @param items
	 *            �������ַ�����
	 * @return ��������
	 */
	public static int[] strArrayToInt(String[] items) {
		return ArrayUtils.strArrayToInt(items);
	}

	/**
	 * ���ض��ָ����ָ����ַ���ת��Ϊ�б�
	 * 
	 * @param source
	 *            Դ��
	 * @param splitchar
	 *            �ָ���
	 * @return
	 */
	public static List<?> stringToList(String source, String splitchar) {

		return ArrayUtils.stringToList(source, splitchar);

	}

	/**
	 * ���ݲ���ֵȡ��ʽ
	 * 
	 * @param value
	 *            true or false/yes or no
	 * @return if value is true,return is yes,neight it is no
	 */
	public static String stringYesNo(boolean value) {
		return HTMLUtils.strongYesNo(value);
	}

	/**
	 * ȡ��ɫֵ
	 * 
	 * @param value
	 *            yes or no
	 * @param yes
	 *            the style of yes
	 * @param no
	 *            the style of no
	 * @return ��ɫ/��ʽ
	 */
	public static String strongYesNo(boolean value, String yes, String no) {
		return HTMLUtils.strongYesNo(value, yes, no);
	}

	/**
	 * �����±�ȡ��ɫֵ
	 * 
	 * @param value
	 *            ö��ֵ
	 * @param colors
	 *            ��ɫ/��ʽ����
	 * @return ��ɫ/��ʽ
	 */
	public static String strongYesNo(int value, String[] colors) {
		return HTMLUtils.strongYesNo(value, colors);
	}

	/**
	 * �൱�ڽض��ַ���
	 * 
	 * @param source
	 * @param defaultValue
	 * @param maxlength
	 * @return
	 */
	public static String valueOf(String source, String defaultValue,
			int maxlength) {
		return StringUtils.valueOf(source, defaultValue, maxlength);
	}

	/**
	 * ��ָ��˫���ȱ�����ʽ��Ϊָ�������ַ�������ֵΪ��ʱ����Ĭ�ϴ�
	 * 
	 * @param value
	 *            ˫���ȱ���
	 * @param defaultValue
	 *            ˫���ȱ���Ϊ0ʱ���ر�ȱʡֵ
	 * @param scale
	 *            С��λ��
	 * @return value=1.23 defaultValue="" scale=1 ����1.2
	 * 
	 * value=0.0 defaultValue="��ֵ" ���ؿ�ֵ
	 */
	public static String zero2Str(double value, String defaultValue, int scale) {
		return NumberUtils.zero2Str(value, defaultValue, scale);
	}

	/**
	 * ��ָ�����������ʽ��Ϊָ�������ַ�������ֵΪ��ʱ����Ĭ�ϴ�
	 * 
	 * @param value
	 *            �������
	 * @param defaultValue
	 *            �������Ϊ0ʱ���ر�ȱʡֵ
	 * @param scale
	 *            С��λ��
	 * @return value=1.23 defaultValue="" scale=1 ����1.2
	 * 
	 * value=0.0 defaultValue="��ֵ" ���ؿ�ֵ
	 */
	public static String zero2Str(float value, String defaultValue, int scale) {
		return NumberUtils.zero2Str(value, defaultValue, scale);
	}

	public static String zero2Str(int value, String defaultValue) {
		return NumberUtils.zero2Str(value, defaultValue);
	}

	public static String zero2Str(long value, String defaultValue) {
		return NumberUtils.zero2Str(value, defaultValue);
	}

	/**
	 * ����List<?>��ѡ���ֵValues��ȡ����ѡ�е���Ŀ�����ƻ����
	 */
	public static String getMultiCheckedTitle(List<?> list, String values) {
		return HTMLUtils.getMultiCheckedTitle(list, values, ",");
	}

	/**
	 * ����List<?>��ѡ���ֵValues��ȡ����ѡ�е���Ŀ�����ƻ����
	 */
	public static String getMultiCheckedTitle(List<?> list, String values,
			String splitStr) {
		return HTMLUtils.getMultiCheckedTitle(list, values, splitStr);
	}

	/**
	 * ����List<?>��ѡ���ֵValues��ȡ����ѡ�е���Ŀ�����ƻ����
	 */
	public static String getMultiCheckedTitle(List<?> list, String[] values) {
		return HTMLUtils.getMultiCheckedTitle(list, values);
	}

}
