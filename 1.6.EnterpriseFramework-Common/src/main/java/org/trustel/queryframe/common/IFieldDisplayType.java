package org.trustel.queryframe.common;

import java.util.Map;
/**
 * ���ڲ�ѯ��ܵĽӿ�
 * @author joll
 *
 */
public interface IFieldDisplayType {

	/**
	 * ��ָ���Ĳ�ѯ�ֶ����ɲ�ѯҳ���е�input��ʽ
	 * @param resultMapָ���ֶεļ�¼
	 * @return
	 */
	public String getHtmlStr(Map<String,Object> resultMap);
}
