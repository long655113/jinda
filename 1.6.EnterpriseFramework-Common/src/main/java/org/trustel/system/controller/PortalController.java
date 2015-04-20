package org.trustel.system.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.trustel.controller.CommonController;
import org.trustel.system.Visitor;
import org.trustel.system.service.IPortalMenuService;

@Controller
@RequestMapping(value = "/core/portal/*")
public class PortalController extends CommonController {

	@Autowired
	private IPortalMenuService portalMenuService;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "left")
	public String queryMenus(HttpServletRequest request) {
        Visitor visitor=getVisitor(request);
        request.setAttribute("menus", portalMenuService.queryMenu(visitor));
		return "/core/portal/left";
	}
}
