package org.trustel.privilege;

/**
 * 
 * 类 名：角色权限信息
 * 
 * 版 本：0.0.0.1
 * 
 * 设 计：万志勇
 * 
 * 日 期：2011-03-21
 * 
 * 数据源：v_system_roleprivileges(角色权限信息)
 * 
 * 描 述：
 * 
 **/

public class PrivilegeRoleOfView {
	/**
	 * 权限编码
	 */
	private String id;
	/**
	 * 角色状态 (映射flag字段)
	 */
	private String flag;
	/**
	 * 权限编码 (映射privilege_code字段)
	 */
	private String privilegeCode;

	/**
	 * 
	 * @return 权限编码(id<--id)
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @return 角色编码(flag<--flag)
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 
	 * @return 权限编码(privilegeCode<--privilege_code)
	 */
	public String getPrivilegeCode() {
		return privilegeCode;
	}

	/**
	 *设置权限编码
	 * 
	 * @param 权限编码
	 *            (id-->id)
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 *设置角色编码
	 * 
	 * @param 角色编码
	 *            (flag-->flag)
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 *设置权限编码
	 * 
	 * @param 权限编码
	 *            (privilegeCode-->privilege_code)
	 */
	public void setPrivilegeCode(String privilegeCode) {
		this.privilegeCode = privilegeCode;
	}
}
