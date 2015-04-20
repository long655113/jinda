package org.trustel.account;

import org.trustel.system.AbstractRegion;

public interface IRegionOfAccountService {

	/**
	 * @param account
	 * @param fieldName
	 *            业务表如用户表的组织属性（地市）字段名或hibernate映射属性名
	 * @param orgid
	 *            从请求模型带入的查询条件（用户选中的地市）
	 * @return 用户区域权限条件如 fieldName in (select orgid from ORGANIZATIONS where
	 *         orgid=?)
	 */
	public String getRegionJDBCCondition(CommonAccount account,
			String fieldName, int orgid);

	/**
	 * @param account
	 * @param fieldName
	 *            业务表如用户表的组织属性（地市）hibernate映射属性名
	 * @param orgid
	 *            从请求模型带入的查询条件（用户选中的地市）
	 * @return 用户区域权限条件如 fieldName in (select orgid from ORGANIZATIONS where
	 *         orgid=?)
	 */
	public String getRegionHBMCondition(CommonAccount account,
			String fieldName, int orgid);

	public AbstractRegion hasRegionPrivilege(CommonAccount account, int regionId);
}
