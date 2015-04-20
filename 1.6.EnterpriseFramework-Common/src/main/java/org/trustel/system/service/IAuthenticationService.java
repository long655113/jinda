package org.trustel.system.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trustel.account.CommonAccount;
import org.trustel.system.form.LoginForm;

public interface IAuthenticationService {

	public String login(HttpServletRequest request,
			HttpServletResponse response, LoginForm form);
	
	/**
	 * ��Ʒ����ͻ��� ��¼
	 * @Description: TODO
	 * @param form
	 * @return
	 */
	public CommonAccount loginApi(LoginForm form);
	
	/**
	 * ��֤b1��¼�������Ƿ���ȷ
	 * @Description: TODO
	 * @param form
	 * @return
	 */
	public boolean validateSapBoneLogin(LoginForm form);
}
