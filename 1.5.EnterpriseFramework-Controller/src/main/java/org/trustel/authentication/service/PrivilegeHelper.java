package org.trustel.authentication.service;

import java.util.List;

import org.trustel.privilege.PrivilegeOfRole;
import org.trustel.service.IEnterpriseService;
import org.trustel.service.sql.QueryBuilder;
import org.trustel.system.Visitor;

public class PrivilegeHelper {

	private PrivilegeHelper() {
	}

	private static PrivilegeHelper instance;

	public static PrivilegeHelper getInstance() {
		if (instance == null)
			instance = new PrivilegeHelper();
		return instance;
	}

	public boolean accessible(IEnterpriseService service, Visitor visitor,
			String privilegeCode,String priOfRoleClassName) {
		QueryBuilder builder = new QueryBuilder(priOfRoleClassName);
		builder.where("privilegeCode", privilegeCode);
		builder.where("roleCode", visitor.account.getRoleCode());
		builder.or();
		builder.where(" roleCode in (select roleCode from ProductPackOrderRecord where status=1 and endTime>NOW() and merchantId='"+visitor.account.getMerchantId()+"')");
		long count = service.getRecordCount(builder);
		return count > 0;
	}

	public List<?> queryPrivilegeConfigs(IEnterpriseService service) {
		QueryBuilder builder = new QueryBuilder(PrivilegeOfRole.class);
		return service.query(builder, 0);
	}

}
