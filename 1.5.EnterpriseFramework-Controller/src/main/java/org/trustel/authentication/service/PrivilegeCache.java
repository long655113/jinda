package org.trustel.authentication.service;

import java.util.ArrayList;
import java.util.List;

import org.trustel.privilege.PrivilegeOfRole;
import org.trustel.service.IEnterpriseService;
import org.trustel.system.Visitor;

public class PrivilegeCache {

	private static PrivilegeCache instance;

	public static PrivilegeCache getInstance() {
		if (instance == null)
			instance = new PrivilegeCache();
		return instance;
	}

	private List<?> privileges[] = null;

	private int index = 0;

	private Boolean flag = new Boolean(true);

	protected PrivilegeCache() {
		privileges = new List<?>[2];
	}

	public boolean accessible(IEnterpriseService service, Visitor visitor,
			String privilegeCode) {
		String key = visitor.account.getRoleCode() + privilegeCode;
		if (privileges[index] == null)
			loadCache(service);
		return privileges[index] == null ? false : privileges[index]
				.contains(key);
	}

	public void loadCache(IEnterpriseService service) {
		List<?> list = queryPrivilegeConfigs(service);
		List<String> cache = new ArrayList<String>();
		if (list != null)
			for (int i = 0; i < list.size(); i++) {
				PrivilegeOfRole item = (PrivilegeOfRole) list.get(i);
				cache.add(item.getRoleCode() + item.getPrivilegeCode());
			}

		synchronized (flag) {
			int a = index == 0 ? 1 : 0;
			privileges[a] = cache;
			index = a;
		}
	}

	private List<?> queryPrivilegeConfigs(IEnterpriseService service) {
		return PrivilegeHelper.getInstance().queryPrivilegeConfigs(service);
	}
}
