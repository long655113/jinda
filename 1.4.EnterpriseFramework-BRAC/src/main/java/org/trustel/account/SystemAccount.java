package org.trustel.account;

import java.util.Date;

/**
 * 
 * 类 名：系统帐号信息
 * 
 * 版 本：0.0.0.1
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-04 09:27
 * 
 * 数据源：system_accounts(系统帐号信息)
 * 
 * 描 述：
 * 
 */

public class SystemAccount extends CommonAccount {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6897566537810337343L;

	/**
	 * 公司电话
	 */
	private String tel;

	/**
	 * 公司传真
	 */
	private String tax;

	/**
	 *邮编
	 */
	private String postCode;

	/**
	 * 生效时间
	 */
	private Date startDate;

	/**
	 * 失效时间
	 */
	private Date endDate;

	/**
	 * 密码类型 (映射passwod_category字段)
	 */
	private int passwodCategory = 0;

	/**
	 * 密码过期时间
	 */
	private Date deadline;

	/**
	 * 剩余使用次数:可用次数
	 */
	private int availables = 0;

	/**
	 * 
	 * 请参考SYSTEM_PASSWORDCATEGORIES系统常量
	 * 
	 * @return 密码类型(passwodCategory<--passwod_category)
	 */
	public int getPasswodCategory() {
		return passwodCategory;
	}

	/**
	 * 
	 * @return 密码过期时间(deadline<--deadline)
	 */
	public Date getDeadline() {
		return deadline;
	}

	/**
	 * 
	 * @return 剩余使用次数:可用次数(availables<--availables)
	 */
	public int getAvailables() {
		return availables;
	}

	/**
	 * 设置密码类型
	 * 
	 * @param 密码类型
	 *            (passwodCategory-->passwod_category)
	 */
	public void setPasswodCategory(int passwodCategory) {
		this.passwodCategory = passwodCategory;
	}

	/**
	 * 设置密码过期时间
	 * 
	 * @param 密码过期时间
	 *            (deadline-->deadline)
	 */
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	/**
	 * 设置剩余使用次数:可用次数
	 * 
	 * @param 剩余使用次数
	 *            :可用次数(availables-->availables)
	 */
	public void setAvailables(int availables) {
		this.availables = availables;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTax() {
		return tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public void cloneFrom(CommonAccount item, boolean includePrimaryKey) {
		super.cloneFrom(item, includePrimaryKey);
		SystemAccount systemAccount = (SystemAccount) item;
		// 密码类型(passwodCategory-->passwod_category)
		this.passwodCategory = systemAccount.getPasswodCategory();
		// 密码过期时间(deadline-->deadline)
		this.deadline = systemAccount.getDeadline();
		// 剩余使用次数(availables-->availables)
		this.availables = systemAccount.getAvailables();
		this.tel = systemAccount.getTel();
		this.tax = systemAccount.getTax();
		this.postCode = systemAccount.getPostCode();
		this.startDate = systemAccount.getStartDate();
		this.endDate = systemAccount.getEndDate();
	}
}
