package org.trustel.scheduling.service;

import org.trustel.authentication.service.PrivilegeCache;
import org.trustel.service.IEnterpriseService;

public class PrivilegeLoaderService implements Scheduable {

	public boolean execute() {
		PrivilegeCache.getInstance().loadCache(enterpriseService);
		return false;
	}

	private IEnterpriseService enterpriseService;

	public void setEnterpriseService(IEnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}
}
