package org.trustel.account;

import org.trustel.privilege.Role;

public interface IRoleService {

	/**
	 * 根据用户帐号的角色信息组合用户权限条件
	 * 
	 * @param roleOfUser
	 * @param fieldName
	 *            　
	 * @return　fieldName in (select ..from role where)
	 */
	public String getRoleCondition(Role roleOfUser, String fieldName);

	/**
	 * 根据帐号的角色信息获取该帐号可新增角色的权限条件
	 * 
	 * @param account
	 * @return rankN =?
	 */
	public String getRoleListCondition(Role role);

}
