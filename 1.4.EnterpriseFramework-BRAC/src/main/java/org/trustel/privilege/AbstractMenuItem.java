package org.trustel.privilege;

import org.trustel.common.IMenuItem;

/**
 * 
 * �� ����ϵͳ�˵�
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-17 15:41
 * 
 * ����Դ��system_menuitems(ϵͳ�˵�)
 * 
 * �� ����
 * 
 **/

public class AbstractMenuItem extends AbstractPrivilege implements IMenuItem {
	/**
	 * url:��������˵�
	 */
	private String url;
	/**
	 * ��ʽ
	 */
	private String css;

	/**
	 * 
	 * @return url:��������˵�(url<--url)
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * @return ��ʽ(css<--css)
	 */
	public String getCss() {
		return css;
	}

	/**
	 *����url:��������˵�
	 * 
	 * @param url
	 *            :��������˵�(url-->url)
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 *������ʽ
	 * 
	 * @param ��ʽ
	 *            (css-->css)
	 */
	public void setCss(String css) {
		this.css = css;
	}

	public int getChildrenCount() {
		return 0;
	}

	public String getTip() {
		return getDescription();
	}
}
