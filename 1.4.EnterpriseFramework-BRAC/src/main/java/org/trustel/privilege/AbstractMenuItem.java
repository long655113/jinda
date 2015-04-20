package org.trustel.privilege;

import org.trustel.common.IMenuItem;

/**
 * 
 * 类 名：系统菜单
 * 
 * 版 本：0.0.0.1
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-17 15:41
 * 
 * 数据源：system_menuitems(系统菜单)
 * 
 * 描 述：
 * 
 **/

public class AbstractMenuItem extends AbstractPrivilege implements IMenuItem {
	/**
	 * url:用于输出菜单
	 */
	private String url;
	/**
	 * 样式
	 */
	private String css;

	/**
	 * 
	 * @return url:用于输出菜单(url<--url)
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 
	 * @return 样式(css<--css)
	 */
	public String getCss() {
		return css;
	}

	/**
	 *设置url:用于输出菜单
	 * 
	 * @param url
	 *            :用于输出菜单(url-->url)
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 *设置样式
	 * 
	 * @param 样式
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
