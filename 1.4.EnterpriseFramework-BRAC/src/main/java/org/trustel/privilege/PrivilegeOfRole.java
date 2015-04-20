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
 * 数据源：system_role_privileges(角色权限信息)
 * 
 * 描 述：
 * 
 **/

public class PrivilegeOfRole {
	/**
	 * 权限编码
	 */
	private String code;
	/**
	 * 角色编码 (映射role_code字段)
	 */
	private String roleCode;
	/**
	 * 权限编码 (映射privilege_code字段)
	 */
	private String privilegeCode;

	/**
	 * 
	 * @return 权限编码(code<--code)
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 
	 * @return 角色编码(roleCode<--role_code)
	 */
	public String getRoleCode() {
		return roleCode;
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
	 *            (code-->code)
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 *设置角色编码
	 * 
	 * @param 角色编码
	 *            (roleCode-->role_code)
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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
