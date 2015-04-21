package org.trustel.privilege.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.trustel.controller.CommonController;
import org.trustel.privilege.SystemRole;
import org.trustel.privilege.service.IRoleService;
import org.trustel.system.SystemConstant;
import org.trustel.system.Visitor;
import org.trustel.system.service.ISystemService;

@Controller
@RequestMapping(value = "/core/role/*")
public class RoleQueryController extends CommonController {
	@Autowired
	private IRoleService roleService;

	@Autowired
	private ISystemService systemService;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "query")
	public String query(HttpServletRequest request, HttpServletResponse response) {
		Visitor visitor = getVisitor(request);

		request.setAttribute(SystemConstant.ATTRIBUTE_ITEMPAGE, roleService
				.queryRoles(visitor));

		return "/core/roles/query";
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "view")
	public String viewRoleDetail(HttpServletRequest request) {
		Visitor visitor = getVisitor(request);
		String code = request.getParameter("code");
		request.setAttribute(SystemConstant.ATTRIBUTE_INSTANCE, roleService
				.getRoleById(visitor, code));
		request.setAttribute("langs", systemService.getLanguages(visitor));
		request.setAttribute("descriptions", roleService.getRoleDescription(
				visitor, code));
		return "/core/roles/view";
	}

	public String save(HttpServletRequest request,
			HttpServletResponse response, SystemRole role) {
		roleService.save(getVisitor(request), role);
		return "success";
	}
}
