package org.trustel.privilege.service;

import java.util.List;

import org.trustel.privilege.MenuDescription;
import org.trustel.privilege.MenuItem;
import org.trustel.privilege.SystemMenu;
import org.trustel.service.IEnterpriseService;
import org.trustel.service.sql.QueryBuilder;
import org.trustel.system.Visitor;

public class DefaultPrivilegeService implements IPrivilegeService {

	private IEnterpriseService enterpriseService;

	public void setEnterpriseService(IEnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	public List<?> query(Visitor visitor) {
		QueryBuilder query = new QueryBuilder(MenuItem.class);
		query.orderBy("ucode");
		query.orderBy("seq");
		return enterpriseService.query(query, 0);
	}

	public SystemMenu view(Visitor visitor, String code) {
		QueryBuilder query = new QueryBuilder(SystemMenu.class);
		query.where("code", code);
		// query.where("lang", visitor.account._getCurrentLanaguage());
		List<?> list = enterpriseService.query(query, 2);

		SystemMenu menu = null;
		if (list != null && list.size() == 1) {
			menu = (SystemMenu) list.get(0);
			query = new QueryBuilder(MenuDescription.class);
			query.where("ucode", menu.getCode());
			menu._descriptions = enterpriseService.query(query, 0);
		}
		return menu;
	}

	/**
	 * 
	 */
	public String[] queryPrivilegeOfRole(Visitor visitor, String grade) {
		List list = enterpriseService.query(
				"select privilegeCode from PrivilegeOfRole where roleCode='"
						+ grade + "'", -1);
		if (list != null && list.size() > 0) {
			String[] p = new String[list.size()];
			for (int i = 0; i < list.size(); i++) {
				p[i] = (String) list.get(i);
			}
			return p;
		}
		return null;
	}

}
