package org.trustel.common;

/**
 * 
 * �� ����ϵͳ�˵�
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-18
 * 
 * ����Դ��һ�������ӳ�䵽�˵���ͼ����v_menus)
 * 
 * �� ����
 * 
 */

public class DefaultMenuItem extends DefaultTreeItem implements IMenuItem {

	private String url;

	public DefaultMenuItem(String code, String title, String ucode, String url) {
		super(code, title, ucode);
		this.url = url;
	}

	public DefaultMenuItem(String code, String title, String ucode) {
		super(code, title, ucode);
		url = "";
	}

	public String getUrl() {
		return url;
	}

}
