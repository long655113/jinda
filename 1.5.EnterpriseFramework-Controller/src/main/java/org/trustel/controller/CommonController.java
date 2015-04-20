package org.trustel.controller;

import javax.servlet.http.HttpServletRequest;

import org.trustel.system.SystemConstant;
import org.trustel.system.Visitor;

/**
 * 
 * @author Micky
 * 
 */
public class CommonController {

	protected Visitor getVisitor(HttpServletRequest request) {
		return (Visitor) request.getSession().getAttribute(
				SystemConstant.SESSION_VISITOR);
	}

	protected String getLanguage(HttpServletRequest request) {
		return request.getLocale().toString();
	}

	protected String getLanguage(HttpServletRequest request, Visitor visitor) {
		return visitor == null || visitor.account == null ? getLanguage(request)
				: visitor.account._getCurrentLanaguage();
	}

}
