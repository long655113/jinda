package org.trustel.util;

import java.util.Date;
import java.util.List;

import org.trustel.common.IListItem;


public class HTMLUtils {
	/**
	 * ��ǰȱʡֵ���ڲ�ѯ�������֮����Ҫ����ȡ�����������´κϳɲ�ѯ����ʱ�ı�
	 * ��ʱ������б�ʱ��û�в�ѯ������Ĭ�ϵ�һ��Ϊ��ѯ��ֵ����ʱ������Ҫȡ����ǰ�б��ȱʡֵ��ʲô��
	 */
	private static String currentValue = "";

	/**
	 * ��IListItem�б�����Radio�б�
	 * 
	 * @param list
	 *            IListItem�б�
	 * @param defaultValue
	 *            ��ǰѡ�е�ֵ
	 * @param buttonName
	 *            ��ť����
	 * @param ext
	 *            ��չ�ַ�������onclick='' or class="button"
	 * @param radio
	 *            true=��ѡ false��ѡ
	 * @return HTML����
	 */
	public static String getButtonsByList(List<?> list, String defaultValue,
			String buttonName, String ext, boolean radio) {
		if (list == null)
			return "";
		if (defaultValue == null)
			defaultValue = "";
		StringBuffer buf = new StringBuffer("");
		String tmp;
		currentValue = defaultValue;
		for (int i = 0; i < list.size(); i++) {
			IListItem item = (IListItem) list.get(i);
			tmp = " value='" + item.getCode() + "'";
			if (i == 0)
				currentValue = item.getCode();
			if (defaultValue.equals(item.getCode())) {
				tmp = tmp + " checked ";
				currentValue = item.getCode();
			}

			if (radio)
				buf.append("<input type=radio name='" + buttonName + "'" + tmp
						+ ext + ">" + item.getTitle() + "\n");
			else
				buf.append("<input type=checkbox name='" + buttonName + "'"
						+ tmp + ext + ">" + item.getTitle() + "\n");

		}
		return buf.toString();
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
		if (list == null)
			return null;
		if (title == null) {
			title = "";
			return null;
		} else
			title = title.trim();
		if (list != null)
			for (int i = 0; i < list.size(); i++) {
				IListItem item = (IListItem) list.get(i);
				if (title.equals(item.getTitle().trim()))
					return item.getCode();
			}
		return null;
	}

