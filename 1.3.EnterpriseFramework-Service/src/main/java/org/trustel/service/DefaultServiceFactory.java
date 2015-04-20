package org.trustel.service;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultServiceFactory implements IServiceFactory {
	private Log logger = LogFactory.getLog(getClass());

	private String defaultServiceName = "enterpriseService";

	private Map<String, IEnterpriseService> map = new HashMap<String, IEnterpriseService>();

	public void setMap(Map<String, IEnterpriseService> map) {
		this.map = map;
	}

	/**
	 * ��ȡȱʡ�ķ������ƣ�ȱʡ����ͨ��ϵͳͨ������ȱʡ�������Ȩ��
	 */
	public IEnterpriseService getDefaultService() {
		return getServiceByName(defaultServiceName);
	}

	/**
	 * ͨ�����ƻ�ȡ����
	 */
	public IEnterpriseService getServiceByName(String name) {
		if (map.containsKey(name))
			return map.get(name);
		logger.warn(String.format(
				"not found %s,you should config in Spring Configuration",
				new Object[] { name }));
		return null;
	}

	/**
	 * ����ȱʡ��������
	 * 
	 * @param defaultServiceName
	 *            ȱʡ���ƣ�ͨ��ʹ��Spring����
	 */
	public void setDefaultServiceName(String defaultServiceName) {
		this.defaultServiceName = defaultServiceName;
	}

}
