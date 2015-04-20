package org.trustel.system;

import java.util.Date;

import org.trustel.common.Utils;



/**
 * 类 名：用户提醒日志
 * 
 * 日 期：2008-01-23
 * 
 * 设 计：万志勇
 * 
 * 版 本：0.0.0.1
 * 
 */
public class LogOfSystemTip {

	/**
	 * 日志编码
	 */
	private String code;

	/**
	 * 操作描述
	 */
	private String description;

	/**
	 * 提醒日期
	 */
	private Date during = Utils.get(new Date(), "GMT+8");

	/**
	 * 提醒编码
	 */
	private String tipCode;

	/**
	 * 用户编码
	 */
	private String userCode;

	/**
	 * 日志编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 操作描述
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 提醒日期
	 */
	public Date getDuring() {
		return during;
	}

	/**
	 * 提醒编码
	 */
	public String getTipCode() {
		return tipCode;
	}

	/**
	 * 用户编码
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * 日志编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 操作描述
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 提醒日期
	 */
	public void setDuring(Date during) {
		this.during = during;
	}

	/**
	 * 提醒编码
	 */
	public void setTipCode(String tipcode) {
		this.tipCode = tipcode;
	}

	/**
	 * 用户编码
	 */
	public void setUserCode(String usercode) {
		this.userCode = usercode;
	}
}
