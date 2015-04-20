package org.trustel.scheduling.service;

import java.util.HashMap;
import java.util.Map;

import org.trustel.util.ParameterUtility;

public class DictionaryFactory {

	private Map<String, ParameterUtility> dictionary;

	private boolean flag = false;

	private static DictionaryFactory instance;

	public final static DictionaryFactory getInstance() {
		if (instance == null)
			instance = new DictionaryFactory();

		return instance;
	}

	private DictionaryFactory() {
		dictionary = new HashMap<String, ParameterUtility>();
	}

	public synchronized void load(String lang, ParameterUtility resource) {
		flag = true;
		dictionary.remove(lang);
		dictionary.put(lang, resource);
		flag = false;
	}

	private String getString(String lang, String name, String defaultMsg) {
		while (flag)
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
			}
		return dictionary.get(lang).getString(name, defaultMsg);
	}

	/**
	 * ��ȡ��Ӧ���ԵĴʵ�����
	 * 
	 * @param lang
	 *            ���������zh_CN,��Сд����
	 * @param name
	 *            ����
	 * @param defaultMsg
	 *            ȱʡ�ʵ䣨��δ��ȡ��ָ�����ƺ����Եĵ���ʱ���ظ�ֵ)
	 * @return
	 */
	public static String getMessage(String lang, String name, String defaultMsg) {
		return getInstance().getString(lang, name, defaultMsg);
	}

	public static String getMessage(String lang, String name) {
		return getMessage(lang, name, "");
	}

}
