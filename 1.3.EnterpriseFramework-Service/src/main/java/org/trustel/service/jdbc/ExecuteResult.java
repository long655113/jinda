package org.trustel.service.jdbc;

import java.util.List;

public class ExecuteResult {
	/**
	 * �����Ƿ�ɹ�
	 */
	public boolean ret = false;

	/**
	 * Ӱ���¼����
	 */
	public long updateCount = 0;

	public String toString() {
		return String.format("execute--> %s,affected %d rows ", new Object[] {
				ret, updateCount });
	}

	/**
	 * ���洢���̷��ص����ݼ���Ŀǰ��֧��һ�����ݼ�
	 */
	public List<?> sets;
}
