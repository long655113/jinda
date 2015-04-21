package org.trustel.privilege.service;

import java.util.ArrayList;
import java.util.List;

import org.trustel.privilege.CommonRole;
import org.trustel.privilege.Role;
import org.trustel.privilege.RoleDescription;
import org.trustel.privilege.SystemRole;
import org.trustel.service.IEnterpriseService;
import org.trustel.service.sql.QueryBuilder;
import org.trustel.system.Visitor;

public class DefaultRoleService implements IRoleService {

	/**
	 * 获取当前用户可编辑角色列表,指定语言信息
	 * 
	 * @param visitor
	 * @return List<Role>/Role/CommonRole
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

	/**
	 * 获取指定角色
	 */
	public SystemRole getRoleById(Visitor visitor, String id) {
		CommonRole r = visitor.account._role;
		if (r == null)
			return null;
		QueryBuilder query = new QueryBuilder(SystemRole.class);
		query.where("id", id);
		query.where("rank" + r.getRank(), r.getId());
		List<?> list = enterpriseService.query(query, 2);
		if (list == null || list.size() != 1)
			return null;
		return (SystemRole) list.get(0);
	}

	public List<?> getRoleDescription(Visitor visitor, String roleId) {
		QueryBuilder query = new QueryBuilder(RoleDescription.class);
		query.where("ucode", roleId);
		//query.where("lang", visitor.account._getCurrentLanaguage());
		return enterpriseService.query(query, 0);
	}

	public void save(Visitor visitor ,SystemRole role)
	{
		QueryBuilder query=new QueryBuilder(SystemRole.class);
		query.where("code",role.getUcode());
		List<?> list=enterpriseService.query(query,2);
		SystemRole root=null;
		if(list!=null&&list.size()==1)
		{
			root=(SystemRole)list.get(0);
		}
		
	}
	private IEnterpriseService enterpriseService;

	public void setEnterpriseService(IEnterpriseService service) {
		this.enterpriseService = service;
	}

}
