package org.trustel.privilege;

import java.util.List;

/**
 * 
 * �� ����ϵͳ�˵�
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-21
 * 
 * ����Դ��system_menus(ϵͳ�˵�)
 * 
 * �� ����
 * 
 */

public class SystemMenu extends AbstractPrivilege {
	
	/**
	 * ��������˵�
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
	

	/**
	 * ������û��ӳ��
	 * 
	 * @deprecated
	 */
	public String getDescription() {
		return super.getDescription();
	}

	/**
	 * ������û��ӳ��
	 * 
	 * @deprecated
	 */
	public String getLang() {
		return super.getLang();
	}

	/**
	 * ������û��ӳ��
	 * 
	 * @deprecated
	 */
	public String getTip() {
		return super.getTip();
	}

	/**
	 * ������û��ӳ��
	 * 
	 * @deprecated
	 */
	public String getTitle() {
		return super.getTitle();
	}

	public List<?> _descriptions;

}
