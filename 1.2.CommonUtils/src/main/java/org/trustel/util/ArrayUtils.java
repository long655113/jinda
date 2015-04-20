package org.trustel.util;

import java.util.ArrayList;
import java.util.List;

import org.trustel.common.DefaultListItem;
import org.trustel.common.IListItem;


public class ArrayUtils {
	/**
	 * ������ת��Ϊ�б�
	 * 
	 * @param items
	 * @return
	 */
	public static List<?> arrayToList(Object[] items) {

		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < items.length; i++)
			list.add(items[i]);

		return list;
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
		StringBuffer buf = new StringBuffer("");
		String fix = "'";
		if (asNumber)
			fix = "";
		if (values != null)
			for (int i = 0; i < values.length; i++)
				if (i == 0)
					buf.append(fix + values[i] + fix);
				else
					buf.append(split + fix + values[i] + fix);
		return buf.toString();
	}

	/**
	 * ����תΪ�ַ���
	 * 
	 * @param items
	 * @param splitChar
	 * @return
	 */
	public static String arrayToString(int[] items, String splitChar) {
		StringBuffer buf = new StringBuffer("");
		if (items != null)
			for (int i = 0; i < items.length; i++)
				if (i > 0)
					buf.append(splitChar + items[i]);
				else
					buf.append(items[i]);
		return buf.toString();
	}

	/**
	 * ����תΪ�ַ���
	 * 
	 * @param items
	 * @param splitChar
	 * @return
	 */
	public static String arrayToString(Object[] items, String splitChar) {
		StringBuffer buf = new StringBuffer("");
		if (items != null)
			for (int i = 0; i < items.length; i++)
				if (i > 0)
					buf.append(splitChar + items[i]);
				else
					buf.append(items[i]);
		return buf.toString();
	}

	/**
	 * ת��List<String>��List<?>Ϊ��������
	 */
	public static int[] convert(List<?> items) {
		return convert(ArrayUtils.listToArray(items));
	}

	/**
	 * ת���ַ�������Ϊ��������
	 */
	public static int[] convert(String[] items) {
		int[] ret = new int[items.length];
		for (int i = 0; i < items.length; i++)
			ret[i] = Integer.parseInt(items[i]);
		return ret;
	}

	/**
	 * ת����ֵͨ--�����б�ΪIListItem�б���������ת�����б����
	 * 
	 * @param items
	 *            ��ֵ--���Ʊ����������,�԰�Ƕ��ŷָ�
	 * @return IListItem�б�
	 */
	public static List<?> convertList(String[] items, String split) {
		List<IListItem> list = new ArrayList<IListItem>();

		if (items != null) {
			for (int i = 0; i < items.length; i++) {
				String[] arr = items[i].split(split);
				if (arr.length > 1){
					if(arr.length>2){
						list.add(new DefaultListItem(arr[0], arr[1], arr[2]));
					}else{
						list.add(new DefaultListItem(arr[0], arr[1]));
					}
				}
				else
					list.add(new DefaultListItem(items[i], items[i]));
			}
		}
		return list;

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
		List<Object> list = new ArrayList<Object>();
		if (arrCode == null) {
			if (excludes)
				list.addAll(items);
			return list;
		}
		String codes = "#@$%^&*;" + arrayToSting(arrCode, ";", true) + ";";
		if (items != null) {
			for (int i = 0; i < items.size(); i++) {
				IListItem item = (IListItem) items.get(i);
				boolean exist = codes.indexOf(";" + item.getCode() + ";") > 0;
				if (excludes) {
					if (!exist)
						list.add(item);
				} else {
					if (exist)
						list.add(item);
				}

			}
		}
		return list;
	}

	/**
	 * ���ַ����б�ת��Ϊ�ַ�������
	 * 
	 * @param list
	 *            List<?> or List<String>
	 * @return
	 */
	public static String[] listToArray(List<?> list) {
		String[] names = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) instanceof IListItem) {
				names[i] = ((IListItem) list.get(i)).getCode();
			} else {
				names[i] = (String) list.get(i);
			}

		}
		return names;
	}

	/**
	 * 
	 * @param items
	 *            �������ַ�����
	 * @return ��������
	 */
	public static int[] strArrayToInt(String[] items) {
		return convert(items);
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

		if (source == null)
			return new ArrayList<Object>();
		else
			return arrayToList(source.split(splitchar));

	}
}
