package org.trustel.scheduling.service;

import java.util.List;

import org.trustel.common.Language;
import org.trustel.common.Message;
import org.trustel.common.Parameter;
import org.trustel.service.IEnterpriseService;
import org.trustel.service.sql.QueryBuilder;
import org.trustel.system.SystemLogger;
import org.trustel.util.ParameterUtility;
import org.trustel.util.ResourceFactory;

public class MessageLoaderService implements Scheduable {

	private IEnterpriseService enterpriseService;

	public void setEnterpriseService(IEnterpriseService enterpriseService) {
		this.enterpriseService = enterpriseService;
	}

	private List<?> getParameterList() {
		QueryBuilder builder = new QueryBuilder(Message.class);
		return enterpriseService.query(builder, 0);
	}

	protected void _loadMessagesByLang(String lang) {
		ResourceFactory factory = ResourceFactory.getInstance();
		final List<?> messages = getParameterList();
		ParameterUtility utility = new ParameterUtility();
		for (int i = 0; i < messages.size(); i++) {
			Parameter p = (Parameter) messages.get(i);
			utility.put(p.getName(), p.getValue());
		}
		factory.load(lang, utility);
	}

	protected void _loadMessages() {
		QueryBuilder builder = new QueryBuilder(Language.class);
		List<?> list = enterpriseService.query(builder, 0);
		for (int i = 0; i < list.size(); i++) {
			Language item = (Language) list.get(i);
			_loadMessagesByLang(item.getCode());
		}
	}

	public boolean execute() {
		try {
			_loadMessages();
			SystemLogger.info("成功加载系统消息！");
			return true;
		} catch (Exception e) {
			SystemLogger.error("加载系统消息出错！");
			SystemLogger.error(this, e);
		}
		return false;

	}

}
