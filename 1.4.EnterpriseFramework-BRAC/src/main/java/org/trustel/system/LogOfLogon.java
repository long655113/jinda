package org.trustel.system;

import java.util.Date;

/**
 * 
 * �� ����ϵͳ��½��־
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-11 13:07
 * 
 * ����Դ��system_loginlogs(ϵͳ��½��־)
 * 
 * �� ����
 * 
 **/

public class LogOfLogon {
	/**
	 * ����
	 */
	private String code ;
	/**
	 * ��½�ʺ�
	 */
	private String account;
	/**
	 * ��½ʱ�� (ӳ��logon_in�ֶ�)
	 */
	private Date logonIn;
	/**
	 * ����:���������ʱ��¼
	 */
	private String password;
	/**
	 * �Ƿ��½�ɹ�
	 */
	private int success = 1;
	/**
	 * ��������
	 */
	private String description;
	/**
	 * �˳�ʱ�� (ӳ��logon_out�ֶ�)
	 */
	private Date logonOut;
	/**
	 * ��½IP
	 */
	private String ip;
	/**
	 * ��������:�û��Ǵ��ĸ�ҳ����ʵ�,�����գң̲���
	 */
	private String url;

	/**
	 * 
	 * @return ����(code<--code)
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return ��½�ʺ�(account<--account)
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 
	 * @return ��½ʱ��(logonIn<--logon_in)
	 */
	public Date getLogonIn() {
		return logonIn;
	}

	/**
	 * 
	 * @return ����:���������ʱ��¼(password<--password)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * ��ο�SYSTEM_LOGINFLAGSϵͳ����
	 * 
	 * @return �Ƿ��½�ɹ�(success<--success)
	 */
	public int getSuccess() {
		return success;
	}

	/**
	 * 
	 * @return ��������(description<--description)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return �˳�ʱ��(logonOut<--logon_out)
	 */
	public Date getLogonOut() {
		return logonOut;
	}

	/**
	 * 
	 * @return ��½IP(ip<--ip)
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * 
	 * @return ��������:�û��Ǵ��ĸ�ҳ����ʵ�,�����գң̲���(url<--url)
	 */
	public String getUrl() {
		return url;
	}

	/**
	 *���ñ���
	 * 
	 * @param ����
	 *            (id-->id)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 *���õ�½�ʺ�
	 * 
	 * @param ��½�ʺ�
	 *            (account-->account)
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 *���õ�½ʱ��
	 * 
	 * @param ��½ʱ��
	 *            (logonIn-->logon_in)
	 */
	public void setLogonIn(Date logonIn) {
		this.logonIn = logonIn;
	}

	/**
	 *��������:���������ʱ��¼
	 * 
	 * @param ����
	 *            :���������ʱ��¼(password-->password)
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 *�����Ƿ��½�ɹ�
	 * 
	 * @param �Ƿ��½�ɹ�
	 *            (success-->success)
	 */
	public void setSuccess(int success) {
		this.success = success;
	}

	/**
	 *���ó�������
	 * 
	 * @param ��������
	 *            (description-->description)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 *�����˳�ʱ��
	 * 
	 * @param �˳�ʱ��
	 *            (logonOut-->logon_out)
	 */
	public void setLogonOut(Date logonOut) {
		this.logonOut = logonOut;
	}

	/**
	 *���õ�½IP
	 * 
	 * @param ��½IP
	 *            (ip-->ip)
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 *���÷�������:�û��Ǵ��ĸ�ҳ����ʵ�,�����գң̲���
	 * 
	 * @param ��������
	 *            :�û��Ǵ��ĸ�ҳ����ʵ�,�����գң̲���(url-->url)
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
