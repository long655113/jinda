package org.trustel.service.jdbc;

import java.sql.CallableStatement;
import java.sql.SQLException;

public interface ICallableStatementSetter {
	/**
	 * �洢���̲�������
	 * 
	 * @param ps
	 * @param index
	 * 
	 * Sample:
	 * 
	 */
	public void setParameterValues(CallableStatement cs) throws SQLException;

}
