package org.trustel.util;

import java.util.HashMap;

public class ResourceFactory {

	private HashMap<String, ParameterUtility> resources;

	private boolean flag = false;

	private static ResourceFactory instance;

	public final static ResourceFactory getInstance() {
		if (instance == null)
			instance = new ResourceFactory();

		return instance;
	}

	private ResourceFactory() {
		resources = new HashMap<String, ParameterUtility>();
	}

	public synchronized void load(String lang, ParameterUtility resource) {
		flag = true;
		resources.remove(lang);
		resources.put(lang, resource);
		flag = false;
	}

	private String getString(String lang, String name, String defaultMsg) {
		while (flag)
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}

		ParameterUtility utility = resources.get(lang);
		if (utility != null) {
			return utility.getString(name, defaultMsg);
		}
		return "";
	}

	/**
	 * ��ȡ��Ӧ���Ե���Ϣ����
	 * 
	 * @param lang
	 *            ���������zh_CN,��Сд����
	 * @param name
	 *            ����
	 * @param defaultMsg
	 *            ȱʡ��Ϣ����δ��ȡ��ָ�����ƺ����Ե���Ϣʱ���ظ�ֵ)
	 * @return
	 */
	public static String getMessage(String lang, String name, String defaultMsg) {
		return getInstance().getString(lang, name, defaultMsg);
	}

	public static String getMessage(String lang, String name) {
		return getMessage(lang, name, "");
	}

}
