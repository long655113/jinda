package org.trustel.system;

/**
 * 
 * 类 名：系统常量
 * 
 * 版 本：0.0.0.1
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-04-21 14:56
 * 
 * 数据源：
 * 
 * 描 述：
 * 
 * 在SESSION中的变量命名以SESSION开始，放在请求中的变量以ATTRIBUTE开始，区分ACTION的变量以ACTION开始
 * 
 */

public class SystemConstant {

	public final static String SESSION_VISITOR = "VISITOR";

	public final static String SESSION_MESSAGE = "MESSAGE";

	public final static String ATTRIBUTE_MESSAGE = "MESSAGE";

	public final static String ATTRIBUTE_ITEMPAGE = "ITEMPAGE";

	public final static String ATTRIBUTE_INSTANCE = "INSTANCE";

	public final static String ATTRIBUTE_LIST = "LIST_DATA";

	public final static String ACTION_DELETE = "DELETE";
	
	public final static String SESSION_HUEASYURL = "HUEASYURL";
	
	/**
	 * 技能组
	 */
	public final static String SESSION_SKILLGROUP = "SESSION_SKILLGROUP";

	/**
	 * 根目录ID 
	 */
	public final static String DIR_ROOT_ID = "0";

	/**
	 * 代理商uid
	 */
	public final static String SESSION_AGENT_UID = "agentUid";

	/**
	 * 系统后台用户登录名
	 */
	public final static String SESSION_ADMIN_NAME = "ADMIN_NAME";
	/**
	 * 系统前台用户登录名
	 */
	public final static String SESSION_USER_NAME = "USER_NAME";
	
	/**
	 * 系统后台用户登录密码
	 */
	public final static String SESSION_ADMIN_PASS = "ADMIN_PASS";
	
	/**
	 * 商家信息
	 */
	public final static String SESSION_MERCHANT = "MERCHANT_BASE_INFO";
	/**
	 * 商家模板id
	 */
	public final static String SESSION_PAGE_TEMPLATE_ID = "template"; 
	

}