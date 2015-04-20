package org.trustel.system.service;

import org.trustel.account.CommonAccount;
import org.trustel.system.Visitor;
import org.trustel.system.form.AccountQueryForm;

import com.trustel.common.ItemPage;

public interface IAccountService {
	public ItemPage query(Visitor visitor, AccountQueryForm form);

	public long delete(Visitor visitor, String[] codes);

	public CommonAccount getAccount(Visitor visitor, String code);

	public void updateAccount(Visitor visitor, CommonAccount item);

}
