package org.trustel.privilege;

import java.util.List;

/**
 * 
 * 类 名：系统菜单
 * 
 * 版 本：0.0.0.1
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-21
 * 
 * 数据源：system_menus(系统菜单)
 * 
 * 描 述：
 * 
 */

public class SystemMenu extends AbstractPrivilege {
	
	/**
	 * 用于输出菜单
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
	

	/**
	 * 本方法没有映射
	 * 
	 * @deprecated
	 */
	public String getDescription() {
		return super.getDescription();
	}

	/**
	 * 本方法没有映射
	 * 
	 * @deprecated
	 */
	public String getLang() {
		return super.getLang();
	}

	/**
	 * 本方法没有映射
	 * 
	 * @deprecated
	 */
	public String getTip() {
		return super.getTip();
	}

	/**
	 * 本方法没有映射
	 * 
	 * @deprecated
	 */
	public String getTitle() {
		return super.getTitle();
	}

	public List<?> _descriptions;

}
