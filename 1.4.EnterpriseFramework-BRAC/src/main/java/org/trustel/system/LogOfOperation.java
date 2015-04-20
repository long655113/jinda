package org.trustel.system;

import java.util.Date;

/**
 * 
 * 类 名：系统操作日志
 * 
 * 版 本：0.0.0.1
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-11 13:23
 * 
 * 数据源：system_operationlogs(系统操作日志)
 * 
 * 描 述：
 * 
 */

public class LogOfOperation {
	/**
	 * 操作描述
	 */
	private String description;

	/**
	 * 功能编码(权限码) (映射function_code字段)
	 */
	private String functionCode;

	/**
	 * 操作ID
	 */
	private int id = 0;

	/**
	 * 登陆ID (映射logon_id字段)
	 */
	private int logonId = 0;

	/**
	 * 操作类型:用来收集用户使用习惯 (映射operation_category字段)
	 */
	private int operationCategory = 0;

	/**
	 * 操作时间 (映射operation_seconds字段)
	 */
	private Date operationSeconds;

	/**
	 * 
	 * @return 操作描述(description<--description)
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 
	 * @return 功能编码(权限码)(functionCode<--function_code)
	 */
	public String getFunctionCode() {
		return functionCode;
	}

	/**
	 * 
	 * @return 操作ID(id<--id)
	 */
	public int getId() {
		return id;
	}

	/**
	 * 
	 * @return 登陆ID(logonId<--logon_id)
	 */
	public int getLogonId() {
		return logonId;
	}

	/**
	 * 
	 * 请参考SYSTEM_OPERATIONLOG_CATEGORIES系统常量
	 * 
	 * @return 操作类型:用来收集用户使用习惯(operationCategory<--operation_category)
	 */
	public int getOperationCategory() {
		return operationCategory;
	}

	/**
	 * 
	 * @return 操作时间(operationSeconds<--operation_seconds)
	 */
	public Date getOperationSeconds() {
		return operationSeconds;
	}

	/**
	 * 设置操作描述
	 * 
	 * @param 操作描述
	 *            (description-->description)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 设置功能编码(权限码)
	 * 
	 * @param 功能编码
	 *            (权限码)(functionCode-->function_code)
	 */
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	/**
	 * 设置操作ID
	 * 
	 * @param 操作ID
	 *            (id-->id)
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 设置登陆ID
	 * 
	 * @param 登陆ID
	 *            (logonId-->logon_id)
	 */
	public void setLogonId(int logonId) {
		this.logonId = logonId;
	}

	/**
	 * 设置操作类型:用来收集用户使用习惯
	 * 
	 * @param 操作类型
	 *            :用来收集用户使用习惯(operationCategory-->operation_category)
	 */
	public void setOperationCategory(int operationCategory) {
		this.operationCategory = operationCategory;
	}

	/**
	 * 设置操作时间
	 * 
	 * @param 操作时间
	 *            (operationSeconds-->operation_seconds)
	 */
	public void setOperationSeconds(Date operationSeconds) {
		this.operationSeconds = operationSeconds;
	}
}
