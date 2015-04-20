package org.trustel.service.jdbc;

import java.sql.CallableStatement;
import java.sql.SQLException;

import org.trustel.util.SimpleHashMap;


public class NextStrCodeGetter implements ICallableStatementGetter {

	private String nextCode;

	public NextStrCodeGetter(String nextCode) {
		this.nextCode = nextCode;
	}

	public void readOutParameter(CallableStatement cs) throws SQLException {
		nextCode = cs.getString(1);
	}

	public String getNextCode() {
		return nextCode;
	}

	public Object transform(long index, SimpleHashMap fields) {
		return null;
	}

}
