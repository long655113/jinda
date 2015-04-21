package org.trustel.system;

import org.trustel.system.AbstractRegion;

/**
 * 
 * 类 名：系统区域信息
 * 
 * 版 本：0.0.0.1
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-21
 * 
 * 数据源：system_region(系统区域信息)
 * 
 * 描 述：
 * 
 * 
 **/

public class SystemRegion extends AbstractRegion {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3678490977451024657L;

	/**
	 * 该信息在对应语言描述表中
	 * 
	 * @deprecated
	 */
	public String getDescription() {
		return super.getDescription();
	}

	/**
	 * 该信息在对应语言描述表中
	 * 
	 * @deprecated
	 */
	public String getLang() {
		return super.getLang();
	}

	/**
	 * 该信息在对应语言描述表中
	 * 
	 * @deprecated
	 */
	public String getTitle() {
		return super.getTitle();
	}

}
