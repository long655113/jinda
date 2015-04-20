package org.trustel.common;

/**
 * 
 * �� ����ȱʡ�����б���
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-04
 * 
 * ����Դ�������Ͳ���Ҫӳ�䣬������������б��ҵ����
 * 
 * �� ����
 * 
 */

public class DefaultListItem implements IListItem {
	private String code;

	private String title;

	private String tip;

	/**
	 * ͨ�����빹�������б��е��������ʾ��Ϣ��ֵ��
	 */
	public DefaultListItem(int code) {
		this.code = String.valueOf(code);
		this.title = this.code;
	}

	/**
	 * ͨ�����뼰���⹹�����б���ã�[������ʾ��Ϣ�Ͷ�Ӧֵ��ͬ����������M��ʾ]
	 */
	public DefaultListItem(String code, String title) {
		this.code = code;
		this.title = title;
	}

	public DefaultListItem(String code, String title, String tip) {
		this.code = code;
		this.title = title;
		this.tip = tip;
	}

	public String getCode() {
		return code;
	}

	public String getTip() {
		return tip;
	}

	public String getTitle() {
		return title;
	}
}