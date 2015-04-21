package org.trustel.privilege.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.trustel.controller.CommonController;
import org.trustel.privilege.service.IPrivilegeService;
import org.trustel.system.SystemConstant;
import org.trustel.system.Visitor;
import org.trustel.system.form.AccountQueryForm;
import org.trustel.system.service.ISystemService;

@Controller
@RequestMapping(value = "/core/privilege/*")
public class PrivilegeQueryController extends CommonController {

	@Autowired
	private IPrivilegeService privilegeService;
	
	@Autowired
	private ISystemService systemService;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "query")
	public String query(HttpServletRequest request,
			HttpServletResponse response, AccountQueryForm form) {
		Visitor visitor =  getVisitor(request);

		request.setAttribute(SystemConstant.ATTRIBUTE_ITEMPAGE,
				privilegeService.query(visitor));

		return "/core/privilege/query";
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "view")
	public String query(HttpServletRequest request) {
		Visitor visitor =getVisitor(request);
		String code = request.getParameter("code");
		request.setAttribute(SystemConstant.ATTRIBUTE_INSTANCE,
				privilegeService.view(visitor, code));
		request.setAttribute("langs", systemService.getLanguages(visitor));

		return "/core/privilege/view";
	}

}
