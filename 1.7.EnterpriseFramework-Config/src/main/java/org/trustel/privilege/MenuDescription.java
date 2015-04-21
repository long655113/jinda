package org.trustel.privilege;

import org.trustel.common.Description;

/**
 * 
 * 类 名：系统菜单描述
 * 
 * 版 本：0.0.0.1
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-18
 * 
 * 数据源：system_menu_descriptions(系统菜单描述)
 * 
 * 描 述：
 * 
 **/

public class MenuDescription extends Description {
	/**
	 * 标题
	 */
	private String title;

	/**
	 * 
	 * @return 标题(title<--title)
	 */
	public String getTitle() {
		return title;
	}

	/**
	 *设置标题
	 * 
	 * @param 标题
	 *            (title-->title)
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
