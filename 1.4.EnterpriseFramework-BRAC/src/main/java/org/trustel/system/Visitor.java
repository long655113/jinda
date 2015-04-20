package org.trustel.system;

import java.io.Serializable;
import java.util.Date;

import org.trustel.account.CommonAccount;
import org.trustel.common.Utils;

/**
 * 类名：com.trustel.l3x.system.Visitor 特性：可序列化 日期：2006-05-31 19:30 设计：万志勇
 * 功能：保存当前用户(session)信息,包括用户权限，最后一次请求提示
 */
public class Visitor implements Serializable {

	private static final long serialVersionUID = 278384900951105649L;

	// 保存当前用户登陆信息
	public CommonAccount account = null;

	// 当前用户的权限列表

	public String IP;

	public boolean logined = false;

	public String loginId;

	public String loginTime = Utils.format(new Date(), "yyyy-MM-dd HH:mm:ss",
			"GMT+8");

	public String url;

	public int filter(int regionId) {
		AbstractRegion region = account._hasRegionPrivilege(regionId);
		if (region == null)
			return -1;
		else
			return region.getId();
	}

	public String getRegionJDBCCondition(String fieldName, int regionId) {
		return account._getRegionJDBCCondition(fieldName, regionId);
	}

	public String getRegionHBMCondition(String fieldName, int regionId) {
		return account._getRegionHBMCondition(fieldName, regionId);
	}

	public String getRegionCondition(String fieldName, int regionId,
			boolean jdbc) {
		if (jdbc)
			return getRegionJDBCCondition(fieldName, regionId);
		else
			return getRegionHBMCondition(fieldName, regionId);
	}

}
