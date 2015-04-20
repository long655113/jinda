package org.trustel.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.trustel.account.SystemAccount;
import org.trustel.controller.CommonController;
import org.trustel.system.SystemConstant;
import org.trustel.system.Visitor;
import org.trustel.system.form.AccountQueryForm;
import org.trustel.system.service.IAccountService;
import org.trustel.system.service.ISystemService;
import org.trustel.util.ResourceFactory;

@Controller
@RequestMapping(value = "/core/account/*")
public class AccountManagementController extends CommonController {

	@Autowired
	private ISystemService systemService;

	@Autowired
	private IAccountService accountService;

	@RequestMapping(method = RequestMethod.GET, value = "view")
	public String viewAccount(HttpServletRequest request,
			HttpServletResponse response) {
		Visitor visitor = getVisitor(request);
		// request.setAttribute("regions", Utils.getOptionsAsTree(systemService
		// .queryRegions(visitor), -1));
		String code = request.getParameter("code");
		request.setAttribute("roles", systemService.queryRoles(visitor));
		request.setAttribute("regions", systemService.queryRegions(visitor));
		request.setAttribute(SystemConstant.ATTRIBUTE_INSTANCE, accountService
				.getAccount(visitor, code));
		return "/core/account/viewaccount";
	}

	@RequestMapping(method = RequestMethod.POST, value = "save")
	public String updateAccount(HttpServletRequest request,
			HttpServletResponse response, SystemAccount account) {
		Visitor visitor = getVisitor(request);
		accountService.updateAccount(visitor, account);

		return "/core/account/viewaccount";
	}

	@RequestMapping(method = RequestMethod.POST, value = "remove")
	public String removeAccounts(HttpServletRequest request,
			HttpServletResponse response, AccountQueryForm form) {
		Visitor visitor = getVisitor(request);
		String lang = getLanguage(request, visitor);
		if (SystemConstant.ACTION_DELETE.equalsIgnoreCase(form.getAction())) {
			String[] chk = form.getChk();
			if (chk != null && chk.length > 0) {
				long ret = accountService.delete(visitor, chk);
				if (ret > 0) {
					String message = ResourceFactory.getMessage(lang,
							"MESSAGE_DELETE_SUCCESS", "您成功删除%d条记录！");
					request.setAttribute(SystemConstant.ATTRIBUTE_MESSAGE,
							String.format(message, new Object[] { ret }));
				}
			}
		}

		request.setAttribute(SystemConstant.ATTRIBUTE_ITEMPAGE, accountService
				.query(visitor, form));
		// request.setAttribute("regions", Utils.getOptionsAsTree(systemService
		// .queryRegions(visitor), form.getRegion()));
		request.setAttribute("roles", systemService.queryRoles(visitor));
		request.setAttribute("regions", systemService.queryRegions(visitor));
		return "/core/account/accountquery";

	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "query")
	public String queryAccounts(HttpServletRequest request,
			HttpServletResponse response, AccountQueryForm form) {
		Visitor visitor = getVisitor(request);

		request.setAttribute(SystemConstant.ATTRIBUTE_ITEMPAGE, accountService
				.query(visitor, form));
		request.setAttribute("form", form);
		// request.setAttribute("regions", Utils.getOptionsAsTree(systemService
		// .queryRegions(visitor), form.getRegion()));
		request.setAttribute("regions", systemService.queryRegions(visitor));
		request.setAttribute("roles", systemService.queryRoles(visitor));
		return "/core/account/accountquery";
	}

	public void setAccountService(IAccountService accountService) {
		this.accountService = accountService;
	}

	public void setSystemService(ISystemService systemService) {
		this.systemService = systemService;
	}
}
