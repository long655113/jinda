package org.trustel.system.form;

/**
 * @Description: ϵͳ��¼����
 * @author  guof
 * @date    2013-4-12 ����05:45:51
 * @version V1.0 
 */
public class LoginForm {
	//��̨�û���
	public static final String CONSTANT_LOGIN_NAME =	"ENCRYPT_ADMIN_NAME";
	//��̨����
	public static final String CONSTANT_LOGIN_PASSWORD =	"ENCRYPT_ADMIN_PASSWORD";
	//��̨�Ƿ��ס�û���
	public static final String CONSTANT_REMEMBER_CODE =	"ENCRYPT_ADMIN_REMEMBER_CODE";
	//��̨�Ƿ��ס�û���
	public static final String CONSTANT_REMEMBER_PASSWORD =	"ENCRYPT_ADMIN_REMEMBER_PASSWORD";
	//�����Ƿ��Ѿ����ܹ�
	public static final String CONSTANT_PASSWORD_ENCRYPTED ="ENCRYPT_ADMIN_PASSWORD_ENCRYPTED";
	/**
	 * @Fields merchantId: �̼�ID
	 */
	private String merchantId;

	/**
	 * @Fields loginName: �˺�
	 */
	private String loginName;

	/**
	 *  @Fields loginType: ��¼���ͣ�1���˺ŵ�¼���ֻ����롢email�������¼����2����ݵ�¼���ֻ����롢�ֻ�У���룩
	 */
	private String loginType;
	
	/**
	 * @Fields password: ����
	 */
	private String password;
	
	/**
	 * @Fields message: ��ʾ��Ϣ
	 */
	private String message;
	
	/**
	 * @Fields rememberPass:��ס�˺�
	 */
	private String rememberCode;

	/**
	 * @Fields rememberPass: ��ס����
	 */
	private String rememberPass;
	/**
	 * �����Ƿ��Ѿ����ܹ���1�ǣ�����ʹ��3des�����˼��ܣ�0��,��ǰ̨��Ҫ����rsa�����㷨
	 */
	private int passEncrypted=0;
	
	/**
	 * ERPϵͳ�����½·��ǣ�Ĭ��Ϊ�� ,��ֵ��ʾ�����ڵ����¼
	 */
	private String ssoLogin;
	

	/**
	 * @return the passEncrypted
	 */
	public int getPassEncrypted() {
		return passEncrypted;
	}

	/**
	 * @param passEncrypted the passEncrypted to set
	 */
	public void setPassEncrypted(int passEncrypted) {
		this.passEncrypted = passEncrypted;
	}

	/**
	 * �̼�ID
	 * @return merchantId (merchantId<--merchantId)
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * �̼�ID
	 * @param merchantId (merchantId-->merchantId)
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getLoginName() {
		return loginName;
	}

	public String getMessage() {
		return message;
	}

	public String getPassword() {
		return password;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return String.format("name=%s/password=%s/rememberCode=%s/rememberPass=%s",new Object[]{loginName, password,rememberCode,rememberPass});
	}

	public String getLoginType() {
		return loginType;
	}

	public void setLoginType(String loginType) {
		this.loginType = loginType;
	}

	public String getRememberCode() {
		return rememberCode;
	}

	public void setRememberCode(String rememberCode) {
		this.rememberCode = rememberCode;
	}

	public String getRememberPass() {
		return rememberPass;
	}

	public void setRememberPass(String rememberPass) {
		this.rememberPass = rememberPass;
	}

	public String getSsoLogin() {
		return ssoLogin;
	}

	public void setSsoLogin(String ssoLogin) {
		this.ssoLogin = ssoLogin;
	}


	
}