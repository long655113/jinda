package org.trustel.scheduling.service;

import java.util.List;

import org.trustel.common.Parameter;
import org.trustel.service.IEnterpriseService;
import org.trustel.service.sql.QueryBuilder;
import org.trustel.system.SystemLogger;
import org.trustel.util.ParameterFactory;
import org.trustel.util.ParameterUtility;

public class ParameterLoaderService implements Scheduable {

	private IEnterpriseService enterpriseService;

	public void setEnterpriseService(IEnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	private List<?> getParameterList() {
		QueryBuilder builder = new QueryBuilder(Parameter.class);
		return enterpriseService.query(builder, 0);
	}

	protected void _loadSystemParameter() {
		ParameterFactory factory = ParameterFactory.getInstance();
		final List<?> params = getParameterList();
		ParameterUtility utility = new ParameterUtility();
		for (int i = 0; i < params.size(); i++) {
			Parameter p = (Parameter) params.get(i);
			utility.put(p.getName(), p.getValue());
		}
		factory.exchange(utility);
	}

	public boolean execute() {
		try {
			_loadSystemParameter();
			SystemLogger.info("成功加载系统参数！");
			return true;
		} catch (Exception e) {
			SystemLogger.error("加载系统参数出错");
			SystemLogger.error(this, e);
		}
		return false;
	}

}
