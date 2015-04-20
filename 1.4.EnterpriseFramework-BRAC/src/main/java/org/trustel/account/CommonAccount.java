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
 * �� ����ͨ���ʺ���Ϣ
 * 
 * �� ����0.0.0.1
 * 
 * �� �ƣ���־��
 * 
 * �� �ڣ�2011-03-04 09:23
 * 
 * ����Դ��
 * 
 * �� ����
 * 
 */

public abstract class CommonAccount implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1547302089278981843L;

	/**
	 * �û���������,�û���½ʱ����
	 */
	public AbstractRegion _region = null;

	/**
	 * ��ǰ�û����Բ�����ҵ�������б�,�û���½ʱ����
	 */
	public List<?> _regions = null;

	/**
	 * �ø����������û���½ʱ����
	 */
	public IRegionOfAccountService _regionService = null;

	/**
	 * ������ɫ,�û���½ʱ����
	 */
	public CommonRole _role = null;

	/**
	 * �ø����������û���½ʱ����
	 */
	public IRoleService _roleService = null;

	/**
	 * ��½����/�ʺ�
	 */
	private String account;

	/**
	 * �ʺű���
	 */
	private String code;

	/**
	 * ��ϵ����
	 */
	private String email;

	/**
	 * �� (ӳ��first_name�ֶ�)
	 */
	protected String firstName;

	/**
	 * ��½IP:����ͨ���ɣ����Ƶ�½��ַ��
	 */
	private String ip;

	/**
	 * ȱʡ����
	 */
	private String language = "zh_CN";

	/**
	 * �� (ӳ��last_name�ֶ�)
	 */
	protected String lastName;

	/**
	 * ��ϵ�绰
	 */
	private String mobile;

	/**
	 * ������ʾ��ʽ (ӳ��display�ֶ�)
	 */
	private int display = 0;

	/**
	 * �ǳ�
	 */
	protected String nickName;

	/**
	 * ����
	 */
	private String password;

	/**
	 * ȱʡͼ��:ͷ���ļ�����·�����������ɣкͶ˿�
	 */
	private String photo;

	/**
	 * ������֯ (ӳ��region_id�ֶ�)
	 */
	private int regionId = 0;

	/**
	 * ��ɫ (ӳ��role_code�ֶ�)
	 */
	private String roleCode;

	/**
	 * �ʺ�״̬
	 */
	private int status = 2;

	/**
	 * ȱʡ��ʽ
	 */
	private String theme;

	/**
	 * �����½ʱ�� (ӳ��last_access_time�ֶ�)
	 */
	private Date timeOfLastAccess;

	/**
	 * ϵͳ��ʱ:����
	 */
	private int timeout = 0;

	 /**
     * md5����ʹ��
     */
    private String salt;

    /**
     * �̼�id
     */
    private String merchantId;
    
    /**
     * ʱ���������ͬ���˻���erp
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
	 * @return ��½����/�ʺ�(account<--account)
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 
	 * @return �ʺű���(code<--code)
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return �û�ѡ��ĵ�ǰ����
	 */
	public String _getCurrentLanaguage() {
		return getLanguage();
	}

	private String getDefaultTheme() {
		return ParameterFactory.getString("SYSTEM_DEFAULTTHEME", "default");
	}

	/**
	 * 
	 * @return ��ϵ����(email<--email)
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 
	 * @return ��(firstName<--first_name)
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * 
	 * @return ��½IP:����ͨ���ɣ����Ƶ�½��ַ��(ip<--ip)
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * 
	 * @return ȱʡ����(language<--language)
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * 
	 * @return ��(lastName<--last_name)
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * 
	 * @return ��ϵ�绰(mobile<--mobile)
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * 
	 * ��ο�SYSTEM_NAME_DISPLAYORDERSϵͳ����
	 * 
	 * @return ������ʾ��ʽ(display<--display)
	 */
	public int getDisplay() {
		return display;
	}

	/**
	 * 
	 * @return �ǳ�(nickName<--nickName)
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * 
	 * @return ����(password<--password)
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 
	 * @return ȱʡͼ��:ͷ���ļ�����·�����������ɣкͶ˿�(photo<--photo)
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * 
	 * @return ������֯(regionId<--region_id)
	 */
	public int getRegionId() {
		return regionId;
	}

	/**
	 * 
	 * @return ��ɫ(roleCode<--role_code)
	 */
	public String getRoleCode() {
		return roleCode;
	}

	/**
	 * 
	 * @return �ʺ�״̬(status<--status)
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * 
	 * @return ȱʡ��ʽ(theme<--theme)
	 */

	public String getTheme() {
		if (theme == null || theme.trim().equals(""))
			return getDefaultTheme();
		else
			return theme;
	}

	/**
	 * 
	 * @return �����½ʱ��(timeOfLastAccess<--last_access_time)
	 */
	public Date getTimeOfLastAccess() {
		return timeOfLastAccess;
	}

	/**
	 * 
	 * @return ϵͳ��ʱ:����(timeout<--timeout)
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * ���õ�½����/�ʺ�
	 * 
	 * @param ��½����
	 *            /�ʺ�(account-->account)
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * �����ʺű���
	 * 
	 * @param �ʺű���
	 *            (code-->code)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * ������ϵ����
	 * 
	 * @param ��ϵ����
	 *            (email-->email)
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * ������
	 * 
	 * @param ��
	 *            (firstName-->first_name)
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * ���õ�½IP:����ͨ���ɣ����Ƶ�½��ַ��
	 * 
	 * @param ��½IP
	 *            :����ͨ���ɣ����Ƶ�½��ַ��(ip-->ip)
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * ����ȱʡ����
	 * 
	 * @param ȱʡ����
	 *            (language-->language)
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * ������
	 * 
	 * @param ��
	 *            (lastName-->last_name)
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * ������ϵ�绰
	 * 
	 * @param ��ϵ�绰
	 *            (mobile-->mobile)
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * ����������ʾ��ʽ
	 * 
	 * @param ������ʾ��ʽ
	 *            (display-->display)
	 */
	public void setDisplay(int display) {
		this.display = display;
	}

	/**
	 * �����ǳ�
	 * 
	 * @param �ǳ�
	 *            (nickName-->nickName)
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * ��������
	 * 
	 * @param ����
	 *            (password-->password)
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ����ȱʡͼ��:ͷ���ļ�����·�����������ɣкͶ˿�
	 * 
	 * @param ȱʡͼ��
	 *            :ͷ���ļ�����·�����������ɣкͶ˿�(photo-->photo)
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * ����������֯
	 * 
	 * @param ������֯
	 *            (regionId-->region_id)
	 */
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}

	/**
	 * ���ý�ɫ
	 * 
	 * @param ��ɫ
	 *            (roleCode-->role_code)
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	/**
	 * �����ʺ�״̬
	 * 
	 * @param �ʺ�״̬
	 *            (status-->status)
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * ����ȱʡ��ʽ
	 * 
	 * @param ȱʡ��ʽ
	 *            (theme-->theme)
	 */
	public void setTheme(String theme) {
		this.theme = theme;
	}

	/**
	 * ���������½ʱ��
	 * 
	 * @param �����½ʱ��
	 *            (timeOfLastAccess-->last_access_time)
	 */
	public void setTimeOfLastAccess(Date timeOfLastAccess) {
		this.timeOfLastAccess = timeOfLastAccess;
	}

	/**
	 * ����ϵͳ��ʱ:����
	 * 
	 * @param ϵͳ��ʱ
	 *            :����(timeout-->timeout)
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
	 * get �̼�id
	 * @return
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * set �̼�id
	 * @param merchantId
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}


	public void cloneFrom(CommonAccount item, boolean includePrimaryKey) {
		// �ʺű���(code-->code
		if (includePrimaryKey){
			this.code = item.getCode();
		}
		// ������ʾ��ʽ(display-->display
		this.display = item.getDisplay();
		// ��(lastName-->last_name
		this.lastName = item.getLastName();
		// ��(firstName-->first_name
		this.firstName = item.getFirstName();
		// �ǳ�(nickName-->nickName
		this.nickName = item.getNickName();
		// ȱʡͼ��(photo-->photo
		this.photo = item.getPhoto();
		// ��½����/�ʺ�(account-->account
		this.account = item.getAccount();
		// ����(password-->password
		this.password = item.getPassword();
		// ��ϵ�绰(mobile-->mobile
		this.mobile = item.getMobile();
		// ��ϵ����(email-->email
		this.email = item.getEmail();
		// ������֯(regionId-->region_id
		this.regionId = item.getRegionId();
		// ȱʡ��ʽ(theme-->theme
		this.theme = item.getTheme();
		// ȱʡ����(language-->language
		this.language = item.getLanguage();
		// ϵͳ��ʱ(timeout-->timeout
		this.timeout = item.getTimeout();
		// �ʺ�״̬(status-->status
		this.status = item.getStatus();
		// ��ɫ(roleCode-->role_code
		this.roleCode = item.getRoleCode();
		// �����½ʱ��(timeOfLastAccess-->last_access_time
		this.timeOfLastAccess = item.getTimeOfLastAccess();
		// ��½IP(ip-->ip
		this.ip = item.getIp();
		//�̼�id
		this.merchantId = item.getMerchantId();
		//MD5������
		this.salt = item.getSalt();
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}


}