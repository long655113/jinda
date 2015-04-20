package org.trustel.account;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.trustel.common.Utils;
import org.trustel.privilege.CommonRole;
import org.trustel.system.AbstractRegion;
import org.trustel.util.ParameterFactory;

/**
 * 
 * 类 名：通用帐号信息
 * 
 * 版 本：0.0.0.1
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-04 09:23
 * 
 * 数据源：
 * 
 * 描 述：
 * 
 */

public abstract class CommonAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1547302089278981843L;

	/**
	 * 用户所在区域,用户登陆时加载
	 */
	public AbstractRegion _region = null;

	/**
	 * 当前用户可以操作的业务区域列表,用户登陆时加载
	 */
	public List<?> _regions = null;

	/**
	 * 该辅助服务在用户登陆时加载
	 */
	public IRegionOfAccountService _regionService = null;

	/**
	 * 所属角色,用户登陆时加载
	 */
	public CommonRole _role = null;

	/**
	 * 该辅助服务在用户登陆时加载
	 */
	public IRoleService _roleService = null;

	/**
	 * 登陆名称/帐号
	 */
	private String account;

	/**
	 * 帐号编码
	 */
	private String code;

	/**
	 * 联系邮箱
	 */
	private String email;

	/**
	 * 名 (映射first_name字段)
	 */
	protected String firstName;

	/**
	 * 登陆IP:可能通过ＩＰ限制登陆地址。
	 */
	private String ip;

	/**
	 * 缺省语言
	 */
	private String language = "zh_CN";

	/**
	 * 姓 (映射last_name字段)
	 */
	protected String lastName;

	/**
	 * 联系电话
	 */
	private String mobile;

	/**
	 * 姓名显示方式 (映射display字段)
	 */
	private int display = 0;

	/**
	 * 昵称
	 */
	protected String nickName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 缺省图像:头像文件绝对路径：不包括ＩＰ和端口
	 */
	private String photo;

	/**
	 * 所属组织 (映射region_id字段)
	 */
	private int regionId = 0;

	/**
	 * 角色 (映射role_code字段)
	 */
	private String roleCode;

	/**
	 * 帐号状态
	 */
	private int status = 2;

	/**
	 * 缺省样式
	 */
	private String theme;

	/**
	 * 最近登陆时间 (映射last_access_time字段)
	 */
	private Date timeOfLastAccess;

	/**
	 * 系统超时:分钟
	 */
	private int timeout = 0;

	 /**
     * md5加密使用
     */
    private String salt;

    /**
     * 商家id
     */
    private String merchantId;
    
    /**
     * 时间戳，用于同步账户至erp
     */
    private Date timeStamp;
 

	/**
	 * @see IRegionOfAccountService
	 */
	public String _getRegionHBMCondition(String fieldName, int regionId) {
		return _regionService.getRegionHBMCondition(this, fieldName, regionId);
	}

	public AbstractRegion _hasRegionPrivilege(int regionId) {
		return _regionService.hasRegionPrivilege(this, regionId);
	}

	/**
	 * @see IRegionOfAccountService
	 */
	public String _getRegionJDBCCondition(String fieldName, int regionId) {
		return _regionService.getRegionJDBCCondition(this, fieldName, regionId);
	}

	public String _getDisplayName() {
		if (display == 0)
			return Utils.null2Str(lastName) + Utils.null2Str(firstName);
		else
			return Utils.null2Str(firstName) + Utils.null2Str(lastName);
	}

	public String _getDisplayName(int display) {
		if (display == 0)
			return lastName + firstName;
		else
			return firstName + lastName;
	}

	/**
	 * 
	 * @return 登陆名称/帐号(account<--account)
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 
	 * @return 帐号编码(code<--code)
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return 用户选择的当前语言
	 */
	public String _getCurrentLanaguage() {
		return getLanguage();
	}

	private String getDefaultTheme() {
		return ParameterFactory.getString("SYSTEM_DEFAULTTHEME", "default");
	}

	/**
	 * 
	 * @return 联系邮箱(email<--email)
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @return 名(firstName<--first_name)
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @return 登陆IP:可能通过ＩＰ限制登陆地址。(ip<--ip)
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * 
	 * @return 缺省语言(language<--language)
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * 
	 * @return 姓(lastName<--last_name)
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @return 联系电话(mobile<--mobile)
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 
	 * 请参考SYSTEM_NAME_DISPLAYORDERS系统常量
	 * 
	 * @return 姓名显示方式(display<--display)
	 */
	public int getDisplay() {
		return display;
	}

	/**
	 * 
	 * @return 昵称(nickName<--nickName)
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * 
	 * @return 密码(password<--password)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @return 缺省图像:头像文件绝对路径：不包括ＩＰ和端口(photo<--photo)
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * 
	 * @return 所属组织(regionId<--region_id)
	 */
	public int getRegionId() {
		return regionId;
	}

	/**
	 * 
	 * @return 角色(roleCode<--role_code)
	 */
	public String getRoleCode() {
		return roleCode;
	}

	/**
	 * 
	 * @return 帐号状态(status<--status)
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 
	 * @return 缺省样式(theme<--theme)
	 */

	public String getTheme() {
		if (theme == null || theme.trim().equals(""))
			return getDefaultTheme();
		else
			return theme;
	}

	/**
	 * 
	 * @return 最近登陆时间(timeOfLastAccess<--last_access_time)
	 */
	public Date getTimeOfLastAccess() {
		return timeOfLastAccess;
	}

	/**
	 * 
	 * @return 系统超时:分钟(timeout<--timeout)
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * 设置登陆名称/帐号
	 * 
	 * @param 登陆名称
	 *            /帐号(account-->account)
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * 设置帐号编码
	 * 
	 * @param 帐号编码
	 *            (code-->code)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 设置联系邮箱
	 * 
	 * @param 联系邮箱
	 *            (email-->email)
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 设置名
	 * 
	 * @param 名
	 *            (firstName-->first_name)
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * 设置登陆IP:可能通过ＩＰ限制登陆地址。
	 * 
	 * @param 登陆IP
	 *            :可能通过ＩＰ限制登陆地址。(ip-->ip)
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * 设置缺省语言
	 * 
	 * @param 缺省语言
	 *            (language-->language)
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * 设置姓
	 * 
	 * @param 姓
	 *            (lastName-->last_name)
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * 设置联系电话
	 * 
	 * @param 联系电话
	 *            (mobile-->mobile)
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 设置姓名显示方式
	 * 
	 * @param 姓名显示方式
	 *            (display-->display)
	 */
	public void setDisplay(int display) {
		this.display = display;
	}

	/**
	 * 设置昵称
	 * 
	 * @param 昵称
	 *            (nickName-->nickName)
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 设置密码
	 * 
	 * @param 密码
	 *            (password-->password)
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 设置缺省图像:头像文件绝对路径：不包括ＩＰ和端口
	 * 
	 * @param 缺省图像
	 *            :头像文件绝对路径：不包括ＩＰ和端口(photo-->photo)
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * 设置所属组织
	 * 
	 * @param 所属组织
	 *            (regionId-->region_id)
	 */
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	/**
	 * 设置角色
	 * 
	 * @param 角色
	 *            (roleCode-->role_code)
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	/**
	 * 设置帐号状态
	 * 
	 * @param 帐号状态
	 *            (status-->status)
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * 设置缺省样式
	 * 
	 * @param 缺省样式
	 *            (theme-->theme)
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * 设置最近登陆时间
	 * 
	 * @param 最近登陆时间
	 *            (timeOfLastAccess-->last_access_time)
	 */
	public void setTimeOfLastAccess(Date timeOfLastAccess) {
		this.timeOfLastAccess = timeOfLastAccess;
	}

	/**
	 * 设置系统超时:分钟
	 * 
	 * @param 系统超时
	 *            :分钟(timeout-->timeout)
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	
	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * get 商家id
	 * @return
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * set 商家id
	 * @param merchantId
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}


	public void cloneFrom(CommonAccount item, boolean includePrimaryKey) {
		// 帐号编码(code-->code
		if (includePrimaryKey){
			this.code = item.getCode();
		}
		// 姓名显示方式(display-->display
		this.display = item.getDisplay();
		// 姓(lastName-->last_name
		this.lastName = item.getLastName();
		// 名(firstName-->first_name
		this.firstName = item.getFirstName();
		// 昵称(nickName-->nickName
		this.nickName = item.getNickName();
		// 缺省图像(photo-->photo
		this.photo = item.getPhoto();
		// 登陆名称/帐号(account-->account
		this.account = item.getAccount();
		// 密码(password-->password
		this.password = item.getPassword();
		// 联系电话(mobile-->mobile
		this.mobile = item.getMobile();
		// 联系邮箱(email-->email
		this.email = item.getEmail();
		// 所属组织(regionId-->region_id
		this.regionId = item.getRegionId();
		// 缺省样式(theme-->theme
		this.theme = item.getTheme();
		// 缺省语言(language-->language
		this.language = item.getLanguage();
		// 系统超时(timeout-->timeout
		this.timeout = item.getTimeout();
		// 帐号状态(status-->status
		this.status = item.getStatus();
		// 角色(roleCode-->role_code
		this.roleCode = item.getRoleCode();
		// 最近登陆时间(timeOfLastAccess-->last_access_time
		this.timeOfLastAccess = item.getTimeOfLastAccess();
		// 登陆IP(ip-->ip
		this.ip = item.getIp();
		//商家id
		this.merchantId = item.getMerchantId();
		//MD5加密用
		this.salt = item.getSalt();
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


}