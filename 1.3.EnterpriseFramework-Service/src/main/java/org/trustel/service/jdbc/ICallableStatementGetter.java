package org.trustel.service.jdbc;

import java.sql.CallableStatement;
import java.sql.SQLException;

import org.trustel.service.common.IORTransform;

public interface ICallableStatementGetter extends IORTransform {
	/**
	 * ��ȡ�洢���̵ķ���ֵ
	 * 
	 * @param cs
	 *            �洢����
	 * @throws SQLException
	 */
	public void readOutParameter(CallableStatement cs) throws SQLException;
}
