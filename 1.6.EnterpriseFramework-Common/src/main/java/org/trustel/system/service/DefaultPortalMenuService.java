package org.trustel.system.service;

import java.util.List;

import org.trustel.service.IEnterpriseService;
import org.trustel.service.sql.QueryBuilder;
import org.trustel.system.Visitor;
/**
 * @Description: 后台首页菜单查询
 * @author  guof
 * @date    2013-9-25 下午03:24:44
 * @version V1.0
 */
public class DefaultPortalMenuService implements IPortalMenuService {

	private IEnterpriseService enterpriseService;

	private String menuItemClassName = "MenuItem";

	public void setMenuItemClassName(String menuItemClassName) {
		this.menuItemClassName = menuItemClassName;
	}

	
	/**
	 * @Description: 查询菜单
	 * @param visitor
	 * @return
	 */
	@Override
	public List<?> queryMenu(Visitor visitor) {
		QueryBuilder query = new QueryBuilder(menuItemClassName);
		if (visitor != null && visitor.account != null)
			query.where("lang", visitor.account._getCurrentLanaguage());
		query.where(" status",1);
		//0:公共菜单  1：虎翼汇菜单  2：分销菜单
		query.where(" type!='2'");
		query.createCondtionGroup();
		query.where(" code in (select privilegeCode from PrivilegeRoleOfView where id='" + visitor.account.getRoleCode() + "' and flag=1)");
		query.or();
		query.where(" code in (select a.privilegeCode from PrivilegeRoleOfView a,ProductPackOrderRecord b where a.id=b.roleCode and a.flag=1 and b.status=1 and b.endTime>NOW() and b.merchantId='"+visitor.account.getMerchantId()+"')");
		query.endGroudCondtion();
		query.orderBy("ucode");
		query.orderBy("seq");		
		return enterpriseService.query(query, 0);
	}
	
	
	/**
	 * @Description: 暂无使用
	 * @param visitor
	 * @param label
	 * @return
	 */
	@Override
	public List<?> queryMenu(Visitor visitor,String label) {
		QueryBuilder query = new QueryBuilder(menuItemClassName);
		if (visitor != null && visitor.account != null)
			query.where("lang", visitor.account._getCurrentLanaguage());
		query.where(" status",1);
		//0:公共菜单  1：虎翼汇菜单  2：分销菜单
		query.where(" type!='2'");
		query.where("title",label);
		query.where(" code in (select privilegeCode from PrivilegeRoleOfView where id='" + visitor.account.getRoleCode() + "' and flag=1)");
		query.orderBy("ucode");
		query.orderBy("seq");		
		return enterpriseService.query(query, 0);
	}

	public void setEnterpriseService(IEnterpriseService service) {
		this.enterpriseService = service;
	}

}