package org.trustel.system;

import java.util.Date;

/**
 * 
 * 类 名：系统登陆日志
 * 
 * 版 本：0.0.0.1
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-11 13:07
 * 
 * 数据源：system_loginlogs(系统登陆日志)
 * 
 * 描 述：
 * 
 **/

public class LogOfLogon {
	/**
	 * 编码
	 */
	private String code ;
	/**
	 * 登陆帐号
	 */
	private String account;
	/**
	 * 登陆时间 (映射logon_in字段)
	 */
	private Date logonIn;
	/**
	 * 密码:当密码错误时记录
	 */
	private String password;
	/**
	 * 是否登陆成功
	 */
	private int success = 1;
	/**
	 * 出错描述
	 */
	private String description;
	/**
	 * 退出时间 (映射logon_out字段)
	 */
	private Date logonOut;
	/**
	 * 登陆IP
	 */
	private String ip;
	/**
	 * 访问域名:用户是从哪个页面访问的,包括ＵＲＬ参数
	 */
	private String url;

	/**
	 * 
	 * @return 编码(code<--code)
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return 登陆帐号(account<--account)
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 
	 * @return 登陆时间(logonIn<--logon_in)
	 */
	public Date getLogonIn() {
		return logonIn;
	}

	/**
	 * 
	 * @return 密码:当密码错误时记录(password<--password)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * 请参考SYSTEM_LOGINFLAGS系统常量
	 * 
	 * @return 是否登陆成功(success<--success)
	 */
	public int getSuccess() {
		return success;
	}

	/**
	 * 
	 * @return 出错描述(description<--description)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return 退出时间(logonOut<--logon_out)
	 */
	public Date getLogonOut() {
		return logonOut;
	}

	/**
	 * 
	 * @return 登陆IP(ip<--ip)
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * 
	 * @return 访问域名:用户是从哪个页面访问的,包括ＵＲＬ参数(url<--url)
	 */
	public String getUrl() {
		return url;
	}

	/**
	 *设置编码
	 * 
	 * @param 编码
	 *            (id-->id)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 *设置登陆帐号
	 * 
	 * @param 登陆帐号
	 *            (account-->account)
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 *设置登陆时间
	 * 
	 * @param 登陆时间
	 *            (logonIn-->logon_in)
	 */
	public void setLogonIn(Date logonIn) {
		this.logonIn = logonIn;
	}

	/**
	 *设置密码:当密码错误时记录
	 * 
	 * @param 密码
	 *            :当密码错误时记录(password-->password)
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 *设置是否登陆成功
	 * 
	 * @param 是否登陆成功
	 *            (success-->success)
	 */
	public void setSuccess(int success) {
		this.success = success;
	}

	/**
	 *设置出错描述
	 * 
	 * @param 出错描述
	 *            (description-->description)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 *设置退出时间
	 * 
	 * @param 退出时间
	 *            (logonOut-->logon_out)
	 */
	public void setLogonOut(Date logonOut) {
		this.logonOut = logonOut;
	}

	/**
	 *设置登陆IP
	 * 
	 * @param 登陆IP
	 *            (ip-->ip)
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 *设置访问域名:用户是从哪个页面访问的,包括ＵＲＬ参数
	 * 
	 * @param 访问域名
	 *            :用户是从哪个页面访问的,包括ＵＲＬ参数(url-->url)
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	public void cloneFrom(Visitor visitor) {
		if (visitor == null)
			return;
		ip = visitor.IP;
		url = visitor.url;

		code = visitor.loginId;
		success = visitor.logined ? 0 : 1;
		if (visitor.account == null)
			return;

		account = visitor.account.getAccount();

	}

}
