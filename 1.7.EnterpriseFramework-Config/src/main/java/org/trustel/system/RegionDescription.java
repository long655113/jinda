package org.trustel.system;

import org.trustel.common.Description2;

/**
 * 
 * 类 名：区域信息－描述
 * 
 * 版 本：0.0.0.1
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-21
 * 
 * 数据源：system_region_descriptions(区域信息－描述)
 * 
 * 描 述：
 * 
 **/

public class RegionDescription extends Description2 {
	/**
	 * 名称
	 */
	private String name;

	/**
	 * 
	 * @return 名称(name<--name)
	 */
	public String getName() {
		return name;
	}

	/**
	 *设置名称
	 * 
	 * @param 名称
	 *            (name-->name)
	 */
	public void setName(String name) {
		this.name = name;
	}
}
