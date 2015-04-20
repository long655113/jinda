package org.trustel.privilege;

import org.trustel.common.ITreeItem;

/**
 * 
 * 类 名：控制器[抽象]
 * 
 * 版 本：4.0.0.0
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-17
 * 
 * 数据源：
 * 
 * 描 述：
 * 
 * 
 **/

public abstract class AbstractPrivilege implements ITreeItem {
	
	/**
	 * 控制器编码:控制器权限通常是类名 也可以是从CommonControllor继承并重载的getPrivilegeCode的返回值
	 */
	private String code;

	/**
	 * 所属控制器
	 */
	private String ucode;

	/**
	 * 控制器标题
	 */
	private String title;

	/**
	 * 功能描述
	 */
	private String description;

	/**
	 * 状态:用于控制权限是否开放
	 */
	private int status = 0;

	/**
	 * 显示顺序
	 */
	private int seq = 0;

	/**
	 * 语言
	 */
	private String lang = "zh_CN";

	/**
	 * 菜单类型(0:公共菜单;1:虎翼汇;2:分销平台)
	 */
	private String type;
	

	/**
	 * 菜单类型
	 * @return type (type<--type)
	 */
	public String getType() {
		return type;
	}

	/**
	 * 菜单类型
	 * @param type (type-->type)
	 */
	public void setType(String type) {
		this.type = type;
	}


	public int getChildrenCount() {
		return 0;
	}

	/**
	 * 
	 * @return 控制器编码:控制器权限通常是类名
	 *         也可以是从CommonControllor继承并重载的getPrivilegeCode的返回值(code<--code)
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return 功能描述(description<--description)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return 语言(lang<--lang)
	 */
	public String getLang() {
		return lang;
	}

	/**
	 * 
	 * @return 显示顺序(seq<--seq)
	 */
	public int getSeq() {
		return seq;
	}

	/**
	 * 
	 * 请参考SYSTEM_CONTROLLERSTATUS系统常量
	 * 
	 * @return 状态:用于控制权限是否开放(status<--status)
	 */
	public int getStatus() {
		return status;
	}

	public String getTip() {
		return description;
	}

	/**
	 * 
	 * @return 控制器标题(title<--title)
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @return 所属控制器(ucode<--ucode)
	 */
	public String getUcode() {
		return ucode;
	}

	/**
	 *设置控制器编码:控制器权限通常是类名 也可以是从CommonControllor继承并重载的getPrivilegeCode的返回值
	 * 
	 * @param 控制器编码
	 *            :控制器权限通常是类名
	 *            也可以是从CommonControllor继承并重载的getPrivilegeCode的返回值(code-->code)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 *设置功能描述
	 * 
	 * @param 功能描述
	 *            (description-->description)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 *设置语言
	 * 
	 * @param 语言
	 *            (lang-->lang)
	 */
	public void setLang(String lang) {
		this.lang = lang;
	}

	/**
	 *设置显示顺序
	 * 
	 * @param 显示顺序
	 *            (seq-->seq)
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}

	/**
	 *设置状态:用于控制权限是否开放
	 * 
	 * @param 状态
	 *            :用于控制权限是否开放(status-->status)
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 *设置控制器标题
	 * 
	 * @param 控制器标题
	 *            (title-->title)
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 *设置所属控制器
	 * 
	 * @param 所属控制器
	 *            (ucode-->ucode)
	 */
	public void setUcode(String ucode) {
		this.ucode = ucode;
	}

	
}
