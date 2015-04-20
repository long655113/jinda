package org.trustel.system.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.trustel.account.CommonAccount;
import org.trustel.account.DefaultRegionOfAccountService;
import org.trustel.account.IRegionOfAccountService;
import org.trustel.account.IRoleService;
import org.trustel.common.Utils;
import org.trustel.service.IEnterpriseService;
import org.trustel.service.id.SequenceUtils;
import org.trustel.service.sql.QueryBuilder;
import org.trustel.system.Region;
import org.trustel.system.SystemConstant;
import org.trustel.system.SystemLogger;
import org.trustel.system.Visitor;
import org.trustel.system.form.LoginForm;
import org.trustel.util.ResourceFactory;

import com.trustel.common.DateFunc;
import com.trustel.common.MD5Implementor;

public class DefaultAuthenticationService implements IAuthenticationService {

	private IEnterpriseService enterpriseService;

	private String errorUrl = "/core/login/login";

	private String portalUrl = "redirect:/portal";

	private IRegionOfAccountService regionOfAccountService = new DefaultRegionOfAccountService();

	private IRoleService roleService;// =new DefaultRoleService();

	private String accountClassName = "SystemAccount";

	public void setAccountClassName(String accountClassName) {
		this.accountClassName = accountClassName;
	}
	/**
	 * MD5两次加密
	 * @param password
	 * @param salt
	 * @return
	 */
	protected String encodePassword(String password,String salt) {
		return  MD5Implementor.MD5Encode((salt + MD5Implementor.MD5Encode(password,false)),false);
	}

	protected String getAccountError(String lang) {
		return ResourceFactory.getMessage(lang, "ERROR_LOGIN_ACCOUNT",
				"帐号或密码错误!");
	}

	protected String getFieldIsNullMessage(String lang) {
		return ResourceFactory.getMessage(lang, "ERROR_LOGIN_FIELDISNULL",
				"帐号和密码均不能为空!");
	}

	protected String getPasswordError(String lang) {
		return ResourceFactory.getMessage(lang, "ERROR_LOGIN_ACCOUNT",
				"帐号或密码错误!");
	}

	protected String getStatusError(String lang) {
		return ResourceFactory.getMessage(lang, "ERROR_LOGIN_ACCOUNT",
				"帐号已被禁用!");
	}
	
	protected String getTimeError(String lang) {
		return ResourceFactory.getMessage(lang, "ERROR_LOGIN_ACCOUNT",
				"帐号已失效!");
	}
	
	protected void loadRegion(CommonAccount account) {
		QueryBuilder query = new QueryBuilder(Region.class);
		query.where("id", account.getRegionId());
		List<?> list = enterpriseService.query(query, 0);
		if (list != null && list.size() == 1)
			account._region = (Region) list.get(0);
	}

	protected void loadRegions(CommonAccount account) {
		if (account._region == null)
			return;
		QueryBuilder query = new QueryBuilder(Region.class);
		query.where("rank" + account._region.getRank(), account._region.getId());
		List<?> list = enterpriseService.query(query, 0);
		account._regions = list;

	}

	protected String loadUserInfo(Visitor visitor) {
		CommonAccount account = visitor.account;
		account._regionService = this.regionOfAccountService;
		account._roleService = this.roleService;
		loadRegion(account);
		loadRegions(account);
		return portalUrl;
	}
	
	/**
	 * 基于系统角色上配置流程组角色
	 * @param request
	 * @param visitor
	 */
	protected void initSkillGroupRole(HttpServletRequest request, Visitor visitor) {
		String role = visitor.account.getRoleCode();
		QueryBuilder builder = new QueryBuilder("SystemFlowAgent a,SystemFlowSkillgroup b");
		builder.select("a.sid");
		builder.where("a.roleId", role);
		builder.where("a.sid=b.id and b.status='1'");
		List<String> roles = (List<String>)enterpriseService.query(builder, 0);
		request.getSession().setAttribute(SystemConstant.SESSION_SKILLGROUP, roles);
	}

	public String login(HttpServletRequest request, HttpServletResponse response, LoginForm form) {
		String lang = request.getLocale().toString();
		String loginName = Utils.null2Str(form.getLoginName()).trim();
		String password = Utils.null2Str(form.getPassword()).trim();
		if (loginName.equals("") || password.equals("")) {
			setMessage(request, getFieldIsNullMessage(lang));
			SystemLogger.warn("帐号或密码为空!");
			return errorUrl;
		}

		QueryBuilder builder = new QueryBuilder(accountClassName);
		builder.where("account", form.getLoginName());
		String nowTime=DateFunc.getCurrentDateString("yyyy-MM-dd");
//		builder.where("endDate", DateUtils.stringToDate(nowTime, "yyyy-MM-dd"), QueryAction.GE);
//		builder.where("startDate", DateUtils.stringToDate(nowTime, "yyyy-MM-dd"), QueryAction.LE);
		List<?> list = enterpriseService.query(builder, 0);
		if (list.size() == 1) {
			CommonAccount account = (CommonAccount) list.get(0);
			   if(account.getStatus() == 3){
				   setMessage(request, getStatusError(lang));
			   }
			   else{
			String encodePass = encodePassword(password,account.getSalt()); 
			if (encodePass.equals(account.getPassword())) {
				Visitor visitor = new Visitor();
				visitor.IP = request.getRemoteAddr();
				visitor.loginId = SequenceUtils.getNext7Plus5Code(
						enterpriseService, "SYTEM_NEXTLOGINID");
				visitor.loginTime = Utils.format(new Date(),
						"yyyy-MM-HH mm:ss", "GMT+8");
				visitor.logined = true;
				visitor.account = account;
				request.getSession(true).setAttribute(
						SystemConstant.SESSION_VISITOR, visitor);
				initSkillGroupRole(request,visitor);
				return loadUserInfo(visitor);
			}
			setMessage(request, getPasswordError(lang));
			SystemLogger.warn(loginName + ":密码错误!");
			   }
		} else
			setMessage(request, getAccountError(lang));

		return errorUrl;
	}
	
	
	public CommonAccount loginApi(LoginForm form) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * 验证b1登录名密码是否正确
	 * @Description: TODO
	 * @param form
	 * @return
	 */
	public boolean validateSapBoneLogin(LoginForm form){
		return false;
	}
	public void setEnterpriseService(IEnterpriseService service) {
		this.enterpriseService = service;
	}

	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}

	protected void setMessage(HttpServletRequest request, String message) {
		request.getSession().setAttribute(SystemConstant.SESSION_MESSAGE,
				message);
	}

	public void setPortalUrl(String portalUrl) {
		this.portalUrl = portalUrl;
	}

	public void setRegionOfAccountService(
			IRegionOfAccountService regionOfAccountService) {
		this.regionOfAccountService = regionOfAccountService;
	}

	public void setRoleService(IRoleService roleService) {
		this.roleService = roleService;
	}

}
