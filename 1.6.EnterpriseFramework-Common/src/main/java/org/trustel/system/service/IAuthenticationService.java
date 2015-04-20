package org.trustel.system.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trustel.account.CommonAccount;
import org.trustel.system.form.LoginForm;

public interface IAuthenticationService {

	public String login(HttpServletRequest request,
			HttpServletResponse response, LoginForm form);
	
	/**
	 * 商品导入客户端 登录
	 * @Description: TODO
	 * @param form
	 * @return
	 */
	public CommonAccount loginApi(LoginForm form);
	
	/**
	 * 验证b1登录名密码是否正确
	 * @Description: TODO
	 * @param form
	 * @return
	 */
	public boolean validateSapBoneLogin(LoginForm form);
}
