package org.trustel.privilege;

import java.util.Date;

/**
 * 
 * 类 名：委托授权登记表
 * 
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-11 10:31
 * 
 * 数据源：system_permitions(委托授权登记表)
 * 
 * 描 述：暂不支持按次和按业务内容的授权模式
 * 
 * @version 1.0.0.0 2011-03-11
 * 
 **/

public class Permition {
	/**
	 * 授权编码
	 */
	private int id = 0;
	/**
	 * 委托人:系统帐号编码 (映射consignor_code字段)
	 */
	private String consignorCode;
	/**
	 * 受理人:即系统帐号编码 (映射delegate_code字段)
	 */
	private String delegateCode;
	/**
	 * 授权日期
	 */
	private Date created;
	/**
	 * 授权生效时间 (映射delegate_start字段)
	 */
	private Date delegateStart;
	/**
	 * 授权结束时间 (映射delegate_expire字段)
	 */
	private Date delegateExpire;
	/**
	 * 授权描述:授权人给代理人的说明 或因何授权处理
	 */
	private String description;

	/**
	 * 
	 * @return 授权编码(id<--id)
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return 委托人:系统帐号编码(consignorCode<--consignor_code)
	 */
	public String getConsignorCode() {
		return consignorCode;
	}

	/**
	 * 
	 * @return 受理人:即系统帐号编码(delegateCode<--delegate_code)
	 */
	public String getDelegateCode() {
		return delegateCode;
	}

	/**
	 * 
	 * @return 授权日期(created<--created)
	 */
	public Date getCreated() {
		return created;
	}

	/**
	 * 
	 * @return 授权生效时间(delegateStart<--delegate_start)
	 */
	public Date getDelegateStart() {
		return delegateStart;
	}

	/**
	 * 
	 * @return 授权结束时间(delegateExpire<--delegate_expire)
	 */
	public Date getDelegateExpire() {
		return delegateExpire;
	}

	/**
	 * 
	 * @return 授权描述:授权人给代理人的说明 或因何授权处理(description<--description)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 *设置授权编码
	 * 
	 * @param 授权编码
	 *            (id-->id)
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 *设置委托人:系统帐号编码
	 * 
	 * @param 委托人
	 *            :系统帐号编码(consignorCode-->consignor_code)
	 */
	public void setConsignorCode(String consignorCode) {
		this.consignorCode = consignorCode;
	}

	/**
	 *设置受理人:即系统帐号编码
	 * 
	 * @param 受理人
	 *            :即系统帐号编码(delegateCode-->delegate_code)
	 */
	public void setDelegateCode(String delegateCode) {
		this.delegateCode = delegateCode;
	}

	/**
	 *设置授权日期
	 * 
	 * @param 授权日期
	 *            (created-->created)
	 */
	public void setCreated(Date created) {
		this.created = created;
	}

	/**
	 *设置授权生效时间
	 * 
	 * @param 授权生效时间
	 *            (delegateStart-->delegate_start)
	 */
	public void setDelegateStart(Date delegateStart) {
		this.delegateStart = delegateStart;
	}

	/**
	 *设置授权结束时间
	 * 
	 * @param 授权结束时间
	 *            (delegateExpire-->delegate_expire)
	 */
	public void setDelegateExpire(Date delegateExpire) {
		this.delegateExpire = delegateExpire;
	}

	/**
	 *设置授权描述:授权人给代理人的说明 或因何授权处理
	 * 
	 * @param 授权描述
	 *            :授权人给代理人的说明 或因何授权处理(description-->description)
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
