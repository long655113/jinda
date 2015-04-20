package org.trustel.authentication.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.trustel.service.IEnterpriseService;
import org.trustel.system.Visitor;
import org.trustel.util.ParameterFactory;

public class DefaultAuthenticationInerceptorService implements IAuthenticationInerceptorService {
	private Log logger = LogFactory.getLog(getClass());

	private IEnterpriseService enterpriseService;
	
	private String priOfRoleClassName = "PrivilegeOfRole";
	
	public String getPriOfRoleClassName() {
		return priOfRoleClassName;
	}

	public void setPriOfRoleClassName(String priOfRoleClassName) {
		this.priOfRoleClassName = priOfRoleClassName;
	}

	private boolean useCache = false;

	private boolean accessibleC(Visitor visitor, String privilegeCode) {
		logger.info("通过缓存判断用户权限！");
		PrivilegeCache cache = PrivilegeCache.getInstance();
		return cache.accessible(enterpriseService, visitor, privilegeCode);
	}

	public boolean accessible(Visitor visitor, String privilegeCode) {
		if (isUseCache()) {
			return accessibleC(visitor, privilegeCode);
		} else
			return accessibleA(visitor, privilegeCode);
	}

	private boolean accessibleA(Visitor visitor, String privilegeCode) {
		logger.info("直接查询数据库判断用户权限！");
		PrivilegeHelper helper = PrivilegeHelper.getInstance();
		return helper.accessible(enterpriseService, visitor, privilegeCode,this.priOfRoleClassName);
	}

	public void setEnterpriseService(IEnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	public void setUseCache(boolean useCache) {
		this.useCache = useCache;
	}

	public boolean isUseCache() {
		if (ParameterFactory.getInt("PRIVILEGE_CACHE_POLICY", 0) == 1) {
			logger.info("权限缓冲策略是参数配置优先于SPRING配置！");
			useCache = ParameterFactory.getInt("PRIVILEGE_CACHABLE", 0) == 1;
		}
		return useCache;
	}

}
