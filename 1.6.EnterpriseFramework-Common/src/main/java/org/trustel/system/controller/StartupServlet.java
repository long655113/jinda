package org.trustel.system.controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.trustel.common.Utils;
import org.trustel.scheduling.service.Scheduable;
import org.trustel.system.service.IOrganizationRefactorService;

public class StartupServlet extends HttpServlet {
	private Log logger = LogFactory.getLog("Framework");

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String configurationLoader = "configurationLoader";

	private String organizationRefactorServiceName = "organizationRefactorService";

	public void init(ServletConfig servletConfig) throws ServletException {

		super.init(servletConfig);

		String serviceName = Utils.null2Str(servletConfig
				.getInitParameter("serviceName"), "enterpriseService");

		organizationRefactorServiceName = Utils.null2Str(servletConfig
				.getInitParameter("organizationRefactorServiceName"),
				organizationRefactorServiceName);

		configurationLoader = Utils.null2Str(servletConfig
				.getInitParameter("configurationLoader"),
				configurationLoader);

		String title = "========[Compact J2EE Framework]*****[WANZY]==========";
		logger.info(title);

		logger.info("[configuration]default-enterpriseName:" + serviceName);
		try {

			WebApplicationContext ctx = WebApplicationContextUtils
					.getWebApplicationContext(servletConfig.getServletContext());
			onLoad(ctx);

		} catch (Exception e) {
			logger.error("[init][init]load system...fail!");
			logger.error(this, e);
		}

		logger.info(title);
	}

	protected void onLoad(WebApplicationContext context) {
		Scheduable service = (Scheduable) context
				.getBean(configurationLoader);
		if (service.execute()) {
			logger.info("初始化系统参数成功！");
		} else
			logger.equals("初始化系统参数失败");
		IOrganizationRefactorService orgService = (IOrganizationRefactorService) context
				.getBean(organizationRefactorServiceName);
		orgService.refacting();
		
		logger.info("组织架构重整完成");

	}

}
