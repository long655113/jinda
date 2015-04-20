package org.trustel.system;

import java.io.Serializable;
import java.util.Date;

import org.trustel.common.Utils;


/**
 * 类 名：系统提醒信息
 * 
 * 日 期：2008-01-23
 * 
 * 设 计：万志勇
 * 
 * 版 本：0.0.0.1
 * 
 */
public class SystemTip implements Serializable {

	private static final long serialVersionUID = 6161617787200589234L;

	/**
	 * 提醒类型 <br>
	 * 1-消息 2-URL
	 */
	private int category = 0;

	/**
	 * 数据编码
	 */
	private String code;

	/**
	 * 备注
	 */
	private String description;

	/**
	 * 有效期
	 */
	private Date expire = Utils.get(new Date(), "GMT+8");

	/**
	 * 提醒内容
	 */
	private String msg;

	private int orgid;

	/**
	 * 开始日期
	 */
	private Date outset = Utils.get(new Date(), "GMT+8");

	/**
	 * 状态 <br>
	 * 1-有效 其他--无效
	 */
	private int status = 1;

	private String ucode;

	/**
	 * 提醒类型 <br>
	 * 1-消息 2-URL
	 */
	public int getCategory() {
		return category;
	}

	/**
	 * 数据编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 备注
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 有效期
	 */
	public Date getExpire() {
		return expire;
	}

	/**
	 * 提醒内容
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 开始日期
	 */
	public Date getOutset() {
		return outset;
	}

	/**
	 * 状态 <br>
	 * 1-有效 其他--无效
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 提醒类型 <br>
	 * 1-消息 2-URL
	 */
	public void setCategory(int category) {
		this.category = category;
	}

	/**
	 * 数据编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 备注
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 有效期
	 */
	public void setExpire(Date expire) {
		this.expire = expire;
	}

	/**
	 * 提醒内容
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 开始日期
	 */
	public void setOutset(Date outset) {
		this.outset = outset;
	}

	/**
	 * 状态 <br>
	 * 1-有效 其他--无效
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	public int getOrgid() {
		return orgid;
	}

	public void setOrgid(int orgid) {
		this.orgid = orgid;
	}

	public String getUcode() {
		return ucode;
	}

	public void setUcode(String ucode) {
		this.ucode = ucode;
	}
}
