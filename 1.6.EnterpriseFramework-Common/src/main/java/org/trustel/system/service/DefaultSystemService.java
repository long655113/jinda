package org.trustel.system.service;

import java.util.ArrayList;
import java.util.List;

import org.trustel.privilege.CommonRole;
import org.trustel.privilege.Role;
import org.trustel.service.IEnterpriseService;
import org.trustel.service.sql.QueryBuilder;
import org.trustel.system.Region;
import org.trustel.system.Visitor;

public class DefaultSystemService implements ISystemService {
	private IEnterpriseService enterpriseService;

	public void setEnterpriseService(IEnterpriseService service) {
		this.enterpriseService = service;
	}

	public List<?> queryControllers(Visitor visitor) {
		return null;
	}

	public List<?> queryRegions(Visitor visitor) {
		QueryBuilder builder = new QueryBuilder(Region.class);
		builder.where(visitor.getRegionCondition("id", -1, false));
		return enterpriseService.query(builder, 0);
	}

	public List<?> getLanguages(Visitor visitor) {
		return enterpriseService.query("from Language", 0);
	}

	/**
	 * 获取当前用户可编辑角色列表
	 * 
	 * @param visitor
	 * @return
	 */
	public List<?> queryRoles(Visitor visitor) {

		CommonRole r = visitor.account._role;
		if (r == null)
			return new ArrayList<Object>();
		QueryBuilder query = new QueryBuilder(Role.class);
		query.where("rank" + r.getRank(), r.getId());
		query.where("lang", visitor.account._getCurrentLanaguage());
		return enterpriseService.query(query, 0);
	}
}