	/**
	 * ��ǰȱʡֵ���ڲ�ѯ�������֮����Ҫ����ȡ�����������´κϳɲ�ѯ����ʱ�ı�
	 * ��ʱ������б�ʱ��û�в�ѯ������Ĭ�ϵ�һ��Ϊ��ѯ��ֵ����ʱ������Ҫȡ����ǰ�б��ȱʡֵ��ʲô��
	 * 
	 * @return
	 */
	public static String getCurrentValue() {
		return currentValue;
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
		return getItemById(list, String.valueOf(code));
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
		if (list == null)
			return null;
		if (Title == null) {
			Title = "";
			return null;
		} else
			Title = Title.trim();

		if (list != null)
			for (int i = 0; i < list.size(); i++) {
				IListItem item = (IListItem) list.get(i);
				if (Title.equals(item.getTitle()))
					return item;
			}
		return null;
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
	public static IListItem getItemById(List<?> list, String code) {
		if (list == null)
			return null;
		if (code == null) {
			code = "";
			return null;
		} else
			code = code.trim();

		if (list != null)
			for (int i = 0; i < list.size(); i++) {
				IListItem item = (IListItem) list.get(i);
				if (code.equals(item.getCode()))
					return item;
			}
		return null;
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
		StringBuffer buf = new StringBuffer("");
		from = (from == null) ? new Date() : from;
		to = (to == null) ? new Date() : to;
		boolean asc = to.after(from);
		Date d = from;
		String cur;
		if (asc) {

			while (d.before(to)) {
				cur = DateUtils.format(d, format, "GMT+8");
				if (cur.equals(defaultvalue))
					buf.append("<option value='" + cur + "' selected>"
							+ DateUtils.format(d, titleformat, "GMT+8")
							+ "</option>\n");
				else
					buf.append("<option value='" + cur + "'>"
							+ DateUtils.format(d, titleformat, "GMT+8")
							+ "</option>\n");

				d = DateUtils.add(d, DateUtils.TIME_MONTH, 1);
			}

		} else {
			d = from;
			while (d.after(to)) {
				cur = DateUtils.format(d, format, "GMT+8");
				if (cur.equals(defaultvalue))
					buf.append("<option value='" + cur + "' selected>"
							+ DateUtils.format(d, titleformat, "GMT+8")
							+ "</option>\n");
				else
					buf.append("<option value='" + cur + "'>"
							+ DateUtils.format(d, titleformat, "GMT+8")
							+ "</option>\n");
				d = DateUtils.add(d, DateUtils.TIME_MONTH, -1);
			}
		}
		return buf.toString();

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
		return getOptionsAsTree(list, String.valueOf(defaultValue));
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
	public static String getOptionsAsTree(List<?> list,
			int defaultValue, boolean allowSelectTop) {
		return getOptionsAsTree(list, String.valueOf(defaultValue),
				allowSelectTop);
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
	public static String getOptionsAsTree(List<?> list,
			String defaultValue) {
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
	public static String getOptionsAsTree(List<?> list,
			String defaultValue, boolean allowSelectTop) {

		return (new OptionTreeUtils(list, defaultValue, allowSelectTop)).getTree();
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
		return getOptionsByList(list, String.valueOf(defaultValue));
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
			String[] checkeds) {
		StringBuffer ret = new StringBuffer("");
		if (list != null)
			for (int i = 0; i < list.size(); i++) {
				String checked = "";
				IListItem item = (IListItem) list.get(i);
				if (checkeds != null)
					for (int j = 0; j < checkeds.length; j++)
						if (item.getCode().equals(checkeds[j])) {
							checked = " checked";
						}
				ret.append(String.format(
						"<input type='checkbox' name='%s' value='%s'%s/>%s",
						new Object[] { name, item.getCode(), checked,
								item.getTitle() }));
			}

		return ret.toString();
	}

	/**
	 * ����List<?>��ѡ���ֵValues��ȡ����ѡ�е���Ŀ�����ƻ����
	 */
	public static String getMultiCheckedTitle(List<?> list, String values) {
		return getMultiCheckedTitle(list, values, ",");
	}

	/**
	 * ����List<?>��ѡ���ֵValues��ȡ����ѡ�е���Ŀ�����ƻ����
	 */
	public static String getMultiCheckedTitle(List<?> list, String values,
			String splitStr) {
		values = StringUtils.valueOf(values);
		String[] checked = values.split(splitStr);
		return getMultiCheckedTitle(list, checked);
	}

	/**
	 * ����List<?>��ѡ���ֵValues��ȡ����ѡ�е���Ŀ�����ƻ����
	 */
	public static String getMultiCheckedTitle(List<?> list, String[] values) {
		StringBuffer ret = new StringBuffer("");
		if (values != null)
			;
		for (int i = 0; i < values.length; i++)
			ret.append(getTitleByList(list, values[i]) + ",");
		return ret.toString();
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
		if (list == null)
			return "";
		StringBuffer buf = new StringBuffer("");
		if (defaultValue == null)
			defaultValue = "";
		else
			defaultValue = defaultValue.trim();
		String tmp;
		currentValue = defaultValue;
		for (int i = 0; i < list.size(); i++) {
			IListItem item = (IListItem) list.get(i);
			tmp = " value='" + item.getCode() + "'";
			if (i == 0)
				currentValue = item.getCode();
			if (defaultValue.equals(item.getCode())) {
				tmp = tmp + " selected";
				currentValue = item.getCode();
			}

			buf.append("<option" + tmp + ">" + item.getTitle() + "</option>\n");
		}
		return buf.toString();
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
		StringBuffer buf = new StringBuffer("");
		from = (from == null) ? new Date() : from;
		from = DateUtils.get(from, "GMT+8");
		to = (to == null) ? new Date() : to;
		to = DateUtils.get(to, "GMT+8");
		boolean asc = to.after(from);
		Date d = from;
		String cur, tmp;

		int month;
		if (asc) {
			while (d.before(to)) {
				month = Integer.valueOf(DateUtils.format(d, "M", ""));

				if (month >= 1 && month <= 3)
					tmp = "1";
				else if (month >= 4 && month <= 6)
					tmp = "2";
				else if (month >= 7 && month <= 9)
					tmp = "3";
				else
					tmp = "4";
				cur = DateUtils.format(d, format, "GMT+8") + tmp;
				if (cur.equals(defaultvalue))
					buf.append("<option value='" + cur + "' selected>"
							+ DateUtils.format(d, "yy��", "") + tmp
							+ "����</option>\n");
				else
					buf.append("<option value='" + cur + "'>"
							+ DateUtils.format(d, "yy��", "") + tmp
							+ "����</option>\n");

				d = DateUtils.add(d, DateUtils.TIME_MONTH, 3);
			}

		} else {
			d = from;
			while (d.after(to)) {
				month = DateUtils.getTimePart(d, DateUtils.TIME_MONTH, "GMT+8");

				if (month >= 1 && month <= 3)
					tmp = "1";
				else if (month >= 4 && month <= 6)
					tmp = "2";
				else if (month >= 7 && month <= 9)
					tmp = "3";
				else
					tmp = "4";
				cur = DateUtils.format(d, format, "GMT+8") + tmp;
				if (cur.equals(defaultvalue))
					buf.append("<option value='" + cur + "' selected>"
							+ DateUtils.format(d, "yy��", "") + tmp
							+ "����</option>\n");
				else
					buf.append("<option value='" + cur + "'>"
							+ DateUtils.format(d, "yy��", "") + tmp
							+ "����</option>\n");
				d = DateUtils.add(d, DateUtils.TIME_MONTH, -3);
			}
		}
		return buf.toString();

	}

	/**
	 * 
	 * from 1 to 100 step 1 from 100 to 1 step -1
	 */
	public static String getSequenceOptions(int from, int to, int defaultvalue) {
		return getSequenceOptions(from, to, defaultvalue, 1);
	}

	public static String getSequenceOptions(int from, int to, int defaultvalue,
			int step) {
		StringBuffer buf = new StringBuffer("");
		for (int i = from; i <= to; i = i + step) {
			if (i == defaultvalue)
				buf.append("<option value=" + i + " selected>" + i
						+ "</option>");
			else
				buf.append("<option value=" + i + ">" + i + "</option>");
		}

		return buf.toString();
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
		return getTitleByList(list, String.valueOf(code));
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
		IListItem item = getItemById(list, code);
		if (item == null)
			return code == null ? "" : code;
		else
			return item.getTitle();
	}

	/**
	 * ͨ�����뷵��Tip
	 * 
	 * @param list
	 *            IListItem/ITreeItem/IMenuItem�б�
	 * @param code
	 *            ����
	 * @return ���ƻ����
	 */
	public static String getTipByList(List<?> list, int code) {
		return getTitleByList(list, String.valueOf(code));
	}

	/**
	 * ͨ�����뷵��Tip
	 * 
	 * @param list
	 *            IListItem/ITreeItem/IMenuItem�б�
	 * @param code
	 *            ����
	 * @return ���ƻ����
	 */
	public static String getTipByList(List<?> list, String code) {
		IListItem item = getItemById(list, code);
		if (item == null)
			return code == null ? "" : code;
		else
			return item.getTip();
	}

	/**
	 * ���ݲ���ֵȡ��ʽ
	 * 
	 * @param value
	 *            true or false/yes or no
	 * @return if value is true,return is yes,neight it is no
	 */
	public static String strongYesNo(boolean value) {
		return strongYesNo(value, "yes", "no");
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
		return value ? yes : no;
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
		if (value > 0 && value < colors.length)
			return colors[value];
		else
			return "";
	}

}
