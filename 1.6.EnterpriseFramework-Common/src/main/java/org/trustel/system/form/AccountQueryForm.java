package org.trustel.system.form;

import org.trustel.service.form.PageQueryForm;

public class AccountQueryForm extends PageQueryForm {

	private String account;
	private int region=10000;
	private String roleCode;

	public String getAccount() {
		return account;
	}

	public int getRegion() {
		return region;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public void setRegion(int region) {
		this.region = region;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

}
