package org.trustel.system.service;

import java.util.List;

import org.trustel.account.CommonAccount;
import org.trustel.service.IEnterpriseService;
import org.trustel.service.sql.QueryAction;
import org.trustel.service.sql.QueryBuilder;
import org.trustel.system.Visitor;
import org.trustel.system.form.AccountQueryForm;

import com.trustel.common.ItemPage;

public class DefaultAccountService implements IAccountService {

	private IEnterpriseService enterpriseService;

	private String accountClassName = "SystemAccount";

	public ItemPage query(Visitor visitor, AccountQueryForm form) {
		QueryBuilder builder = new QueryBuilder(accountClassName);
		builder.where("regionId", form.getRegion());
		builder.where("roleCode", form.getRoleCode());
		builder.where("account", form.getAccount(), QueryAction.LIKE);
		builder.orderBy("regionId");

		return enterpriseService.query(builder, form);
	}

	public CommonAccount getAccount(Visitor visitor, String code) {
		if (code == null || code.trim().equals(""))
			return null;
		QueryBuilder builder = new QueryBuilder(accountClassName);
		builder.where("code", code);
		List list = enterpriseService.query(builder, 2);
		if (list == null | list.size() != 1)
			return null;
		return (CommonAccount) list.get(0);
	}
	
	public void updateAccount(Visitor visitor,CommonAccount item)
	{
		if(item.getCode()==null||item.getCode().trim().equals(""))
		{
			enterpriseService.save(item);
			return ;
		}
		enterpriseService.updateObject(item);
	}

	public void setAccountClassName(String accountClassName) {
		this.accountClassName = accountClassName;
	}

	public void setEnterpriseService(IEnterpriseService service) {
		this.enterpriseService = service;
	}

	public long delete(Visitor visitor, String[] codes) {

		QueryBuilder builder = new QueryBuilder(accountClassName);
		builder.where("code", codes);
		return enterpriseService.delete(builder);
	}

}
