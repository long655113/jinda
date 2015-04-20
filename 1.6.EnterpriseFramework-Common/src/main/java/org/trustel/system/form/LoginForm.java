package org.trustel.system.form;

/**
 * @Description: 系统登录参数
 * @author  guof
 * @date    2013-4-12 下午05:45:51
 * @version V1.0 
 */
public class LoginForm {
	//后台用户名
	public static final String CONSTANT_LOGIN_NAME =	"ENCRYPT_ADMIN_NAME";
	//后台密码
	public static final String CONSTANT_LOGIN_PASSWORD =	"ENCRYPT_ADMIN_PASSWORD";
	//后台是否记住用户名
	public static final String CONSTANT_REMEMBER_CODE =	"ENCRYPT_ADMIN_REMEMBER_CODE";
	//后台是否记住用户名
	public static final String CONSTANT_REMEMBER_PASSWORD =	"ENCRYPT_ADMIN_REMEMBER_PASSWORD";
	//密码是否已经加密过
	public static final String CONSTANT_PASSWORD_ENCRYPTED ="ENCRYPT_ADMIN_PASSWORD_ENCRYPTED";
	/**
	 * @Fields merchantId: 商家ID
	 */
	private String merchantId;

	/**
	 * @Fields loginName: 账号
	 */
	private String loginName;

	/**
	 *  @Fields loginType: 登录类型：1、账号登录（手机号码、email和密码登录）；2、快捷登录（手机号码、手机校验码）
	 */
	private String loginType;
	
	/**
	 * @Fields password: 密码
	 */
	private String password;
	
	/**
	 * @Fields message: 提示信息
	 */
	private String message;
	
	/**
	 * @Fields rememberPass:记住账号
	 */
	private String rememberCode;

	/**
	 * @Fields rememberPass: 记住密码
	 */
	private String rememberPass;
	/**
	 * 密码是否已经加密过：1是（代表使用3des进行了加密）0否,则前台需要调用rsa加密算法
	 */
	private int passEncrypted=0;
	
	/**
	 * ERP系统单点登陆路标记：默认为空 ,有值表示是属于单点登录
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
	 * 商家ID
	 * @return merchantId (merchantId<--merchantId)
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * 商家ID
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