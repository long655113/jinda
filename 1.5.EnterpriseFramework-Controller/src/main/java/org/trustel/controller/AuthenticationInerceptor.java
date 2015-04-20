package org.trustel.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.trustel.authentication.service.IAuthenticationInerceptorService;
import org.trustel.common.Language;
import org.trustel.system.SystemConstant;
import org.trustel.system.Visitor;
import org.trustel.util.ResourceFactory;

public class AuthenticationInerceptor extends HandlerInterceptorAdapter
		implements HandlerInterceptor {

	private Log logger = LogFactory.getLog(getClass());

	private IAuthenticationInerceptorService authenticationInerceptorService;

	private String loginUrl = "";

	private String exceptionUrl = "/error/403";

	private final static String MESSAGE_OVERTIME = "系统超时或您尚未登陆本系统！";

	private final static String MESSAGE_NOPRIVILEGE = "您没有权限访问本系统功能，如确实需要访问，请与系统管理员联系！";

	protected void clearSession(HttpSession session) {
		if (session == null)
			return;
		Enumeration<?> names = session.getAttributeNames();
		while (names.hasMoreElements()) {
			// String name = names.nextElement();
			session.removeAttribute((String) names.nextElement());
		}
	}

	protected boolean forward(HttpServletRequest request,
			HttpServletResponse response, String privilegeCode,Visitor visitor)
			throws ServletException, IOException {
		String message = "";
		String lang = getDefaultLanguage(request, visitor);
		String url = "";

		if (visitor == null) {
			message = ResourceFactory.getMessage(lang, "ERROR_OVERTIME",MESSAGE_OVERTIME);
			logger.warn(MESSAGE_OVERTIME);
			clearSession(request.getSession());
			url = loginUrl;
		} else if (visitor.logined) {
			if (!authenticationInerceptorService.accessible(visitor, privilegeCode)) {
				logger.error(privilegeCode);
				logger.error("您没有权限访问本系统功能，如确实需要访问，请与系统管理员联系！");
				message = ResourceFactory.getMessage(lang, "ERROR_NOPRIVILEGE",MESSAGE_NOPRIVILEGE);
				url = exceptionUrl;
				//return false;
			}else {
				return true;
			}
		} else {
			message = ResourceFactory.getMessage(lang, "ERROR_OVERTIME",MESSAGE_OVERTIME);
			logger.warn(MESSAGE_OVERTIME);
			url = loginUrl;
		}
		request.setAttribute(SystemConstant.ATTRIBUTE_MESSAGE, message);
		request.getRequestDispatcher(url).forward(request, response);
		return false;
	}

	protected String getDefaultLanguage(HttpServletRequest request,
			Visitor visitor) {
		if (visitor != null && visitor.account != null)
			return visitor.account._getCurrentLanaguage();
		Locale locale = request.getLocale();
		String lang = Language.LANG_DEFAULT;
		if (locale.equals(Locale.CHINA) || locale.equals(Locale.CHINESE))
			lang = "zh_CN";
		else if (locale.equals(Locale.TAIWAN)
				|| locale.equals(Locale.TRADITIONAL_CHINESE))
			lang = "zh_TW";
		else
			lang = "en";

		return lang;
	}

	public String getExceptionUrl() {
		return exceptionUrl;
	}

	public String getLoginUrl() {
		return loginUrl;
	}

	protected Visitor getVisitor(HttpServletRequest request,Object handler) {
		HttpSession session = request.getSession();
		if (session == null)
			return null;
		return (Visitor) session.getAttribute(SystemConstant.SESSION_VISITOR);
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.info("preHandle-->" + request.getRemoteAddr()+"[handler:"+handler.getClass().getSimpleName()+"];[RequestURI:" + request.getRequestURI()+"]"+request.getSession().getId());
		logRequestParam(request);
		String privilegeCode = handler.getClass().getSimpleName();
		if (handler instanceof Identifiable) {
			logger.info("preHandle-->handle implement Identifiable");
			privilegeCode = ((Identifiable) handler).getPrivilegeCode();
			Visitor visitor = getVisitor(request,handler);
			return forward(request, response, privilegeCode,visitor);
		}

		return true;
	}

	public void setAuthenticationInerceptorService(
			IAuthenticationInerceptorService authenticationService) {
		this.authenticationInerceptorService = authenticationService;
	}

	public void setExceptionUrl(String exceptionUrl) {
		this.exceptionUrl = exceptionUrl;
	}

	public void setLoginUrl(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	/**
	 * 记录请求参数
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	protected void logRequestParam(HttpServletRequest request){
		Enumeration enu=request.getParameterNames(); 
		StringBuffer paramBuffer = new StringBuffer();
        while(enu.hasMoreElements()) 
        { 
        	 String name=(String)enu.nextElement();
             if(name!=null && !name.toLowerCase().contains("pass")){
             	String value = request.getParameter(name);
             	paramBuffer.append("["+name+"="+value+"],");             
             }           
        }
        logger.info("RequestParam-->"+paramBuffer.toString());
	}
}
